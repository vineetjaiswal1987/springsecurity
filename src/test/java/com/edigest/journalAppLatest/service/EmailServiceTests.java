package com.edigest.journalAppLatest.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTests {

    @Autowired
    private EmailService emailService;

    @Test
    public void testEmailService() {
        emailService.sendEmail("vjvineet2@gmail.com","Hi this is test email","Hello from Spring security");

    }

}
