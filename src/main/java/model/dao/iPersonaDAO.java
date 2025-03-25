package model.dao;

import model.entities.Persona;

import java.util.List;

public interface iPersonaDAO
{
	/**
	 * Restituisce una persona dato il suo id
	 * Se non presente produce null
	 */
	Persona findById(Long id);

	/**
	 * Restituisce una lista con tutte le persone nel db
	 */
	List<Persona> findAll();

	/**
	 * Fa UPSERT della persona passata come parametro
	 */
	void save(Persona p);

	/**
	 * Cancella la persona con id passato come parametro
	 * Se non presente da una ObjectNotFoundException
	 */
	void delete(Long id);
}
