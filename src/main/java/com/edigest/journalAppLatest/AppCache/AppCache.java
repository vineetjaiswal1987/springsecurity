package com.edigest.journalAppLatest.AppCache;

import com.edigest.journalAppLatest.Repository.ConfigJournalAppRepo;
import com.edigest.journalAppLatest.entity.ConfigJournalAppEntity;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AppCache {
    public Map<String, String> APP_CACHE=new HashMap<>();

    @Autowired
    private ConfigJournalAppRepo configJournalAppRepo;

    @PostConstruct
    public void init()
    {
        List<ConfigJournalAppEntity> all = configJournalAppRepo.findAll();

        for(ConfigJournalAppEntity configJournalAppEntity:all){
            APP_CACHE.put(configJournalAppEntity.getKey(), configJournalAppEntity.getValue());
        }

    }
}
