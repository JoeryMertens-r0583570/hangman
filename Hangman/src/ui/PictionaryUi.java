package ui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import domain.*;

public class PictionaryUi {
	private Speler speler;

	public PictionaryUi(Speler speler) {
		this.speler = speler;
		this.showMenu();
	}

	public void showMenu() {
		JFrame f = new JFrame();
		Integer x = null;
		Integer y = null;
		while (x==null) {
			try {
				x = Integer.parseInt(JOptionPane.showInputDialog(f, "x coordinaat:"));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(f,"geen valide waarde");
			}
		}
		while (y==null) {
			try {
				y = Integer.parseInt(JOptionPane.showInputDialog(f, "y coordinaat:"));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(f,"geen valide waarde");
			}
		}
		Punt punt = new Punt(x, y);

		JOptionPane.showMessageDialog(f, "U heeft een correct punt aangemaakt: (" + x + "," + y + ")");
	}
}
