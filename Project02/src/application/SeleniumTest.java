package application;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"F:/chromedriver_win32/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
	      
		// Launch website  
		    driver.navigate().to("https://www.phptravels.net/");  
		          
		    // Click on the search text box and send value  
		    driver.findElement(By.linkText("OFFERS")).click();
		    
		          
		    // Click on the search button  
		    //driver.findElement(By.name("btnI")).click();  
	}
}
