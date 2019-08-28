package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"F:/chromedriver_win32/chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.navigate().to("https://www.phptravels.net/register"); 
		
	}
	
	@Test 
	public void noInputTest() {
		driver.findElement(By.className("signupbtn")).click();
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		
	}

}
