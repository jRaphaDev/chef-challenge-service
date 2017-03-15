package br.com.caicara.tech.services;

import br.com.caicara.tech.model.Ingredient;

public interface IngredientService {

	Iterable<Ingredient> listAllIngredient();
	
	Ingredient getIngredientById(long id);
	
	Ingredient saveIngredient(Ingredient ingredient);
	
	void deleteIngredient(Ingredient ingredient);

}
