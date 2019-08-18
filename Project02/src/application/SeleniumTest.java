package application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SeleniumTest {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
		           "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
		
		WebDriver driver = new ChromeDriver();
//		WebDriver d = new EdgeDriver();
		
		driver.get("https://seleniumhq.org/");
	}
}
