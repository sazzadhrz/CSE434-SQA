package application.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ EducationControllerTest.class, IntroductionControllerTest.class, OthersControllerTest.class,
		WorkControllerTest.class })
public class AllTests {

}

