package domain;

public class Omhullende {
	private int hoogte;
	private int breedte;
	private Punt linksboven;

	public Omhullende(Vorm vorm) {
		if(vorm instanceof Rechthoek) {
			linksboven = ((Rechthoek) vorm).getLinkerBovenhoek();
			breedte=((Rechthoek) vorm).getBreedte();
			hoogte=((Rechthoek) vorm).getHoogte();
		}
		if(vorm instanceof Cirkel) {
			linksboven=new Punt(((Cirkel) vorm).getMiddelpunt().getX()-((Cirkel) vorm).getRadius(),((Cirkel) vorm).getMiddelpunt().getY()-((Cirkel) vorm).getRadius());
			hoogte=((Cirkel) vorm).getRadius()*2;
			breedte=((Cirkel) vorm).getRadius()*2;
		}
	}

	public Punt getLinksboven() {
		return linksboven;
	}

	public void setLinksboven(Punt linksboven) {
		this.linksboven = linksboven;
	}

	public int getBreedte() {
		return breedte;
	}

	public void setBreedte(int breedte) {
		this.breedte = breedte;
	}

	public int getHoogte() {
		return hoogte;
	}

	public void setHoogte(int hoogte) {
		this.hoogte = hoogte;
	}
	public int getMinimumX() {
		return linksboven.getX();
	}
	public int getMinimumY() {
		return linksboven.getY()-hoogte;
	}
	public int getMaximumX() {
		return linksboven.getX()+breedte;
	}
	public int getMaximumY() {
		return linksboven.getY();
	}
}
