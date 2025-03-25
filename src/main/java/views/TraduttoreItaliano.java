package views;

import model.entities.Persona;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TraduttoreItaliano implements iTraduttore
{
	private Map<String,String> traduzioni = new HashMap<>();

	public TraduttoreItaliano()
	{
		traduzioni.put("IN_NOME","Per favore inserisci il nome? grazie");
		traduzioni.put("IN_ID","Inserisci ID");
		traduzioni.put("IN_COGNOME","Mannaggia a te, dammi cognome");
		traduzioni.put("IN_DOB","Mannaggia a te, dammi data nascita formato eu");
		traduzioni.put("IN_COM","Inserisci Comando");
		traduzioni.put("OUT_QUIT","Ciao ciao");
		traduzioni.put("INV_CMD","Comando non valido");
		traduzioni.put("INV_INS","Dati non validi");
		traduzioni.put("VAL_INS","Complimenti, persona creata");
		traduzioni.put("INV_ID","Devi mettere un numero");
		traduzioni.put("PNF","Persona non trovata");
	}

	@Override
	public String traduciTesto(String testoKey)
	{
		return traduzioni.get(testoKey);
	}

	@Override
	public String produciStampaPersona(Persona p)
	{
		return "Ciao mi chiamo "+p.getNome()+" "+p.getCognome()+" e sono nato il "+p.getDob();
	}

	@Override
	public String produciStampaListaPersone(List<Persona> persone)
	{
		String res="Lista di persone:\n";
		for(Persona p:persone)
			res+="Nominativo: "+p.getNome()+" "+p.getCognome()+", dob: "+p.getDob()+"/n";

		//Lista di persone
		//Nominativo: Stefano Rubinetti, dob: 1995-08-27
		//Nominativo: Claudio Costantino, dob: 1999-03-16
		return res;
	}
}
