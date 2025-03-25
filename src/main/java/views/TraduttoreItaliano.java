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
		traduzioni.put("IN_COGNOME","Mannaggia a te, dammi cognome");
		traduzioni.put("IN_DOB","Mannaggia a te, dammi data nascita formato eu");
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
		return "";
	}
}
