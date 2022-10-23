package ru.yakimovvn.cv.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yakimovvn.cv.persistence.entities.Contact;

import java.util.List;
import java.util.UUID;

public interface ContactRepository extends JpaRepository<Contact, UUID> {

    List<Contact> findAllByOrderByIndex();
}
