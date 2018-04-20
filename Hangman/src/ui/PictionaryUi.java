package ui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import domain.*;

public class PictionaryUi {
	private Speler speler;
	Tekening tekening;
	private PictionaryHoofdScherm view;
	private JFrame f;

	public PictionaryUi(Speler speler, JFrame f) throws DomainException {
		this.speler = speler;
		this.tekening = new Tekening(speler.getNaam());
		this.f=f;
		view = new PictionaryHoofdScherm(speler.getNaam(), this, tekening);
		view.setVisible(true);
		view.teken();
	}

	public void showMenu() throws DomainException {
		Vorm vorm = null;

		JOptionPane.showMessageDialog(f, "Het scherm gaat tussen (" + tekening.getMinX() + "," + tekening.getMinY()
				+ ") en (" + tekening.getMaxX() + "," + tekening.getMaxY() + ")");
		String[] shapes = { "Driehoek", "Cirkel", "Rechthoek", "Lijnstuk" };
		String keuze = (String) JOptionPane.showInputDialog(null, "Wat wilt u tekenen", "input",
				JOptionPane.INFORMATION_MESSAGE, null, shapes, null);
		Integer x = null;
		String result = null;
		while (x == null) {
			try {
				result = JOptionPane.showInputDialog(f, "X coordinaat:");
				if (result == null) {
					showMenu();
					return;
				}
				x = Integer.parseInt(result);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(f, "geen valide waarde");
			}
		}
		Integer y = null;
		while (y == null) {
			try {
				result = JOptionPane.showInputDialog(f, "Y coordinaat:");
				if (result == null) {
					showMenu();
					return;
				}
				y = Integer.parseInt(result);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(f, "geen valide waarde");
			}
		}

		Punt punt = new Punt(x, y);
		JOptionPane.showMessageDialog(f, "U heeft een correct punt aangemaakt: (" + x + "," + y + ")");
		if (keuze.equals("Driehoek")) {
			vorm = maakDriehoek(f, punt);
		}
		if (keuze.equals("Cirkel")) {
			vorm = maakCirkel(f, punt);
		}
		if (keuze.equals("Rechthoek")) {
			vorm = maakRechthoek(f, punt);
		}
		if (keuze.equals("Lijnstuk")) {
			vorm = maakLijnstuk(f, punt);
		}
		if (vorm == null)
			return;

		try {
			tekening.voegToe(vorm);

			JOptionPane.showMessageDialog(f, "u heeft een correcte " + keuze + " aangemaakt");
		} catch (DomainException e) {
			JOptionPane.showMessageDialog(f, "vorm niet binnen grenzen");
		}
		view.teken();
		
	}

	private Driehoek maakDriehoek(JFrame f, Punt punt) {
		Integer tweedePuntX = null;
		String result = null;
		while (tweedePuntX == null) {
			try {
				result = JOptionPane.showInputDialog(f, "X coordinaat 2de punt:");
				if (result == null) {
					showMenu();
					return null;
				}
				tweedePuntX = Integer.parseInt(result);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(f, "geen valide waarde");
			}
		}
		Integer tweedePuntY = null;
		while (tweedePuntY == null) {
			try {
				result = JOptionPane.showInputDialog(f, "Y coordinaat 2de punt:");
				if (result == null) {
					showMenu();
					return null;
				}
				tweedePuntY = Integer.parseInt(result);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(f, "geen valide waarde");
			}
		}
		Punt tweedePunt = new Punt(tweedePuntX, tweedePuntY);
		Integer derdePuntX = null;
		while (derdePuntX == null) {
			try {
				result = JOptionPane.showInputDialog(f, "X coordinaat 3de punt:");
				if (result == null) {
					showMenu();
					return null;
				}
				derdePuntX = Integer.parseInt(result);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(f, "geen valide waarde");
			}
		}
		Integer derdePuntY = null;
		while (derdePuntY == null) {
			try {
				result = JOptionPane.showInputDialog(f, "Y coordinaat 3de punt:");
				if (result == null) {
					showMenu();
					return null;
				}
				derdePuntY = Integer.parseInt(result);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(f, "geen valide waarde");
			}
		}
		Punt derdePunt = new Punt(derdePuntX, derdePuntY);
		Driehoek driehoek;
		try {
			driehoek = new Driehoek(punt, tweedePunt, derdePunt);
		} catch (DomainException d) {
			JOptionPane.showMessageDialog(f, d.getMessage());
			return null;
		}
		return driehoek;
	}

	public Cirkel maakCirkel(JFrame f, Punt punt) {
		Integer radius = null;
		String result = null;
		while (radius == null) {
			try {
				result = JOptionPane.showInputDialog(f, "Radius van de cirkel:");
				if (result == null) {
					showMenu();
					return null;
				}
				radius = Integer.parseInt(result);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(f, "geen valide waarde");
			}
		}
		Cirkel cirkel;
		try {
			cirkel = new Cirkel(punt, radius);
		} catch (DomainException d) {
			JOptionPane.showMessageDialog(f, d.getMessage());
			return null;
		}
		return cirkel;

	}

	public Rechthoek maakRechthoek(JFrame f, Punt punt) throws DomainException {
		String result = null;
		Integer breedte = null;
		Integer hoogte = null;
		Rechthoek rechthoek = null;
		while (breedte == null) {
			try {
				result = JOptionPane.showInputDialog(f, "Breedte van de rechthoek:");
				if (result == null) {
					showMenu();
					return null;
				}
				breedte = Integer.parseInt(result);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(f, "geen valide waarde");
			}
		}
		while (hoogte == null) {
			try {
				result = JOptionPane.showInputDialog(f, "Hoogte van de rechthoek:");
				if (result == null) {
					showMenu();
					return null;
				}
				hoogte = Integer.parseInt(result);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(f, "geen valide waarde");
			}
		}

		rechthoek = new Rechthoek(punt, breedte, hoogte);

		return rechthoek;
	}

	public LijnStuk maakLijnstuk(JFrame f, Punt punt) {
		String result = null;
		Integer x = null;
		while (x == null) {
			try {
				result = JOptionPane.showInputDialog(f, "x-coordinaat van eindpunt:");
				if (result == null) {
					showMenu();
					return null;
				}
				x = Integer.parseInt(result);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(f, "geen valide waarde");
			}
		}
		Integer y = null;
		while (y == null) {
			try {
				result = JOptionPane.showInputDialog(f, "y-coordinaat van eindpunt:");
				if (result == null) {
					showMenu();
					return null;
				}
				y = Integer.parseInt(result);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(f, "geen valide waarde");
			}
		}
		Punt eindpunt = null;
		try {
			eindpunt = new Punt(x, y);
		} catch (IllegalArgumentException i) {
			JOptionPane.showMessageDialog(f, i.getMessage());
			return null;
		}
		if (eindpunt != null) {
		}
		LijnStuk lijn;
		try {
			lijn = new LijnStuk(punt, eindpunt);
		} catch (DomainException d) {
			JOptionPane.showMessageDialog(f, d.getMessage());
			return null;
		}
		return lijn;
	}
	public void clear() {
		this.tekening.getLijst().clear();
		view.teken();
	}

}
