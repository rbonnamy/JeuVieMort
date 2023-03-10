package fr.diginamic.jeudelavie.gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;

/** Fournit des services pour les interfaces utilisateur de type Desktop
 * @author RichardBONNAMY
 *
 */
public class GUIHelper {
    
    /** Créée une JFrame contenant le composant passé en paramètre avec un titre
     * @param component composant à insérer dans la JFrame
     * @param frameName nom de la frame apparaissant dans la barre
     */
    public static void showOnFrame(JComponent component, String frameName) {
        JFrame frame = new JFrame(frameName);
        WindowAdapter wa = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };
        frame.addWindowListener(wa);
        frame.getContentPane().add(component);
        frame.pack();
        frame.setVisible(true);
    }

}