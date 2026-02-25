package com.edigest.journalAppLatest.service;

import com.edigest.journalAppLatest.Repository.UserEntryRepo;
import com.edigest.journalAppLatest.entity.User;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserEntryServiceTests {
    @Autowired
    private UserEntryRepo userEntryRepo;

    @Autowired
    private UserEntryService userEntryService;
    @Disabled
    @ParameterizedTest
    @ArgumentsSource(UserArgumentsProvider.class )
    public void testSaveNewUser(User userName)
    {
        assertTrue(userEntryService.saveNewUser(userName));
//        assertNotNull(userEntryRepo.findByUserName(userName.getUserName()), "failed for:" +userName);
//        assertTrue(1>3);
    }

    @Disabled
    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "2,3,5",
            "7,2,8"
    })
    public void test(int a, int b, int expected){
        assertEquals(expected,a+b);
    }
}
