package com.Mishrajee.journalApp.Repository;

import com.Mishrajee.journalApp.Entity.ConfigJournalAppEntity;
import com.Mishrajee.journalApp.Entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConfigJournalAppRepository extends MongoRepository<ConfigJournalAppEntity,ObjectId > {
}
