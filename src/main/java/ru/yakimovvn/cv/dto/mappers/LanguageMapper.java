package ru.yakimovvn.cv.dto.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.yakimovvn.cv.dto.LanguageDto;
import ru.yakimovvn.cv.dto.SkillDto;
import ru.yakimovvn.cv.persistence.entities.Language;
import ru.yakimovvn.cv.persistence.entities.Skill;

import java.util.List;

/**
 * Create by Vladimir Yakimov on 10.09.2022
 * cv
 **/

@Mapper
public interface LanguageMapper {
    LanguageMapper INSTANCE = Mappers.getMapper(LanguageMapper.class);

    LanguageDto toDto(Language language);

    Language toEntity(LanguageDto languageDto);

    Iterable<LanguageDto> toDtoList(List<Language> languages);
}
