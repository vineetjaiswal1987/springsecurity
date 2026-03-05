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
    public enum keys{
        WEATHER_API;
    }


    public Map<String, String> appCache;

    @Autowired
    private ConfigJournalAppRepo configJournalAppRepo;

    @PostConstruct
    public void init()
    {
        appCache = new HashMap<>();
        List<ConfigJournalAppEntity> all = configJournalAppRepo.findAll();
        for(ConfigJournalAppEntity configJournalAppEntity:all){
            appCache.put(configJournalAppEntity.getKey(), configJournalAppEntity.getValue());
        }

    }
}
