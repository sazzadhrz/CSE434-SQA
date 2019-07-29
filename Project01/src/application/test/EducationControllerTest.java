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
	
	
	@Test
	public void IsNullTest() {
		assertTrue(ec.isNull(""));
		assertFalse(ec.isNull("Supra"));
	}

	@Test
	public void isNameValidTest() {
		// fail("Not yet implemented");

		assertTrue(ec.isNameValid("NSU"));
		assertTrue(ec.isNameValid("NORTH SOUTH UNIVERSITY"));
		assertTrue(ec.isNameValid("North South University"));
		
		assertFalse(ec.isNameValid("G5"));
		assertFalse(ec.isNameValid("#NSU"));
		assertFalse(ec.isNameValid("nsu = north south university"));
		assertFalse(ec.isNameValid("G5"));
	}
	
	

}
