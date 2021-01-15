package br.com.bianeck.microservices.app.users.controllers;

import br.com.bianeck.microservices.app.users.models.entity.Student;
import br.com.bianeck.microservices.app.users.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<?> list() {
        return ResponseEntity.ok().body(studentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> see(@PathVariable Long id) {
        Optional<Student> student = studentService.findById(id);
        if(student.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student.get());
    }
}
