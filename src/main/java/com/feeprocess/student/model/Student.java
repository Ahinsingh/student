package com.feeprocess.student.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "student")
@Data
public class Student {
    @Id
    private String id;
    private String name;
    private long studentClass;
    private double amount;
}
