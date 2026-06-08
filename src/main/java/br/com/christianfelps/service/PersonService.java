package br.com.christianfelps.service;

import br.com.christianfelps.data.dto.PersonDTO;
import br.com.christianfelps.exception.ResourceNotFoundException;
import br.com.christianfelps.mapper.custom.PersonMapper;
import br.com.christianfelps.model.Person;
import br.com.christianfelps.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import static br.com.christianfelps.mapper.ObjectMapper.parseListObjects;
import static br.com.christianfelps.mapper.ObjectMapper.parseObject;

@Service
public class PersonService {
    private final AtomicLong counter = new AtomicLong();
    private final Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepository repository;

    @Autowired
    PersonMapper converter;

    public List<PersonDTO> findAll() {
        logger.info("Finding all people");
       return parseListObjects(repository.findAll(), PersonDTO.class);
    }



    public PersonDTO findById(Long id) {
        logger.info("Finding one person");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        return parseObject(entity, PersonDTO.class);
    }

    public PersonDTO create (PersonDTO person) {
        logger.info("Creating a new person");
        var entity = parseObject(person, Person.class);
        return parseObject(repository.save(entity), PersonDTO.class);
    }


    public PersonDTO update (PersonDTO person) {
        logger.info("Updating a new person");
        Person entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return parseObject(repository.save(entity), PersonDTO.class);
    }

    public void delete(Long id) {
        logger.info("Deleting a person");
        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        repository.delete(entity);

    }
}

