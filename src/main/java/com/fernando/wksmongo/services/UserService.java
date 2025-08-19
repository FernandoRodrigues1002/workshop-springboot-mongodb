package com.fernando.wksmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernando.wksmongo.domain.User;
import com.fernando.wksmongo.repositories.UserRepoitory;

@Service
public class UserService {

    @Autowired
    private UserRepoitory repoitory;

    public List<User> findAll(){
        return repoitory.findAll();
    }
}
