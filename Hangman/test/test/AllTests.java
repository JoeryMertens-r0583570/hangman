package test;

import domain.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import static org.junit.Assert.*;

public class AllTests {
	
	private String naam;
	private String anderenaam;
	private int positiveScore;
	private int negativeScore;
	private Speler speler;
	
	private Punt punt1 = new Punt(10, 20);
	private Punt zelfdeAlsPunt1 = new Punt(10, 20);
	private Punt verschillendVanPunt1 = new Punt(15, 20);
	private Punt punt2 = new Punt(20, 40);
	private Punt zelfdeAlsPunt2 = new Punt(20, 40);
	private Punt verschillendVanPunt2 = new Punt(40, 20);
	private Punt punt3 = new Punt(190, 30);
	private Punt zelfdeAlsPunt3 = new Punt(190, 30);
	private Punt verschillendVanPunt3 = new Punt(120, 100);
	
	
	private Punt lijnstukPunt2 = new Punt(190, 30);
    private Punt lijnstukZelfdeAlsPunt2 = new Punt(190, 30);
	
    
    private Punt linkerBovenhoek;
	private int breedte, hoogte;
	private Omhullende omhullende;
	
	private int xCoordinaat;
	private int yCoordinaat;
	private Punt punt;
	
	private Rechthoek rechthoek;
	
	@Before
	public void setUp() {
		naam = "Lars";
		anderenaam = "Lies";
		positiveScore = 5;
		negativeScore = -5;
		speler = new Speler(naam);
		
		linkerBovenhoek = new Punt(200, 200);
		breedte = 20;
		hoogte = 40;
		omhullende = new Omhullende(linkerBovenhoek,breedte, hoogte);
		
		xCoordinaat = 5;
		yCoordinaat = 10;
		punt = new Punt(xCoordinaat, yCoordinaat);
		
		rechthoek = new Rechthoek(linkerBovenhoek,breedte, hoogte);
	}
	
	//CirkelTest
	@Test
    public void testCirkelAanmakenCorrect() {
        Punt punt = new Punt(200, 200);
        Cirkel cirkel = new Cirkel(punt, 20);
    }
    @Test(expected = DomainException.class)
    public void testCirkelAanmakenMiddelpuntNull() {
        Cirkel cirkel = new Cirkel(null, 20);
    }
    @Test(expected = DomainException.class)
    public void testCirkelAanmakenStraalKleinerDan0() {
        Punt punt = new Punt(200, 200);
        Cirkel cirkel = new Cirkel(punt, -20);
    }
    @Test(expected = DomainException.class)
    public void testCirkelAanmakenStraalGelijkAan0() {
        Punt punt = new Punt(200, 200);
        Cirkel cirkel = new Cirkel(punt, 0);
    }
    @Test
    public void testCirkelsVergelijkenCorrect() {
        Punt punt = new Punt(200, 200);
        Cirkel cirkel1 = new Cirkel(punt, 20);
        Cirkel cirkel2 = new Cirkel(punt, 20);
        assertTrue(cirkel1.equals(cirkel2));
    }
    @Test
    public void testCirkelsVergelijkenTweedeCirkelNull() {
        Punt punt = new Punt(200, 200);
        Cirkel cirkel1 = new Cirkel(punt, 20);
        Cirkel cirkel2 = null;
        assertFalse(cirkel1.equals(cirkel2));
    }
    @Test
    public void testCirkelsVergelijkenVerschillendMiddelpunt() {
        Punt punt1 = new Punt(200, 200);
        Punt punt2 = new Punt(100, 100);
        Cirkel cirkel1 = new Cirkel(punt1, 20);
        Cirkel cirkel2 = new Cirkel(punt2, 20);
        assertFalse(cirkel1.equals(cirkel2));
    }
    @Test
    public void testCirkelsVergelijkenVerschillendeStraal() {
        Punt punt = new Punt(200, 200);
        Cirkel cirkel1 = new Cirkel(punt, 20);
        Cirkel cirkel2 = new Cirkel(punt, 10);
        assertFalse(cirkel1.equals(cirkel2));
    }
    
    //DriehoekTest
    @Test
	public void Driehoek_moet_DrieHoek_aanmaken_met_gegeven_hoekpunten() {
		Driehoek drieHoek = new Driehoek(punt1, punt2, punt3);

		assertEquals(punt1, drieHoek.getHoekPunt1());
		assertEquals(punt2, drieHoek.getHoekPunt2());
		assertEquals(punt3, drieHoek.getHoekPunt3());
	}
	
	@Test (expected = DomainException.class)
	public void Driehoek_Moet_exception_gooien_als_hoekpunt1_null()  {
		new Driehoek(null, punt2, punt3);
	}
	
