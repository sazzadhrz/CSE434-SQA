/**
 * 
 */
package application.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import application.controller.OthersController;

/**
 * @author Sazzad
 *
 */
public class OthersControllerTest {
	private OthersController oc;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		oc = new OthersController();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		oc = null;
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
		assertTrue(oc.isNull(""));
		assertTrue(oc.isNull(" \t"));
		assertTrue(oc.isNull("\n"));
		assertTrue(oc.isNull("                "));
		assertTrue(oc.isNull("\b"));
		assertTrue(oc.isNull("\f"));
		assertTrue(oc.isNull("\r"));
		
		// BLOCK 2
		assertFalse(oc.isNull("\\"));
		assertFalse(oc.isNull("\""));
		assertFalse(oc.isNull("\'"));
		
		// BLOCK 3
		assertFalse(oc.isNull("Supra"));
		assertFalse(oc.isNull("545"));
		assertFalse(oc.isNull("saz5"));
		assertFalse(oc.isNull("&$^#*&^#&"));
		assertFalse(oc.isNull("M1x3d f$C@"));
	}

}
