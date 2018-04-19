
package ui;

import java.io.IOException;

import javax.swing.*;

import db.*;
import domain.*;

public class Launcher {

	
	public static void main(String[] args) throws DomainException, IOException, DbException {
		
		WoordenLezer woordenLezer = new WoordenLezer("src/db/hangman.txt");
		WoordenLijst woordenLijst = woordenLezer.lees();

		JFrame f = new JFrame();
		String speler= "";
		Speler player= null;
		while(speler.trim().isEmpty()) {
			speler = JOptionPane.showInputDialog(f, "Welkom! \nHoe heet je?");
			try{player = new Speler(speler);}
			catch (DomainException e){JOptionPane.showMessageDialog(null, e.getMessage());}
		}
		JOptionPane.showMessageDialog(f, player.toString()+" heeft als score: "+player.getScore());
		String[] games = {"Pictonary", "HangMan"};
		String keuze = (String) JOptionPane.showInputDialog(null, "Wat wilt u spelen", "input", JOptionPane.INFORMATION_MESSAGE,
				null, games, null);
		if (keuze.equals("Pictonary")){
			new PictionaryUi(player, f);
			
		}
		else if (keuze.equals("HangMan")) {
			new HangManUI(player, woordenLijst);
		}
	}
}
