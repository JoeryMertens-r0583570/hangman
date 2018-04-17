package ui;

import javax.swing.*;

import domain.DomainException;
import domain.Speler;

public class Launcher {

	
	public static void main(String[] args) throws DomainException {
		
		JFrame f = new JFrame();
		String speler = JOptionPane.showInputDialog(f, "Welkom! \nHoe heet je?");
		Speler player = new Speler(speler);
		JOptionPane.showMessageDialog(f, player.toString()+" heeft als score: "+player.getScore());
		String[] games = {"Pictonary", "HangMan"};
		String keuze = (String) JOptionPane.showInputDialog(null, "Wat wilt u spelen", "input", JOptionPane.INFORMATION_MESSAGE,
				null, games, null);
		if (keuze.equals("Pictonary")){
			new PictionaryUi(player, f);
			
		}
		else if (keuze.equals("HangMan")) {
			new HangManUI(player, f);
		}
	}
}
