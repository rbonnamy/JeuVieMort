package fr.diginamic.jeudelavie.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.text.html.HTMLDocument;

import fr.diginamic.jeudelavie.entites.Grille;
import fr.diginamic.jeudelavie.entites.GrilleFactory;

/** Composant principal avec les éléments interactifs : 
 * <ul>
 * <li>Bouton Démarrage / Arrêt</li>
 * <li>Liste permettant de sélectionner une configuration de grille initiale</li>
 * <li>La zone de dessin qui permet de visualiser la grille</li>
 * </ul>
 * @author RichardBONNAMY
 *
 */
public class PanneauJeu extends JPanel {

	/** serialVersionUID */
	private static final long serialVersionUID = 1454047456314804234L;
	
	/** Bouton marche/arrêt */
	private JButton boutonMarcheArret;
	
	/** Description de la structure */
	private JEditorPane description;
	
	/** Liste de sélection */
	private JComboBox<String> listeSelection;
	
	/** Grille */
	private Grille grille;
	
	/** Composant de dessin */
	private DessinGrille dessin; 
	
	private PanneauEdition editeur = new PanneauEdition(this);
	
	/** Permet d'indiquer si le jeu de la vie doit avancer d'une génération ou non */
	private boolean avancerGenerationSuivante = false;

	/** Constructeur
	 * Permet de placer les différents éléments sur le panneau
	 */
	public PanneauJeu() {
		
		this.setLayout(null);
		
		String[] listeConfiguration = { "Choisir", "Test", "Carré", "Ruche", "Feuille", "Clignoteur", "Balise", "Crapaud", "Horloge", "Pentadecathlon", "Planeur", "LWSS", "HWSS", "Tagalong", "Canon à planeurs" };
		 
        // create checkbox
		listeSelection = new JComboBox<>(listeConfiguration);
		listeSelection.setBounds(30, 30, 200, 30);
		listeSelection.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				String name = e.getItem().toString();
				grille = GrilleFactory.getGrille(name);
				description.setText("<b>"+grille.getNom()+"</b><br>"+grille.getDescription());
				dessin.setGrille(grille);
				if (grille!=null) {
					repaint();
				}
			}
		});
		add(listeSelection);

		boutonMarcheArret = new JButton("Démarrage");
		boutonMarcheArret.setBounds(260, 30, 120, 30);
		boutonMarcheArret.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				avancerGenerationSuivante=!avancerGenerationSuivante;
				if (avancerGenerationSuivante) {
					boutonMarcheArret.setText("Arrêt");
				}
				else {
					boutonMarcheArret.setText("Démarrage");
				}
			}
		});

		// Spécifier la position et la taille du bouton
		add(boutonMarcheArret);
		
		Font font = new Font("Dialog", Font.PLAIN, 14);
		
		description = new JEditorPane("text/html", "<b>Jeu de la Vie et de la Mort de Conway</b>.<br>Ce jeu est un automate cellulaire permettant de voir évoluer un ensemble de cellules en fonction de règles de naissance, de survie et de mort. Choisissez une structure dans la liste de sélection puis cliquez sur Démarrage.");
		
		System.out.println(listeSelection.getFont());
		description.setBounds(30, 70, 970, 70);
		String bodyRule = "body { font-family: " + font.getFamily() + "; " +
	            "font-size: " + font.getSize() + "pt; }";
	    ((HTMLDocument)description.getDocument()).getStyleSheet().addRule(bodyRule);
	    add(description);
		
		dessin = new DessinGrille();
		dessin.setBounds(30,  140, 970, 620);
		add(dessin);
		
		JButton boutonEdition = new JButton("Edition");
		boutonEdition.setBounds(700, 30, 120, 30);
		boutonEdition.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				editeur.setVisible(true);
			}
		});
		add(boutonEdition);
		
		editeur.setVisible(false);
		
	}

	/** Permet de démarrer le jeu de la vie
	 * 
	 */
	public void demarrer() {
		
		while (true) {
			if (avancerGenerationSuivante) {
				if (grille!=null) {
					grille.avance();
					dessin.repaint();
				}
			}
			
			// Interruption de 100ms afin d'éviter que ça aille trop vite
			try {
				Thread.sleep(100L);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	public void updateGrille(Grille nvGrille) {
		this.grille = nvGrille;
		dessin.setGrille(nvGrille);
	}

	/**
	 * @return the grille
	 */
	public Grille getGrille() {
		return grille;
	}
}