package application;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TourTest {
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
		driver.navigate().to("https://www.phptravels.net/m-tours"); 
		js = (JavascriptExecutor)driver;
	}
	
	@BeforeMethod
	public void setup() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void searchTourTest() throws InterruptedException {
		//driver.findElement(By.xpath("//*[@id='body-section']/section/div[2]/div/div/div[2]/ul/li[2]/a")).click();
		WebElement searchbox = driver.findElement(By.xpath("//*[@id='s2id_autogen3']/a"));
		
		System.out.println(searchbox.getText());
		searchbox.click();
		searchbox.sendKeys("sheraton");
		Thread.sleep(1000);
		searchbox.sendKeys(Keys.ENTER);

		WebElement date = driver.findElement(By.xpath("//*[@id='tchkin']/div/input"));
		date.clear();
		date.click();
		date.sendKeys("04/09/2019");
		date.sendKeys(Keys.ENTER);

	}
	
/*	@Test (priority = 1)
	public void reviewTour() throws InterruptedException {
		js = (JavascriptExecutor)driver;
		js.executeScript("scroll(0, 3000);");
		
		driver.findElement(By.xpath("//*[@id='body-section']/div[3]/div[4]/div/div[2]/button")).click();
		
		driver.findElement(By.name("fullname")).sendKeys("Sazzad Hossain");
		driver.findElement(By.name("email")).sendKeys("sazzad@yahoo.com");
		driver.findElement(By.name("reviews_comments")).sendKeys("Amazing Place. nice weather. Would like to visit again");
		
		Thread.sleep(200);
		js.executeScript("scroll(0, 3100);");
		Thread.sleep(200);
		driver.findElement(By.xpath("//*[@id='body-section']/div[3]/div[4]/div/div[2]/button")).click(); 
		
	} */
	
	@Test (priority = 2)
	public void bookTourwithoutFirstNameTest() throws InterruptedException {
		driver.navigate().refresh();
		WebElement bookNow = driver.findElement(By.xpath("//*[@id='body-section']/div[3]/div[2]/div[2]/div/form/div[4]/button"));
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
//		WebElement bookNow = driver.findElement(By.xpath("//*[@id='body-section']/div[3]/div[2]/div[2]/div/form/div[4]/button"));
//		scrollUntilFindElement(bookNow);		
//		bookNow.click();
		
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
	public void bookTourwithoutEmailTest() throws InterruptedException {
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
	
	@Test (priority = 3)
	public void bookTourwithoutConfirmEmail() throws InterruptedException {
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
	
	@Test (priority = 3)
	public void bookTourwithWrongConfirmEmail() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(500);
		
		driver.findElement(By.xpath("//*[@id='guestform']/div[1]/div[2]/input")).sendKeys("Sazzad");
		driver.findElement(By.xpath("//*[@id='guestform']/div[1]/div[3]/input")).sendKeys("Hossain");
		driver.findElement(By.xpath("//*[@id='guestform']/div[2]/div[2]/input")).sendKeys("sazzad.hossian09@northsouth.edu");
		driver.findElement(By.xpath("//*[@id='guestform']/div[2]/div[3]/input")).sendKeys("sazzad@northsouth.edu");
		driver.findElement(By.xpath("//*[@id='guestform']/div[3]/div[2]/input")).sendKeys("01613645555");
		driver.findElement(By.xpath("//*[@id='guestform']/div[4]/div[2]/input")).sendKeys("Dhaka");
		
		WebElement confirmBookingBtn = driver.findElement(By.xpath("//*[@id='body-section']/div[1]/div/div/div/div[1]/div[2]/div[4]/button"));
		scrollUntilFindElement(confirmBookingBtn);
		confirmBookingBtn.click();

		js.executeScript("scroll(0, 00);");
		
		String warning = driver.findElement(By.xpath("//*[@id='body-section']/div[1]/div/div/div/div[1]/div[2]/div[1]/div/p[1]")).getText();
		Assert.assertEquals(warning, "Email not matching with confirm email");
		
	}
	
	@Test (priority = 4)
	public void bookTourSuccessfully() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(500);
		
		driver.findElement(By.xpath("//*[@id='guestform']/div[1]/div[2]/input")).sendKeys("Sazzad");
		driver.findElement(By.xpath("//*[@id='guestform']/div[1]/div[3]/input")).sendKeys("Hossain");
		driver.findElement(By.xpath("//*[@id='guestform']/div[2]/div[2]/input")).sendKeys("sazzad.hossian09@northsouth.edu");
		driver.findElement(By.xpath("//*[@id='guestform']/div[2]/div[3]/input")).sendKeys("sazzad.hossian09@northsouth.edu");
		driver.findElement(By.xpath("//*[@id='guestform']/div[3]/div[2]/input")).sendKeys("01613645555");
		driver.findElement(By.xpath("//*[@id='guestform']/div[4]/div[2]/input")).sendKeys("Dhaka");
		
		WebElement confirmBookingBtn = driver.findElement(By.xpath("//*[@id='body-section']/div[1]/div/div/div/div[1]/div[2]/div[4]/button"));
		scrollUntilFindElement(confirmBookingBtn);
		confirmBookingBtn.click();
		
	}
	
	
}
