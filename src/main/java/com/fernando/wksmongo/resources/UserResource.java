package com.fernando.wksmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fernando.wksmongo.domain.User;
import com.fernando.wksmongo.dto.UserDTO;
import com.fernando.wksmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    //Metodo diferente para @GetMapping, mas são a mesma coisa
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = service.findAll();
        List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User user = service.findById(id);
        return ResponseEntity.ok().body(new UserDTO(user));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) {
        User obj = service.fromDto(objDto);
        obj = service.insert(obj);

        //Vai retornar o caminho com o id do usuario criado
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

        //Retorna o corpo(body) vazio com o código 200(created), na header retorna o URI
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);

        //Reposta quando não retorna nada é 204 (No content)
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody UserDTO objDto, @PathVariable String id) {
        User obj = service.fromDto(objDto);
        obj.setId(id);
        obj = service.update(obj);

        //Reposta quando não retorna nada é 204 (No content)
        return ResponseEntity.noContent().build();
    }
}