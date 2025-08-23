package com.fernando.wksmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernando.wksmongo.domain.User;
import com.fernando.wksmongo.dto.UserDTO;
import com.fernando.wksmongo.repositories.UserRepository;
import com.fernando.wksmongo.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(String id){
        //se não houver usuario, retorna nulo
        User user = repository.findById(id).orElse(null);
        if(user == null){
           throw new ObjectNotFoundException("Objeto não encontrado") ;
        }
        return user;
    }

    public User insert(User obj){
        return repository.insert(obj);
    }

    public User fromDto(UserDTO objDto){
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }

    public void delete(String id){
        findById(id);
        repository.deleteById(id);
    }

    public User update(User user){
        User newUser = repository.findById(user.getId()).orElse(null);
        updateData(newUser, user);
        return repository.save(newUser);
    }

    private void updateData(User newUser, User user) {
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
    }
}
