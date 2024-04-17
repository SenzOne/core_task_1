package com.example.core_task_1.util;

import com.example.core_task_1.model.TestData;
import org.springframework.stereotype.Component;

@Component
public class Decorator {

    public static TestData decorate(TestData testData) {
        System.out.println("Данные добавлены: " + testData.toString());
        return testData;
    }
}
