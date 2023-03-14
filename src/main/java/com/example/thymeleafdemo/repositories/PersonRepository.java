package com.example.thymeleafdemo.repositories;

import com.example.thymeleafdemo.model.Person;
import org.springframework.stereotype.Repository;
import java.util.Arrays;
import java.util.List;

@Repository
public class PersonRepository {

  //This is a stub version of the database

  public Person findPerson(String name) {
    return new Person ("Fred", 25);
  }

  public List<Person> findAll() {
    List persons = Arrays.asList(new Person("Fred", 25), new Person("Lisa", 27), new Person("Tom", 17));
    return persons;
  }
}
