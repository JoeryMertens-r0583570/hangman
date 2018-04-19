package domain;

public class Speler {
	
	private String naam;
	private int score;
	private int id;
	private static int counter = 0;

	public Speler(String naam) throws DomainException{
		this.setNaam(naam);
		counter++;
		setId(counter);
	}
	
	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) throws DomainException {
		if (naam == null || naam.trim().isEmpty()) {
			throw new DomainException("Naam mag niet leeeg zijn.");
		}
		else this.naam = naam;
		
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
		if (this.score == object.getScore() && this.naam.equals(object.getNaam())) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		return (this.getNaam());
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
	    if (id > counter) {
            this.id = id;
        }
        else {
	        counter++;
	        this.id = counter;
        }
    }
}
