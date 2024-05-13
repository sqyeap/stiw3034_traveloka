package TC_21_30;

import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Test Case for Traveloka - Contact Traveloka Using Telegram
 * 
 * @author Yeap
 *
 */

public class TC_28_Contact_Using_Telegram {
	
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
		
		// Scroll down to See All Promos
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1000);
		
		// Click on See All Promos
		driver.findElement(By.xpath("//*[@id=\"merchandising\"]/div[1]/div[2]/div/div[3]/div/div")).click();
		Thread.sleep(5000);
		
		// Click on See More
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[6]/div[2]/div/div/div/div[1]/a/div[2]/span")).click();
		
		// Follow to second tab
		driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
		Thread.sleep(5000);
		
		// Scroll down to Join Our Telegram
		js.executeScript("window.scrollBy(0,8000)");
		Thread.sleep(1000);
		
		// Click on Join Our Telegram
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[4]/div/div[12]/div/div[1]/div/div/div")).click();
		
		// Follow to third tab
		driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
		Thread.sleep(5000);
		
		String actualObject1 = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/span")).getText();
		Thread.sleep(1000);
		
		String actualObject2 = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[5]/a")).getText();
		Thread.sleep(1000);
		
		String expectedObject1 = "Traveloka Malaysia";
		String expectedObject2 = "VIEW IN TELEGRAM";
		
		Assert.assertEquals(expectedObject1, actualObject1);
		Assert.assertEquals(expectedObject2, actualObject2);
		
	}
	
}
