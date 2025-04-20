package com.feeprocess.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feeprocess.student.model.Catalog;
import com.feeprocess.student.model.Student;
import com.feeprocess.student.repository.StudentRepository;

@Service
public class StudentService {
    @Autowired
	private StudentRepository studentRepository;
    
    @Autowired
    CatalogClient catalogClient;
	
    public Student addStudent(Student student) {
    	
    	Catalog catalog = getCatalog(student.getCourseId());
        if (catalog != null) {
            student.setPendingFee(catalog.getCourseFee());
            System.out.println("Catalog Fee for class " + student.getStudentClass() + " : " + catalog.getCourseFee());
        } else {
            System.out.println("Catalog not found for class: " + student.getStudentClass());
        }
        return studentRepository.save(student);
    }
    
    public Catalog getCatalog(long id) {
		Catalog catalog = catalogClient.getCourse(id);
		if (catalog == null || catalog.getId() != id) {
			throw new IllegalArgumentException("Student verification failed.");
		} else {
			return catalog;
		}

	}
}
