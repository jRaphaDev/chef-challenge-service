package br.com.caicara.tech.services;

import br.com.caicara.tech.model.Person;

public interface PersonService {
	
    Iterable<Person> listAllPerson();

    Person getPersonById(Long id);

    Person savePerson(Person person);

    void deletePerson(Person person);
    
}
