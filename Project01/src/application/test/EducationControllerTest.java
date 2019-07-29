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
	
	
	/*
	 * INPUT SPACE PARTITIONING FOR isYearValid
	 * 
	 * PARAMETER STRING
	 * DOMAIN - ANY KING OF STRING
	 * 
	 * CHARACTERISTICS 
	 * 1 - VALID
	 * 2 - NOT VALID
	 * 
	 * BLOCK FOR VALID INPUT
	 * 1 - ONLY YEAR
	 * 2 - YEAR WITH STRING
	 * 3 - ONLY STRING
	 * 
	 * BLOCK FOR INVALID INPUT
	 * 4 - WITH SPECIAL CHARACTER
	 *  
	 */
	
	@Test
	public void isYearValidTest() {
		// BLOCK 1
		assertTrue(ec.isYearValid("2016-2018"));
		assertTrue(ec.isYearValid("2019"));
		assertTrue(ec.isYearValid("2002-2015"));
		
		//BLOCK 2
		assertTrue(ec.isYearValid("February 2018 - March 2019"));
		assertTrue(ec.isYearValid("2011 - Present"));
		assertTrue(ec.isYearValid("14th January 2004 - Present"));
		
		//BLOCK 3
		assertTrue(ec.isYearValid("February - Present"));
		assertTrue(ec.isYearValid("Not Applicable"));
		assertTrue(ec.isYearValid("March - This Month"));
		
		//BLOCK 4
		assertFalse(ec.isYearValid("$$$"));
		assertFalse(ec.isYearValid("J@nuary - Feb"));
		assertFalse(ec.isYearValid("= 2017"));
	}
	
	/*
	 * INPUT SPACE PARTITIONING FOR isCGPAValid
	 * 
	 * PARAMETER STRING
	 * DOMAIN - ANY KING OF STRING
	 * 
	 * CHARACTERISTICS 
	 * 1 - VALID
	 * 2 - NOT VALID
	 * 
	 * BLOCK FOR VALID INPUT
	 * 1 - CGPA >= 0 && CGPA <=4.00 [UNIVERSITY + HSC/SSC]
	 * 2 - CGPA >4.00 && CGPA <= 5.00 [GPA FOR SSC AND HSC]
	 * 
	 * BLOCK FOR INVALID INPUT
	 * 3 - CGPA > 5
	 * 4 - INTEGER
	 * 5 - DON'T FOLLOW THE FORMAT [#.##]
	 *  
	 */

	@Test
	public void isCgpaValidTest() {
		//BLOCK 1
		assertTrue(ec.isCgpaValid("2.36"));
		assertTrue(ec.isCgpaValid("3.81"));
		assertTrue(ec.isCgpaValid("1.23"));
		assertTrue(ec.isCgpaValid("4.00"));
		
		//BLOCK 2
		assertTrue(ec.isCgpaValid("5.00"));
		assertTrue(ec.isCgpaValid("4.81"));
		assertTrue(ec.isCgpaValid("4.44"));
		
		//BLOCK 3
		assertFalse(ec.isCgpaValid("5.01"));
		assertFalse(ec.isCgpaValid("9.91"));
		assertFalse(ec.isCgpaValid("8.45"));
		
		//BLOCK 4
		assertFalse(ec.isCgpaValid("0"));
		assertFalse(ec.isCgpaValid("4"));
		assertFalse(ec.isCgpaValid("5"));
		
		//BLOCK 5
		assertFalse(ec.isCgpaValid("23.26"));
		assertFalse(ec.isCgpaValid("2.258"));
		assertFalse(ec.isCgpaValid("4.0"));
		assertFalse(ec.isCgpaValid("3.6"));
		assertFalse(ec.isCgpaValid("03.03"));
	}
	
	/*
	 * INPUT SPACE PARTITIONING FOR h5, h4 AND h3
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
	public void h5Test() {
		// VALID
		assertEquals("<h5>" + "Sazzad" + "</h5>" + "\n", ec.h5("Sazzad"));
		assertEquals("<h5>" + "" + "</h5>" + "\n", ec.h5(""));
		assertEquals("<h5>" + "KheLa hoBe" + "</h5>" + "\n", ec.h5("KheLa hoBe"));
		
		//NOT VALID
		assertNotEquals("<h5>" + "sazzad" + "</h5>" + "\n", ec.h5("Sazzad"));
		assertNotEquals("<h5>" + "KheLa hoBe" + "</h5>" + "\n", ec.h5("Khela Hobe"));
		assertNotEquals("<h5>" + "" + "</h5>" + "\n", ec.h5("434"));
	}
	
	@Test
	public void h4Test() {
		// VALID
		assertEquals("<h4>" + "Sazzad" + "</h4>" + "\n", ec.h4("Sazzad"));
		assertEquals("<h4>" + "" + "</h4>" + "\n", ec.h4(""));
		assertEquals("<h4>" + "KheLa hoBe" + "</h4>" + "\n", ec.h4("KheLa hoBe"));
		
		//NOT VALID
		assertNotEquals("<h4>" + "sazzad" + "</h4>" + "\n", ec.h4("Sazzad"));
		assertNotEquals("<h4>" + "KheLa hoBe" + "</h4>" + "\n", ec.h4("Khela Hobe"));
		assertNotEquals("<h4>" + "" + "</h4>" + "\n", ec.h4("434"));
	}

	@Test
	public void h3Test() {
		// VALID
		assertEquals("<h3>" + "Sazzad" + "</h3>" + "\n", ec.h3("Sazzad"));
		assertEquals("<h3>" + "" + "</h3>" + "\n", ec.h3(""));
		assertEquals("<h3>" + "KheLa hoBe" + "</h3>" + "\n", ec.h3("KheLa hoBe"));
		
		//NOT VALID
		assertNotEquals("<h3>" + "sazzad" + "</h3>" + "\n", ec.h3("Sazzad"));
		assertNotEquals("<h3>" + "KheLa hoBe" + "</h3>" + "\n", ec.h3("Khela Hobe"));
		assertNotEquals("<h3>" + "" + "</h3>" + "\n", ec.h3("434"));
	}
	
	/*
	 * AS THE FUNCTIONS OF EDUCATION-CONTROLLER ARE SMALL UNIT AND INDIVIDUAL, 
	 * IT IS NOT POSSIBLE TO DO GRAPH COVERAGE
	 */

}
