package ru.yakimovvn.cv.dto.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.yakimovvn.cv.dto.JobDto;
import ru.yakimovvn.cv.persistence.entities.Job;
import java.util.List;

@Mapper
public interface JobMapper {
    JobMapper INSTANCE = Mappers.getMapper(JobMapper.class);

    JobDto toDto(Job job);

    Job toEntity(JobDto jobDto);

    Iterable<JobDto> toDtoList(List<Job> jobs);
}
