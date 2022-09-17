package ru.yakimovvn.cv.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/**
 * Create by Vladimir Yakimov on 04.09.2022
 * cv
 **/

@Getter
@Setter
@NoArgsConstructor
public class ContactDto {
    private UUID id;
    private String name;
    private String data;
}
