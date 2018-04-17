package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import domain.*;
import org.junit.Test;

public class LijnstukTest {
    private Punt punt1 = new Punt(10, 20);
    private Punt zelfdeAlsPunt1 = new Punt(10, 20);
    private Punt punt2 = new Punt(190, 30);
    private Punt zelfdeAlsPunt2 = new Punt(190, 30);

    @Test
    public void LijnStuk_moet_lijnstuk_aanmaken_met_gegeven_startPunt_en_eindPunt() {
        LijnStuk lijnstuk = new LijnStuk(punt1, punt2);

        assertEquals(punt1, lijnstuk.getStartpunt());
        assertEquals(punt2, lijnstuk.getEindpunt());
    }

    @Test (expected = DomainException.class)
    public void LijnStuk_Moet_exception_gooien_als_startpunt_null()  {
        new LijnStuk(null, punt2);
    }

    @Test (expected = DomainException.class)
    public void LijnStuk_Moet_exception_gooien_als_eindpunt_null()  {
        new LijnStuk(punt1, null);
    }

    @Test
    public void equals_moet_true_teruggeven_als_begin_en_eindpunt_gelijk_zijn(){
        LijnStuk lijnStuk = new LijnStuk(punt1, punt2);
        LijnStuk zelfdeLijnStuk = new LijnStuk(zelfdeAlsPunt1, zelfdeAlsPunt2);
        assertTrue(lijnStuk.equals(zelfdeLijnStuk));
    }

    @Test
    public void equals_moet_false_teruggeven_als_begin_en_eindpunt_niet_gelijk_zijn(){
        LijnStuk lijnStuk = new LijnStuk(punt1, punt2);
        Punt anderPunt1 = new Punt(50,50);
        LijnStuk zelfdeLijnStuk = new LijnStuk(anderPunt1, zelfdeAlsPunt2);
        assertFalse(lijnStuk.equals(zelfdeLijnStuk));
    }

    @Test
    public void equals_moet_false_teruggeven_als_parameter_null(){
        LijnStuk lijnStuk = new LijnStuk(punt1, punt2);
        assertFalse(lijnStuk.equals(null));
    }
}
