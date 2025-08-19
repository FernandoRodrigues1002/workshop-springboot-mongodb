package com.fernando.wksmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fernando.wksmongo.domain.User;

@Repository
public interface UserRepoitory extends MongoRepository<User, String>{


}
