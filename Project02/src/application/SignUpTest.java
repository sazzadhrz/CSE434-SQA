package application;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpTest {
	
	WebDriver driver;
	JavascriptExecutor js;
	
	@BeforeClass
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver", "F:/chromedriver_win32/chromedriver.exe");
		
		driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.navigate().to("https://www.phptravels.net/register"); 
	}
	
	@BeforeMethod
	public void setup() {
//		System.setProperty("webdriver.chrome.driver", "F:/chromedriver_win32/chromedriver.exe");
//		
//		driver = new ChromeDriver();
//		
//		driver.manage().window().maximize();
//		driver.navigate().to("https://www.phptravels.net/register"); 
//		 scroll down to access submit btn
		js = (JavascriptExecutor)driver;
		js.executeScript("scroll(0, 200);");
		clearFields();
		driver.navigate().refresh();
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public void scrollUpandGetWarningTextandAssert(String expectedWarning) {
		js.executeScript("scroll(0, -200);");				
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		String warning = driver.findElement(By.cssSelector("div.alert.alert-danger p")).getText();
		System.out.println(warning);
		Assert.assertEquals(warning, expectedWarning);
	}
	
	public void clearFields() {
		driver.findElement(By.name("firstname")).clear();
		driver.findElement(By.name("lastname")).clear();
		driver.findElement(By.name("phone")).clear();
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("confirmpassword")).clear();
	}
	
	@Test 
	public void noInputTest() {
		driver.findElement(By.className("signupbtn")).click();	
		
		scrollUpandGetWarningTextandAssert("The Email field is required.");

	}
	
	@Test 
	public void noFirstNameTest() {
		driver.findElement(By.name("lastname")).sendKeys("Hossain");
		driver.findElement(By.name("phone")).sendKeys("01613645555");
		driver.findElement(By.name("email")).sendKeys("sazzad.hossian09@northsouth.edu");
		driver.findElement(By.name("password")).sendKeys("haha123");
		driver.findElement(By.name("confirmpassword")).sendKeys("haha123");
		
		driver.findElement(By.className("signupbtn")).click();
		
		scrollUpandGetWarningTextandAssert("The First name field is required.");

	}
	
	@Test 
	public void noLastNameTest() {
		driver.findElement(By.name("firstname")).sendKeys("Sazzad");
		driver.findElement(By.name("phone")).sendKeys("01613645555");
		driver.findElement(By.name("email")).sendKeys("sazzad.hossian09@northsouth.edu");
		driver.findElement(By.name("password")).sendKeys("haha123");
		driver.findElement(By.name("confirmpassword")).sendKeys("haha123");
		
		driver.findElement(By.className("signupbtn")).click();
		
		scrollUpandGetWarningTextandAssert("The Last Name field is required.");

	}
	
	// forcefully failing it because it logs in without phone number
	@Test 
	public void noPhoneTest() {
		driver.findElement(By.name("firstname")).sendKeys("Sazzad");
		driver.findElement(By.name("lastname")).sendKeys("Hossain");
		driver.findElement(By.name("email")).sendKeys("sazzad.hossian09@northsouth.edu");
		driver.findElement(By.name("password")).sendKeys("haha123");
		//driver.findElement(By.name("confirmpassword")).sendKeys("haha123");
		
		
		driver.findElement(By.className("signupbtn")).click();
		
		scrollUpandGetWarningTextandAssert("The Phone field is required.");

	}
	
	@Test 
	public void noEmailTest() {
		driver.findElement(By.name("firstname")).sendKeys("Sazzad");
		driver.findElement(By.name("lastname")).sendKeys("Hossain");
		driver.findElement(By.name("phone")).sendKeys("01613645555");
		driver.findElement(By.name("password")).sendKeys("haha123");
		driver.findElement(By.name("confirmpassword")).sendKeys("haha123");
		
		driver.findElement(By.className("signupbtn")).click();
		
		scrollUpandGetWarningTextandAssert("The Email field is required.");

	}
	
	@Test 
	public void invalidEmailTest() {
		driver.findElement(By.name("firstname")).sendKeys("Sazzad");
		driver.findElement(By.name("lastname")).sendKeys("Hossain");
		driver.findElement(By.name("phone")).sendKeys("01613645555");
		driver.findElement(By.name("email")).sendKeys("agdum-bagdum");
		driver.findElement(By.name("password")).sendKeys("haha123");
		driver.findElement(By.name("confirmpassword")).sendKeys("haha123");
		
		driver.findElement(By.className("signupbtn")).click();
		
		scrollUpandGetWarningTextandAssert("The Email field must contain a valid email address.");

	}
	
	@Test 
	public void noPasswordTest() {
		driver.findElement(By.name("firstname")).sendKeys("Sazzad");
		driver.findElement(By.name("lastname")).sendKeys("Hossain");
		driver.findElement(By.name("phone")).sendKeys("01613645555");
		driver.findElement(By.name("email")).sendKeys("sazzad.hossian09@northsouth.edu");
		driver.findElement(By.name("confirmpassword")).sendKeys("haha123");
		
		driver.findElement(By.className("signupbtn")).click();
		
		scrollUpandGetWarningTextandAssert("The Password field is required.");	

	} 
	
	@Test 
	public void noConfirmPasswordTest() {
		driver.findElement(By.name("firstname")).sendKeys("Sazzad");
		driver.findElement(By.name("lastname")).sendKeys("Hossain");
		driver.findElement(By.name("phone")).sendKeys("01613645555");
		driver.findElement(By.name("email")).sendKeys("sazzad.hossian09@northsouth.edu");
		driver.findElement(By.name("password")).sendKeys("haha123");
		
		driver.findElement(By.className("signupbtn")).click();
		
		scrollUpandGetWarningTextandAssert("The Password field is required.");		

	} 
	
	@Test 
	public void shortPasswordTest() {
		driver.findElement(By.name("firstname")).sendKeys("Sazzad");
		driver.findElement(By.name("lastname")).sendKeys("Hossain");
		driver.findElement(By.name("phone")).sendKeys("01613645555");
		driver.findElement(By.name("email")).sendKeys("sazzad.hossian09@northsouth.edu");
		driver.findElement(By.name("password")).sendKeys("a");
		driver.findElement(By.name("confirmpassword")).sendKeys("a");
		
		driver.findElement(By.className("signupbtn")).click();
		
		scrollUpandGetWarningTextandAssert("The Password field must be at least 6 characters in length.");	

	} 
	
	@Test 
	public void passwordMismathwithConfirmPasswordTest() {
		driver.findElement(By.name("firstname")).sendKeys("Sazzad");
		driver.findElement(By.name("lastname")).sendKeys("Hossain");
		driver.findElement(By.name("phone")).sendKeys("01613645555");
		driver.findElement(By.name("email")).sendKeys("sazzad.hossian09@northsouth.edu");
		driver.findElement(By.name("password")).sendKeys("haha123");
		driver.findElement(By.name("confirmpassword")).sendKeys("goru");
		
		driver.findElement(By.className("signupbtn")).click();
		
		scrollUpandGetWarningTextandAssert("Password not matching with confirm password.");

	}
	
	
	
	@AfterMethod
	public void tearDown() {
		//driver.close();
	}

}
