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
	public void test() {
		fail("Not yet implemented");
	}

}
