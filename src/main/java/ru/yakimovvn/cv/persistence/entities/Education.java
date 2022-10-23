package ru.yakimovvn.cv.persistence.entities;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

/**
 * Create by Vladimir Yakimov on 11.09.2022
 * cv
 **/

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "educations")
public class Education {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;
    @Column(name = "index")
    private Integer index;
    @Column(name = "education")
    private String education;
}
