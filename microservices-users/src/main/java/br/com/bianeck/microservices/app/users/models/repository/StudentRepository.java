package br.com.bianeck.microservices.app.users.models.repository;

import br.com.bianeck.microservices.app.users.models.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
