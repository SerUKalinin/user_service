package com.example.user_service.controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.fail;

public class UserControllerTest {

    @Test
    public void testAlwaysFails() {
        // Этот тест всегда будет падать
        fail("Этот тест специально написан, чтобы проверить CI/CD");
    }
}
