package domain;

public class Driehoek extends Vorm {

	private Punt hoekPunt1;
	private Punt hoekPunt2;
	private Punt hoekPunt3;
	
	public Driehoek(Punt hoekPunt1, Punt hoekPunt2, Punt hoekPunt3) {
		setHoekPunten(hoekPunt1, hoekPunt2, hoekPunt3);
	}
	
	public void setHoekPunten(Punt hoekPunt1, Punt hoekPunt2, Punt hoekPunt3) {
		if ( hoekPunt1 == null ||hoekPunt2 == null ||hoekPunt3 == null ) throw new DomainException("Hoekpunten  mogen niet NULL zijn.");
		if (hoekPunt1.equals(hoekPunt2) || hoekPunt1.equals(hoekPunt3) || hoekPunt2.equals(hoekPunt3)) throw new DomainException("HoekPunten mogen niet samenvallen.");
		if ((hoekPunt2.getX() - hoekPunt1.getX())*(hoekPunt3.getY() - hoekPunt1.getY())==(hoekPunt3.getX()-hoekPunt1.getX())*(hoekPunt2.getY()- hoekPunt1.getY())) {
			throw new DomainException("Hoekpunten mogen niet op een lijn liggen");
		}else {
			this.hoekPunt1 = hoekPunt1;
			this.hoekPunt2 = hoekPunt2;
			this.hoekPunt3 = hoekPunt3;
		}
	}

	public Punt getHoekPunt1() {
		return hoekPunt1;
	}
	
	public Punt getHoekPunt2() {
		return hoekPunt2;
	}

	public Punt getHoekPunt3() {
		return hoekPunt3;
	}
	
	public boolean equals(Driehoek object) {
		if (object == null) return false;
		Punt[] listOfPointsObject = {object.hoekPunt1, object.hoekPunt2, object.hoekPunt3};
		Punt[] listOfPointsThis = {this.hoekPunt1, this.hoekPunt2, this.hoekPunt3};
		
		if(listOfPointsObject.equals(listOfPointsThis)) {
			return true;
		}
		return false;
	}

	
	
}