	@Test (expected = DomainException.class)
	public void Driehoek_Moet_exception_gooien_als_hoekpunt2_null()  {
		new Driehoek(punt1, null, punt3);
	}
	
	@Test (expected = DomainException.class)
	public void DrieHoek_Moet_exception_gooien_als_hoekpunt3_null()  {
		new Driehoek(punt1, punt2, null);
	}
	
	@Test
	public void Driehoek_equals_moet_false_teruggeven_als_hoekPunt1_verschillend(){
		Driehoek drieHoek = new Driehoek(punt1, punt2, punt3);
		Driehoek andereDriehoek = new Driehoek(verschillendVanPunt1, zelfdeAlsPunt2, zelfdeAlsPunt3);
		assertFalse(drieHoek.equals(andereDriehoek));
	}
	
	@Test
	public void Driehoek_equals_moet_false_teruggeven_als_hoekPunt2_verschillend(){
		Driehoek drieHoek = new Driehoek(punt1, punt2, punt3);
		Driehoek andereDriehoek = new Driehoek(zelfdeAlsPunt1, verschillendVanPunt2, zelfdeAlsPunt3);
		assertFalse(drieHoek.equals(andereDriehoek));
	}
	
	@Test
	public void Driehoek_equals_moet_false_teruggeven_als_hoekPunt3_verschillend(){
		Driehoek drieHoek = new Driehoek(punt1, punt2, punt3);
		Driehoek andereDriehoek = new Driehoek(zelfdeAlsPunt1, zelfdeAlsPunt2, verschillendVanPunt3);
		assertFalse(drieHoek.equals(andereDriehoek));
	}
	
	@Test
	public void Driehoek_equals_moet_false_teruggeven_als_parameter_null(){
		Driehoek drieHoek = new Driehoek(punt1, punt2, punt3);
		assertFalse(drieHoek.equals(null));
	}
	
	@Test
    public void LijnStuk_moet_lijnstuk_aanmaken_met_gegeven_startPunt_en_eindPunt() {
        LijnStuk lijnstuk = new LijnStuk(punt1, lijnstukPunt2);

        assertEquals(punt1, lijnstuk.getStartpunt());
        assertEquals(lijnstukPunt2, lijnstuk.getEindpunt());
    }

    @Test (expected = DomainException.class)
    public void LijnStuk_Moet_exception_gooien_als_startpunt_null()  {
        new LijnStuk(null, lijnstukPunt2);
    }

    @Test (expected = DomainException.class)
    public void LijnStuk_Moet_exception_gooien_als_eindpunt_null()  {
        new LijnStuk(punt1, null);
    }

    @Test
    public void equals_moet_true_teruggeven_als_begin_en_eindpunt_gelijk_zijn(){
        LijnStuk lijnStuk = new LijnStuk(punt1, lijnstukPunt2);
        LijnStuk zelfdeLijnStuk = new LijnStuk(zelfdeAlsPunt1, lijnstukZelfdeAlsPunt2);
        assertTrue(lijnStuk.equals(zelfdeLijnStuk));
    }

    @Test
    public void equals_moet_false_teruggeven_als_begin_en_eindpunt_niet_gelijk_zijn(){
        LijnStuk lijnStuk = new LijnStuk(punt1, lijnstukPunt2);
        Punt anderPunt1 = new Punt(50,50);
        LijnStuk zelfdeLijnStuk = new LijnStuk(anderPunt1, lijnstukZelfdeAlsPunt2);
        assertFalse(lijnStuk.equals(zelfdeLijnStuk));
    }

    @Test
    public void equals_moet_false_teruggeven_als_parameter_null(){
        LijnStuk lijnStuk = new LijnStuk(punt1, lijnstukPunt2);
        assertFalse(lijnStuk.equals(null));
    }
    
    //OmhullendeTest
    @Test
	public void Omhullende_moet_omhullende_aanmaken_met_gegeven_linkerbovenhoek_breedte_en_hoogte() {
		Omhullende omhullende = new Omhullende(linkerBovenhoek,breedte, hoogte);
		assertEquals(linkerBovenhoek, omhullende.getLinkerBovenhoek());
		assertEquals(hoogte, omhullende.getHoogte());
		assertEquals(breedte, omhullende.getBreedte());
	}
	
	@Test (expected = DomainException.class)
	public void Omhullende_Moet_exception_gooien_als_linkerbovenhoek_null()  {
		new Omhullende(null, breedte, hoogte);
	}
	
