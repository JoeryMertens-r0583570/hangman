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
	private JLabel message;

	private TekenVenster tekenVenster;
	private HangMan spel;

	public HangmanPaneel(HangMan spel) {
		super();
		setSpel(spel);
		init();
	}

	private void init() {
		letter = new JTextField("", 5);
		woord = new JLabel("");
		message = new JLabel("");

		this.setLayout(new BorderLayout());
		this.add(letter, BorderLayout.EAST);
		this.add(woord, BorderLayout.CENTER);
		this.add(message, BorderLayout.SOUTH);

		letter.addKeyListener(new RaadLuisteraar());
	}

	private void reset() {
		woord.setText(getSpel().getHint());
		getTekenVenster().teken();
	}

	public class RaadLuisteraar implements KeyListener {

		@Override
		public void keyPressed(KeyEvent arg0) {
			if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
				String input = letter.getText();
				char guess = '\u0000';
				char[] alphabet= new char[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
				if (input.length() == 1) {
					guess = input.toLowerCase().charAt(0);
					boolean correct=false;
					for(char c:alphabet) {
						if(guess==c) {
							message.setText("U heeft de letter "+guess+" gegokt");
							correct=true;
							break;
							}
					}
					if(!correct) {
						message.setText("Gelieve een letter uit het Nederlandse alphabet te gebruiken");
						return;
					}
					
				} else {
					message.setText("Gelieve exact één letter in te geven");
					letter.setText("");
					return;
				}
				getSpel().raad(guess);

				woord.setText(getSpel().getHint());
				letter.setText("");
				getTekenVenster().teken();
				int dialog = -1;
				while (dialog == -1) {
					if (getSpel().isGewonnen()) {
						dialog = JOptionPane.showConfirmDialog(null,
								"Hoera, je hebt het woord geraden! Wil je nog eens spelen?", "Gewonnen!",
								JOptionPane.YES_NO_OPTION);
					} else if (getSpel().isGameOver()) {
						dialog = JOptionPane.showConfirmDialog(null,
								"Helaas, je bent verloren! Wil je nog eens spelen?", "Verloren :(",
								JOptionPane.YES_NO_OPTION);
					}
					else break;
				}
				if (dialog == JOptionPane.YES_OPTION) {
					getSpel().reset();
					woord.setText(getSpel().getHint());
					letter.setText("");
					getTekenVenster().teken();
				} else if (dialog == JOptionPane.NO_OPTION) {
					System.exit(0);
				}
			}
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			/* Niet nodig */}

		@Override
		public void keyTyped(KeyEvent arg0) {
			/* Niet nodig */}
	}

	private void setSpel(HangMan spel) {
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