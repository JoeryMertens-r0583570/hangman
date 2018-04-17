package db;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WoordenLezer {
	
	private String bestandsnaam;

	public WoordenLezer(String bestandsNaam) {
		this.bestandsnaam = bestandsNaam;
	}
	
	public WoordenLijst lees() throws DbException, FileNotFoundException {
		WoordenLijst woordenLijst = new WoordenLijst();
		File file = new File(bestandsnaam);
		Scanner scanner = new Scanner(file);
		String woord = "";
		while (scanner.hasNextLine()) {
//			System.out.println(scanner.nextLine());
			woord = scanner.nextLine();
			woordenLijst.voegToe(woord);
		}
		scanner.close();
		return woordenLijst;
	}
}
