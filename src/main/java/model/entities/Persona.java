package model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
public class Persona
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome,cognome;
	private LocalDate dob;

	public Persona(){}

	public Persona(Long id, String nome, String cognome, LocalDate dob)
	{
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.dob = dob;
	}

	public Persona( String nome, String cognome, LocalDate dob)
	{
		this.nome = nome;
		this.cognome = cognome;
		this.dob = dob;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public String getCognome()
	{
		return cognome;
	}

	public void setCognome(String cognome)
	{
		this.cognome = cognome;
	}

	public LocalDate getDob()
	{
		return dob;
	}

	public void setDob(LocalDate dob)
	{
		this.dob = dob;
	}

	public void setDob(String dobStringa)
	{
		this.dob = LocalDate.parse(dobStringa);//1995-08-27
	}

	public void setDob(int anno,int mese,int giorno)
	{
		this.dob = LocalDate.of(anno,mese,giorno);
	}

	public void setDob(String dobStringa,String formato)
	{
		String pattern;
		switch (formato)
		{
			case "EU" ->pattern= "dd/MM/yyyy";
			case "US" ->pattern= "MM/dd/yyyy";
			default ->pattern= "yyyy-MM-dd";
		}
		this.dob = LocalDate.parse(dobStringa, DateTimeFormatter.ofPattern(pattern));
	}
}
