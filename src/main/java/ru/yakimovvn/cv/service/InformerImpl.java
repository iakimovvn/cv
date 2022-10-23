package ru.yakimovvn.cv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.yakimovvn.cv.persistence.*;
import ru.yakimovvn.cv.persistence.entities.*;
import ru.yakimovvn.cv.service.interfaces.Informer;

import java.util.List;

/**
 * Create by Vladimir Yakimov on 10.09.2022
 * cv
 **/
@Service
public class InformerImpl implements Informer {

    @Value("${cv.short.information}")
    private String shortInformation;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private EducationRepository educationRepository;

    @Override
    public String getShortInformation() {
        return shortInformation;
    }

    @Override
    @Cacheable("contacts")
    public List<Contact> getContacts() {
        return contactRepository.findAllByOrderByIndex();
    }

    @Override
    @Cacheable("jobs")
    public List<Job> getJobs() {
        return jobRepository.findAllByOrderByIndex();
    }

    @Override
    @Cacheable("skills")
    public List<Skill> getSkills() {
        return skillRepository.findAllByOrderByIndex();
    }

    @Override
    @Cacheable("languages")
    public List<Language> getLanguages() {
        return languageRepository.findAllByOrderByIndex();
    }

    @Override
    @Cacheable("educations")
    public List<Education> getEducations() {
        return educationRepository.findAllByOrderByIndex();
    }

    @Override
    public Message saveMassage(Message message) {
        return messageRepository.save(message);
    }
}
