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
	 * 3 - ANYTHING LENGTH > 0  [NOT NULL BLOCK]
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
	
	
	/*
	 * INPUT SPACE PARTITIONING FOR isNameValid
	 * 
	 * PARAMETER STRING
	 * DOMAIN - ANY KING OF STRING
	 * 
	 * CHARACTERISTICS 
	 * 1 - VALID
	 * 2 - NOT VALID
	 * 
	 * BLOCK FOR VALID INPUT
	 * 1 - PLAIN NAME
	 * 2 - NAME WITH TITLE
	 * 
	 * BLOCK FOR INVALID INPUT
	 * 3 - WITH NUMERIC CHARACTER
	 * 4 - WITH SPECIAL CHARACTER
	 *  
	 */

	@Test
	public void isNameValidTest() {
		// fail("Not yet implemented");
		
		// BLOCK 1
		assertTrue("valid", ic.isNameValid("Sazzad"));
		assertTrue(ic.isNameValid("Sazzad Hossain"));
		assertTrue(ic.isNameValid("Md Sazzad Hossain"));
		assertTrue(ic.isNameValid("Shaikh Shawon Arefin Shimon"));
		
		// BLOCK 2
		assertTrue(ic.isNameValid("Mr. Sazzad"));
		assertTrue(ic.isNameValid("Engr. Sazzad"));
		assertTrue(ic.isNameValid("Dr. Hossain"));
		assertTrue(ic.isNameValid("Prof. Sazzad"));
		
		// BLOCK 3
		assertFalse(ic.isNameValid("456"));
		assertFalse(ic.isNameValid("M00N"));
		assertFalse(ic.isNameValid("Sh3f4n"));
		
		//BLOCK 4
		assertFalse(ic.isNameValid("@$%&*"));
		assertFalse(ic.isNameValid("S@zZ@d"));
		assertFalse(ic.isNameValid("Mr* Saz"));
		assertFalse(ic.isNameValid("Sazzad + Hossain"));
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
		assertTrue(ic.isPhoneValid("018-132-56"));
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
