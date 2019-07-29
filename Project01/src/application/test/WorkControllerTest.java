/**
 * 
 */
package application.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import application.controller.WorkController;

/**
 * @author Sazzad
 *
 */
public class WorkControllerTest {
	private WorkController wc;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		wc = new WorkController();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		wc = null;
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
		assertTrue(wc.isNull(""));
		assertTrue(wc.isNull(" \t"));
		assertTrue(wc.isNull("\n"));
		assertTrue(wc.isNull("                "));
		assertTrue(wc.isNull("\b"));
		assertTrue(wc.isNull("\f"));
		assertTrue(wc.isNull("\r"));
		
		// BLOCK 2
		assertFalse(wc.isNull("\\"));
		assertFalse(wc.isNull("\""));
		assertFalse(wc.isNull("\'"));
		
		// BLOCK 3
		assertFalse(wc.isNull("Supra"));
		assertFalse(wc.isNull("545"));
		assertFalse(wc.isNull("saz5"));
		assertFalse(wc.isNull("&$^#*&^#&"));
		assertFalse(wc.isNull("M1x3d f$C@"));
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
	 * 
	 * BLOCK FOR INVALID INPUT
	 * 2 - WITH NUMERIC CHARACTER
	 * 3 - WITH SPECIAL CHARACTER
	 *  
	 */

	@Test
	public void isNameValidTest() {
		// fail("Not yet implemented");
		
		// BLOCK 1
		assertTrue(wc.isNameValid("NASA"));
		assertTrue(wc.isNameValid("NORTH SOUTH UNIVERSITY"));
		assertTrue(wc.isNameValid("NSU-CPC"));
		assertTrue(wc.isNameValid("Facebook Inc."));
		assertTrue(wc.isNameValid("Microsoft Cloud"));
		
		// BLOCK 2
		assertFalse(wc.isNameValid("G5"));
		assertFalse(wc.isNameValid("5456484325"));
		assertFalse(wc.isNameValid("N0R7H 50U7H UN1V3RS1TY"));
		
		// BLOCK 3
		assertFalse(wc.isNameValid("#NASA"));
		assertFalse(wc.isNameValid("FB = Facebook"));
		assertFalse(wc.isNameValid("n$u north $outh university"));
	}

}
