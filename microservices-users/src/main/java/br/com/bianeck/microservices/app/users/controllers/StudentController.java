package br.com.bianeck.microservices.app.users.controllers;

import br.com.bianeck.microservices.app.users.models.entity.Student;
import br.com.bianeck.microservices.app.users.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Student student) {
        Student studentDb = studentService.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@RequestBody Student student, @PathVariable Long id) {
        Optional<Student> studentOp = studentService.findById(id);
        if(studentOp.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Student studentDb = studentOp.get();
        studentDb.setName(student.getName());
        studentDb.setLastName(student.getLastName());
        studentDb.setEmail(student.getEmail());

        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.save(studentDb));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        studentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
