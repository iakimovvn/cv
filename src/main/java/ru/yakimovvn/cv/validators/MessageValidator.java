package ru.yakimovvn.cv.validators;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.yakimovvn.cv.dto.MessageDto;

import java.util.regex.Pattern;

/**
 * Create by Vladimir Yakimov on 05.09.2022
 * cv
 **/

@Service
public class MessageValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return MessageDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        MessageDto messageDto = (MessageDto) target;

        if(messageDto.getUser() == null || messageDto.getUser().isEmpty()) {
            errors.rejectValue("user", "Error", "Wrong login");
        }
        if(messageDto.getEmail() == null || !Pattern.compile("^(.+)@(.+)$").matcher(messageDto.getEmail()).matches()) {
            errors.rejectValue("email", "Error", "Wrong e-mail");
        }
        if(messageDto.getTopic() == null || messageDto.getTopic().isEmpty()) {
            errors.rejectValue("topic", "Error", "Wrong topic");
        }
    }
}
