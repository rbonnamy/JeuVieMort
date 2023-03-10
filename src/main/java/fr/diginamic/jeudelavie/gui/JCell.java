package fr.diginamic.jeudelavie.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import fr.diginamic.jeudelavie.entites.Grille;

public class JCell extends JButton {

	private boolean value;
	
	private Grille grille;
	private int x;
	private int y;

	public JCell(Grille grille, int x, int y) {
		this.grille = grille;
		this.x=x;
		this.y=y;
		addActionListener(new CellActionListener(this));
		setContentAreaFilled(false);
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        if (value) {
            g.setColor(Color.BLACK);
        } else {
        	g.setColor(Color.WHITE);
        }
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
	
	public void push() {
		setValue(!value);
		grille.setCellValue(x, y, value);
	}

	/**
	 * @return the value
	 */
	public boolean isValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(boolean value) {
		this.value = value;
	}
	
	public static class CellActionListener implements ActionListener {
		
		private JCell jcell;
		
		public CellActionListener(JCell jcell) {
			this.jcell = jcell;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			jcell.push();
			jcell.repaint();
		}
		
	}
}
