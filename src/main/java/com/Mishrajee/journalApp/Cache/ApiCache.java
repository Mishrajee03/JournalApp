package com.Mishrajee.journalApp.Cache;

import com.Mishrajee.journalApp.Entity.ConfigJournalAppEntity;
import com.Mishrajee.journalApp.Repository.ConfigJournalAppRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ApiCache {
    @Autowired
    private ConfigJournalAppRepository configJournalAppRepository;

    public final Map<String,String> APP_CACHE = new HashMap<>();

    @PostConstruct
    public void init(){
        List<ConfigJournalAppEntity> all=configJournalAppRepository.findAll();
        for (ConfigJournalAppEntity configJournalAppEntity : all) {
            APP_CACHE.put(configJournalAppEntity.getKey(), configJournalAppEntity.getValue());
        }

    }


}
