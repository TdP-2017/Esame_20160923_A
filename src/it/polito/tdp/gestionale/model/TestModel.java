package it.polito.tdp.gestionale.model;

import java.util.List;

public class TestModel {

	public static void main(String[] args) {

		Model model = new Model();
		
		model.generaGrafo();
		
		List<Integer> stat = model.getStatCorsi();
		int counter = 0;
		for (Integer i : stat) {
			System.out.format("Numero di studenti che seguono %d corsi: %d\n", counter, i);
			counter++;
		}
	}

}
