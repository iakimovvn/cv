package ru.yakimovvn.cv.dto.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.yakimovvn.cv.dto.ContactDto;
import ru.yakimovvn.cv.dto.SkillDto;
import ru.yakimovvn.cv.persistence.entities.Contact;
import ru.yakimovvn.cv.persistence.entities.Skill;

import java.util.List;

/**
 * Create by Vladimir Yakimov on 10.09.2022
 * cv
 **/

@Mapper
public interface SkillMapper {
    SkillMapper INSTANCE = Mappers.getMapper(SkillMapper.class);

    SkillDto toDto(Skill skill);

    Skill toEntity(SkillDto skillDto);

    Iterable<SkillDto> toDtoList(List<Skill> skills);
}
