package fr.diginamic.jeudelavie.entites;

import java.util.ArrayList;
import java.util.List;

/**
 * Une grille est constituée de lignes et de colonnes. <br>
 * Les coordonnées d'une cellule dans cette grille sont fournies par un couple
 * d'entiers (x, y):
 * <ul>
 * <li>x désigne le numéro de colonne dont la numérotation commence à 1</li>
 * <li>x désigne le numéro de ligne dont la numérotation commence à 1</li>
 * </ul>
 * Pour créer des cellules dans la grille on peut :
 * <ul>
 * <li>utiliser la méthode setLigne(int nb, String chaine) où nb est le numéro
 * de ligne et chaine une chaine de caractères. Dans cette chaine, les X
 * marquent l'emplacement d'une cellule.</li>
 * <li>Uiliser la méthode setCellValue(int x, int y, boolean value) qui permet
 * de renseigner l'état d'une cellule pour les coordonnées (x, y). Si value=true
 * la cellule est vivante sinon elle est morte.
 * </ul>
 * 
 * @author RichardBONNAMY
 *
 */
public class Grille implements Cloneable {

	/** Largeur de la grille (nombre de colonnes) */
	private int largeur;
	/** Hauteur de la grille (nombre de lignes) */
	private int hauteur;

	/** nom */
	private String nom;

	/** Description associée à la structure */
	private String description;

	/** Lignes de la grille */
	private List<Ligne> lignes = new ArrayList<>();

	/**
	 * Constructeur
	 * 
	 * @param largeur Largeur de la grille (nombre de colonnes)
	 * @param hauteur Hauteur de la grille (nombre de lignes)
	 */
	public Grille(int largeur, int hauteur) {
		super();
		this.largeur = largeur;
		this.hauteur = hauteur;

		for (int i = 0; i < hauteur; i++) {
			lignes.add(new Ligne(largeur));
		}
	}

	public Grille clone() {

		Grille clone = new Grille(largeur, hauteur);
		for (int i = 0; i < hauteur; i++) {
			lignes.add(new Ligne(largeur));
		}
		for (int x = 1; x <= largeur; x++) {
			for (int y = 1; y <= hauteur; y++) {
				clone.setCellValue(x, y, getCellValue(x, y));

			}
		}
		return clone;
	}

	/**
	 * Cette méthode permet de compléter une ligne où nb est le numéro de la ligne
	 * et chaine une chaine de caractères. <br>
	 * <br>
	 * Dans cette chaine, les X marquent l'emplacement d'une cellule et les espaces
	 * ou les underscores une absence de cellule.<br>
	 * Le premier caractère de la chaine renseigne l'état de la cellule 1, puis le
	 * second celle de la cellule 1, etc..<br>
	 * <br>
	 * Si la chaine est plus petite que la longueur de la ligne alors la ligne ne
	 * sera pas complètement renseignée. <br>
	 * Dans ce cas les cellules non renseignées sont mortes par défaut.<br>
	 * <br>
	 * Si la chaine est plus grande que la ligne alors une exception se produit et
	 * stoppe l'application <br>
	 * 
	 * @param nb     numéro de la ligne
	 * @param chaine chaine d'initialisation d'une ligne
	 */
	public void setLigne(int nb, String chaine) {
		if (chaine.length() > largeur) {
			throw new RuntimeException("Le nombre de valeurs ne doit pas dépasser " + largeur);
		}

		Ligne ligne = lignes.get(nb - 1);
		for (int i = 0; i < chaine.length(); i++) {
			if (chaine.charAt(i) == 'X') {
				ligne.setCellValue(i + 1, true);
			} else {
				ligne.setCellValue(i + 1, false);
			}
		}
	}

	/**
	 * Cette méthode permet de compléter une ligne où :
	 * <ul>
	 * <li>nb est le numéro de la ligne</li>
	 * <li>values est une liste de valeurs constituées de 0 et de 1.</li>
	 * </ul>
	 * <br>
	 * Les values permettent d'indiquer si une cellule est vivante (1) ou morte
	 * (0).<br>
	 * La première valeur renseigne la première cellule et ainsi de suite. <br>
	 * Si values a une longueur inférieure à celle de la ligne alors les cellules
	 * non valorisées sont à 0 par défaut<br>
	 * <br>
	 * Si values a une longueur supérieure à celle de la ligne alors une exception
	 * est générée et stoppe l'application <br>
	 * 
	 * @param nb     numéro de la ligne
	 * @param chaine chaine d'initialisation d'une ligne
	 */
	public void setLigne(int nb, int... values) {

		if (values.length > largeur) {
			throw new RuntimeException("Le nombre de valeurs ne doit pas dépasser " + largeur);
		}

		Ligne ligne = lignes.get(nb - 1);
		for (int i = 0; i < values.length; i++) {
			if (values[i] == 1) {
				ligne.setCellValue(i + 1, true);
			} else {
				ligne.setCellValue(i + 1, false);
			}
		}
	}

