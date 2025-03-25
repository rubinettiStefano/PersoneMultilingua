package controllers;

import model.dao.PersonaDAO;
import model.dao.iPersonaDAO;
import model.entities.Persona;
import org.hibernate.Session;
import utility.HibernateUtil;
import views.TraduttoreInglese;
import views.TraduttoreItaliano;
import views.TraduttoreScelta;
import views.iTraduttore;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MainMultilingua
{
	static Scanner sc = new Scanner(System.in);
	static Session session = HibernateUtil.getSessionFactory().openSession();
	static TraduttoreItaliano ita = new TraduttoreItaliano();
	static TraduttoreInglese eng = new TraduttoreInglese();
	static TraduttoreScelta scelta = new TraduttoreScelta();

	//MODEL
	static iPersonaDAO personaDao = new PersonaDAO(session);
	//VIEW
	static iTraduttore t;

	public static void main(String[] args)
	{
		cambiaLingua();
		String cmd;
		do
		{
			System.out.println(t.traduciTesto("IN_COM"));
			cmd = sc.nextLine().toUpperCase();

			switch (cmd)
			{
				case "INSERT" -> create();
				case "READONE" -> read();
				case "READALL" -> readAll();
				case "DELETE" -> delete();
				case "LANG" -> cambiaLingua();
				case "QUIT" -> System.out.println("OUT_QUIT");
				default -> System.out.println("INV_CMD");

			}
		} while (!cmd.equals("QUIT"));



	}

	private static void create()
	{
		try
		{
			Persona p = new Persona();
			System.out.println(t.traduciTesto("IN_NOME"));
			p.setNome(sc.nextLine());
			System.out.println(t.traduciTesto("IN_COGNOME"));
			p.setCognome(sc.nextLine());
			System.out.println(t.traduciTesto("IN_DOB"));
			p.setDob(sc.nextLine(),"EU");
			personaDao.save(p);
			System.out.println(t.traduciTesto("VAL_INS"));
		} catch (Exception e)
		{
			System.out.println(t.traduciTesto("INV_INS"));
		}
	}

	private static void read()
	{
		try
		{
			System.out.println(t.traduciTesto("IN_ID"));
			Long id = Long.parseLong(sc.nextLine());
			Persona p = personaDao.findById(id);
			if(p==null)
				System.out.println(t.traduciTesto("PNF"));
			else
				System.out.println(t.produciStampaPersona(p));

		}catch (Exception e)
		{
			System.out.println(t.traduciTesto("INV_ID"));
		}


	}

	private static void readAll()
	{
		//il controller usa il model per ottenere i dati (punto 3/4 schema)
		List<Persona> dati = personaDao.findAll();

		//punto 5/6, il controller manda i dati alla view, la quale produce
		//una grafica e la manda indietro
		String grafica = t.produciStampaListaPersone(dati);

		//punto 7, il controller fa OUTPUT verso Actor
		System.out.println(grafica);

	}

	private static void delete()
	{

	}

	public static void cambiaLingua()
	{
		System.out.println("CHOOSE YOUR LANGUAGE (ITA/ENG/SCELTA)");
		String lingua = sc.nextLine();

		switch (lingua.toUpperCase())
		{
			case "ITA" 		-> t=ita;
			case "ENG" 		-> t=eng;
			case "SCELTA" 	-> t=scelta;
			default 		-> t=ita;
		}
	}

}

