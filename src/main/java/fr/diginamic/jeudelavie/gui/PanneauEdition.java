package fr.diginamic.jeudelavie.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import fr.diginamic.jeudelavie.entites.Grille;

/**
 * Composant principal avec les éléments interactifs :
 * <ul>
 * <li>250 boutons permettant de créer une structure</li>
 * <li>un bouton valider pour sauvegarder la grille</li>
 * </ul>
 * 
 * @author RichardBONNAMY
 *
 */
public class PanneauEdition extends JFrame {

	/** Dimensions d'une cellule (carré) en pixels */
	private static int CELL_SIZE = 20;

	/** serialVersionUID */
	private static final long serialVersionUID = 1454047456314804234L;

	/** Bouton marche/arrêt */
	private JButton boutonValider;

	/** Nombre de lignes contenues dans le panneau d'édition d'une configuration */
	private int nbLignes = 25;
	
	/** Nombre de lignes contenues dans le panneau d'édition d'une configuration */
	private int nbColonnes = 25;
	
	/** Grille du panneau d'édition */
	Grille grille = new Grille(70, 70);

	/**
	 * Constructeur Permet de placer les différents éléments sur le panneau
	 * 
	 * @param panneauJeu panneau principal
	 */
	public PanneauEdition(PanneauJeu panneauJeu) {

		this.setLayout(null);
		setBounds(150, 150, 630, 670);

		boutonValider = new JButton("Valider");
		boutonValider.setBounds(260, 20, 100, 30);
		boutonValider.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				panneauJeu.updateGrille(grille.clone());
				panneauJeu.repaint();
			}
		});

		int xOri = 30;
		int yOri = 60;

		int xMargin = 2;
		int yMargin = 2;

		for (int i = 1; i <= nbLignes; i++) {
			for (int j = 1; j <= nbColonnes; j++) {
				JCell button = new JCell(grille, j, i);
				button.setBounds(xOri + (j - 1) * (CELL_SIZE + xMargin) + xMargin,
						yOri + (i - 1) * (CELL_SIZE + yMargin) + yMargin, CELL_SIZE, CELL_SIZE);
				add(button);
			}
		}

		// Spécifier la position et la taille du bouton
		add(boutonValider);

		int x = SwingUIBuilder.getX(this);
		int y = SwingUIBuilder.getY(this);
		setLocation(x, y);
	}
}