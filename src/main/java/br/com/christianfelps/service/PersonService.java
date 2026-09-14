package br.com.christianfelps.service;

import br.com.christianfelps.controllers.PersonController;
import br.com.christianfelps.data.dto.PersonDTO;
import br.com.christianfelps.exception.RequiredObjectIsNullException;
import br.com.christianfelps.mapper.custom.PersonMapper;
import br.com.christianfelps.model.Person;
import br.com.christianfelps.repository.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.logging.Logger;

import static br.com.christianfelps.mapper.ObjectMapper.parseListObjects;
import static br.com.christianfelps.mapper.ObjectMapper.parseObject;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class PersonService {
    private final Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepository repository;

    @Autowired
    PersonMapper converter;

    public List<PersonDTO> findAll() {
        logger.info("Finding all people");
       var people = parseListObjects(repository.findAll(), PersonDTO.class);
       people.forEach(PersonService::addHateoasLinks);
        return people;
    }



    public PersonDTO findById(Long id) {
        logger.info("Finding one person");

        var entity = repository.findById(id)
                .orElseThrow(() -> new RequiredObjectIsNullException("No records found for this ID"));
        var dto =  parseObject(entity, PersonDTO.class);
        addHateoasLinks(dto);
        return dto;
    }

    public PersonDTO create (PersonDTO person) {

        if(person == null) throw new RequiredObjectIsNullException();
        logger.info("Creating a new person");
        var entity = parseObject(person, Person.class);
        var dto = parseObject(repository.save(entity), PersonDTO.class);
        addHateoasLinks(dto);
        return dto;
    }


    public PersonDTO update (PersonDTO person) {
        if(person == null) throw new RequiredObjectIsNullException();
        logger.info("Updating a new person");
        Person entity = repository.findById(person.getId()).orElseThrow(() -> new RequiredObjectIsNullException("No records found for this ID"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        var dto = parseObject(repository.save(entity), PersonDTO.class);
         addHateoasLinks(dto);
         return dto;
    }

    public void delete(Long id) {
        logger.info("Deleting a person");
        Person entity = repository.findById(id)
                .orElseThrow(() -> new RequiredObjectIsNullException("No records found for this ID"));
        repository.delete(entity);

    }

    @Transactional
    public PersonDTO disablePerson (Long id) {
        logger.info("Disabling one person");
        repository.findById(id)
                .orElseThrow(() -> new RequiredObjectIsNullException("No records found for this ID"));
        repository.disablePerson(id);

        var entity = repository.findById(id).get();
        var dto = parseObject(entity, PersonDTO.class);
        addHateoasLinks(dto);
        return dto;

    }

    private static void addHateoasLinks(PersonDTO dto) {
        dto.add(linkTo(methodOn(PersonController.class).findById(dto.getId())).withSelfRel().withType("GET"));
        dto.add(linkTo(methodOn(PersonController.class).findAll()).withRel("findAll").withType("GET"));
        dto.add(linkTo(methodOn(PersonController.class).create(dto)).withRel("create").withType("POST"));
        dto.add(linkTo(methodOn(PersonController.class).update(dto)).withRel("update").withType("PUT"));
        dto.add(linkTo(methodOn(PersonController.class).disablePerson(dto.getId())).withRel("disable").withType("PATCH"));
        dto.add(linkTo(methodOn(PersonController.class).delete(dto.getId())).withRel("delete").withType("DELETE"));
    }
}

