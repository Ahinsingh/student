package com.feeprocess.student.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.feeprocess.student.model.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

}
