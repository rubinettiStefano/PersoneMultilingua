package views;

import model.entities.Persona;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TraduttoreInglese implements iTraduttore
{
	private Map<String,String> traduzioni = new HashMap<>();

	public TraduttoreInglese()
	{
		traduzioni.put("IN_NOME","Could you please insert the name?");
		traduzioni.put("IN_ID","Insert ID");
		traduzioni.put("IN_COGNOME","GIVE ME SURNAME");
		traduzioni.put("IN_DOB","INSERT DOB eu format plz");
		traduzioni.put("IN_COM","Insert Command");
		traduzioni.put("OUT_QUIT","Bye Bye");
		traduzioni.put("INV_CMD","Invalid Command");
		traduzioni.put("INV_INS","Invalid data");
		traduzioni.put("VAL_INS","Success");
		traduzioni.put("INV_ID","ID IS A NUMBER");
		traduzioni.put("PNF","Person not found");
	}

	@Override
	public String traduciTesto(String testoKey)
	{
		return traduzioni.get(testoKey);
	}

	@Override
	public String produciStampaPersona(Persona p)
	{
		return "Hello my name is "+p.getNome()+" "+p.getCognome()+" and i was born on "+p.getDob();
	}

	@Override
	public String produciStampaListaPersone(List<Persona> persone)
	{
		return "";
	}
}
