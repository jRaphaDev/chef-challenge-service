package br.com.caicara.tech.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.caicara.tech.model.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, Long>{

}
