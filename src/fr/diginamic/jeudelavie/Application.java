package fr.diginamic.jeudelavie;

import java.awt.Color;
import java.awt.Dimension;

import fr.diginamic.jeudelavie.gui.GUIHelper;
import fr.diginamic.jeudelavie.gui.PanneauJeu;

public class Application {

	public static void main(String[] args) throws InterruptedException {

		PanneauJeu panneauJeu = new PanneauJeu();
		panneauJeu.setBackground(Color.WHITE);
		panneauJeu.setPreferredSize(new Dimension(1030, 800));
		GUIHelper.showOnFrame(panneauJeu, "Conway's Game of Life");
		
		panneauJeu.demarrer();
	}

}