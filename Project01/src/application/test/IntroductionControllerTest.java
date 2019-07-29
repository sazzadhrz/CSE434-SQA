package application.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import application.controller.IntroductionController;

/**
 * @author Sazzad
 *
 */
public class IntroductionControllerTest {
	private IntroductionController ic;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		ic = new IntroductionController();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		ic = null;
	}
	
	
	/*
	 * INPUT SPACE PARTITIONING FOR isNull
	 * 
	 * PARAMETER STRING
	 * DOMAIN - ANY KING OF STRING
	 * 
	 * CHARACTERISTICS 
	 * 1 - NULL
	 * 2 - NOT NULL
	 * 
	 * BLOCK
	 * 1 - ESCAPE SEQUENCE (NULL, WHITESPACE, TAB, NEW LINE ETC.)
	 * 2 - ESCAPE SEQUENCE EXCEPT ( \", \', \\)
	 * 3 - ANYTHING LENGTH > 0
	 *  
	 */
	
	@Test
	public void IsNullTest() {
		// BLOCK 1
		assertTrue(ic.isNull(""));
		assertTrue(ic.isNull(" \t"));
		assertTrue(ic.isNull("\n"));
		assertTrue(ic.isNull("                "));
		assertTrue(ic.isNull("\b"));
		assertTrue(ic.isNull("\f"));
		assertTrue(ic.isNull("\r"));
		
		// BLOCK 2
		assertFalse(ic.isNull("\\"));
		assertFalse(ic.isNull("\""));
		assertFalse(ic.isNull("\'"));
		
		// BLOCK 3
		assertFalse(ic.isNull("Supra"));
		assertFalse(ic.isNull("545"));
		assertFalse(ic.isNull("saz5"));
		assertFalse(ic.isNull("&$^#*&^#&"));
		assertFalse(ic.isNull("M1x3d f$C@"));
	}

	@Test
	public void isNameValidTest() {
		// fail("Not yet implemented");

		assertTrue("valid", ic.isNameValid("Sazzad"));
		assertFalse(ic.isNameValid("456"));
	}

	@Test
	public void isEmailValidTest() {
		// fail("Not yet implemented");

		assertTrue("valid", ic.isEmailValid("sazzadhrz@gmail.com"));
		assertFalse(ic.isEmailValid("dfsaf5"));
		assertTrue("valid", ic.isEmailValid("sazzad_5136@hotmail.com"));
		assertFalse(ic.isEmailValid("sazzad.com"));
	}

	@Test
	public void isPhoneValidTest() {
		assertEquals(true, ic.isPhoneValid("01613645555"));
		assertFalse(ic.isPhoneValid("1234"));
		assertTrue(ic.isPhoneValid("+8801613645555"));
		assertTrue(ic.isPhoneValid("9125698"));
		// fail("NI");
	}
	
	
	@Test
	public void h1Test() {
		assertEquals("<h1>" + "Sazzad" + "</h1>" + "\n", ic.h1("Sazzad"));
	}
	
	@Test
	public void h3Test() {
		assertEquals("<h3>" + "school" + "</h3>" + "\n", ic.h3("school"));
	}

}
