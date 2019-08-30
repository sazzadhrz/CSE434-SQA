package application;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TourTest {
	WebDriver driver;
	JavascriptExecutor js;
	
	@BeforeClass
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver", "F:/chromedriver_win32/chromedriver.exe");
		
		driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.navigate().to("https://www.phptravels.net/m-tours"); 
	}
	
	@BeforeMethod
	public void setup() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void searchTour() throws InterruptedException {
		//driver.findElement(By.xpath("//*[@id='body-section']/section/div[2]/div/div/div[2]/ul/li[2]/a")).click();
		WebElement searchbox = driver.findElement(By.xpath("//*[@id='s2id_autogen3']/a"));
		
		System.out.println(searchbox.getText());
		searchbox.click();
		searchbox.sendKeys("sheraton");
		Thread.sleep(1000);
		searchbox.sendKeys(Keys.ENTER);

		WebElement date = driver.findElement(By.xpath("//*[@id='tchkin']/div/input"));
		date.click();
		date.sendKeys("04/09/2019");
		date.sendKeys(Keys.ENTER);
		
		WebElement tourType = driver.findElement(By.xpath("//*[@id='tourtype']"));
		tourType.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@id='tourtype']/option[3]")).click();

	}
}
