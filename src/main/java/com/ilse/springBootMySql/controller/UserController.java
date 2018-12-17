package com.ilse.springBootMySql.controller;

import com.ilse.springBootMySql.domain.User;
import com.ilse.springBootMySql.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/demo")
public class UserController {

    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private UserRepository userRepository;

    @GetMapping(path="/add") // Map ONLY GET Requests
    public @ResponseBody
    User addNewUser (@RequestParam String name, @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User n = new User();
        n.setName(name);
        n.setEmail(email);
        return userRepository.save(n);
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

    @GetMapping(path="/update")
    public @ResponseBody
    User updateUser (@RequestParam Integer id, @RequestParam String name, @RequestParam String email) {

        if (userRepository.existsById(id)) {
            User n = new User();
            n.setId(id);
            n.setName(name);
            n.setEmail(email);
            return userRepository.save(n);
        }
        throw new IllegalArgumentException("User to update does not exist with id " + id);
    }

    @GetMapping(path="/delete")
    public @ResponseBody
    String deleteUser (@RequestParam Integer id) {

        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return "User with id " + id + " deleted";
        }

        return "User with id " + id + " to delete does not exist!";
    }
}
