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
	
	
	/*
	 * INPUT SPACE PARTITIONING FOR isPositionValid
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
	public void isPositionValidTest() {
		// fail("Not yet implemented");
		
		// BLOCK 1
		assertTrue(wc.isPositionValid("Intern"));
		assertTrue(wc.isPositionValid("Athlete"));
		assertTrue(wc.isPositionValid("Student"));
		assertTrue(wc.isPositionValid("CEO"));		
		assertTrue(wc.isPositionValid("Proffesor"));	
		assertTrue(wc.isPositionValid("Fisherman"));
		
		// BLOCK 2
		assertFalse(wc.isPositionValid("Intern5"));
		assertFalse(wc.isPositionValid("5456484325"));
		assertFalse(wc.isPositionValid("T3ach3r"));
		
		// BLOCK 3
		assertFalse(wc.isPositionValid("#Dr."));
		assertFalse(wc.isPositionValid("Prof."));
		assertFalse(wc.isPositionValid("Eng."));
	}
	
	
	/*
	 * INPUT SPACE PARTITIONING FOR p, h4 AND h3
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
	public void pTest() {
		// VALID
		assertEquals("<p>" + "Sazzad" + "</p>" + "\n", wc.p("Sazzad"));
		assertEquals("<p>" + "" + "</p>" + "\n", wc.p(""));
		assertEquals("<p>" + "KheLa hoBe" + "</p>" + "\n", wc.p("KheLa hoBe"));
		
		//NOT VALID
		assertNotEquals("<p>" + "sazzad" + "</p>" + "\n", wc.p("Sazzad"));
		assertNotEquals("<p>" + "KheLa hoBe" + "</p>" + "\n", wc.p("Khela Hobe"));
		assertNotEquals("<p>" + "" + "</p>" + "\n", wc.p("434"));
	}
	
	@Test
	public void h4Test() {
		// VALID
		assertEquals("<h4>" + "Sazzad" + "</h4>" + "\n", wc.h4("Sazzad"));
		assertEquals("<h4>" + "" + "</h4>" + "\n", wc.h4(""));
		assertEquals("<h4>" + "KheLa hoBe" + "</h4>" + "\n", wc.h4("KheLa hoBe"));
		
		//NOT VALID
		assertNotEquals("<h4>" + "sazzad" + "</h4>" + "\n", wc.h4("Sazzad"));
		assertNotEquals("<h4>" + "KheLa hoBe" + "</h4>" + "\n", wc.h4("Khela Hobe"));
		assertNotEquals("<h4>" + "" + "</h4>" + "\n", wc.h4("434"));
	}

	@Test
	public void h3Test() {
		// VALID
		assertEquals("<h3>" + "Sazzad" + "</h3>" + "\n", wc.h3("Sazzad"));
		assertEquals("<h3>" + "" + "</h3>" + "\n", wc.h3(""));
		assertEquals("<h3>" + "KheLa hoBe" + "</h3>" + "\n", wc.h3("KheLa hoBe"));
		
		//NOT VALID
		assertNotEquals("<h3>" + "sazzad" + "</h3>" + "\n", wc.h3("Sazzad"));
		assertNotEquals("<h3>" + "KheLa hoBe" + "</h3>" + "\n", wc.h3("Khela Hobe"));
		assertNotEquals("<h3>" + "" + "</h3>" + "\n", wc.h3("434"));
	}
	
	/*
	 * AS THE FUNCTIONS OF WORK-CONTROLLER ARE SMALL UNIT AND INDIVIDUAL, 
	 * IT IS NOT POSSIBLE TO DO GRAPH COVERAGE
	 */

}
