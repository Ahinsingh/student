package com.feeprocess.student.model;

import lombok.Data;

@Data
public class Catalog {
    private String id;
    private long studentClass;
    private double fee;

    public Catalog(String id, long studentClass, double fee) {
        this.id = id;
        this.studentClass = studentClass;
        this.fee = fee;
    }
   
}