package com.feeprocess.student.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table(name = "student")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String grade;
    private String mobileNumber;
    private String schoolName;
    private String courseCode;
    private long courseId;
    private String studentClass;
    private double pendingFee;
    private boolean status;
//    private List<Course> courses;
    
}
