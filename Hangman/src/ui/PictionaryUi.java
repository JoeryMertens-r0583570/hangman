package ui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import domain.*;

public class PictionaryUi {
	private Speler speler;
	private Tekening tekening;

    public PictionaryUi(Speler speler, JFrame f) throws DomainException {
        this.speler=speler;
        this.tekening=new Tekening(speler.getNaam());
        this.showMenu(f);
    }

    public void showMenu(JFrame f) throws DomainException {
        Integer x = null;
        Integer y = null;
        Vorm vorm = null;
        String[] shapes = { "Cirkel", "Rechthoek", "Lijnstuk" };
		String keuze = (String) JOptionPane.showInputDialog(null, "Wat wilt u tekenen", "input", JOptionPane.INFORMATION_MESSAGE,
				null, shapes, null);
		
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
        if (keuze.equals("Cirkel")) {
			vorm=maakCirkel(f, punt);
		}
		if (keuze.equals("Rechthoek")) {
			vorm=maakRechthoek(f, punt);
		}
		if (keuze.equals("Lijnstuk")) {
			vorm=maakLijnstuk(f, punt);
		}

		
		tekening.voegToe(vorm);
		
		GameHoofdScherm view = new GameHoofdScherm(speler.getNaam(), tekening);
		view.setVisible(true);
		view.teken();
    }
    
    public Cirkel maakCirkel(JFrame f, Punt punt) {
        int radius = Integer.parseInt(JOptionPane.showInputDialog(f, "Radius van de cirkel:"));
        Cirkel cirkel;
        try {
            cirkel = new Cirkel(punt, radius);
        } catch (DomainException d) {
            JOptionPane.showMessageDialog(f, d.getMessage());
            return null;
        }
            JOptionPane.showMessageDialog(f, "U heeft een correcte cirkel aangemaakt: " + cirkel.toString());
            return cirkel;
        
    }
    
    public Rechthoek maakRechthoek(JFrame f, Punt punt) throws DomainException {
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
        
            JOptionPane.showMessageDialog(f, "U heeft een correcte rechthoek aangemaakt: " + rechthoek.toString());
            return rechthoek;
    }
    public LijnStuk maakLijnstuk(JFrame f, Punt punt) {
        int x = Integer.parseInt(JOptionPane.showInputDialog(f, "x-coordinaat van eindpunt:"));
        int y = Integer.parseInt(JOptionPane.showInputDialog(f, "y-coordinaat van eindpunt:"));
        Punt eindpunt = null;
        try {
            eindpunt = new Punt(x, y);
        } catch (IllegalArgumentException i) {
            JOptionPane.showMessageDialog(f, i.getMessage());
            return null;
        }
        if (eindpunt != null) {
            JOptionPane.showMessageDialog(f, "U heeft een correct eindpunt aangemaakt: " + eindpunt.toString());
        }
        LijnStuk lijn;
        try {
            lijn = new LijnStuk(punt, eindpunt);
        } catch (DomainException d) {
            JOptionPane.showMessageDialog(f, d.getMessage());
            return null;
        }
            JOptionPane.showMessageDialog(f, "U heeft een correcte lijn aangemaakt: " + lijn.toString());
            return lijn;
    }

}
