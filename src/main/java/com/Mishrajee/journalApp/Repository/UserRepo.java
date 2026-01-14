package com.Mishrajee.journalApp.Repository;

import com.Mishrajee.journalApp.Entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User, ObjectId> {
    User findByUserName(String userName);

    User deleteByUserName(String UserName);
}
