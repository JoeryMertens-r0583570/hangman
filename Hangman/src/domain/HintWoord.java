package domain;

import java.util.ArrayList;
import java.util.List;

public class HintWoord {
	
	private List<HintLetter> letterList = new ArrayList<HintLetter>(); 
	private boolean isgeraden;

	public HintWoord(String woord) {
		if (woord == null ||  woord.isEmpty()) throw new DomainException("woord mag niet NULL zijn");
		for (int i = 0; i < woord.length();i++) {
			letterList.add(new HintLetter(woord.charAt(i)));
		}
		
	}
	
	public boolean raad(char letter) {
		boolean juist = false;
		for(HintLetter hintLetter: letterList) {
			if(hintLetter.raad(letter)) {
				juist = true;
			}
			
		}
		return juist;
	}
	
	public boolean isGeraden() {
		if (this.toString().replace("   ", " # ").replace(" ", "").replace("#", " ").equals(this.getWoord())) return true;
		return false;
	}
	
	public String toString() {
		String hint = "";
		for(HintLetter hintLetter: letterList) {
			hint += (" "+ hintLetter.toChar());
		}
		return hint.trim();
	}
	
	public String getWoord() {
		String woord = "";
		for(HintLetter hintLetter: letterList) {
			woord += (""+ hintLetter.getLetter());
		}
		return woord.trim();
	}
}
