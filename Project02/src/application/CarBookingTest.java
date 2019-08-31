package application;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CarBookingTest {
	WebDriver driver;
	JavascriptExecutor js;
	
	public void scrollUntilFindElement(WebElement WebElement_Path) {
		js.executeScript("arguments[0].scrollIntoView(true);", WebElement_Path);
	}

}
