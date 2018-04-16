package ui;

import javax.swing.*;

public class Launcher {
	
	public static void main(String[] args) {
		
		JFrame f = new JFrame();
		JOptionPane.showInputDialog(f, "Welkom! \nHoe heet je?");
		JOptionPane.showMessageDialog(f, "... heeft als score: 0");
	}
}
