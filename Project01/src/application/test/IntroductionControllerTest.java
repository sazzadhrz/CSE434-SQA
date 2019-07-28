package application.test;

import static org.junit.Assert.*;

import org.hamcrest.core.IsNull;
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
	public void IsNullTest() {
		assertTrue(ic.isNull(""));
		assertFalse(ic.isNull("Supra"));
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
