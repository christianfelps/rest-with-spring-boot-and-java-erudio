package br.com.christianfelps.repository;

import br.com.christianfelps.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
