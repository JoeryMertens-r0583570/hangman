package ui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import db.WoordenLijst;
import domain.*;

public class HangManUI {
	
	private Speler speler;
	private WoordenLijst lijst;
	
	public HangManUI(Speler speler, WoordenLijst lijst) throws DomainException {
        setSpeler(speler);
        setLijst(lijst);
        this.showMenu();
    }

	
	 public void showMenu() throws DomainException {
	    HangMan spel = new HangMan(getSpeler(), getLijst());
	    HangmanPaneel paneel = new HangmanPaneel(spel);
	    HangManHoofdScherm view = new HangManHoofdScherm(spel, paneel);
	    view.setVisible(true);
	    view.teken();
	 }



    public Speler getSpeler() {
        return speler;
    }

    public void setSpeler(Speler speler) {
        this.speler = speler;
    }

    public WoordenLijst getLijst() {
        return lijst;
    }

    public void setLijst(WoordenLijst lijst) {
        this.lijst = lijst;
    }
}
