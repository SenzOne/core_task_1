package com.example.core_task_1.controller;

import com.example.core_task_1.model.TestData;
import com.example.core_task_1.service.DataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/v1")
public class TestDataController {

    private final DataService dataService;

    public TestDataController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/get")
    public ResponseEntity<List<TestData>> getAllData() {
        return new ResponseEntity<>(dataService.getAllData(), HttpStatus.OK);
    }
}
