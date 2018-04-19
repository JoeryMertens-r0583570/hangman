package test;

import domain.*;
import org.junit.*;

import db.DbException;
import db.WoordenLijst;

import static org.junit.Assert.*;

import java.util.ArrayList;

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
	private HangMan hangman;
	private Speler geldigeSpeler;
	private WoordenLijst geldigeWoordenlijst;
	private WoordenLijst woordenlijstMetEnkelWoordTest;
	private Vorm gebouw;
	private Vorm dak;
	private Vorm deur;
	private Vorm raam;
	private Vorm deurknop;
	private Vorm raambalk1;
	private Vorm raambalk2;
	private Vorm schouwNietInTekening;
	private WoordenLijst woordenlijstLeeg;
	private WoordenLijst woordenlijstMetEenGeldigWoord;
	private WoordenLijst woordenlijstMetGeldigeWoorden;
	private ArrayList<String> geldigeWoorden;
	
	@Before
	public void setUp() throws DbException {
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
		gebouw = new Rechthoek(new Punt(100, 200), 200, 180);
	    dak = new Driehoek(new Punt(100, 200), new Punt(300, 200), new Punt(200, 100));
	    deur = new Rechthoek(new Punt(130, 280), 50,100);
	    raam = new Rechthoek(new Punt(210, 220), 80, 60);
	    deurknop = new Cirkel(new Punt(170, 320), 2);
	    raambalk1 = new LijnStuk(new Punt(210, 250), new Punt(290, 250));
	    raambalk2 = new LijnStuk(new Punt(250, 220), new Punt(250, 280));
	    schouwNietInTekening = new Rechthoek(new Punt(150, 150), 20,40);
	    geldigeWoorden = new ArrayList<String>();
		geldigeWoorden.add("test");
		geldigeWoorden.add("game");
		geldigeWoorden.add("hangman");
		
		woordenlijstLeeg = new WoordenLijst();
		
		woordenlijstMetEenGeldigWoord = new WoordenLijst();
		woordenlijstMetEenGeldigWoord.voegToe(geldigeWoorden.get(0));
		
		woordenlijstMetGeldigeWoorden = new WoordenLijst();
		woordenlijstMetGeldigeWoorden.voegToe(geldigeWoorden.get(0));
		woordenlijstMetGeldigeWoorden.voegToe(geldigeWoorden.get(1));
		woordenlijstMetGeldigeWoorden.voegToe(geldigeWoorden.get(2));
		geldigeSpeler = new Speler("naam");

		geldigeWoordenlijst = new WoordenLijst();
		geldigeWoordenlijst.voegToe("test");
		
		hangman = new HangMan(geldigeSpeler, geldigeWoordenlijst);
		
		woordenlijstMetEnkelWoordTest = new WoordenLijst();
		woordenlijstMetEnkelWoordTest.voegToe("test");
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
	//Lijnstuktest
	
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
	
	//HintLetterTest
	@Test
	public void HintLetter_moet_HintLetter_maken_die_niet_geraden_is() {
		HintLetter letter = new HintLetter('a');

		assertFalse(letter.isGeraden());
	}

	@Test
	public void raad_moet_true_teruggeven_en_op_geraden_zetten_als_juiste_letter() {
		HintLetter letter = new HintLetter('x');

		assertTrue(letter.raad('x'));
		assertTrue(letter.isGeraden());
	}

	@Test
	public void raad_moet_true_teruggeven_en_op_geraden_zetten_als_juiste_letter_maar_upperCase_in_plaats_van_lowercase() {
		HintLetter letter = new HintLetter('x');

		assertTrue(letter.raad('X'));
		assertTrue(letter.isGeraden());
	}

	@Test
	public void raad_moet_true_teruggeven_en_op_geraden_zetten_als_juiste_letter_maar_lowerCase_in_plaats_van_uppercase() {
		HintLetter letter = new HintLetter('X');

		assertTrue(letter.raad('x'));
		assertTrue(letter.isGeraden());
	}

	@Test
	public void raad_moet_false_teruggeven_als_verkeerde_letter() {
		HintLetter letter = new HintLetter('x');

		assertFalse(letter.raad('y'));
		assertFalse(letter.isGeraden());
	}

	@Test
	public void raad_moet_false_teruggeven_maar_op_geraden_laten_staan_als_juiste_letter_maar_reeds_geraden() {
		HintLetter letter = new HintLetter('f');

		assertTrue(letter.raad('f'));
		assertTrue(letter.isGeraden());
		assertFalse(letter.raad('f'));
	}

	@Test
	public void toChar_moet_letter_tonen_als_geraden() {
		HintLetter letter = new HintLetter('x');
		assertTrue(letter.raad('x'));

		assertEquals('x', letter.toChar());
		;
	}

	@Test
	public void toChar_moet_streepje_teruggeven_als_niet_geraden() {
		HintLetter letter = new HintLetter('x');

		assertEquals('_', letter.toChar());
	}

	@Test
	public void getLetter_moet_letter_teruggeven_als_geraden() {
		HintLetter letter = new HintLetter('x');
		assertTrue(letter.raad('x'));

		assertEquals('x', letter.toChar());
	}

	@Test
	public void getLetter_moet_letter_teruggeven_als_niet_geraden() {
		HintLetter letter = new HintLetter('x');

		assertEquals('x', letter.getLetter());
	}
	
	//HintWoordTest
	@Test
	public void HintWoord_moet_HintWoord_aanmaken_waarvan_alle_letters_verborgen_zijn() {
		String woord = "test";
		
		HintWoord hint = new HintWoord(woord);
		
		assertEquals(woord, hint.getWoord());
		assertEquals("_ _ _ _", hint.toString());
		assertFalse(hint.isGeraden());
	}
	
	@Test (expected = DomainException.class)
	public void HintWoord_moet_exception_gooien_als_woord_null(){
		new HintWoord(null);
	}
	
	@Test (expected = DomainException.class)
	public void HintWoord_moet_exception_gooien_als_woord_lege_string(){
		new HintWoord("");
	}
	
	@Test
	public void raad_moet_false_geven_als_letter_niet_in_woord(){
		HintWoord hint = new HintWoord("test");
		assertFalse(hint.raad('a'));
		assertFalse(hint.isGeraden());
	}
	
	@Test
	public void raad_moet_false_geven_als_letter_in_woord_maar_reeds_geraden(){
		HintWoord hint = new HintWoord("test");
		assertTrue(hint.raad('e'));
		assertFalse(hint.raad('e'));
		assertFalse(hint.isGeraden());
	}
	
	@Test
	public void raad_moet_true_geven_en_hint_aanpassen_als_letter_in_woord(){
		HintWoord hint = new HintWoord("test");
		assertTrue(hint.raad('e'));
		assertEquals("_ e _ _", hint.toString());
		assertFalse(hint.isGeraden());
	}
	
	@Test
	public void raad_moet_true_geven_en_hint_aanpassen_als_letter_in_woord_maar_in_verkeerde_case(){
		HintWoord hint = new HintWoord("test");
		assertTrue(hint.raad('E'));
		assertEquals("_ e _ _", hint.toString());
		assertFalse(hint.isGeraden());
	}
	
	@Test
	public void raad_moet_true_geven_en_hint__op_meerdere_plaatsen_aanpassen_als_letter_meermaals_in_woord(){
		HintWoord hint = new HintWoord("test");
		assertTrue(hint.raad('t'));
		assertEquals("t _ _ t", hint.toString());
		assertFalse(hint.isGeraden());
	}
	
	@Test 
	public void isGeraden_geeft_true_als_alle_letters_geraden(){
		HintWoord hint = new HintWoord("test");
		assertTrue(hint.raad('e'));
		assertTrue(hint.raad('t'));
		assertTrue(hint.raad('s'));
		
		assertTrue(hint.isGeraden());
	}

	//TekeningHangmanTests
    @Test
    public void maak_Tekening_Van_Hangman() {
	    TekeningHangman hangman = new TekeningHangman();
	    assertEquals(hangman.getNaam(), "Hangman");
	    assertEquals(hangman.getAantalOnzichtbaar(), 14);
	    assertTrue(hangman.getVorm(3).isZichtbaar());
    }

    @Test
    public void zet_Volgende_Zichtbaar() {
        TekeningHangman hangman = new TekeningHangman();
        hangman.zetVolgendeZichtbaar();
        assertEquals(hangman.getAantalOnzichtbaar(), 13);
        assertTrue(hangman.getVorm(4).isZichtbaar());
        hangman.zetVolgendeZichtbaar();
        assertEquals(hangman.getAantalOnzichtbaar(), 12);
        assertTrue(hangman.getVorm(5).isZichtbaar());
    }
    @Test(expected = DomainException.class)
    public void zet_Volgende_Zichtbaar_18_Zichtbaar() {
        TekeningHangman hangman = new TekeningHangman();
        for (int i = 4; i < 18; i++) {
            hangman.zetVolgendeZichtbaar();
        }
        assertEquals(hangman.getAantalOnzichtbaar(), 0);
        assertTrue(hangman.getVorm(17).isZichtbaar());
        hangman.zetVolgendeZichtbaar();
    }
    @Test
    public void reset_Hangman() {
        TekeningHangman hangman = new TekeningHangman();
        hangman.zetVolgendeZichtbaar();
        assertEquals(hangman.getAantalOnzichtbaar(), 13);
        assertTrue(hangman.getVorm(4).isZichtbaar());
        hangman.zetVolgendeZichtbaar();
        assertEquals(hangman.getAantalOnzichtbaar(), 12);
        assertTrue(hangman.getVorm(5).isZichtbaar());
        hangman.reset();
        assertEquals(hangman.getAantalOnzichtbaar(), 14);
        assertTrue(hangman.getVorm(3).isZichtbaar());
    }
    @Test(expected = DomainException.class)
    public void voeg_Toe_Aan_Hangman() {
        TekeningHangman hangman = new TekeningHangman();
        hangman.voegToe(new Cirkel(punt, 20));
    }
    @Test(expected = DomainException.class)
    public void verwijder_Van_Hangman() {
        TekeningHangman hangman = new TekeningHangman();
        hangman.verwijder(hangman.getVorm(5));
    }

//Hangman

@Test
public void HangMan_moet_een_HangMan_spel_maken_en_initialiseren_voor_de_gegeven_speler_met_de_gegeven_woordenlijst() {
	hangman = new HangMan(geldigeSpeler, woordenlijstMetEnkelWoordTest);
	assertEquals(geldigeSpeler, hangman.getSpeler());
	assertFalse(hangman.isGameOver());
	assertFalse(hangman.isGewonnen());
	assertEquals("_ _ _ _", hangman.getHint());
}

@Test (expected = DomainException.class)
public void HangMan_moet_een_exception_gooien_als_gegeven_speler_null() {
	hangman = new HangMan(null, geldigeWoordenlijst);
}

@Test (expected = DomainException.class)
public void HangMan_moet_een_exception_gooien_als_gegeven_woordenlijst_null() {
	hangman = new HangMan(geldigeSpeler, null);
}

@Test (expected = DomainException.class)
public void HangMan_moet_een_exception_gooien_als_gegeven_woordenlijst_leeg() {
	WoordenLijst legeWoordenlijst = new WoordenLijst();
	assertEquals(0, legeWoordenlijst.getAantalWoorden());
	hangman = new HangMan(geldigeSpeler, legeWoordenlijst);
}

// De testen voor wat er gebeurt als je een foutieve letter (null, leeg, meer dan 1 karakter) 
// meegeeft, worden hier niet herhaald, die zitten al in de HintWoordTest	
@Test
public void raad_moet_volgende_zichtbaar_zetten_indien_fout_geraden(){
	hangman = new HangMan(geldigeSpeler, woordenlijstMetEnkelWoordTest);
	char letter = 'a';
	assertEquals(14, hangman.getTekening().getAantalOnzichtbaar());
	
	hangman.raad(letter);
	assertEquals(13, hangman.getTekening().getAantalOnzichtbaar());
	assertFalse(hangman.isGameOver());
	assertFalse(hangman.isGewonnen());
}
@Test
public void raad_moet_volgende_zichtbaar_zetten_indien_fout_geraden2(){
	hangman = new HangMan(geldigeSpeler, woordenlijstMetEnkelWoordTest);
	char letter = 'b';
	assertEquals(14, hangman.getTekening().getAantalOnzichtbaar());
	
	hangman.raad(letter);
	assertEquals(13, hangman.getTekening().getAantalOnzichtbaar());
	assertFalse(hangman.isGameOver());
	assertFalse(hangman.isGewonnen());

}
@Test
public void raad_mag_volgende_niet_zichtbaar_zetten_indien_juist_geraden(){
	hangman = new HangMan(geldigeSpeler, woordenlijstMetEnkelWoordTest);
	char letter = 'e';
	assertEquals(14, hangman.getTekening().getAantalOnzichtbaar());
	
	hangman.raad(letter);
	assertEquals(14, hangman.getTekening().getAantalOnzichtbaar());
	assertFalse(hangman.isGameOver());
	assertFalse(hangman.isGewonnen());
}

@Test
public void raad_mag_volgende_niet_zichtbaar_zetten_en_gewonnen_op_true_als_laatste_letter_juist_geraden(){
	HangMan hangmanOp1NaGeraden = new HangMan(geldigeSpeler, woordenlijstMetEnkelWoordTest);
	hangmanOp1NaGeraden.raad('t');
	hangmanOp1NaGeraden.raad('e');
	
	hangmanOp1NaGeraden.raad('s');

	assertEquals(14, hangmanOp1NaGeraden.getTekening().getAantalOnzichtbaar());
	assertFalse(hangmanOp1NaGeraden.isGameOver());
	assertTrue(hangmanOp1NaGeraden.isGewonnen());
}

@Test
public void raad_moet_volledige_afbeelding_zichtbaar_zetten_en_gameover_op_true_als_laatste_kans_fout_geraden(){
	HangMan hangmanNietGeradenEn13FouteAntwoorden = new HangMan(geldigeSpeler, woordenlijstMetEnkelWoordTest);
	for(int i = 0; i < 13; i++){
		hangmanNietGeradenEn13FouteAntwoorden.raad('a');
	}

	hangmanNietGeradenEn13FouteAntwoorden.raad('o');
	
	assertEquals(0, hangmanNietGeradenEn13FouteAntwoorden.getTekening().getAantalOnzichtbaar());
	assertTrue(hangmanNietGeradenEn13FouteAntwoorden.isGameOver());
	assertFalse(hangmanNietGeradenEn13FouteAntwoorden.isGewonnen());
}

@Test
public void Tekening_moet_een_tekening_aanmaken_met_een_geldige_naam_en_0_vormen() {
    Tekening huis = new Tekening("huis");
    assertEquals("huis", huis.getNaam());
    assertEquals(0, huis.getAantalVormen());
}

@Test (expected = IllegalArgumentException.class)
public void Tekening_moet_exception_gooien_als_naam_null() {
    new Tekening(null);
}

@Test (expected = IllegalArgumentException.class)
public void Tekening_moet_exception_gooien_als_naam_leeg() {
    new Tekening("");
}
//TODO
/*@Test
public void getAantalVormen_moet_aantal_vormen_teruggeven() {
    Tekening huis = createHuisZonderShouw();
    assertEquals(7, huis.getAantalVormen());
}

@Test
public void bevat_geeft_true_als_gegeven_vorm_deel_uitmaakt_van_de_tekening(){
    Tekening huis = createHuisZonderShouw();
    assertTrue(huis.bevat(deur));
}

@Test
public void bevat_geeft_false__als_gegeven_vorm_geen_deel_uitmaakt_van_de_tekening(){
    Tekening huis = createHuisZonderShouw();
    assertFalse(huis.bevat(schouwNietInTekening));
}



@Test
public void equals_moet_false_teruggeven_als_parameter_tekening_is_met_verschillend_aantal_vormen(){
    Tekening huis = createHuisZonderShouw();
    Tekening huisMetSchouw = createHuisMetSchouw();
    assertFalse(huis.equals(huisMetSchouw));
}

@Test
public void equals_moet_false_teruggeven_als_parameter_tekening_is_met_zelfde_aantal_vormen_ander_vorm(){
    Tekening huis = createHuisZonderShouw();
    Tekening huisMetSchouwZonderDeur = createHuisMetSchouwZonderDeur();
    assertFalse(huis.equals(huisMetSchouwZonderDeur));
}

@Test
public void equals_moet_true_teruggeven_als_parameter_tekening_is_met_zelfde_aantal_vormen_andere_volgorde(){
    Tekening huis = createHuisZonderShouw();
    Tekening huisMetSchouwZonderDeur = createHuisMetSchouwZonderDeur();
    huisMetSchouwZonderDeur.verwijder(schouwNietInTekening);
    huisMetSchouwZonderDeur.voegToe(deur);
    assertTrue(huis.equals(huisMetSchouwZonderDeur));
}

@Test
public void equals_moet_true_teruggeven_alsparameter_tekening_is_met_zelfde_aantal_vormen_zelfde_volgorde(){
    Tekening huis = createHuisZonderShouw();
    Tekening huisMetSchouw = createHuisMetSchouw();
    huisMetSchouw.verwijder(schouwNietInTekening);
    assertTrue(huis.equals(huisMetSchouw));
}


public Tekening createHuisMetSchouw() {
    Tekening huisMetSchouw = new Tekening("huisMetSchouw");
    huisMetSchouw.voegToe(gebouw);
    huisMetSchouw.voegToe(dak);
    huisMetSchouw.voegToe(deur);
    huisMetSchouw.voegToe(raam);
    huisMetSchouw.voegToe(deurknop);
    huisMetSchouw.voegToe(raambalk1);
    huisMetSchouw.voegToe(raambalk2);
    huisMetSchouw.voegToe(schouwNietInTekening);
    return huisMetSchouw;
}

public Tekening createHuisZonderShouw() {
    Tekening huis = new Tekening("huis");
    huis.voegToe(gebouw);
    huis.voegToe(dak);
    huis.voegToe(deur);
    huis.voegToe(raam);
    huis.voegToe(deurknop);
    huis.voegToe(raambalk1);
    huis.voegToe(raambalk2);
    return huis;
}

public Tekening createHuisMetSchouwZonderDeur() {
    Tekening huisMetSchouwZonderDeur = new Tekening("huisMetSchouwZonderDeur");
    huisMetSchouwZonderDeur.voegToe(gebouw);
    huisMetSchouwZonderDeur.voegToe(dak);
    huisMetSchouwZonderDeur.voegToe(raam);
    huisMetSchouwZonderDeur.voegToe(deurknop);
    huisMetSchouwZonderDeur.voegToe(raambalk1);
    huisMetSchouwZonderDeur.voegToe(raambalk2);
    huisMetSchouwZonderDeur.voegToe(schouwNietInTekening);
    return huisMetSchouwZonderDeur;
}
*/
//woordenlijst
@Test
public void WoordenLijst_moet_een_Woordenlijst_maken_zonder_woorden() {
	WoordenLijst woordenlijstLeeg = new WoordenLijst();
	assertEquals(0,woordenlijstLeeg.getAantalWoorden());
}

@Test
public void voegToe_moet_een_woord_toevoegen() throws DbException {
	woordenlijstLeeg.voegToe(geldigeWoorden.get(0));
	
	assertEquals(1,woordenlijstLeeg.getAantalWoorden());
}

@Test (expected = DbException.class)
public void voegToe_moet_exception_gooien_als_gegeven_woord_null() throws DbException {
	woordenlijstLeeg.voegToe(null);
}

@Test (expected = DbException.class)
public void voegToe_moet_exception_gooien_als_gegeven_woord_leeg() throws DbException {
	woordenlijstLeeg.voegToe("");
}

@Test (expected = DbException.class)
public void voegToe_moet_exception_gooien_als_gegeven_woord_reeds_in_lijst() throws DbException {
	String woordAlInLijst = geldigeWoorden.get(2);

	woordenlijstMetGeldigeWoorden.voegToe(woordAlInLijst);
}

}






