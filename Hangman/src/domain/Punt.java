package domain;

public class Punt {
	private int x;
	private int y;

	public Punt(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x=x;
	}

	public void setY(int y) {
		this.y=y;
	}

	public String toString() {
		return "positie: ("+x+", "+y+")";
	}

	public boolean equals(Punt p) {
		if (p==null) return false;
		if(p.getX()==x&&p.getY()==y)return true;
		return false;
	}
}
