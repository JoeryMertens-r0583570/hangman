package db;

import java.util.*;

public class WoordenLijst {
	
	private List<String> woordenLijst = new ArrayList<String>();
	
	public WoordenLijst() {
		
	}
	
	public int getAantalWoorden() {
		return woordenLijst.size();
	}
	
	public void voegToe(String woord) throws DbException {
		if ( woord == null || woord.equals("") || woordenLijst.contains(woord)) throw new DbException();
		else woordenLijst.add(woord);
	}
	
	public String getRandomWoord() {
		Random random = new Random();
		return (woordenLijst.get(random.nextInt(woordenLijst.size())));
	}
	
}
