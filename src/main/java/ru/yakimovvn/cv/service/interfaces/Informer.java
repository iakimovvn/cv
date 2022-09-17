package ru.yakimovvn.cv.service.interfaces;

import org.springframework.cache.annotation.CacheEvict;
import ru.yakimovvn.cv.persistence.entities.*;

import java.lang.reflect.Member;
import java.util.List;

/**
 * Create by Vladimir Yakimov on 10.09.2022
 * cv
 **/
public interface Informer {

    String getShortInformation();

    List<Contact> getContacts();

    List<Job> getJobs();

    List<Skill> getSkills();

    List<Language> getLanguages();

    @CacheEvict(value="addresses", allEntries=true)
    List<Education> getEducations();

    Message saveMassage(Message message);
}
