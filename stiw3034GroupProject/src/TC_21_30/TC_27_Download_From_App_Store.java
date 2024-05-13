package TC_21_30;

import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Test Case for Traveloka - Download From Apple App Store
 * 
 * @author Yeap
 *
 */

public class TC_27_Download_From_App_Store {
	
	/**
	 * Test Case for Download Application From Apple App Store
	 */

	@Test
	public void TC27() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Webdriver\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.manage().window().maximize();
		driver.get("https://www.traveloka.com/en-my/v2");
		Thread.sleep(1000);
		
		// Scroll to the bottom of the page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(1000);
		
		// Click on Apple Store button
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[6]/div/div[1]/div[2]/div[3]/div[2]/div[3]/a")).click();
		Thread.sleep(5000);
		
		String actualObject1 = driver.findElement(By.xpath("//*[@id=\"localnav\"]/div/div[2]/div[1]/a/span")).getText();
		Thread.sleep(1000);
		
		String actualObject2 = driver.findElement(By.xpath("/html/body/div[3]/main/div[2]/section[1]/div/div[2]/header/h1")).getText();
		Thread.sleep(1000);
		
		String expectedObject1 = "App Store";
		String expectedObject2 = "Traveloka: Hotels & Flights 4+";
		
		Assert.assertEquals(expectedObject1, actualObject1);
		Assert.assertEquals(expectedObject2, actualObject2);
		
	}
	
}
