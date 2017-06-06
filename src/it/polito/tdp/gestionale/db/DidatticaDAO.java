package it.polito.tdp.gestionale.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import it.polito.tdp.gestionale.model.Corso;
import it.polito.tdp.gestionale.model.Studente;

public class DidatticaDAO {

	/*
	 * Ottengo tutti gli studenti iscritti al Corso
	 */
	public void setStudentiIscrittiAlCorso(Corso corso, Map<Integer, Studente> mapStudenti) {
		final String sql = "SELECT studente.matricola FROM iscrizione, studente WHERE iscrizione.matricola=studente.matricola AND codins=?";

		List<Studente> studentiIscrittiAlCorso = new ArrayList<Studente>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, corso.getCodins());

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int matricola = rs.getInt("matricola");
				Studente studente = mapStudenti.get(matricola);
				if (studente != null) {
					studentiIscrittiAlCorso.add(studente);
				} else {
					System.out.println("ERRORE! Lo studente non è presente!");
				}
			}

			corso.setStudenti(studentiIscrittiAlCorso);

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}

	/*
	 * Ottengo tutti i corsi salvati nel Db
	 */
	public List<Corso> getTuttiICorsi() {

		final String sql = "SELECT * FROM corso";

		List<Corso> corsi = new LinkedList<Corso>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				Corso s = new Corso(rs.getString("codins"), rs.getInt("crediti"), rs.getString("nome"), rs.getInt("pd"));
				corsi.add(s);
			}

			return corsi;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}

	/*
	 * Ottengo tutti gli studenti salvati nel Db
	 */
	public List<Studente> getTuttiStudenti() {

		final String sql = "SELECT * FROM studente";

		List<Studente> studenti = new LinkedList<Studente>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				Studente s = new Studente(rs.getInt("matricola"), rs.getString("cognome"), rs.getString("nome"), rs.getString("CDS"));
				studenti.add(s);
			}

			return studenti;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}

}
