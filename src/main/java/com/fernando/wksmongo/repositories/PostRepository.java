package com.fernando.wksmongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fernando.wksmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

    //Buscando post que contenham o Conteudo no titulo, ignorando o Case Sensitivy
    List<Post> findByTitleContainingIgnoreCase(String text);

}
