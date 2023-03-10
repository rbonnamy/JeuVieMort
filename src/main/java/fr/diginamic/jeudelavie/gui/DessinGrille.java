package fr.diginamic.jeudelavie.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import fr.diginamic.jeudelavie.entites.Grille;

/** Composant permettant de dessiner une gr
 * 
 * @author RichardBONNAMY
 *
 */
public class DessinGrille extends JPanel {
	
	/** SERIAL UID */
	private static final long serialVersionUID = 3556451310766630788L;

	/** Taille des cellules dans la grille */
	private static final int BOX_SIZE = 10;
	
	/** grille **/
	private Grille grille;
	
	
	/** Constructeur
	 * 
	 */
	public DessinGrille() {
		setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D drawImage = (Graphics2D) g;
		drawImage.setColor(Color.CYAN);
		drawImage.fillRect(0, 0, 1000, 1000);
		
		int xOffset=0;
		int yOffset=0;
		if (grille!=null) {
			for (int x = 1; x <= grille.getLargeur(); x++) {
				for (int y = 1; y <= grille.getHauteur(); y++) {
					if (grille.getCellValue(x, y)) {
						drawImage.setColor(Color.BLACK);
						drawImage.fillRect((x-1) * BOX_SIZE+xOffset, (y-1) * BOX_SIZE+yOffset, BOX_SIZE, BOX_SIZE);
					} 
				}
			}
		}
	}

	/**
	 * @return the grille
	 */
	public Grille getGrille() {
		return grille;
	}

	/**
	 * @param grille the grille to set
	 */
	public void setGrille(Grille grille) {
		this.grille = grille;
	}

}
