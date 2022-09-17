package ru.yakimovvn.cv.dto.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.yakimovvn.cv.dto.EducationDto;
import ru.yakimovvn.cv.persistence.entities.Education;

import java.util.List;

/**
 * Create by Vladimir Yakimov on 10.09.2022
 * cv
 **/

@Mapper
public interface EducationMapper {
    EducationMapper INSTANCE = Mappers.getMapper(EducationMapper.class);

    EducationDto toDto(Education education);

    Education toEntity(EducationDto educationDto);

    Iterable<EducationDto> toDtoList(List<Education> educations);
}
