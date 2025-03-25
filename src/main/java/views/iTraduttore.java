package views;

import model.entities.Persona;

import java.util.List;

public interface iTraduttore
{
	/**
	 * Riceve una chiave di un testo (es IN_NOME) e da la frase corrispondente nella lingua giusta
	 */
	String traduciTesto(String testoKey);

	/**
	 * Il toString di una Persona sostanzialmente, ma mettendolo qui possiamo averlo nelle varie lingue
	 */
	String produciStampaPersona(Persona p);
	/**
	 * Il toString di una Lista di persone sostanzialmente, ma mettendolo qui possiamo averlo nelle varie lingue
	 */
	String produciStampaListaPersone(List<Persona> persone);
}
