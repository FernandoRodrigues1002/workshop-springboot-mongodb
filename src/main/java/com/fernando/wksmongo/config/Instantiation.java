package com.fernando.wksmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.fernando.wksmongo.domain.User;
import com.fernando.wksmongo.repositories.UserRepoitory;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepoitory userRepoitory;

    @Override
    public void run(String... args) throws Exception {

        userRepoitory.deleteAll();

        //Id nulo pois está sendo incrementado no banco
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepoitory.saveAll(Arrays.asList(maria, alex, bob));
    }

}
