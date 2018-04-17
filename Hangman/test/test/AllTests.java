package test;

import domain.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import static org.junit.Assert.*;

public class AllTests {
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
	
	//CirkelTest
	@Test
    public void testCirkelAanmakenCorrect() {
        Punt punt = new Punt(200, 200);
        Cirkel cirkel = new Cirkel(punt, 20);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testCirkelAanmakenMiddelpuntNull() {
        Cirkel cirkel = new Cirkel(null, 20);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testCirkelAanmakenStraalKleinerDan0() {
        Punt punt = new Punt(200, 200);
        Cirkel cirkel = new Cirkel(punt, -20);
    }
    @Test(expected = IllegalArgumentException.class)
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
    

}
