package com.ilse.springBootMySql.controller.person;

import com.ilse.springBootMySql.domain.person.Inss;
import com.ilse.springBootMySql.domain.person.Person;
import com.ilse.springBootMySql.domain.person.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Controller
@RequestMapping(path="/person")
public class PersonController {

    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private PersonRepository personRepository;


    @PostMapping(value = "/add", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public void addPerson(@Valid @RequestBody PersonTO personTO) {
        Person savedPerson = personRepository.save(new Person(personTO.getName(), personTO.getFirstName(), new Inss(personTO.getInss())));
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Person> getAllPersons() {
        // This returns a JSON or XML with the users
        return personRepository.findAll();
    }

//    @GetMapping(path="/update")
//    public @ResponseBody
//    User updateUser (@RequestParam Integer id, @RequestParam String name, @RequestParam String email) {
//
//        if (userRepository.existsById(id)) {
//            User n = new User();
//            n.setId(id);
//            n.setName(name);
//            n.setEmail(email);
//            return userRepository.save(n);
//        }
//        throw new IllegalArgumentException("User to update does not exist with id " + id);
//    }

//    @GetMapping(path="/delete")
//    public @ResponseBody
//    String deleteUser (@RequestParam Integer id) {
//
//        if (userRepository.existsById(id)) {
//            userRepository.deleteById(id);
//            return "User with id " + id + " deleted";
//        }
//
//        return "User with id " + id + " to delete does not exist!";
//    }
}