	/**
	 * Permet d'avancer d'une génération
	 * 
	 */
	public void avance() {
		for (int x = 1; x <= largeur; x++) {
			for (int y = 1; y <= hauteur; y++) {
				int cpt = countNeighbours(x, y);
				if (cpt == 3) {
					setCellNextValue(x, y, true);
				} else if (cpt > 3 || cpt < 2) {
					setCellNextValue(x, y, false);
				} else if (cpt == 2) {
					setCellNextValue(x, y, getCellValue(x, y));
				}
			}
		}
		commitNext();
	}

	/**
	 * Permet de remplacer la génération actuelle par la nouvelle génération
	 * 
	 */
	private void commitNext() {
		for (Ligne ligne : lignes) {
			ligne.commitNext();
		}

	}

	/**
	 * Permet de rensseigner l'état d'une cellule avec 2 valeurs de value possibles
	 * : 0=morte, 1=vivante.
	 * 
	 * @param x     numéro de colonne
	 * @param y     numéro de ligne
	 * @param value 0=morte, 1=vivante.
	 */
	public void setCellValue(int x, int y, boolean value) {
		if (x < 1 || x > largeur) {
			throw new RuntimeException("x doit être compris entre 0 et " + largeur);
		}
		if (y < 1 || y > largeur) {
			throw new RuntimeException("y doit être compris entre 0 et " + hauteur);
		}
		lignes.get(y - 1).setCellValue(x, value);
	}

	/**
	 * Permet de renseigner l'état qu'aura la cellule à la génération suivante.
	 * value a 2 valeurs de value possibles : 0=morte, 1=vivante.
	 * 
	 * @param x     numéro de colonne
	 * @param y     numéro de ligne
	 * @param value 0=morte, 1=vivante.
	 */
	private void setCellNextValue(int x, int y, boolean value) {
		if (x < 1 || x > largeur) {
			throw new RuntimeException("x doit être compris entre 0 et " + largeur);
		}
		if (y < 1 || y > largeur) {
			throw new RuntimeException("y doit être compris entre 0 et " + hauteur);
		}
		lignes.get(y - 1).setCellNextValue(x, value);
	}

	/**
	 * Retourne le nombre de voisins d'une cellule donnée
	 * 
	 * @param x numéro de colonne
	 * @param y numéro de ligne
	 * @return int
	 */
	public int countNeighbours(int x, int y) {
		int cpt = 0;
		for (int i = x - 1; i <= x + 1; i++) {
			for (int j = y - 1; j <= y + 1; j++) {
				if (getCellValue(i, j)) {
					cpt++;
				}
			}
		}
		if (getCellValue(x, y)) {
			cpt--;
		}
		return cpt;
	}

	/**
	 * Retourne l'état d'une cellule (true=vivante, false=morte) dont les
	 * coordonnées sont passées en paramètres
	 * 
	 * @param x numéro de colonne
	 * @param y numéro de ligne
	 * @return boolean
	 */
	public boolean getCellValue(int x, int y) {
		int xm = x;
		int ym = y;
		if (xm == 0) {
			xm = largeur;
		}
		if (xm >= largeur + 1) {
			xm = 1;
		}
		if (ym == 0) {
			ym = largeur;
		}
		if (ym == largeur + 1) {
			ym = 1;
		}
		return lignes.get(ym - 1).getCellValue(xm);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (Ligne ligne : lignes) {
			builder.append(ligne);
		}
		return builder.toString();
	}

	/**
	 * Getter
	 * 
	 * @return the largeur
	 */
	public int getLargeur() {
		return largeur;
	}

	/**
	 * Getter
	 * 
	 * @return the hauteur
	 */
	public int getHauteur() {
		return hauteur;
	}

	/**
	 * Getter
	 * 
	 * @return the lignes
	 */
	public List<Ligne> getLignes() {
		return lignes;
	}

	/**
	 * Setter
	 * 
	 * @param lignes the lignes to set
	 */
	public void setLignes(List<Ligne> lignes) {
		this.lignes = lignes;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @param largeur the largeur to set
	 */
	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	/**
	 * @param hauteur the hauteur to set
	 */
	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}

}
