package com.feeprocess.student.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feeprocess.student.model.Student;
import com.feeprocess.student.repository.StudentRepository;
import com.feeprocess.student.service.StudentService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;
	
    @Autowired
    private StudentService service;
    
    
    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.status(200).body("he testing");
    }
    
    @GetMapping("/{id}")
//    @CircuitBreaker(name = "student-service", fallbackMethod = "fallbackGetStudent")
    public ResponseEntity<Student> getStudentById(@PathVariable long id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    public ResponseEntity<Student> fallbackGetStudent(String id, Throwable ex) {
        return ResponseEntity.status(503).body(null);
    }
    
    @GetMapping("/fee/{feeStatus}")
    public ResponseEntity<List<Student>> getStudentsByStatus(@PathVariable boolean feeStatus) {
//    	List<Student> students = studentRepository.findByStatus(feeStatus);
    	return Optional.ofNullable(studentRepository.findByFeeStatus(feeStatus))
                .filter(list -> !list.isEmpty())
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
   
    @PostMapping
//    @CircuitBreaker(name = "student-service", fallbackMethod = "fallbackAddStudent")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student savedStudent = service.addStudent(student);
        return ResponseEntity.ok(savedStudent);
    }
    
    public ResponseEntity<Student> fallbackAddStudent(Student student, Throwable ex) {
        return ResponseEntity.status(503).body(null);
    }
    
    @PostMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        Optional<Student> existingStudent = studentRepository.findById(student.getId());
        if (existingStudent.isPresent()) {
            Student updatedStudent = studentRepository.save(student);
            return ResponseEntity.ok(updatedStudent);
        }
        return ResponseEntity.notFound().build();
    }
}
