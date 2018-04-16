package domain;

public class Punt {
	private int x;
	private int y;

	public Punt(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public getX() {
		return x;
	}

	public getY() {
		return y;
	}

	public setX(int x) {
		this.x=x;
	}

	public setY(int y) {
		this.y=y;
	}

	public toString() {
		return "positie: ("+x+", "+y+")";
	}

	public equals(Punt p) {
		if(p.getX()==x&&p.getY==y)return true;
		return false;
	}
}
