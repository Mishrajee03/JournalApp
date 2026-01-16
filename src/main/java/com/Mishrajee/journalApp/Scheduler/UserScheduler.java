package com.Mishrajee.journalApp.Scheduler;

import com.Mishrajee.journalApp.Cache.ApiCache;
import com.Mishrajee.journalApp.Entity.JournalEntry;
import com.Mishrajee.journalApp.Entity.User;
import com.Mishrajee.journalApp.Enums.Sentiment;
import com.Mishrajee.journalApp.Repository.UserRepoImpl;
import com.Mishrajee.journalApp.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class UserScheduler {

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserRepoImpl userRepo;



    @Autowired
    private ApiCache apiCache;

    @Scheduled(cron = "0 0 0 * * SUN")
    public void fetchUsersAndSendSaMail(){
        List<User> users = userRepo.getUserForSa();
        for(User user : users){
            List<JournalEntry> journalEntries = user.getJournalEntries();
            List<Sentiment> sentiments = journalEntries.stream().filter(x -> x.getDate().isAfter(LocalDateTime.now().minus(7, ChronoUnit.DAYS))).map(x->x.getSentiment()).collect(Collectors.toList());
            Map<Sentiment, Integer> sentimentCounts = new HashMap<>();
            for (Sentiment sentiment : sentiments) {
                if (sentiment != null)
                    sentimentCounts.put(sentiment, sentimentCounts.getOrDefault(sentiment,0)+1);
            }
                            Sentiment mostFrequentSentiment = null;
                int maxCount = 0;
                for (Map. Entry<Sentiment, Integer> entry : sentimentCounts.entrySet()) {
                    if (entry.getValue() > maxCount) {
                        maxCount = entry. getValue () ;
                        mostFrequentSentiment = entry.getKey ();
                    }

                    if (mostFrequentSentiment != null) {
                        emailService.sendMail(user.getEmail(), "Sentiment for last 7 days ", mostFrequentSentiment.toString());
                    }
                }
        }
    }

    @Scheduled(cron = "0 0/10 * ? * *")
    public void clearAppCache(){
        apiCache.init();
    }
}

