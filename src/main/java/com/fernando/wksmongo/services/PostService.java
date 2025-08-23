package com.fernando.wksmongo.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernando.wksmongo.domain.Post;
import com.fernando.wksmongo.repositories.PostRepository;
import com.fernando.wksmongo.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        //se não houver usuario, retorna nulo
        Post post = repository.findById(id).orElse(null);
        if (post == null) {
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return post;
    }

    public List<Post> findByTitle(String text){
        return repository.findByTitleContainingIgnoreCase(text);
    }

}
