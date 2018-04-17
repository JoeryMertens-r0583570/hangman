package domain;

/**
 * @author Jaro Deklerck
 */
public class TekeningHangman extends Tekening {

    public TekeningHangman() {
        super("Hangman");
        Vorm galgBodem = new Rechthoek(new Punt(10, 350), 300, 40);// altijd zichtbaar
        Vorm galgStaaf = new LijnStuk(new Punt(160, 350), new Punt(160, 50));// altijd zichtbaar
        Vorm hangbar = new LijnStuk(new Punt(160, 50), new Punt(280, 50));// altijd zichtbaar
        Vorm koord = new LijnStuk(new Punt(280, 50), new Punt(280, 100));// altijd zichtbaar
        Vorm hoofd = new Cirkel(new Punt(280, 125), 25);// zichtbaar na 1 fout
        Vorm oogLinks = new Cirkel(new Punt(270, 118), 2);// zichtbaar na 2 fouten
        Vorm oogRechts = new Cirkel(new Punt(290, 118), 2);//…
        Vorm neus = new Cirkel(new Punt(280, 128), 2);
        Vorm mond = new LijnStuk(new Punt(270, 138), new Punt(290, 138));
        Vorm lijf = new LijnStuk(new Punt(280, 150), new Punt(280, 250));
        Vorm beenLinks = new LijnStuk(new Punt(280, 250), new Punt(240, 310));
        Vorm beenRechts = new LijnStuk(new Punt(280, 250), new Punt(320, 310));
        Vorm voetLinks = new Cirkel(new Punt(240, 310), 5);
        Vorm voetRechts = new Cirkel(new Punt(320, 310), 5);
        Vorm armLinks = new LijnStuk(new Punt(280, 200), new Punt(230, 170));
        Vorm armRechts = new LijnStuk(new Punt(280, 200), new Punt(330, 170));
        Vorm handLinks = new Cirkel(new Punt(230, 170), 5);
        Vorm handRechts = new Cirkel(new Punt(330, 170), 5);
        getLijst().add(galgBodem);
        getLijst().add(galgStaaf);
        getLijst().add(hangbar);
        getLijst().add(koord);
        getLijst().add(hoofd);
        getLijst().add(oogLinks);
        getLijst().add(oogRechts);
        getLijst().add(neus);
        getLijst().add(mond);
        getLijst().add(lijf);
        getLijst().add(beenLinks);
        getLijst().add(beenRechts);
        getLijst().add(voetLinks);
        getLijst().add(voetRechts);
        getLijst().add(armLinks);
        getLijst().add(armRechts);
        getLijst().add(handLinks);
        getLijst().add(handRechts);
        for (int i = 4; i<18; i++) {
            getVorm(i).setZichtbaar(false);
        }
    }

    public int getAantalOnzichtbaar() {
        int count = 0;
        for (Vorm v: getLijst()){
            if (!v.isZichtbaar()) {
                count++;
            }
        }
        return count;
    }

    public void ZetVolgendeZichtbaar() {
        for (Vorm v: getLijst()){
            if (!v.isZichtbaar()) {
                v.setZichtbaar(true);
                return;
            }
        }
    }

    public void reset() {
        for (int i = 4; i<18; i++) {
            getVorm(i).setZichtbaar(false);
        }
    }

    @Override
    public void voegToe(Vorm vorm) {
        throw new DomainException("Kan niets toevoegen aan tekening");
    }

    @Override
    public void verwijder(Vorm vorm) {
        throw new DomainException("Kan niets verwijderen van tekening");
    }
}
