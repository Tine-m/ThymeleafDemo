package com.example.thymeleafdemo.controllers;

import com.example.thymeleafdemo.model.Person;
import com.example.thymeleafdemo.services.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("person")
public class PersonController {

  private PersonService personService;

  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  @GetMapping("/find")
  public String getPerson(Model model) {
    Person fred = personService.findPerson("fred");
    model.addAttribute("person", fred);
    return "person";
  }

  @GetMapping("/findAll")
  public String getAll(Model model) {
    List<Person> people = personService.findAll();
    model.addAttribute("list", people);
    return "people";
  }

  @GetMapping("/oldEnough")
  public String findOut(Model model) {
    List<Person> people = personService.findAll();
    model.addAttribute("list", people);
    return "personInfo";
  }
}
