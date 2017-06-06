package it.polito.tdp.gestionale.db;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.polito.tdp.gestionale.model.Corso;
import it.polito.tdp.gestionale.model.Studente;

public class TestDAO {

	public static void main(String[] args) {

		DidatticaDAO dDAO = new DidatticaDAO();
		
		// Ottengo corsi e studenti
		List<Corso> corsi = dDAO.getTuttiICorsi(); 
		System.out.println(corsi.size());
		List<Studente> studenti = dDAO.getTuttiStudenti();
		System.out.println(studenti.size());
		
		// Creo una mappa con studenti e matricola
		Map<Integer, Studente> mapStudenti = new HashMap<Integer, Studente>();
		for (Studente studente: studenti)
			mapStudenti.put(studente.getMatricola(), studente);
		
		// Completo le informazioni di un corso
		Corso corso = new Corso("01KSUPG");
		dDAO.setStudentiIscrittiAlCorso(corso, mapStudenti);
		System.out.println(corso.getStudenti());
	}

}
