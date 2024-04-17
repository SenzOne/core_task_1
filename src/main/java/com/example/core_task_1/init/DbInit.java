package com.example.core_task_1.init;

import com.example.core_task_1.model.TestData;
import com.example.core_task_1.service.DataService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DbInit {

    @Autowired
    private final DataService dataService;

    public DbInit(DataService dataService) {
        this.dataService = dataService;
    }

    @PostConstruct
    void init() {
        System.out.println("init");
        dataService.save(TestData.builder().name("data-1").build());
        dataService.save(TestData.builder().name("data-2").build());
        dataService.save(TestData.builder().name("data-3").build());
        dataService.save(TestData.builder().name("data-4").build());

    }
}
