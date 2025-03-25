package model.dao;

import model.entities.Persona;
import org.hibernate.Session;

import java.util.List;

public class PersonaDAO implements iPersonaDAO
{
	private Session session;

	public PersonaDAO(Session session)
	{
		this.session = session;
	}

	@Override
	public Persona findById(Long id)
	{
		return null;
	}

	@Override
	public List<Persona> findAll()
	{
		return List.of();
	}

	@Override
	public void save(Persona p)
	{

	}

	@Override
	public void delete(Long id)
	{

	}
}
