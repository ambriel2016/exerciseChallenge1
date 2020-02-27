package com.cristian.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    PersonRepository personRepository;

    @Override
    public void run(String... strings) throws Exception{
        Person person1;
        person1 = new Person(1, "Lucas S.", "Marsh", 61);
        personRepository.save(person1);

        Person person2 = new Person(2, "Ron T.", "Hayes", 82);
        personRepository.save(person2);

        Person person3 = new Person(3, "Audrey F. ", "Hill", 27);
        personRepository.save(person3);

        Person person4 = new Person(4, "Danielle M.", "Pratt", 71);
        personRepository.save(person4);

        Person person5 = new Person(5, "Tosha R.", "Simpson", 30);
        personRepository.save(person5);
    }
}

