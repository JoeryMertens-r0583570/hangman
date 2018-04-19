package ui;

import java.awt.BorderLayout;

import domain.Tekening;

public class PictionaryHoofdScherm extends GameHoofdScherm{
	private PictionaryUi ui;

	public PictionaryHoofdScherm(String titel, Tekening tekening) {
		super(titel, tekening);
		// TODO Auto-generated constructor stub
	}
	public PictionaryHoofdScherm(String titel, PictionaryUi ui,Tekening tekening) {
		super(titel, tekening);
		this.ui=ui;

		this.add(new MenuPaneel(this), BorderLayout.SOUTH);
	}
	public void showMenu() {
		ui.showMenu();
	}
	public void clear() {
		ui.clear();
	}

}
