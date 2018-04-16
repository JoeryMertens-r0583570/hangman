package ui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import domain.*;

public class PictionaryUi {
	private Speler speler;

    public PictionaryUi(Speler speler, JFrame f) throws DomainException {
        this.speler=speler;
        this.showMenu(f);
    }

    public void showMenu(JFrame f) throws DomainException {
        Integer x = null;
        Integer y = null;
        while (x == null) {
            try {
                x = Integer.parseInt(JOptionPane.showInputDialog(f, "x coordinaat:"));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(f, "geen valide waarde");
            }
        }
        while (y == null) {
            try {
                y = Integer.parseInt(JOptionPane.showInputDialog(f, "y coordinaat:"));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(f, "geen valide waarde");
            }
        }
        Punt punt = new Punt(x, y);

        JOptionPane.showMessageDialog(f, "U heeft een correct punt aangemaakt: (" + x + "," + y + ")");
        String[] shapes = { "Cirkel", "Rechthoek" };
		String keuze = (String) JOptionPane.showInputDialog(null, "Wat wilt u tekenen", "input", JOptionPane.INFORMATION_MESSAGE,
				null, shapes, null);
		if (keuze.equals("Cirkel"))maakCirkel(f, punt);
		if (keuze.equals("Rechthoek"))maakRechthoek(f, punt);
    }
    
    public void maakCirkel(JFrame f, Punt punt) {
        int radius = Integer.parseInt(JOptionPane.showInputDialog(f, "Radius van de cirkel:"));
        Cirkel cirkel = null;
        try {
            cirkel = new Cirkel(punt, radius);
        } catch (IllegalArgumentException i) {
            JOptionPane.showMessageDialog(f, i.getMessage());
            return;
        }
        if (cirkel != null) {
            JOptionPane.showMessageDialog(f, "U heeft een correcte cirkel aangemaakt: " + cirkel.toString());
        }
    }
    
    public void maakRechthoek(JFrame f, Punt punt) throws DomainException {
        int breedte = Integer.parseInt(JOptionPane.showInputDialog(f, "Breedte van de rechthoek:"));
        int hoogte = Integer.parseInt(JOptionPane.showInputDialog(f, "Hoogte van de rechthoek:"));
        Rechthoek rechthoek = null;
        try {
            rechthoek = new Rechthoek(punt, breedte, hoogte);
        } catch (IllegalArgumentException i) {
            JOptionPane.showMessageDialog(f, i.getMessage());
            return;
        }
        if (rechthoek != null) {
            JOptionPane.showMessageDialog(f, "U heeft een correcte rechthoek aangemaakt: " + rechthoek.toString());
        }
    }

}
