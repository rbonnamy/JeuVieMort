package fr.diginamic.jeudelavie.entites;

/** Représente une cellule du jeu de la vie
 * @author RichardBONNAMY
 *
 */
public class Cellule {

	/** Valeur courante de la cellule (true=vivante, false=morte) */
	private boolean value;
	
	/** Valeur qu'aura la cellule à la génération suivante (true=vivante, false=morte) après l'invocation de la méthode avance() */
	private boolean nextValue;

	/** Getter
	 * @return the value
	 */
	public boolean getValue() {
		return value;
	}

	/** Setter
	 * @param value the value to set
	 */
	public void setValue(boolean value) {
		this.value = value;
	}

	/** Getter
	 * @return the nextValue
	 */
	public boolean getNextValue() {
		return nextValue;
	}

	/** Setter
	 * @param nextValue the nextValue to set
	 */
	public void setNextValue(boolean nextValue) {
		this.nextValue = nextValue;
	}
}
