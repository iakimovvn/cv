package ru.yakimovvn.cv.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yakimovvn.cv.persistence.entities.Message;

import java.util.UUID;

public interface MessageRepository extends JpaRepository<Message, UUID> {
    Message save(Message message);
}
