package fr.diginamic.jeudelavie.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * Classe qui propose quelques méthodes pour construire des composants
 * graphiques
 * 
 * @author RichardBONNAMY
 *
 */
public class SwingUIBuilder {

	/**
	 * FONT_18 : police par défaut utilisée pour la construction de tous les
	 * composants graphiques
	 */
	public static final Font FONT_18 = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
	/**
	 * dimension : classe qui fournit des informations sur l'écran du PC utilisé et
	 * notamment ses dimensions. Cette classe intervient dans le calcul de centrage
	 * des composants graphiques
	 */
	private static Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

	/**
	 * Constructeur
	 * 
	 */
	public SwingUIBuilder() {
	}

	/**
	 * Méthode utilitaire qui permet de calculer l'abscisse (X) idéale d'un
	 * composant graphique pour que celui-ci soit centré par rapport à l'écran de
	 * l'ordinateur utilisé.
	 * 
	 * @param component composant
	 * @return int
	 */
	public static int getY(Component component) {
		return (int) ((dimension.getHeight() - component.getHeight()) / 2);
	}

	/**
	 * Méthode utilitaire qui permet de calculer l'ordonnée (Y) idéale d'un
	 * composant graphique pour que celui-ci soit centré par rapport à l'écran de
	 * l'ordinateur utilisé.
	 * 
	 * @param component composant
	 * @return int
	 */
	public static int getX(Component component) {
		return (int) ((dimension.getWidth() - component.getWidth()) / 2);
	}

	/**
	 * Méthode qui permet de construire une fenêtre secondaire standardisée. Cette
	 * fenêtre secondaire est le point d'entrée de l'exécution d'un cas
	 * d'utilisation de l'application. <br>
	 * <br>
	 * La fenêtre secondaire est constituée d'un ensemble de couples "libellé/champ
	 * de saisie" et d'un bouton valider. <br>
	 * <br>
	 * Lorsque l'utilisateur clique sur le bouton Valider, le contrôleur est appelé
	 * avec en paramètres l'ensemble des valeurs saisies dans les divers champs de
	 * saisie.
	 * 
	 * @param menuRouter contrôleur qui est appelé lorsque l'utilisateur clique sur
	 *                   le bouton validé.
	 * @param type       type de traitement à déclencher
	 * @param questions  les questions correspondent aux différentes questions qu'on
	 *                   va poser à l'utilisateur. Un couple libellé/champ de saisie
	 *                   est généré pour chaque question de ce tableau.
	 * @return JFrame
	 */
	public static JFrame buildJFrame(String nom) {

		// Création de la fenêtre secondaire
		JFrame fenetreRecherche = new JFrame();

		// Calcul de son positionnement par défaut et de ses dimensions.
		// La hauteur dépend notamment du nombre de questions qu'on a à poser
		// à l'utilisateur
		fenetreRecherche.setBounds(100, 100, 650, 650);

		// Lorsqu'on ferme une fenêtre secondaire on ne souhaite pas arrêter
		// l'application
		// mais simplement la masquer.
		fenetreRecherche.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// Dans chaque fenêtre secondaire les composants graphiques seront positionnés
		// en coordonnées x,y d'où la suppression du layout
		fenetreRecherche.getContentPane().setLayout(null);

		// Par défaut les fenêtres secondaires ne sont pas visibles.
		fenetreRecherche.setVisible(false);

		return fenetreRecherche;
	}
}
