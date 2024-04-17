package com.example.core_task_1.init;

import com.example.core_task_1.model.TestData;
import com.example.core_task_1.service.DataService;
import com.example.core_task_1.util.Decorator;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DbInit {

    private final DataService dataService;

    public DbInit(DataService dataService) {
        this.dataService = dataService;
    }

    @PostConstruct
    void init() {
        System.out.println("init");
        dataService.save(Decorator.decorate(new TestData(1L, "data-1")));
        dataService.save(Decorator.decorate(new TestData(2L, "data-2")));
        dataService.save(Decorator.decorate(new TestData(3L, "data-3")));
        dataService.save(Decorator.decorate(new TestData(4L, "data-4")));
    }
}
