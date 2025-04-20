package com.feeprocess.student.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    private String id;
    private String subCourseCode;   
    private String subCourseName;  
    private String subCourseDesc;
    private double subCourseFee;  
    private int credits;
}
