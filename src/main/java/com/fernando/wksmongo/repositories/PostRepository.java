package com.fernando.wksmongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.fernando.wksmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

    //Buscando post que contenham o Conteudo no titulo, ignorando o Case Sensitivy
    List<Post> findByTitleContainingIgnoreCase(String text);

    //{ <field>: { $regex: /pattern/, $options: '<options>' } }
    //pattern -> primeiro paramentro do método || i -> ignora letra maiuscula ou minuscula
    @Query("{ title: { $regex: ?0, $options: 'i' } }")
    List<Post> findByTitle(String text);

}
