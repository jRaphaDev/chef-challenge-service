package br.com.caicara.tech.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.caicara.tech.model.Person;

public interface PersonRepository extends CrudRepository<Person, Long>{

}
