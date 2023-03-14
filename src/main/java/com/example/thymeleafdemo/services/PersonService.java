package com.example.thymeleafdemo.services;

import com.example.thymeleafdemo.model.Person;
import com.example.thymeleafdemo.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

  private PersonRepository personRepo;

  public PersonService(PersonRepository personRepo) {
    this.personRepo = personRepo;
  }

  public Person findPerson(String name) {
    return personRepo.findPerson(name);
  }

  public List<Person> findAll() {
    return personRepo.findAll();
  }
}
