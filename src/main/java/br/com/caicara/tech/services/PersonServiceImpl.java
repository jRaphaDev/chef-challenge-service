package br.com.caicara.tech.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.caicara.tech.model.Person;
import br.com.caicara.tech.relatorio.ClienteREL;
import br.com.caicara.tech.repositories.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {
	
	private PersonRepository personRepository;
	
	@Autowired
    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

	@Override
	public Iterable<Person> listAllPerson() {
		Iterable<Person> people = personRepository.findAll();
		ClienteREL relatorio = new ClienteREL();
		relatorio.imprimir(people);
		return people;
	}

	@Override
	public Person getPersonById(Long id) {
		return personRepository.findOne(id);
	}

	@Override
	public Person savePerson(Person person) {
		return personRepository.save(person);
	}

	@Override
	public void deletePerson(Person person) {
		personRepository.delete(person);
	}

}
