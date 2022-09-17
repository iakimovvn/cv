package ru.yakimovvn.cv.persistence.entities;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

/**
 * Create by Vladimir Yakimov on 11.09.2022
 * cv
 **/

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "languages")
public class Language {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;
    @Column(name = "language_name")
    private String language;
}
