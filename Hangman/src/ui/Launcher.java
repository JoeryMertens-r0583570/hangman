package ui;

import javax.swing.*;

import domain.DomainException;
import domain.Speler;

public class Launcher {
<<<<<<< HEAD

	public static void main(String[] args) {

		JFrame f = new JFrame();
		JOptionPane.showInputDialog(f, "Welkom! \nHoe heet je?");
		JOptionPane.showMessageDialog(f, "... heeft als score: 1");
		Object[] shapes = { "Cirkel", "Rechthoek" };
		Object keuze = JOptionPane.showInputDialog(null, "Wat wilt u tekenen", "input", JOptionPane.INFORMATION_MESSAGE,
				null, shapes, null);
=======
	
	public static void main(String[] args) throws DomainException {
		
		JFrame f = new JFrame();
		String speler = JOptionPane.showInputDialog(f, "Welkom! \nHoe heet je?");
		Speler player = new Speler(speler);
		JOptionPane.showMessageDialog(f, player.toString()+" heeft als score: "+player.getScore());
		new PictionaryUi(player);
>>>>>>> e20ca9e90eb14aa6a37fbad46d54d799f33bbf80
	}
}
