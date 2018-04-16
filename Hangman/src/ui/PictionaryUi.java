package ui;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import domain.*;
public class PictionaryUi {
	private Speler speler;

public PictionaryUi(Speler speler) {
	this.speler=speler;
	this.showMenu();
}

public void showMenu(){
	JFrame f = new JFrame();
	int x= Integer.parseInt(JOptionPane.showInputDialog(f, "x coordinaat:"));
	int y= Integer.parseInt(JOptionPane.showInputDialog(f, "y coordinaat:"));
	Punt punt=new Punt(x,y);

	JOptionPane.showMessageDialog(f, "U heeft een correct punt aangemaakt: ("+x+","+y+")");
}
}
