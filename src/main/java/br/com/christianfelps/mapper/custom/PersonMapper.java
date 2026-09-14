package br.com.christianfelps.mapper.custom;

import br.com.christianfelps.data.dto.PersonDTO;
import br.com.christianfelps.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class PersonMapper {

    public PersonDTO convertEntityToDTO (Person person) {
        PersonDTO dto = new PersonDTO();
        dto.setId(person.getId());
        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        dto.setAddress(person.getAddress());
        dto.setGender(person.getGender());
        dto.setEnabled(person.getEnabled());
        return dto;
    }
    public Person convertDTOToEntity (PersonDTO person) {
        Person entity = new Person();
        entity.setId(person.getId());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        entity.setEnabled(person.getEnabled());
        return entity;
    }
}
