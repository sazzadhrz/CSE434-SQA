package application;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignInTest {
	WebDriver driver;
	JavascriptExecutor js;
	
	@BeforeClass
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver", "F:/chromedriver_win32/chromedriver.exe");
		
		driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.navigate().to("https://www.phptravels.net/login"); 
	}
	
	@BeforeMethod
	public void setup() {

//		 scroll down to access submit btn
		//js = (JavascriptExecutor)driver;
		//js.executeScript("scroll(0, 200);");

	}
	
	public void getWarningTextandAssert(String expectedWarning) {			
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		String warning = driver.findElement(By.cssSelector("div.alert.alert-danger")).getText();
		System.out.println(warning);
		Assert.assertEquals(warning, expectedWarning);
	}
	
	@Test
	public void invalidEmailTest() {
		driver.findElement(By.name("username")).sendKeys("sazzad bhai");
		driver.findElement(By.name("password")).sendKeys("dhikachika123");
		driver.findElement(By.className("loginbtn")).click();
		
		getWarningTextandAssert("Invalid Email or Password");
	}
	
	@Test
	public void invalidPasswordTest() {
		driver.findElement(By.name("username")).sendKeys("sazzad.hossian09@northsouth.edu");
		driver.findElement(By.name("password")).sendKeys("dhikachika123");
		driver.findElement(By.className("loginbtn")).click();
		
		getWarningTextandAssert("Invalid Email or Password");
	}
	
	@Test
	public void validTest() {
		driver.findElement(By.name("username")).sendKeys("sazzad.hossian09@northsouth.edu");
		driver.findElement(By.name("password")).sendKeys("haha123");
		driver.findElement(By.className("loginbtn")).click();
		
		//getWarningTextandAssert("Invalid Email or Password");
	}
	
	
}
