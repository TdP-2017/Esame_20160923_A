package it.polito.tdp.gestionale.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import it.polito.tdp.gestionale.db.DidatticaDAO;

public class Model {

	private List<Corso> corsi;
	private List<Studente> studenti;
	private DidatticaDAO didatticaDAO;
	private SimpleGraph<Nodo, DefaultEdge> grafo;
	private Map<Integer, Studente> mappaStudenti;

	public Model() {
		grafo = new SimpleGraph<Nodo, DefaultEdge>(DefaultEdge.class);
		didatticaDAO = new DidatticaDAO();
		mappaStudenti = new HashMap<Integer, Studente>();
	}

	public List<Studente> getTuttiStudenti() {
		if (studenti == null) {
			studenti = didatticaDAO.getTuttiStudenti();
			for (Studente studente : studenti) {
				mappaStudenti.put(studente.getMatricola(), studente);
			}
		}
		return studenti;
	}

	public List<Corso> getTuttiCorsi() {
		if (corsi == null) {
			corsi = didatticaDAO.getTuttiICorsi();
			// Trick!
			getTuttiStudenti();
			for (Corso corso : corsi) {
				didatticaDAO.setStudentiIscrittiAlCorso(corso, mappaStudenti);
			}
		}
		return corsi;
	}

	public void generaGrafo() {

		studenti = getTuttiStudenti();
		System.out.println("Studenti #: " + studenti.size());

		corsi = getTuttiCorsi();
		System.out.println("Corsi #: " + corsi.size());

		// Aggiungiamo i nodi
		Graphs.addAllVertices(grafo, studenti);
		Graphs.addAllVertices(grafo, corsi);
		System.out.println("Numero vertici: " + grafo.vertexSet().size());

		// Aggiungiamo gli archi
		for (Corso corso : corsi) {
			for (Studente studente : corso.getStudenti())
				grafo.addEdge(corso, studente);
		}
		System.out.println("Numero archi: " + grafo.edgeSet().size());
		System.out.println("Grafo CREATO!!");
	}

	public List<Integer> getStatCorsi() {

		List<Integer> statCorsi = new ArrayList<Integer>();

		// Inizializzo la struttura dati dove salvare le statistiche
		for (int i = 0; i < corsi.size() + 1; i++) {
			statCorsi.add(0);
		}

		// Aggiorno le statistiche
		for (Studente studente : studenti) {
			int ncorsi = Graphs.neighborListOf(grafo, studente).size();
			int counter = statCorsi.get(ncorsi);
			counter++;
			statCorsi.set(ncorsi, counter);
		}

		return statCorsi;
	}
	
	List<Corso> findMinimalSet(){
		List<Corso> soluzioneParziale = new ArrayList<Corso>();
		List<Corso> soluzioneMigliore = new ArrayList<Corso>();
		
		recursive(soluzioneParziale, soluzioneMigliore);
		
		return soluzioneMigliore;
	}
	
	void recursive(List<Corso> soluzioneParziale, List<Corso> soluzioneMigliore) {
		
//		System.out.println(soluzioneParziale);
		
		HashSet<Studente> hashSetStudenti = new HashSet<Studente>(getTuttiStudenti());
		for (Corso corso : soluzioneParziale) {
			hashSetStudenti.removeAll(corso.getStudenti());
		}
		if (hashSetStudenti.isEmpty()) {
			if (soluzioneMigliore.isEmpty())
				soluzioneMigliore.addAll(soluzioneParziale);
			if (soluzioneParziale.size() < soluzioneMigliore.size()){
				soluzioneMigliore.clear();
				soluzioneMigliore.addAll(soluzioneParziale);
			}
		}
		
		for (Corso corso : getTuttiCorsi()) {
			if (soluzioneParziale.isEmpty() || corso.compareTo(soluzioneParziale.get(soluzioneParziale.size()-1)) > 0) {
				soluzioneParziale.add(corso);
				recursive(soluzioneParziale, soluzioneMigliore);
				soluzioneParziale.remove(corso);
			}
		}
		
	}
}
