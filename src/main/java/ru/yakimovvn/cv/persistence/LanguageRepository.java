package ru.yakimovvn.cv.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yakimovvn.cv.persistence.entities.Education;
import ru.yakimovvn.cv.persistence.entities.Language;

import java.util.List;
import java.util.UUID;

/**
 * Create by Vladimir Yakimov on 11.09.2022
 * cv
 **/
public interface LanguageRepository extends JpaRepository<Language, UUID> {
    List<Language> findAll();
}
