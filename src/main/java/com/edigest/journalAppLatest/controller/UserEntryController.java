package com.edigest.journalAppLatest.controller;

import com.edigest.journalAppLatest.Repository.UserEntryRepo;
import com.edigest.journalAppLatest.api.response.WeatherResponse;
import com.edigest.journalAppLatest.entity.User;
import com.edigest.journalAppLatest.service.UserEntryService;
import com.edigest.journalAppLatest.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserEntryController {
    @Autowired
    private UserEntryService userentryservice;

    @Autowired
    private UserEntryRepo userEntryRepo;
    @Autowired
    private WeatherService weatherService;

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName=authentication.getName();
        User userInDb= userentryservice.findByUserName(userName);
        userInDb.setUserName(user.getUserName());
        userInDb.setPassword(user.getPassword());
        userentryservice.saveNewUser(userInDb);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @DeleteMapping
    public ResponseEntity<?> deleteUserById(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userEntryRepo.deleteByUserName(authentication.getName());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    b8ab396efa2d4f1f942133355262502
    @GetMapping
    public ResponseEntity<?> greeting(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        WeatherResponse weatherResponse = weatherService.getWeather("Mumbai");
        String greeting="";
        if(weatherResponse != null){
                greeting= ", Weather feels like" +weatherResponse.getCurrent().getWind_dir();
            }
        return new ResponseEntity<>("HI "+authentication.getName() +greeting,HttpStatus.OK);

    }

}
