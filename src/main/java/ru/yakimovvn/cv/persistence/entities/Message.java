package ru.yakimovvn.cv.persistence.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
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
@Table(name = "messages")
public class Message implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;
    @Column(name = "user_name")
    private String user;
    @Column(name = "email")
    private String email;
    @Column(name = "topic")
    private String topic;
    @Column(name = "message")
    private String message;
}
