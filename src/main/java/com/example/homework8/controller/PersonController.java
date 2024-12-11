package com.example.homework8.controller;

import com.example.homework8.model.Person;
import com.example.homework8.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/persons")
    public String findAll(Model model) {
        model.addAttribute("persons", personService.findAll());
        List<Person> persons = personService.findAll();
        return "persons";
    }

    @GetMapping("/person-create")
    public String createPersonForm(Person person) {
        return "person-create";
    }

    @PostMapping("/person-create")
    public  String createPerson(Person person) {
        personService.savePerson(person);
        return "redirect:/persons";
    }

    @GetMapping("/person-delete/{id}")
    public String deletePerson (@PathVariable("id") Long id) {
        personService.deleteById(id);
        return "redirect:/persons";
    }

    @GetMapping("/person-update/{id}")
    public String updatePersonForm(@PathVariable("id") Long id, Model model) {
        Person person = personService.findById(id);
        model.addAttribute("person", person);
        return "/person-update";
    }


    @PostMapping("/person-update")
    public String updatePerson(Person person) {
        personService.savePerson(person);
        return "redirect:/persons";
    }
}
