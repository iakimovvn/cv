package ru.yakimovvn.cv.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/**
 * Create by Vladimir Yakimov on 11.09.2022
 * cv
 **/
@Data
@NoArgsConstructor
public class SkillDto {
    private UUID id;
    private String skillName;
}
