package application;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
		// scroll down to access submit btn
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 200);");
		
	}
	
	@Test 
	public void noInputTest() {
		driver.findElement(By.className("signupbtn")).click();
		
		driver.findElement(By.className("resultsignup")).getText();

	}
	
	@Test 
	public void noFirstNameTest() {
		driver.findElement(By.name("lastname")).sendKeys("Hossain");
		driver.findElement(By.name("phone")).sendKeys("01613645555");
		driver.findElement(By.name("email")).sendKeys("sazzad.hossian09@northsouth.edu");
		driver.findElement(By.name("password")).sendKeys("haha123");
		driver.findElement(By.name("confirmpassword")).sendKeys("haha123");
		
		driver.findElement(By.className("signupbtn")).click();
		
		driver.findElement(By.className("resultsignup")).getText();

	}
	
	@Test 
	public void noLastNameTest() {
		driver.findElement(By.name("firstname")).sendKeys("Sazzad");
		driver.findElement(By.name("phone")).sendKeys("01613645555");
		driver.findElement(By.name("email")).sendKeys("sazzad.hossian09@northsouth.edu");
		driver.findElement(By.name("password")).sendKeys("haha123");
		driver.findElement(By.name("confirmpassword")).sendKeys("haha123");
		
		driver.findElement(By.className("signupbtn")).click();
		
		driver.findElement(By.className("resultsignup")).getText();

	}
	
	@Test 
	public void noPhoneTest() {
		driver.findElement(By.name("firstname")).sendKeys("Sazzad");
		driver.findElement(By.name("lastname")).sendKeys("Hossain");
		driver.findElement(By.name("email")).sendKeys("sazzad.hossian09@northsouth.edu");
		driver.findElement(By.name("password")).sendKeys("haha123");
		driver.findElement(By.name("confirmpassword")).sendKeys("haha123");
		
		driver.findElement(By.className("signupbtn")).click();
		
		driver.findElement(By.className("resultsignup")).getText();

	}
	
	@Test 
	public void noEmailTest() {
		driver.findElement(By.name("firstname")).sendKeys("Sazzad");
		driver.findElement(By.name("lastname")).sendKeys("Hossain");
		driver.findElement(By.name("phone")).sendKeys("01613645555");
		driver.findElement(By.name("password")).sendKeys("haha123");
		driver.findElement(By.name("confirmpassword")).sendKeys("haha123");
		
		driver.findElement(By.className("signupbtn")).click();
		
		driver.findElement(By.className("resultsignup")).getText();

	}
	
	@Test 
	public void noPasswordTest() {
		driver.findElement(By.name("firstname")).sendKeys("Sazzad");
		driver.findElement(By.name("lastname")).sendKeys("Hossain");
		driver.findElement(By.name("phone")).sendKeys("01613645555");
		driver.findElement(By.name("email")).sendKeys("sazzad.hossian09@northsouth.edu");
		driver.findElement(By.name("confirmpassword")).sendKeys("haha123");
		
		driver.findElement(By.className("signupbtn")).click();
		
		driver.findElement(By.className("resultsignup")).getText();

	}
	
	@Test 
	public void noConfirmPasswordTest() {
		driver.findElement(By.name("firstname")).sendKeys("Sazzad");
		driver.findElement(By.name("lastname")).sendKeys("Hossain");
		driver.findElement(By.name("phone")).sendKeys("01613645555");
		driver.findElement(By.name("email")).sendKeys("sazzad.hossian09@northsouth.edu");
		driver.findElement(By.name("password")).sendKeys("haha123");
		
		driver.findElement(By.className("signupbtn")).click();
		
		driver.findElement(By.className("resultsignup")).getText();

	}
	
	
	
	@AfterMethod
	public void tearDown() {
		//driver.close();
	}

}
