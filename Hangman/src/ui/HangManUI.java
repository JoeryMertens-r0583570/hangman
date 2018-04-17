package ui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import domain.*;

public class HangManUI {
	
	private HintWoord hintWoord = new HintWoord("woord");
	private Speler speler;
	
	public HangManUI(Speler speler, JFrame f) throws DomainException {
        this.speler=speler;
        this.showMenu(f);
    }

	
	 public void showMenu(JFrame f) throws DomainException {
		 String guess = JOptionPane.showInputDialog(null, ("Rarara welk woord zoeken we?\n"+hintWoord.toString())+"\nGeef een letter:");
		 while (! hintWoord.isGeraden()) {
			 if (guess.length() != 1 ) { 
				 JOptionPane.showMessageDialog(null, "Geef een enkelvoudig character in");
				 guess = JOptionPane.showInputDialog(null, ("Rarara welk woord zoeken we?\n"+hintWoord.toString())+"\nGeef een letter:");
			 }
			 else if (hintWoord.raad(guess.charAt(0))) {
				 if ( hintWoord.isGeraden()) break;
				  guess = JOptionPane.showInputDialog(null, ("Super doe zo voort!\nRarara welk woord zoeken we?\n"+hintWoord.toString())+"\nGeef een letter:");
			 }
			 else {
				  guess = JOptionPane.showInputDialog(null, ("Helaas, volgende keer beter!\nRarara welk woord zoeken we?\n"+hintWoord.toString())+"\nGeef een letter:");
			 }
		 }
		 if (hintWoord.isGeraden()) {
			 JOptionPane.showMessageDialog(null, "Super je hebt het woord geraden!\n"+hintWoord.getWoord());
		 }
	 }
}
