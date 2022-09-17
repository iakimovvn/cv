package ru.yakimovvn.cv.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.yakimovvn.cv.dto.*;
import ru.yakimovvn.cv.dto.mappers.*;
import ru.yakimovvn.cv.persistence.entities.Message;
import ru.yakimovvn.cv.service.interfaces.Informer;
import ru.yakimovvn.cv.service.interfaces.Sender;
import ru.yakimovvn.cv.utils.CaptchaGenerator;
import ru.yakimovvn.cv.validators.MessageValidator;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URLConnection;
import java.security.Principal;
import java.util.Arrays;

/**
 * Create by Vladimir Yakimov on 03.09.2022
 * cv
 **/

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private Sender sender;

    @Autowired
    private Informer informer;

    @Value("${files.dir}")
    private String filesDir;

    @Autowired
    private MessageValidator validator;

    @Autowired
    private CaptchaGenerator captchaGenerator;

    @GetMapping
    public String index(Model model) {
        return getIndex(model,  new MessageDto());
    }

    @PostMapping(value = "/message")
    public String sendMessage(MessageDto messageDto,  HttpSession session, Model model, BindingResult bindingResult) {
        validator.validate(messageDto, bindingResult);
        if (!messageDto.getCaptchaCode().equals(session.getAttribute("captchaCode")) || bindingResult.hasErrors()) {
            bindingResult.rejectValue("captchaCode","Error", "Wrong code!");
            return getIndex(model, messageDto);
        }
        Message message = MessageMapper.INSTANCE.toEntity(messageDto);
        informer.saveMassage(message);
        sender.send(messageDto);
        return "redirect:/";
    }

    @GetMapping(value = "/captcha", produces = MediaType.IMAGE_PNG_VALUE)
    public @ResponseBody byte[] captcha(HttpSession session) {
        try {
            BufferedImage img = captchaGenerator.getCaptchaImage();
            session.setAttribute("captchaCode", captchaGenerator.getCaptchaString());
            ByteArrayOutputStream bao = new ByteArrayOutputStream();
            ImageIO.write(img, "png", bao);
            return bao.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping(value="/download/{fileName:.+}")
    public void downloadFile(HttpServletRequest request, HttpServletResponse response,
                             @PathVariable("fileName") String fileName) throws IOException {
        String link = filesDir+ "/" + fileName;
        File file = new File(link);
        String mimeType = URLConnection.guessContentTypeFromName(file.getName());
        if (mimeType == null) {
            mimeType = "application/octet-stream";
        }
        response.setContentType(mimeType);

        response.setHeader("Content-Disposition", String.format("inline; filename=\"%s\"",file.getName()));
        response.setContentLength((int) file.length());
        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
        FileCopyUtils.copy(inputStream, response.getOutputStream());
    }

    private String getIndex(Model model, MessageDto messageDto) {
        model.addAttribute("short_information", informer.getShortInformation());

        Iterable<SkillDto> skillDtoList = SkillMapper.INSTANCE.toDtoList(informer.getSkills());
        model.addAttribute("skills", skillDtoList);

        Iterable<EducationDto> educationDtoList = EducationMapper.INSTANCE.toDtoList(informer.getEducations());
        model.addAttribute("educations", educationDtoList);

        Iterable<LanguageDto> languageDtoList = LanguageMapper.INSTANCE.toDtoList(informer.getLanguages());
        model.addAttribute("languages", languageDtoList);

        Iterable<ContactDto> contactDtoList = ContactMapper.INSTANCE.toDtoList(informer.getContacts());
        model.addAttribute("contacts", contactDtoList);

        Iterable<JobDto> jobDtoList = JobMapper.INSTANCE.toDtoList(informer.getJobs());
        model.addAttribute("jobs", jobDtoList);

        model.addAttribute("messageDto", messageDto);
        return "index.html";
    }
}
