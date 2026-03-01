package com.edigest.journalAppLatest.service;

import com.edigest.journalAppLatest.Repository.JournalEntryRepo;
import com.edigest.journalAppLatest.entity.JournalEntry;
import com.edigest.journalAppLatest.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class JournalEntryService {
    @Autowired
    private JournalEntryRepo journalEntryRepo;
    @Autowired
    private UserEntryService userEntryService;

    private static final Logger logger= LoggerFactory.getLogger(JournalEntryService.class);

    @Transactional
    public void saveEntry(JournalEntry journalEntry, String userName){
        try {
            User user=userEntryService.findByUserName(userName);
            journalEntry.setDate(LocalDateTime.now());
            JournalEntry saved= journalEntryRepo.save(journalEntry);
            user.getJournalEntries().add(saved);
            userEntryService.saveUser(user);

        } catch (Exception e) {
            log.error("Error",e);
            throw new RuntimeException("An error occured while saving the entry" +e);
        }
    }
    public void saveEntry(JournalEntry journalEntry){
        journalEntryRepo.save(journalEntry);
    }
    public List<JournalEntry> getAllEntries(){
        return journalEntryRepo.findAll();
    }
    public Optional<JournalEntry> findById(ObjectId id){
        return journalEntryRepo.findById(id);
    }
    @Transactional
    public boolean deleteById(ObjectId myId, String userName) {
        boolean removed=false;
        try{
            User user=userEntryService.findByUserName(userName);
            removed=user.getJournalEntries().removeIf(x-> x.getId().equals(myId));
            if(removed){
                journalEntryRepo.deleteById(myId);
                userEntryService.saveUser(user);
            }
        }
        catch (Exception e)
        {
//            System.out.println(e);
            logger.info("hahaha");
            throw  new RuntimeException("An error occured while Deleting the entry. " +e);
        }
        return removed;
    }

    public List<JournalEntry> findByUserName(List<JournalEntry> userName){
        return userName;
    }
}
