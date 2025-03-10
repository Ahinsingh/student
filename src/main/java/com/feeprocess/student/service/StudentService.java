package com.feeprocess.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.feeprocess.student.model.Catalog;
import com.feeprocess.student.model.Student;
import com.feeprocess.student.repository.StudentRepository;

@Service
public class StudentService {
    @Autowired
	 private StudentRepository studentRepository;
    
    @Autowired
	private RestTemplate restTemplate;
	
    public Student addStudent(Student student) {
        String catalogUrl = "http://localhost:8081/catalog-service/catalog/" + student.getStudentClass();
        ResponseEntity<Catalog> response = restTemplate.getForEntity(catalogUrl, Catalog.class);
        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            Catalog catalog = response.getBody();
            student.setAmount(catalog.getFee());
            System.out.println("Catalog Fee for class " + student.getStudentClass() + " : " + catalog.getFee());
        } else {
            System.out.println("Catalog not found for class: " + student.getStudentClass());
        }

        return studentRepository.save(student);
    }
}
