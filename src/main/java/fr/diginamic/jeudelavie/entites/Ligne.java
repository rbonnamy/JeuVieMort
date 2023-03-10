package fr.diginamic.jeudelavie.entites;

import java.util.ArrayList;
import java.util.List;

/** Représente une ligne de cellules de la grille.
 * @author RichardBONNAMY
 *
 */
public class Ligne {

	/** Longueur de la ligne (nombre de cellules max) */
	private int longueur;
	
	/** Cellules du jeu de la vie */
	private List<Cellule> cellules = new ArrayList<>();
	
	/** Constructeur
	 * @param longueur longueur de la ligne
	 */
	public Ligne(int longueur) {
		super();
		this.longueur = longueur;
		
		for (int i=0; i<longueur; i++) {
			cellules.add(new Cellule());
		}
	}
	
	/** Permet de remplacer l'état actuel des cellules par la génération suivante
	 * 
	 */
	void commitNext() {
		for (Cellule cell: cellules) {
			cell.setValue(cell.getNextValue());
		}
		
	}
	
	/** Permet de renseigner l'état de la cellule (vivante=true, morte=false) numéro nb
	 * @param nb numéro de la cellule
	 * @param value état de la cellule (vivante=true, morte=false) 
	 */
	public void setCellValue(int nb, boolean value) {
		cellules.get(nb-1).setValue(value);
	}
	
	/** Permet de renseigner l'état futur de la cellule de numéro nb à la génération suivante
	 * @param nb numéro de la cellule
	 * @param value état de la cellule (vivante=true, morte=false) 
	 */
	void setCellNextValue(int nb, boolean value) {
		cellules.get(nb-1).setNextValue(value);
	}
	
	/** Retourne l'état de la cellule numéro nb
	 * @param nb numéro de la cellule
	 * @return boolean
	 */
	public boolean getCellValue(int nb) {
		return cellules.get(nb-1).getValue();
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (Cellule cell: cellules) {
			if (cell.getValue()) {
				builder.append("\u2588\u2588");
			}
			else {
				builder.append("  ");
			}
		}
		builder.append("\n");
		return builder.toString();
	}
	
	/** Getter
	 * @return the longueur
	 */
	public int getLongueur() {
		return longueur;
	}
	/** Setter
	 * @param longueur the longueur to set
	 */
	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}

}
