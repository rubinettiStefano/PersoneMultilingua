package model.dao;

import model.entities.Persona;
import org.hibernate.Session;
import utility.exceptions.ObjectNotFoundException;

import java.util.List;

public class PersonaDAO implements iPersonaDAO
{
	private Session session;

	public PersonaDAO(Session session)
	{
		this.session = session;
	}

	public Persona findById(Long id)
	{
		session.beginTransaction();
		Persona res = session.get(Persona.class,id);
		session.getTransaction().commit();
		return res;
	}

	public List<Persona> findAll()
	{
		session.beginTransaction();
		List<Persona> res = session.createQuery("SELECT p FROM Persona p", Persona.class).getResultList();
		session.getTransaction().commit();
		return  res;
	}

	public void save(Persona s)
	{
		session.beginTransaction();
		session.save(s);
		session.getTransaction().commit();
	}

	public void delete(Long id)
	{
		session.beginTransaction();
		Persona toDelete =findById(id);
		if(toDelete==null)
			throw new ObjectNotFoundException("Non posso cancellare qualcosa che non esiste");

		session.delete(toDelete);
		session.getTransaction().commit();
	}
}
