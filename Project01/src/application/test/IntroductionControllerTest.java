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
	
	
	/*
	 * INPUT SPACE PARTITIONING FOR isEmailValid
	 * 
	 * PARAMETER STRING
	 * DOMAIN - ANY KING OF STRING
	 * 
	 * CHARACTERISTICS 
	 * 1 - VALID
	 * 2 - NOT VALID
	 * 
	 * BLOCK FOR VALID INPUT
	 * 1 - EMAIL CONTAINS ONLY ALPHABET WITH @ AND .
	 * 2 - EMAIL CONTAINS NUMERIC VALUE/ _ - WITH @ AND .
	 * 
	 * BLOCK FOR INVALID INPUT
	 * 3 - EMAIL WITHOUT @
	 * 4 - EMAIL WITHOUT .
	 * 5 - EMAIL WITHOUT @ AND .
	 * 6 - EMAIL CONTAINING SPECIAL CHARACTERS
	 *  
	 */

	@Test
	public void isEmailValidTest() {
		// fail("Not yet implemented");
		
		// BLOCK 1
		assertTrue("valid", ic.isEmailValid("sazzadhrz@gmail.com"));
		assertTrue(ic.isEmailValid("saz@pbsca.ca"));
		assertTrue(ic.isEmailValid("alibaba_arabian@lufthansa.com"));
		assertTrue(ic.isEmailValid("shaikh.shimon@northsouth.edu"));
		assertTrue(ic.isEmailValid("nabeel.mohammed@northsouth.edu"));
		
		
		//BLOCK 2
		assertTrue("valid", ic.isEmailValid("sazzad_5136@hotmail.com"));
		assertTrue(ic.isEmailValid("sazzad9798@yahoo.com"));
		assertTrue(ic.isEmailValid("saz-526@gmail.com"));
		
		// BLOCK 3
		assertFalse(ic.isEmailValid("sazzad.com"));
		assertFalse(ic.isEmailValid("gameon-google.com"));
		assertFalse(ic.isEmailValid("hello5_at_nsu.edu"));
		
		// BLOCK 4
		assertFalse(ic.isEmailValid("sazzad@gmailcom"));
		assertFalse(ic.isEmailValid("saz5@yahoo,com"));
		assertFalse(ic.isEmailValid("noa@nasa"));
		
		//BLOCK 5
		assertFalse(ic.isEmailValid("sazzadhrz"));
		assertFalse(ic.isEmailValid("saz5"));
		assertFalse(ic.isEmailValid("morshed47&gmail,com"));
		
		//BLOCK 6
		assertFalse(ic.isEmailValid("s@zzad@gmail.com"));
		assertFalse(ic.isEmailValid("$azzad@nus.com"));
		assertFalse(ic.isEmailValid("@#$%@sdkjf.com"));
		assertFalse(ic.isEmailValid("w3~r|d@gmail.com"));

	}
	
	
	/*
	 * INPUT SPACE PARTITIONING FOR isPhoneValid
	 * 
	 * PARAMETER STRING
	 * DOMAIN - ANY KING OF STRING
	 * 
	 * CHARACTERISTICS 
	 * 1 - VALID
	 * 2 - NOT VALID
	 * 
	 * BLOCK FOR VALID INPUT
	 * 1 - PLAIN NUMBER
	 * 2 - NUMBER CONTAINS SOME CHARACTERS (EG. +, -, #, \,  )
	 * 
	 * BLOCK FOR INVALID INPUT
	 * 3 - LENGTH <= 6
	 * 4 - CONTAINING SPECIAL CHARACTERS
	 * 5 - NUMBER CONTAINING ALPHABET
	 *  
	 */

	@Test
	public void isPhoneValidTest() {
		// BLOCK 1
		assertEquals(true, ic.isPhoneValid("01613645555"));
		assertTrue(ic.isPhoneValid("9125698"));
		
		// BLOCK 2
		assertTrue(ic.isPhoneValid("+8801613645555"));
		assertTrue(ic.isPhoneValid("018-132-56"));
		assertTrue(ic.isPhoneValid("0161 3645555"));
		
		// BLOCK 3
		assertFalse(ic.isPhoneValid("1234"));
		assertFalse(ic.isPhoneValid("+880"));
		assertFalse(ic.isPhoneValid("123-58"));
		
		// BLOCK 4
		assertFalse(ic.isPhoneValid("S$55465456"));
		assertFalse(ic.isPhoneValid("@01254354"));
		assertFalse(ic.isPhoneValid("12&*=34"));
		
		
		// BLOCK 5
		assertFalse(ic.isPhoneValid("AKJSHFKJ"));
		assertFalse(ic.isPhoneValid("123KA"));
		
		// fail("NI");
	}
	
	
	/*
	 * INPUT SPACE PARTITIONING FOR h1 AND h3
	 * 
	 * PARAMETER STRING
	 * DOMAIN - ANY KING OF STRING
	 * 
	 * CHARACTERISTICS 
	 * 1 - VALID
	 * 2 - NOT VALID
	 * 
	 */
	
	@Test
	public void h1Test() {
		// VALID
		assertEquals("<h1>" + "Sazzad" + "</h1>" + "\n", ic.h1("Sazzad"));
		assertEquals("<h1>" + "" + "</h1>" + "\n", ic.h1(""));
		assertEquals("<h1>" + "KheLa hoBe" + "</h1>" + "\n", ic.h1("KheLa hoBe"));
		
		//NOT VALID
		assertNotEquals("<h1>" + "sazzad" + "</h1>" + "\n", ic.h1("Sazzad"));
		assertNotEquals("<h1>" + "KheLa hoBe" + "</h1>" + "\n", ic.h1("Khela Hobe"));
		assertNotEquals("<h1>" + "" + "</h1>" + "\n", ic.h1("434"));
	}
	

	@Test
	public void h3Test() {
		// VALID
		assertEquals("<h3>" + "Sazzad" + "</h3>" + "\n", ic.h3("Sazzad"));
		assertEquals("<h3>" + "" + "</h3>" + "\n", ic.h3(""));
		assertEquals("<h3>" + "KheLa hoBe" + "</h3>" + "\n", ic.h3("KheLa hoBe"));
		
		//NOT VALID
		assertNotEquals("<h3>" + "sazzad" + "</h3>" + "\n", ic.h3("Sazzad"));
		assertNotEquals("<h3>" + "KheLa hoBe" + "</h3>" + "\n", ic.h3("Khela Hobe"));
		assertNotEquals("<h3>" + "" + "</h3>" + "\n", ic.h3("434"));
	}
	
	

}
