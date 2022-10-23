package ru.yakimovvn.cv.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Create by Vladimir Yakimov on 04.09.2022
 * cv
 **/

@Data
@NoArgsConstructor
public class JobDto implements Serializable {
    private UUID id;
    private String name;
    private String title;
    private String date;
    private String description;
    private List<String> responsibilities;
}
