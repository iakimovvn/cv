package ru.yakimovvn.cv.dto.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.yakimovvn.cv.dto.MessageDto;
import ru.yakimovvn.cv.persistence.entities.Message;

import java.util.List;

/**
 * Create by Vladimir Yakimov on 10.09.2022
 * cv
 **/
@Mapper
public interface MessageMapper {
    MessageMapper INSTANCE = Mappers.getMapper(MessageMapper.class);

    MessageDto toDto(Message message);

    Message toEntity(MessageDto messageDto);

    Iterable<MessageDto> toDtoList(List<Message> messages);
}
