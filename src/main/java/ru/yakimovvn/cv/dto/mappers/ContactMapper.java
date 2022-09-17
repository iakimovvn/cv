package ru.yakimovvn.cv.dto.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.yakimovvn.cv.dto.ContactDto;
import ru.yakimovvn.cv.persistence.entities.Contact;

import java.util.List;

/**
 * Create by Vladimir Yakimov on 10.09.2022
 * cv
 **/

@Mapper
public interface ContactMapper {
    ContactMapper INSTANCE = Mappers.getMapper(ContactMapper.class);

    ContactDto toDto(Contact contact);

    Contact toEntity(ContactDto contactDto);

    Iterable<ContactDto> toDtoList(List<Contact> contacts);
}