	@Test (expected = DomainException.class)
	public void Omhullende_Moet_exception_gooien_als_breedte_kleiner_dan_0()  {
		new Omhullende(linkerBovenhoek, -1, hoogte);
	}
	
	@Test (expected = DomainException.class)
	public void Omhullende_Moet_exception_gooien_als_hoogte_kleiner_dan_0()  {
		new Omhullende(linkerBovenhoek, breedte, -1);
	}

	@Test
	public void Omhullende_Moet_omhullende_maken_als_breedte_gelijk_aan_0()  {
		Omhullende omhullende = new Omhullende(linkerBovenhoek,0, hoogte);
		assertEquals(0, omhullende.getBreedte());
	}
	
	@Test
	public void Omhullende_Moet_omhullende_maken_als_hoogte_gelijk_aan_0()  {
		Omhullende omhullende = new Omhullende(linkerBovenhoek,breedte, 0);
		assertEquals(0, omhullende.getHoogte());
	}
	
	@Test
	public void Omhullend_equals_moet_true_teruggeven_als_linkerbovenhoek_breedte_hoogte_gelijk_zijn(){
		Omhullende zelfdeOmhullende = new Omhullende(linkerBovenhoek,breedte, hoogte);
		assertTrue(omhullende.equals(zelfdeOmhullende));
	}
	
	@Test
	public void Omhullend_equals_moet_false_teruggeven_als_linkerbovenhoek_verschilt(){
		Punt andereLinkerBovenhoek = new Punt(100,100);
		Omhullende verschillendeOmhullende = new Omhullende(andereLinkerBovenhoek, breedte, hoogte);
		assertFalse(omhullende.equals(verschillendeOmhullende));
	}
	
	@Test
	public void Omhullend_equals_moet_false_teruggeven_als_breedte_verschilt(){
		Omhullende verschillendeOmhullende = new Omhullende(linkerBovenhoek, breedte + 10, hoogte);
		assertFalse(omhullende.equals(verschillendeOmhullende));
	}
	
	@Test
	public void Omhullend_equals_moet_false_teruggeven_als_hoogte_verschilt(){
		Omhullende verschillendeOmhullende = new Omhullende(linkerBovenhoek, breedte, hoogte + 10);
		assertFalse(omhullende.equals(verschillendeOmhullende));
	}
	
	@Test
	public void Omhullend_equals_moet_false_teruggeven_als_parameter_null(){
		assertFalse(omhullende.equals(null));
	}
	
	//PuntTest
	
	@Test
	public void Punt_moet_een_punt_maken_met_de_gegeven_coordinaten() {
		punt = new Punt(xCoordinaat, yCoordinaat);
		assertEquals(xCoordinaat, punt.getX());
		assertEquals(yCoordinaat, punt.getY());
	}
	
	public void punt_equals_moet_true_teruggeven_als_x_en_y_coordinaat_gelijk_zijn(){
		Punt puntAnder = new Punt(xCoordinaat, yCoordinaat);
		assertTrue(punt.equals(puntAnder));
	}
	
	@Test
	public void punt_equals_moet_false_teruggeven_als_parameter_null(){
		assertFalse(punt.equals(null));
	}
	
	@Test
	public void punt_equals_moet_false_teruggeven_als_punt_verschillende_x_coordinaat_heeft(){
		Punt puntAnder = new Punt(xCoordinaat-1, yCoordinaat);
		assertFalse(punt.equals(puntAnder));
	}
	
	@Test
	public void punt_equals_moet_false_teruggeven_als_punt_verschillende_y_coordinaat_heeft(){
		Punt puntAnder = new Punt(xCoordinaat, yCoordinaat-1);
		assertFalse(punt.equals(puntAnder));
	}
	
	//RechthoekTest
	@Test
	public void Rechthoek_moet_rechthoek_aanmaken_met_gegeven_linkerbovenhoek_breedte_en_hoogte() throws DomainException {
		Rechthoek rechthoek = new Rechthoek(linkerBovenhoek,breedte, hoogte);
		assertEquals(linkerBovenhoek, rechthoek.getLinkerBovenhoek());
		assertEquals(hoogte, rechthoek.getHoogte());
		assertEquals(breedte, rechthoek.getBreedte());
	}
	
	@Test (expected = DomainException.class)
	public void Rechthoek_Moet_exception_gooien_als_linkerbovenhoek_null() throws DomainException  {
		new Rechthoek(null, breedte, hoogte);
	}
	
	@Test (expected = DomainException.class)
	public void Rechthoek_Moet_exception_gooien_als_breedte_kleiner_dan_0() throws DomainException  {
		new Rechthoek(linkerBovenhoek, -1, hoogte);
	}
	
