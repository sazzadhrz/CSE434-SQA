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

	@Test
	public void isEmailValidTest() {
//		fail("Not yet implemented");
		
		assertTrue("valid", ic.isEmailValid("sazzadhrz@gmail.com"));
		assertFalse(ic.isEmailValid("dfsaf5"));
	}
	

	@Test
	public void isPhoneValidTest() {
		assertEquals(true, ic.isPhoneValid("01613645555"));
		assertFalse(ic.isPhoneValid("1234"));
//		fail("NI");
	}
	
	
	
	
	
	
	
	
	
	

}
