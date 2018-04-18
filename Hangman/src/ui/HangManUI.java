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

//		 String guess = JOptionPane.showInputDialog(null, ("Rarara welk woord zoeken we?\n"+hintWoord.toString())+"\nGeef een letter:");
//		 while (! hintWoord.isGeraden()) {
//			 if (guess.length() != 1 ) {
//				 JOptionPane.showMessageDialog(null, "Geef een enkelvoudig character in");
//				 guess = JOptionPane.showInputDialog(null, ("Rarara welk woord zoeken we?\n"+hintWoord.toString())+"\nGeef een letter:");
//			 }
//			 else if (hintWoord.raad(guess.charAt(0))) {
//				 if ( hintWoord.isGeraden()) break;
//				  guess = JOptionPane.showInputDialog(null, ("Super doe zo voort!\nRarara welk woord zoeken we?\n"+hintWoord.toString())+"\nGeef een letter:");
//			 }
//			 else {
//				  guess = JOptionPane.showInputDialog(null, ("Helaas, volgende keer beter!\nRarara welk woord zoeken we?\n"+hintWoord.toString())+"\nGeef een letter:");
//			 }
//		 }
//		 if (hintWoord.isGeraden()) {
//			 JOptionPane.showMessageDialog(null, "Super je hebt het woord geraden!\nHet woord was: "+hintWoord.getWoord());
//		 }
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
