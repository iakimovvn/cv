package ru.yakimovvn.cv.persistence.entities;

import lombok.*;
import ru.yakimovvn.cv.dto.convertrs.StringListConverter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * Create by Vladimir Yakimov on 10.09.2022
 * cv
 **/
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "jobs")
public class Job implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;
    @Column(name = "name")
    private String name;
    @Column(name = "title")
    private String title;
    @Column(name = "work_date")
    private String date;

    @Column(name = "description")
    @Basic(optional = true)
    private String description;
    @Column(name = "responsibilities")
    @Convert(converter = StringListConverter.class)
    private List<String> responsibilities;
}
