package br.com.springboot.springboot.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.springboot.model.User;

@RestController
@RequestMapping("/users") // passando o path para o controller.
public class UserController {


    private List<User> users = new ArrayList<>(); // "nosso banco em memorio"

    // Para cada método HTTP vamos ter uma anotation.
    @GetMapping("/{id} ")
    public User user(@PathVariable("id") Long id) {
        

        Optional<User> userFind = users.stream().filter(user -> user.getId() == id).findFirst();
        
        if (userFind.isPresent()){
            return userFind.get();
        }
        return null;
    }

    @PostMapping("/")
    public User user(@RequestBody  User user){ // definindo que o user vai vir da request.body.
        users.add(user);
        return user;
    }

    @GetMapping("/list")
    public List<User> list() {
        return users;
    }

}
