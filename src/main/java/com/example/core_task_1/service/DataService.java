package com.example.core_task_1.service;

import com.example.core_task_1.model.TestData;
import com.example.core_task_1.repository.TestDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {

    @Autowired
    private final TestDataRepository dataRepository;

    public DataService(TestDataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public List<TestData> getAllData() {
        return dataRepository.findAll();
    }

    public void save(TestData data) {
        dataRepository.save(data);
    }

}
