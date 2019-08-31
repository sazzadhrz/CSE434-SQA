package application;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CarBookingTest {
	WebDriver driver;
	JavascriptExecutor js;
	
	public void scrollUntilFindElement(WebElement WebElement_Path) {
		js.executeScript("arguments[0].scrollIntoView(true);", WebElement_Path);
	}
	
	@BeforeClass
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver", "F:/chromedriver_win32/chromedriver.exe");
		
		driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.navigate().to("https://www.phptravels.net/m-cars"); 
		js = (JavascriptExecutor)driver;
	}
	
	@BeforeMethod
	public void setup() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void searchCarTest() throws InterruptedException {
		WebElement pickUp = driver.findElement(By.xpath("//*[@id='s2id_carlocations']/a"));
		
		System.out.println(pickUp.getText());
		pickUp.click();
		Thread.sleep(1500);
		pickUp.sendKeys("sharjah");
		Thread.sleep(1000);
		pickUp.sendKeys(Keys.ENTER);

		WebElement pickupDate = driver.findElement(By.xpath("//*[@id='departcar']"));
		pickupDate.clear();
		pickupDate.click();
		pickupDate.sendKeys("04/09/2019");
//		pickupDate.sendKeys(Keys.ENTER);
		
		WebElement dropoffDate = driver.findElement(By.xpath("//*[@id='returncar']"));
		dropoffDate.clear();
		dropoffDate.click();
		dropoffDate.sendKeys("07/09/2019");
		dropoffDate.sendKeys(Keys.ENTER);  

	}
	
	@Test (priority = 1)
	public void selectCar() throws InterruptedException {
		Thread.sleep(1000);
		WebElement car = driver.findElement(By.xpath("//*[@id='body-section']/div[6]/div/div[3]/div/table/tbody/tr/td/div[2]/div/h4/a"));
		System.out.println(car.getText());
		car.click();
	}
	
	@Test (priority = 2)
	public void bookCarwithoutFirstNameTest() throws InterruptedException {
		driver.navigate().refresh();
		WebElement bookNow = driver.findElement(By.xpath("//*[@id='body-section']/div[4]/div/div[2]/form/button"));
		scrollUntilFindElement(bookNow);		
		bookNow.click();
		
		Thread.sleep(1500);
		
		//driver.findElement(By.xpath("//*[@id='guestform']/div[1]/div[2]/input")).sendKeys("Sazzad");
		driver.findElement(By.xpath("//*[@id='guestform']/div[1]/div[3]/input")).sendKeys("Hossain");
		driver.findElement(By.xpath("//*[@id='guestform']/div[2]/div[2]/input")).sendKeys("sazzad.hossian09@northsouth.edu");
		driver.findElement(By.xpath("//*[@id='guestform']/div[2]/div[3]/input")).sendKeys("sazzad.hossian09@northsouth.edu");
		driver.findElement(By.xpath("//*[@id='guestform']/div[3]/div[2]/input")).sendKeys("01613645555");
		driver.findElement(By.xpath("//*[@id='guestform']/div[4]/div[2]/input")).sendKeys("Dhaka");
		
		WebElement confirmBookingBtn = driver.findElement(By.xpath("//*[@id='body-section']/div[1]/div/div/div/div[1]/div[2]/div[4]/button"));
		scrollUntilFindElement(confirmBookingBtn);
		confirmBookingBtn.click();

		js.executeScript("scroll(0, 00);");
		
		String warning = driver.findElement(By.xpath("//*[@id='body-section']/div[1]/div/div/div/div[1]/div[2]/div[1]/div/p[1]")).getText();
		Assert.assertEquals(warning, "First Name is required");
		
	}
	
	@Test (priority = 3)
	public void bookTourwithoutLasttNameTest() throws InterruptedException {
		driver.navigate().refresh();		
		Thread.sleep(1500);
		
		driver.findElement(By.xpath("//*[@id='guestform']/div[1]/div[2]/input")).sendKeys("Sazzad");
//		driver.findElement(By.xpath("//*[@id='guestform']/div[1]/div[3]/input")).sendKeys("Hossain");
		driver.findElement(By.xpath("//*[@id='guestform']/div[2]/div[2]/input")).sendKeys("sazzad.hossian09@northsouth.edu");
		driver.findElement(By.xpath("//*[@id='guestform']/div[2]/div[3]/input")).sendKeys("sazzad.hossian09@northsouth.edu");
		driver.findElement(By.xpath("//*[@id='guestform']/div[3]/div[2]/input")).sendKeys("01613645555");
		driver.findElement(By.xpath("//*[@id='guestform']/div[4]/div[2]/input")).sendKeys("Dhaka");
		
		WebElement confirmBookingBtn = driver.findElement(By.xpath("//*[@id='body-section']/div[1]/div/div/div/div[1]/div[2]/div[4]/button"));
		scrollUntilFindElement(confirmBookingBtn);
		confirmBookingBtn.click();

		js.executeScript("scroll(0, 00);");
		
		String warning = driver.findElement(By.xpath("//*[@id='body-section']/div[1]/div/div/div/div[1]/div[2]/div[1]/div/p[1]")).getText();
		Assert.assertEquals(warning, "Last Name is required");
		
	}
	
	@Test (priority = 3)
	public void bookCarrwithoutEmailTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(500);
		
		driver.findElement(By.xpath("//*[@id='guestform']/div[1]/div[2]/input")).sendKeys("Sazzad");
		driver.findElement(By.xpath("//*[@id='guestform']/div[1]/div[3]/input")).sendKeys("Hossain");
//		driver.findElement(By.xpath("//*[@id='guestform']/div[2]/div[2]/input")).sendKeys("sazzad.hossian09@northsouth.edu");
		driver.findElement(By.xpath("//*[@id='guestform']/div[2]/div[3]/input")).sendKeys("sazzad.hossian09@northsouth.edu");
		driver.findElement(By.xpath("//*[@id='guestform']/div[3]/div[2]/input")).sendKeys("01613645555");
		driver.findElement(By.xpath("//*[@id='guestform']/div[4]/div[2]/input")).sendKeys("Dhaka");
		
		WebElement confirmBookingBtn = driver.findElement(By.xpath("//*[@id='body-section']/div[1]/div/div/div/div[1]/div[2]/div[4]/button"));
		scrollUntilFindElement(confirmBookingBtn);
		confirmBookingBtn.click();

		js.executeScript("scroll(0, 00);");
		
		String warning = driver.findElement(By.xpath("//*[@id='body-section']/div[1]/div/div/div/div[1]/div[2]/div[1]/div/p[1]")).getText();
		Assert.assertEquals(warning, "Email is required");
		
	}
	
	@AfterClass
	public void TearDown() throws InterruptedException {
		Thread.sleep(10000);
		driver.close();
	}

}
