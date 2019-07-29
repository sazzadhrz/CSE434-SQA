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

	@Test
	public void test() {
		//fail("Not yet implemented");
	}

}
