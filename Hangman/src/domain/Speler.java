package domain;

public class Speler {
	
	private String naam;
	private int score;

	public Speler(String naam) throws DomainException{
		if (naam == null || naam.isEmpty()) {
			throw new DomainException();
		}
		else this.setNaam(naam);
	}
	
	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	
	public void addToScore(int score) throws DomainException {
		if (this.getScore()+score < 0) throw new DomainException();
		else this.setScore(this.getScore()+score);
	}
	
	public boolean equals(Speler object) {
		if (object == null) return false;
		if (this.score == object.getScore() && this.naam == object.getNaam()) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		return (this.getNaam());
	}
}
