/**
 * 
 */
package application.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import application.controller.EducationController;

/**
 * @author Sazzad
 *
 */
public class EducationControllerTest {
	private EducationController ec;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		ec = new EducationController();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		ec = null;
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
		assertTrue(ec.isNull(""));
		assertTrue(ec.isNull(" \t"));
		assertTrue(ec.isNull("\n"));
		assertTrue(ec.isNull("                "));
		assertTrue(ec.isNull("\b"));
		assertTrue(ec.isNull("\f"));
		assertTrue(ec.isNull("\r"));
		
		// BLOCK 2
		assertFalse(ec.isNull("\\"));
		assertFalse(ec.isNull("\""));
		assertFalse(ec.isNull("\'"));
		
		// BLOCK 3
		assertFalse(ec.isNull("Supra"));
		assertFalse(ec.isNull("545"));
		assertFalse(ec.isNull("saz5"));
		assertFalse(ec.isNull("&$^#*&^#&"));
		assertFalse(ec.isNull("M1x3d f$C@"));
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
		assertTrue(ec.isNameValid("NSU"));
		assertTrue(ec.isNameValid("NORTH SOUTH UNIVERSITY"));
		assertTrue(ec.isNameValid("North South University"));
		
		// BLOCK 2
		assertFalse(ec.isNameValid("G5"));
		assertFalse(ec.isNameValid("5456484325"));
		assertFalse(ec.isNameValid("N0R7H 50U7H UN1V3RS1TY"));
		
		// BLOCK 3
		assertFalse(ec.isNameValid("#NSU"));
		assertFalse(ec.isNameValid("nsu = north south university"));
		assertFalse(ec.isNameValid("n$u north $outh university"));
	}
	
	/*
	 * INPUT SPACE PARTITIONING FOR isDegreeValid
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
	public void isDegreeValidTest() {
		// fail("Not yet implemented");
		
		// BLOCK 1
		assertTrue(ec.isNameValid("Intern"));
		assertTrue(ec.isNameValid("CEO"));
		assertTrue(ec.isNameValid("Student"));
		assertTrue(ec.isNameValid("Fisherman"));
		assertTrue(ec.isNameValid("Proffesor"));
		assertTrue(ec.isNameValid("Athlete"));
		
		// BLOCK 2
		assertFalse(ec.isNameValid("Intern5"));
		assertFalse(ec.isNameValid("5456484325"));
		assertFalse(ec.isNameValid("T3ach3r"));
		
		// BLOCK 3
		assertFalse(ec.isNameValid("#Dr."));
		assertFalse(ec.isNameValid("Prof."));
		assertFalse(ec.isNameValid("Eng."));
	}
	
	

}
