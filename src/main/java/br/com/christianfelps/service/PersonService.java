package br.com.christianfelps.service;

import br.com.christianfelps.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {
    private final AtomicLong counter = new AtomicLong();
    private final Logger logger = Logger.getLogger(PersonService.class.getName());
    public List<Person> findAll() {
        logger.info("Finding all people");
        List<Person> people = new ArrayList<Person>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            people.add(person);
        }

        return people;
    }



    public Person findById(String id) {
        logger.info("Finding one person");
        Person person = new Person();
        person.setId();
        person.setFirstName("Christian");
        person.setLastName("Alvim");
        person.setAddress("Judiapeba");
        person.setGender("M");
        return person;
    }

    public Person create (Person person) {
        logger.info("Creating a new person");
        return person;
    }
    public Person update (Person person) {
        logger.info("Updating a new person");
        return person;
    }

    public void delete(String id) {
        logger.info("Deleting a person");

    }



        private Person mockPerson(int i) {
            Person person = new Person();
            person.setId();
            person.setFirstName("FirstName" + i);
            person.setLastName("lastName" + i);
            person.setAddress("Same" + i);
            if(i % 2 == 0){ person.setGender("M" );
            } else{ person.setGender("F"); };
            return person;
        }

    }

