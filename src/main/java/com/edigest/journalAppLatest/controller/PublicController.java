package com.edigest.journalAppLatest.controller;

import com.edigest.journalAppLatest.entity.User;
import com.edigest.journalAppLatest.service.UserEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {
    @Autowired
    private UserEntryService userentryservice;


    @GetMapping("/health-check")
    public String healthCheck() {
        return "ok";
    }

    @PostMapping("/create-user")
    public void createUser(@RequestBody User user)
    {
        userentryservice.saveNewUser(user);
    }
}