	@Test (expected = DomainException.class)
	public void Rechthoek_Moet_exception_gooien_als_hoogte_kleiner_dan_0() throws DomainException  {
		new Rechthoek(linkerBovenhoek, breedte, -1);
		
	}

	@Test (expected = DomainException.class)
	public void Rechthoek_Moet_exception_gooien_als_breedte_gelijk_aan_0() throws DomainException  {
		new Rechthoek(linkerBovenhoek, 0, hoogte);
	}
	
	@Test (expected = DomainException.class)
	public void Rechthoek_Moet_exception_gooien_als_hoogte_gelijk_aan_dan_0() throws DomainException  {
		new Rechthoek(linkerBovenhoek, breedte, 0);
	}
	
	@Test
	public void Rechthoek_equals_moet_true_teruggeven_als_linkerbovenhoek_breedte_hoogte_gelijk_zijn() throws DomainException{
		Rechthoek zelfdeRechthoek = new Rechthoek(linkerBovenhoek,breedte, hoogte);
		assertTrue(rechthoek.equals(zelfdeRechthoek));
	}
	
	@Test
	public void Rechthoek_equals_moet_false_teruggeven_als_linkerbovenhoek_verschilt() throws DomainException{
		Punt andereLinkerBovenhoek = new Punt(100,100);
		Rechthoek verschillendeRechthoek = new Rechthoek(andereLinkerBovenhoek, breedte, hoogte);
		assertFalse(rechthoek.equals(verschillendeRechthoek));
	}
	
	@Test
	public void Rechthoek_equals_moet_false_teruggeven_als_breedte_verschilt() throws DomainException{
		Rechthoek verschillendeRechthoek = new Rechthoek(linkerBovenhoek, breedte + 10, hoogte);
		assertFalse(rechthoek.equals(verschillendeRechthoek));
	}
	
	@Test
	public void Rechthoek_equals_moet_false_teruggeven_als_hoogte_verschilt() throws DomainException{
		Rechthoek verschillendeRechthoek = new Rechthoek(linkerBovenhoek, breedte, hoogte + 10);
		assertFalse(rechthoek.equals(verschillendeRechthoek));
	}
	
	@Test
	public void Rechthoek_equals_moet_false_teruggeven_als_parameter_null(){
		assertFalse(rechthoek.equals(null));
	}
	
	//SpelerTest
	@Test
	public void Speler_moet_speler_aanmaken_met_gegeven_naam() throws DomainException {
		speler = new Speler(naam);
		assertEquals(naam, speler.getNaam());
		assertEquals(0, speler.getScore());
	}
	
	@Test (expected = DomainException.class)
	public void Speler_moet_exception_gooien_als_naam_null() throws DomainException {
		speler = new Speler(null);
	}
	
	@Test (expected = DomainException.class)
	public void Speler_moet_exception_gooien_als_naam_lege_string() throws DomainException {
		speler = new Speler("");
	}
	
	@Test
	public void equals_moet_true_teruggeven_als_naam_en_score_gelijk_zijn() throws DomainException{
		speler.addToScore(positiveScore);
		Speler andereSpeler = new Speler(new String("Lars"));
		andereSpeler.addToScore(positiveScore);
		
		assertTrue(speler.equals(andereSpeler));
	}
	
	@Test
	public void Speler_equals_moet_false_teruggeven_als_parameter_null(){
		assertFalse(speler.equals(null));
	}
	
	@Test
	public void equals_moet_false_teruggeven_als_speler_een_andere_naam_heeft() throws DomainException{
		Speler andereSpeler = new Speler(anderenaam);
		assertFalse(speler.equals(andereSpeler));
	}
	
	@Test
	public void equals_moet_false_teruggeven_als_speler_aan_andere_score_heeft() throws DomainException{
		Speler andereSpeler = new Speler(naam);
		andereSpeler.addToScore(positiveScore);
		assertFalse(speler.equals(andereSpeler));
	}
	
	@Test
	public void addToScore_moet_gegeven_score_toevoegen_aan_bestaande_score() throws DomainException{
		speler.addToScore(positiveScore);
		assertEquals(positiveScore, speler.getScore());
	}
	
	@Test
	public void addtoScore_mag_negatieve_score_toevoegen_als_de_resulterende_score_niet_negatief_wordt() throws DomainException{
		speler.addToScore(positiveScore);
		speler.addToScore(positiveScore);
		speler.addToScore(negativeScore);
		assertEquals(positiveScore, speler.getScore());
	}
	
	@Test (expected = DomainException.class)
	public void addToScore_moet_exception_gooien_als_resulterende_score_negatief_wordt() throws DomainException{
		speler.addToScore(negativeScore);
	}
}
