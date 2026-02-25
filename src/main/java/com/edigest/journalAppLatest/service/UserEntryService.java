package com.edigest.journalAppLatest.service;

import com.edigest.journalAppLatest.Repository.UserEntryRepo;
import com.edigest.journalAppLatest.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class UserEntryService {
    @Autowired
    private UserEntryRepo userEntryRepo;

    private static final PasswordEncoder passwordEncoder= new BCryptPasswordEncoder();

//    private static final Logger logger= LoggerFactory.getLogger(UserEntryService.class);

    public boolean saveNewUser(User userEntry){
        try{
            userEntry.setPassword(passwordEncoder.encode(userEntry.getPassword()));
            userEntry.setRoles(Arrays.asList("USER"));
            userEntryRepo.save(userEntry);
            return true;
        }
        catch (Exception e)
        {
            log.error("hahah kya mjak kar rahe ho");
            log.warn("hahah kya mjak kar rahe ho");
            log.info("hahah kya mjak kar rahe ho");
            log.debug("hahah kya mjak kar rahe ho");
            log.trace("hahah kya mjak kar rahe ho");
            return false;
        }

    }

    public void saveUser(User userEntry){
        userEntryRepo.save(userEntry);
    }
    public List<User> getAllEntries(){
        return userEntryRepo.findAll();
    }
    public Optional<User> findById(ObjectId id){
        return userEntryRepo.findById(id);
    }

    public void deleteById(ObjectId Id) {
        userEntryRepo.deleteById(Id);
    }

    public User findByUserName(String userName){
        return userEntryRepo.findByUserName(userName);
    }

    public void saveAdmin(User userEntry) {
        userEntry.setPassword(passwordEncoder.encode(userEntry.getPassword()));
        userEntry.setRoles(Arrays.asList("ADMIN","USER"));
        userEntryRepo.save(userEntry);
    }
}
