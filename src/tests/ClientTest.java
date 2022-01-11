package tests;

import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import dao.client.Adresse;

public class ClientTest {


	@Test
	public void testLux() {
		
		assertEquals("Luxembourg",Adresse.normalizePays("letzebuerg"));
	}
	
	@Test
	public void testBelg() {
		assertEquals("Belgique",Adresse.normalizePays("belgium"));
	}
	
	@Test
	public void testSui1() {
		assertEquals("Suisse",Adresse.normalizePays("Switzerland"));
	}
	
	@Test
	public void testSui2() {
		assertEquals("Suisse",Adresse.normalizePays("Schweiz"));
	}
	
	
	@Test
	public void testMajVille() {
		assertEquals("Saint-Julien-Les-Metz",Adresse.normalizeVille("saint julien les metz"));
	}
	
	@Test
	public void testMajBv1() {
		assertEquals("boulevard", Adresse.normalizeVoie("boul"));
	}
	
	@Test
	public void testMajBv2() {
		assertEquals("boulevard", Adresse.normalizeVoie("boul."));
	}
	
	@Test
	public void testMajBv3() {
		assertEquals("boulevard", Adresse.normalizeVoie("bd"));
	}
	
	@Test
	public void testMajAv() {
		assertEquals("avenue", Adresse.normalizeVoie("av."));
	}
	
	@Test
	public void testMajFaub1() {
		assertEquals("faubourg", Adresse.normalizeVoie("faub."));
	}
	
	@Test
	public void testMajFaub2() {
		assertEquals("faubourg", Adresse.normalizeVoie("fg"));
	}
	
	@Test
	public void testMajPlace() {
		assertEquals("place", Adresse.normalizeVoie("pl."));
	}
	
	@Test
	public void testVirg() {
		assertEquals(", place des choux",Adresse.normalizeVirguleVoie("place des choux"));
	}
	
	@Test
	public void testCodpst() {
		assertEquals("2270", Adresse.normalizeCodePst("L-2270"));
	}
	@Test
	public void testCodpst2() {
		assertEquals("08250", Adresse.normalizeCodePst("8250"));
	}
	

}
