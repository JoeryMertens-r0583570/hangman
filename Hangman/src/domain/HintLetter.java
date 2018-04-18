package domain;

public class HintLetter {

//	temp
	private char letter;
	private boolean isgeraden = false;
	
	public HintLetter(char letter) {
		this.letter = letter;
		if(letter == ' ') isgeraden = true;
	}
	
	public boolean raad(char letter) {
		if (isgeraden) return false;
		if (Character.toLowerCase(this.letter) == Character.toLowerCase(letter)) {
			isgeraden = true;
			return true;
		}
		return false;
	}
	
	public boolean isGeraden() {
		return isgeraden;
	}
	
	public char toChar() {
		if (isgeraden) {
			return this.letter;
		}
		return '_';
	}
	
	public char getLetter() {
		return this.letter;
	}
}
