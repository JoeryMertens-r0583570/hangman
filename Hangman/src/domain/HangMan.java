package domain;

import db.WoordenLijst;

/**
 * @author Jaro Deklerck
 */
public class HangMan {
    private Speler speler;
    private WoordenLijst lijst;
    private HintWoord woord;
    private TekeningHangman tekening = new TekeningHangman();
    private boolean gameOver = false;
    private boolean gewonnen = false;

    public HangMan(Speler speler, WoordenLijst lijst) {
        setSpeler(speler);
        setLijst(lijst);
        setWoord(getLijst().getRandomWoord());
    }

    public String getHint() {
        return getWoord().toString();
    }

    public void raad(char letter) {
        if (!getWoord().raad(letter)) {
            getTekening().zetVolgendeZichtbaar();
        }
        if (getWoord().isGeraden()) {
            setGewonnen(true);
        }
        if (getTekening().getAantalOnzichtbaar() == 0) {
            setGameOver(true);
        }
    }

    public void reset() {
        setWoord(getLijst().getRandomWoord());
        getTekening().reset();
        setGewonnen(false);
        setGameOver(false);
    }

    public Speler getSpeler() {
        return speler;
    }

    public void setSpeler(Speler speler) {
        if (speler == null) {
            throw new DomainException("Speler is null");
        }
        this.speler = speler;
    }

    public WoordenLijst getLijst() {
        return lijst;
    }

    public void setLijst(WoordenLijst lijst) {
        if (lijst == null || lijst.getAantalWoorden()==0) {
            throw new DomainException("Speler is null");
        }
        this.lijst = lijst;
    }

    public TekeningHangman getTekening() {
        return tekening;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public boolean isGewonnen() {
        return gewonnen;
    }

    public void setGewonnen(boolean gewonnen) {
        this.gewonnen = gewonnen;
    }

    public HintWoord getWoord() {
        return woord;
    }

    public void setWoord(String woord) {
        this.woord = new HintWoord(woord);
    }
}
