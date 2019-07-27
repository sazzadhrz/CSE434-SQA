/**
 * 
 */
package application.test;

import static org.junit.Assert.*;

import org.junit.Test;

import application.controller.IntroductionController;

/**
 * @author Sazzad
 *
 */
public class IntroductionControllerTest {

	IntroductionController ic = new IntroductionController();
	@Test
	public void test() {
//		fail("Not yet implemented");
		
		
		assertTrue("valid", ic.isEmailValid("sazzadhrz@gmail.com"));
		assertFalse(ic.isEmailValid("dfsaf5"));
	}

}
