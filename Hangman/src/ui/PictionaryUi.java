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
        String[] shapes = { "Cirkel", "Rechthoek", "Lijnstuk" };
		String keuze = (String) JOptionPane.showInputDialog(null, "Wat wilt u tekenen", "input", JOptionPane.INFORMATION_MESSAGE,
				null, shapes, null);
		if (keuze.equals("Cirkel"))maakCirkel(f, punt);
		if (keuze.equals("Rechthoek"))maakRechthoek(f, punt);
		if (keuze.equals("Lijnstuk"))maakLijnstuk(f, punt);
    }
    
    public void maakCirkel(JFrame f, Punt punt) {
        int radius = Integer.parseInt(JOptionPane.showInputDialog(f, "Radius van de cirkel:"));
        Cirkel cirkel;
        try {
            cirkel = new Cirkel(punt, radius);
        } catch (DomainException d) {
            JOptionPane.showMessageDialog(f, d.getMessage());
            return;
        }
        if (cirkel != null) {
            JOptionPane.showMessageDialog(f, "U heeft een correcte cirkel aangemaakt: " + cirkel.toString());
        }
    }
    
    public void maakRechthoek(JFrame f, Punt punt) throws DomainException {
        Integer breedte = null;
        Integer hoogte = null;
        Rechthoek rechthoek = null;
        while (breedte == null) {
            try {
                breedte = Integer.parseInt(JOptionPane.showInputDialog(f, "Breedte van de rechthoek:"));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(f, "geen valide waarde");
            }
        }
        while (hoogte == null) {
            try {
                hoogte = Integer.parseInt(JOptionPane.showInputDialog(f, "Hoogte van de rechthoek:"));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(f, "geen valide waarde");
            }
        }
        
            rechthoek = new Rechthoek(punt, breedte, hoogte);
        
        if (rechthoek != null) {
            JOptionPane.showMessageDialog(f, "U heeft een correcte rechthoek aangemaakt: " + rechthoek.toString());
        }
    }
    public void maakLijnstuk(JFrame f, Punt punt) {
        int x = Integer.parseInt(JOptionPane.showInputDialog(f, "x-coordinaat van eindpunt:"));
        int y = Integer.parseInt(JOptionPane.showInputDialog(f, "y-coordinaat van eindpunt:"));
        Punt eindpunt = null;
        try {
            eindpunt = new Punt(x, y);
        } catch (IllegalArgumentException i) {
            JOptionPane.showMessageDialog(f, i.getMessage());
            return;
        }
        if (eindpunt != null) {
            JOptionPane.showMessageDialog(f, "U heeft een correct eindpunt aangemaakt: " + eindpunt.toString());
        }
        LijnStuk lijn;
        try {
            lijn = new LijnStuk(punt, eindpunt);
        } catch (DomainException d) {
            JOptionPane.showMessageDialog(f, d.getMessage());
            return;
        }
        if (lijn != null) {
            JOptionPane.showMessageDialog(f, "U heeft een correcte lijn aangemaakt: " + lijn.toString());
        }
    }

}
