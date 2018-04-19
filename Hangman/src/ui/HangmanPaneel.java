package ui;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import domain.HangMan;

public class HangmanPaneel extends JPanel {

	private static final long serialVersionUID = 1L;	
	
	private JTextField letter;	
	private JLabel woord;
	
	private TekenVenster tekenVenster;
	private HangMan spel;
	
	public HangmanPaneel(HangMan spel){
		super();
		setSpel(spel);
		init();
	}

	private void init(){
		letter = new JTextField("",5);
		woord = new JLabel("");
		
		this.setLayout(new BorderLayout());
		this.add(letter, BorderLayout.EAST);
		this.add(woord, BorderLayout.CENTER);
		
		letter.addKeyListener(new RaadLuisteraar());
	}
	
	private void reset() {
		woord.setText(getSpel().getHint());
		getTekenVenster().teken();
	}
	
	public class RaadLuisteraar implements KeyListener {

		@Override
		public void keyPressed(KeyEvent arg0) {
			if(arg0.getKeyCode()== KeyEvent.VK_ENTER){
				String input = letter.getText();
				char guess = '\u0000';
				if(input.length() > 0){
					guess = input.charAt(0);
				}
				//TODO raad
                getSpel().raad(guess);

				woord.setText(getSpel().getHint());
				letter.setText("");
				getTekenVenster().teken();
				
				//TODO
				//toon boodschap als gewonnen of verloren en vraag of speler opnieuw wilt spelen
				//als de speler opnieuw wilt spelen: herzet het spel en het paneel
				//anders stop (System.exit(0))
                int dialog = -1;
                if (getSpel().isGewonnen()) {
                    dialog = JOptionPane.showConfirmDialog(null, "Hoera, je hebt het woord geraden! Wil je nog eens spelen?", "Gewonnen!", JOptionPane.YES_NO_OPTION);
                }
                else if (getSpel().isGameOver()) {
                    dialog = JOptionPane.showConfirmDialog(null, "Helaas, je bent verloren! Wil je nog eens spelen?", "Gewonnen!", JOptionPane.YES_NO_OPTION);
                }
                if (dialog == JOptionPane.YES_OPTION) {
                    getSpel().reset();
                    woord.setText(getSpel().getHint());
                    letter.setText("");
                    getTekenVenster().teken();
                }
                else if (dialog == JOptionPane.NO_OPTION) {
                    System.exit(0);
                }
			}
		}

		@Override
		public void keyReleased(KeyEvent arg0) {/* Niet nodig*/}
		@Override
		public void keyTyped(KeyEvent arg0) {/* Niet nodig*/}
	}
	
	private void setSpel(HangMan spel){
		this.spel = spel;
	}

	private HangMan getSpel() {
		return spel;
	}
	

	private TekenVenster getTekenVenster() {
		return tekenVenster;
	}

	 public void setTekenVenster(TekenVenster tekenVenster) {
		this.tekenVenster = tekenVenster;

		reset();
	}
}