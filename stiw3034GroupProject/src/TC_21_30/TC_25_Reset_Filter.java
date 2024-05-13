package TC_21_30;

import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Test Case for Traveloka - Reset Reviews Filter(s)
 * 
 * @author Yeap
 *
 */

public class TC_25_Reset_Filter {
	
	/**
	 * Test Case for Browse Hotel Reviews, Reset All Filter(s) Applied
	 */

	@Test
	public void TC25() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Webdriver\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.manage().window().maximize();
		driver.get("https://www.traveloka.com/en-my/v2");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div[1]/div[2]/div/div[1]/div/div/div[1]/div/div[2]/div")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div[1]/div[2]/div/div[3]/div/div/div/div/div[2]/div[1]/div/div/div[1]/div/div[1]/input")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div[1]/div[2]/div/div[3]/div/div/div/div/div[2]/div[1]/div/div/div[2]/div/div/div/div[1]/div[2]/div/div/div[1]/div[1]")).click();
		Thread.sleep(1000);
		
		// Click on search button
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div[1]/div[2]/div/div[3]/div/div/div/div/div[2]/div[7]/div/div/div")).click();
		Thread.sleep(1000);
		
		// Scroll down
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(5000);
		
		// Click on Hotel
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[5]/div[1]/div[3]/div[2]/div[4]/div/div[1]/div/div/div/div[1]/div[3]/div[1]/div[1]/h3")).click();
		Thread.sleep(1000);
		
		// Follows to the 2nd Tab
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[5]/div[1]/div[3]/div[2]/div[4]/div/div[1]/div/div/div/div[1]/div[3]/div[1]/div[1]")).click();
		driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
		Thread.sleep(5000);
		
		// Scroll down to Review Tab
		js.executeScript("window.scrollBy(0,9200)");
		Thread.sleep(1000);
		
		// Click on Sort By
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[5]/div[13]/div/div[3]/div[1]/div[2]/div[1]/div/div[1]/div/div[1]/div/div[2]")).click();
		Thread.sleep(1000);
		
		// Click on Score(Low to High)
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[5]/div[13]/div/div[3]/div[1]/div[2]/div[1]/div/div[2]/div/div/div/div[2]/div/div/div")).click();
		Thread.sleep(1000);
		
		// Click on Category combobox
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[5]/div[13]/div/div[3]/div[1]/div[2]/div[3]/div/div[1]/div/div[1]/div/div[2]")).click();
		Thread.sleep(1000);
				
		// Click on first object
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[5]/div[13]/div/div[3]/div[1]/div[2]/div[3]/div/div[2]/div/div/div/div[2]/div/div/div")).click();
		Thread.sleep(1000);
		
		// Click on checkbox
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[5]/div[13]/div/div[3]/div[1]/div[2]/div[7]/div")).click();
		Thread.sleep(5000);
		
		// Click on filter (Strategic Location)
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[5]/div[13]/div/div[3]/div[1]/div[1]/div/div/div/div[2]/div/div")).click();
		Thread.sleep(2000);
		
		// Click on Reset Filter button
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[5]/div[13]/div/div[3]/div[3]/div/div/div[2]/div/div[2]/div")).click();
		Thread.sleep(1000);
		
		String actualObject = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[5]/div[13]/div/div[3]/div[3]/div/div[1]/div/div[1]/div[2]/div[1]/div[2]")).getText();
		Thread.sleep(1000);
		
		String expectedObject = "Staycation";
		
		Assert.assertNotEquals(expectedObject, actualObject);
		
	}
	
}
