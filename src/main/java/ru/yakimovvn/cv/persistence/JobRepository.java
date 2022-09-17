package ru.yakimovvn.cv.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yakimovvn.cv.persistence.entities.Job;

import java.util.List;
import java.util.UUID;

public interface JobRepository extends JpaRepository<Job, UUID> {

    List<Job> findAll();
}
