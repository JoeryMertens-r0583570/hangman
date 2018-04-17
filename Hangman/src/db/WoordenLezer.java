package db;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WoordenLezer {
	
	private String bestandsnaam;
	private WoordenLijst woordenLijst;

	public WoordenLezer(String bestandsNaam) {
		this.bestandsnaam = bestandsNaam;
	}
	
	public WoordenLijst lees() throws DbException, FileNotFoundException {
		File file = new File(bestandsnaam);
		Scanner scanner = new Scanner(file);
		while (scanner.hasNextLine()) {
//			System.out.println(scanner.nextLine());
			woordenLijst.voegToe(scanner.nextLine());
		}
		scanner.close();
		return woordenLijst;
	}
}
