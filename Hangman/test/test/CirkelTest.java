package test;

import domain.*;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author Jaro Deklerck
 */
public class CirkelTest {
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
}
