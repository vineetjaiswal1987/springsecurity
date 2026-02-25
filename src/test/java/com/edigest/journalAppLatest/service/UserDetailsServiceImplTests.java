package com.edigest.journalAppLatest.service;
import com.edigest.journalAppLatest.Repository.UserEntryRepo;
import com.edigest.journalAppLatest.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.security.core.userdetails.UserDetails;
import org.mockito.*;

import java.util.ArrayList;

import static org.mockito.Mockito.*;
//@SpringBootTest
//@ExtendWith(MockitoExtension.class)
public class UserDetailsServiceImplTests {

    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;

    @Mock
    private UserEntryRepo userEntryRepo;

    @BeforeEach
    void setup()
    {
        MockitoAnnotations.openMocks(this);
    }
    @Disabled
    @Test
    void loadUserByUserNameTest(){
    when(userEntryRepo.findByUserName(ArgumentMatchers.anyString())).thenReturn(User.builder().userName("Vineet").password("asssdadasd").roles(new ArrayList<>()).build());
        UserDetails user = userDetailsService.loadUserByUsername("Vineet");
        Assertions.assertNotNull(user);
        Assertions.assertEquals("Vineet", user.getUsername());

    }
}
