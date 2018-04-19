
package ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import domain.HangMan;

public class MenuPaneel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JButton reset;
	private JButton add;
	private PictionaryHoofdScherm game;

	private TekenVenster tekenVenster;

	public MenuPaneel(PictionaryHoofdScherm game) {
		super();
		this.game=game;
		init();
	}

	private void init() {
		reset = new JButton("reset");
		add = new JButton("voeg vorm toe");

		this.setLayout(new BorderLayout());
		this.add(reset, BorderLayout.EAST);
		this.add(add, BorderLayout.WEST);
		ActionListener addEvent = new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {

				game.showMenu();

			}

		};

		add.addActionListener(addEvent);
		ActionListener resetEvent = new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {

				game.clear();

			}

		};

		add.addActionListener(resetEvent);

	}
}
