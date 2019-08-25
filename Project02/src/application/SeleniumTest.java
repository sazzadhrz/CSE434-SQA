package application;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Program Files (x86)/Google/Chrome/Application/chrome.exe");
		
		WebDriver driver = new ChromeDriver();
//		WebDriver d = new EdgeDriver();
		
		driver.get("https://seleniumhq.org/");
		driver.wait(3000);
		
        driver.manage().window().maximize();  
        
        //Scroll down the webpage by 5000 pixels  
      JavascriptExecutor js = (JavascriptExecutor)driver;  
      js.executeScript("scrollBy(0, 5000)");  
      
      driver.findElement(By.linkText("Documentation")).click();  
	}
}
