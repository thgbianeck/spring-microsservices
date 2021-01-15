package br.com.bianeck.microservices.app.users.services.impl;

import br.com.bianeck.microservices.app.users.models.entity.Student;
import br.com.bianeck.microservices.app.users.models.repository.StudentRepository;
import br.com.bianeck.microservices.app.users.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    @Transactional
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }
}
