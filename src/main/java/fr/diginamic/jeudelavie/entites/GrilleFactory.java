package fr.diginamic.jeudelavie.entites;

/** Fabrique une grille
 * @author RichardBONNAMY
 *
 */
public final class GrilleFactory {

	/** Fabrique une grille en fonction d'un nom
	 * @param name nom de le configuration d'origine
	 * @return {@link Grille}
	 */
	public static Grille getGrille(String name) {
		Grille grille = new Grille(100, 100);
		
		if (name.equals("Canon à planeurs")) {
			
			grille.setNom("Le canon à planeurs");
			grille.setDescription("Le canon à planeurs est une structure de type canon, qui génère d'autres structures, ici ce sont des planeurs.");
			
			grille.setLigne(1, "________________________X___________");
			grille.setLigne(2, "______________________X_X___________");
			grille.setLigne(3, "____________XX______XX____________XX");
			grille.setLigne(4, "___________X___X____XX____________XX");
			grille.setLigne(5, "XX________X_____X___XX______________");
			grille.setLigne(6, "XX________X___X_XX____X_X___________");
			grille.setLigne(7, "__________X_____X_______X___________"); 
			grille.setLigne(8, "___________X___X____________________");
			grille.setLigne(9, "____________XX______________________");
		}
		else if (name.equals("Clignoteur")) {
			
			grille.setNom("Le clignoteur");
			grille.setDescription("Le clignoteur est une structure périodique de période d'oscillation 2.");

			grille.setLigne(15, "__________________XXX______________");
		}
		else if (name.equals("Balise")) {
			
			grille.setNom("La balise");
			grille.setDescription("La balise est une structure périodique de période d'oscillation 2.");

			grille.setLigne(15, "__________________XX_______________");
			grille.setLigne(16, "__________________XX_______________");
			grille.setLigne(17, "____________________XX_______________");
			grille.setLigne(18, "____________________XX_______________");
		}
		else if (name.equals("Crapaud")) {
			
			grille.setNom("Le crapaud");
			grille.setDescription("Le crapaud est une structure périodique de période d'oscillation 2.");

			grille.setLigne(15, "__________________XXX______________");
			grille.setLigne(16, "_________________XXX______________");
		}
		else if (name.equals("Horloge")) {
			
			grille.setNom("L'horloge");
			grille.setDescription("L'horloge est une structure périodique de période d'oscillation 4.");

			grille.setLigne(15, "________________XX____");
			grille.setLigne(16, "________________XX____");
			grille.setLigne(17, "______________________");
			grille.setLigne(18, "______________XXXX____");
			grille.setLigne(19, "__________XX_X__X_X___");
			grille.setLigne(20, "__________XX_X_X__X___");
			grille.setLigne(21, "_____________X_X__X_XX");
			grille.setLigne(22, "_____________X____X_XX");
			grille.setLigne(23, "______________XXXX____");
			grille.setLigne(24, "______________________");
			grille.setLigne(25, "______________XX______");
			grille.setLigne(26, "______________XX______");
		}
		else if (name.equals("Pentadecathlon")) {
			
			grille.setNom("Le pentadécathlon");
			grille.setDescription("Le pentadécathlon est une structure périodique de période d'oscillation 15.");

			grille.setLigne(10, "__________________X________________");
			grille.setLigne(11, "__________________X_______________");
			grille.setLigne(12, "_________________X_X______________");
			grille.setLigne(13, "__________________X________________");
			grille.setLigne(14, "__________________X_______________");
			grille.setLigne(15, "__________________X________________");
			grille.setLigne(16, "__________________X_______________");
			grille.setLigne(17, "_________________X_X______________");
			grille.setLigne(18, "__________________X________________");
			grille.setLigne(19, "__________________X________________");
		}
		else if (name.equals("Ruche")) {
			
			grille.setNom("La ruche");
			grille.setDescription("La ruche est une structure stable, i.e. qui n'évolue pas, composée de 6 cellules.");

			grille.setLigne(15, "__________________XX_______________");
			grille.setLigne(16, "_________________X__X______________");
			grille.setLigne(17, "__________________XX_______________");
		}
		else if (name.equals("Feuille")) {

			grille.setNom("La feuille");
			grille.setDescription("La feuille est une structure stable, i.e. qui n'évolue pas, composée de 8 cellules.");
			
			grille.setLigne(15, "__________________XX_______________");
			grille.setLigne(16, "_________________X__X______________");
			grille.setLigne(17, "__________________X_X______________");
			grille.setLigne(18, "___________________XX______________");
		}
		else if (name.equals("Carré")) {
			
			grille.setNom("Le carré");
			grille.setDescription("Le carré est une structure stable, i.e. qui n'évolue pas, composée de 4 cellules. Il n'existe pas de structure stable de moins de 4 cellules.");

			grille.setLigne(15, "__________________XX_______________");
			grille.setLigne(16, "__________________XX_______________");
		}
		else if (name.equals("Tube")) {
			
			grille.setNom("Le tube");
			grille.setDescription("Le tube est une structure stable, i.e. qui n'évolue pas, composée de 4 cellules. Il n'existe pas de structure stable de moins de 4 cellules.");

			grille.setLigne(15, "___________________X_______________");
			grille.setLigne(16, "__________________X_X______________");
			grille.setLigne(16, "___________________X_______________");
		}
		else if (name.equals("Planeur")) {

			grille.setNom("Le planeur");
			grille.setDescription("Le planeur est une structure de type vaisseau, qui se déplace dans la grille en oscillant. C'est le plus petits vaisseau connu. C'est aussi un vaisseau diagonal car il se déplace d'une case verticalement toutes les 4 cases.");
			
			grille.setLigne(1, "__X");
			grille.setLigne(2, "X_X");
			grille.setLigne(3, "_XX");
		}
		else if (name.equals("LWSS")) {
			
			grille.setNom("Le LWSS");
			grille.setDescription("Le Light Weight SpaceShip est une structure de type vaisseau, qui se déplace dans la grille en oscillant.C'est aussi un vaisseau dit orthogonal car il se déplace d'une case soit verticalement, soit horizontalement selon son orientation de départ.");

			grille.setLigne(3, "X__X_");
			grille.setLigne(4, "____X");
			grille.setLigne(5, "X___X");
			grille.setLigne(6, "_XXXX");
		}
		else if (name.equals("HWSS")) {

			grille.setNom("Le HWSS");
			grille.setDescription("Le Heavy Weight SpaceShip est une structure de type vaisseau, qui se déplace dans la grille en oscillant.C'est un vaisseau dit orthogonal car il se déplace d'une case soit verticalement, soit horizontalement selon son orientation de départ.");

			grille.setLigne(1, "__XX___");
			grille.setLigne(2, "X____X_");
			grille.setLigne(3, "______X");
			grille.setLigne(4, "X_____X");
			grille.setLigne(5, "_XXXXXX");
		}
		else if (name.equals("Tagalong")) {

			grille.setNom("Le Tagalong");
			grille.setDescription("Le Tagalong est une structure de type vaisseau, qui se déplace dans la grille en oscillant. C'est un vaisseau dit orthogonal car il se déplace d'une case soit verticalement, soit horizontalement selon son orientation de départ.");

			grille.setLigne(10, "________________________XXXX______________");
			grille.setLigne(11, "________________________X___X_________X___");
			grille.setLigne(12, "________________________X___________XX____");
			grille.setLigne(13, "_________________________X__X__XX_____XXX_");
			grille.setLigne(14, "______________________________XXX______XXX");
			grille.setLigne(15, "_________________________X__X__XX_____XXX_");
			grille.setLigne(16, "________________________X___________XX____");
			grille.setLigne(17, "________________________X___X_________X___");
			grille.setLigne(18, "________________________XXXX______________");
		}
		return grille;
	}

	
}
