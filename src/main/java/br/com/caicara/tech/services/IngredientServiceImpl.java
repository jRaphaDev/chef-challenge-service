package br.com.caicara.tech.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.caicara.tech.model.Ingredient;
import br.com.caicara.tech.repositories.IngredientRepository;

@Service
public class IngredientServiceImpl implements IngredientService {
	
	private IngredientRepository repository;
	
	@Autowired
	public IngredientServiceImpl(IngredientRepository ingredientRepository) {
		this.repository = ingredientRepository;
	}

	@Override
	public Iterable<Ingredient> listAllIngredient() {
		return repository.findAll();
	}

	@Override
	public Ingredient getIngredientById(long id) {
		return repository.findOne(id);
	}

	@Override
	public Ingredient saveIngredient(Ingredient ingredient) {
		return repository.save(ingredient);
	}

	@Override
	public void deleteIngredient(Ingredient ingredient) {
		repository.delete(ingredient);
	}

}
