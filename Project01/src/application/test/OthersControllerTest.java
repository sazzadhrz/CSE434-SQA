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

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
