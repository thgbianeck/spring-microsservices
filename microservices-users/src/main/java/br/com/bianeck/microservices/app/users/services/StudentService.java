package br.com.bianeck.microservices.app.users.services;

import br.com.bianeck.microservices.app.users.models.entity.Student;

import java.util.Optional;

public interface StudentService {

    Iterable<Student> findAll();

    Optional<Student> findById(Long id);

    Student save(Student student);

    void deleteById(Long id);
}
