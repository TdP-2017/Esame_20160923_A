package it.polito.tdp.gestionale.model;

import java.util.ArrayList;
import java.util.List;

public class Studente {

	private List<Corso> corsi;
	private int matricola;
	private String cognome;
	private String nome;
	private String cds;

	public Studente(int matricola) {
		this.matricola = matricola;
	}

	public Studente(int matricola, String cognome, String nome, String cds) {
		this.matricola = matricola;
		this.cognome = cognome;
		this.nome = nome;
		this.cds = cds;
	}

	/*
	 * Getters and Setters
	 */
	public int getMatricola() {
		return matricola;
	}

	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}

	public String getCognome() {
		if (cognome == null)
			return "";
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		if (nome == null)
			return "";
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCds() {
		if (cds == null)
			return "";
		return cds;
	}

	public void setCds(String cds) {
		this.cds = cds;
	}

	public List<Corso> getCorsi() {
		if (corsi == null) {
			return new ArrayList<Corso>();
		}
		return corsi;
	}

	public void setCorsi(List<Corso> corsi) {
		this.corsi = corsi;
	}
}
