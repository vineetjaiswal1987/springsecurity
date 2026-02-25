package com.edigest.journalAppLatest.controller;

import com.edigest.journalAppLatest.entity.User;
import com.edigest.journalAppLatest.service.UserEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserEntryService userEntryService;
    @GetMapping("/all-users")
    public ResponseEntity<?> getAllUsers()
    {
        List<User> allEntries = userEntryService.getAllEntries();
        if(allEntries!=null && !allEntries.isEmpty())
        {
            return new ResponseEntity<>(allEntries, HttpStatus.OK);
        }
        return new ResponseEntity<>(allEntries, HttpStatus.NOT_FOUND);
    }
    @PostMapping("/create-admin-user")
    public void createAdmin(@RequestBody User user)
    {
        userEntryService.saveAdmin(user);
    }

}
