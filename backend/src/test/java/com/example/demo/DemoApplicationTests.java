package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.service.RefineService;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
    private RefineService service;

    @Test
    void shouldRefineText() {
        String result = service.refineText("angry message");
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

}
