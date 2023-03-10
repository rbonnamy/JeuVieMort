package fr.diginamic.jeudelavie.entites;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GrilleTest {

	@Test
	void testGetCellValue() {
		Grille grille = new Grille(8,8);
		grille.setLigne(6, "_______X");
		grille.setLigne(7, "_____X_X");
		grille.setLigne(8, "______XX");
		grille.avance();
		Assertions.assertTrue(grille.getCellValue(9, 7));
	}

}
