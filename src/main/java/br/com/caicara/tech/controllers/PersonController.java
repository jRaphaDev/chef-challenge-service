package br.com.caicara.tech.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.caicara.tech.model.Person;
import br.com.caicara.tech.services.PersonService;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/person")
public class PersonController {

	private PersonService personService;

	@Autowired
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Person person) {
		try {
			personService.savePerson(person);
			System.out.println("Saving person " );
	        return Response.created(URI.create("/person/" + person.getId())).entity(person).type(MediaType.APPLICATION_JSON).build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}

	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public Response list() {
		try {
			Iterable<Person> list = personService.listAllPerson();
			System.out.println("Returning people " );
			return Response.ok().entity(list).build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}

	@GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public Response getPerson(@PathParam("id") Long id) {
		try {
			Person person = personService.getPersonById(id);
			System.out.println("Returning people " );
			return Response.ok().entity(person).build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") Long id, Person person) {
		try {
			if (personService.getPersonById(id) == null) {
	            Response.status(Status.NOT_FOUND).build();
	        }
			personService.savePerson(person);
			System.out.println("Saving person ");
	        return Response.noContent().entity(person).type(MediaType.APPLICATION_JSON).build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") Long id) {
		try {
			Person person = personService.getPersonById(id);
			if (person == null) {
	            Response.status(Status.NOT_FOUND).build();
	        }
			personService.deletePerson(person);
			System.out.println("Deleting person ");
	        return Response.noContent().build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}

}
