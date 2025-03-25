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
import java.util.Scanner;

public class MainMultilingua
{
	static Scanner sc = new Scanner(System.in);
	static Session session = HibernateUtil.getSessionFactory().openSession();
	static iPersonaDAO personaDao = new PersonaDAO(session);
	static iTraduttore t;
	static TraduttoreItaliano ita = new TraduttoreItaliano();
	static TraduttoreInglese eng = new TraduttoreInglese();
	static TraduttoreScelta scelta = new TraduttoreScelta();

	public static void main(String[] args)
	{
		cambiaLingua();

		//0) creare un db chiamato personemultilingua
		//1)Completare DAO
		//2) Fare qui il ciclo principale come chiesto sotto
		//3) Aggiungere nei costruttori dei traduttori le coppie chiave-valore
		//	di ciò che volete tradurre
		//4) Fare il metodo mancante nei traduttore
		//5) provare

		//esempio, voi fate il ciclo principale con i metodi
		//per stampare TUTTE LE PERSONE
		//per stampare una sola persona dato l'id
		//per inserire nuova persona
		//per cancellare una persona
		//per cambiare lingua
		//+classici sbagliato e quit

		//vi faccio come esempio inserimento di dati di una persona e
		//stampa della stessa
		Persona p = new Persona();
		System.out.println(t.traduciTesto("IN_NOME"));
		p.setNome(sc.nextLine());

		System.out.println(t.traduciTesto("IN_COGNOME"));
		p.setCognome(sc.nextLine());

		cambiaLingua();

		System.out.println(t.traduciTesto("IN_DOB"));
		p.setDob(sc.nextLine(),"EU");

		System.out.println(t.produciStampaPersona(p));



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
