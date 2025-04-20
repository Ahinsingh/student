package com.feeprocess.student.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.feeprocess.student.model.Catalog;

@FeignClient(name = "catalog-service")
public interface CatalogClient {

    @GetMapping("/catalog/{id}")
    Catalog getCourse(@PathVariable("id") long id);

    @PostMapping("/catalog/update")
    Catalog updateStudent(Catalog catalog);
}