package TC_21_30;

import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Test Case for Traveloka - Sort Results By Price
 * 
 * @author Yeap
 *
 */

public class TC_30_Sort_By_Price {
	
	/**
	 * Test Case for Sorting Results By Price (Highest)
	 */

	@Test
	public void TC30() throws InterruptedException {
		
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
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(1000);
		
		// Click on Highest Price in Sort Results
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[5]/div[1]/div[3]/div[1]/div/div[3]/div[2]/div/div[1]/div/div[2]")).click();
		Thread.sleep(8000);
		
		String firstPriceString = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[5]/div[1]/div[3]/div[2]/div[4]/div/div[1]/div/div/div/div[1]/div[4]/div[2]/div[2]")).getText();
		String secondPriceString = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[5]/div[1]/div[3]/div[2]/div[4]/div/div[3]/div/div/div/div[1]/div[4]/div[2]/div[2]")).getText();
		
		String[] newArr1 = firstPriceString.split(" ", 2);
		String[] temp1 = newArr1[1].split(",", 2);
		String tempS1 = temp1[0].concat(temp1[1]);
		
		String[] newArr2 = secondPriceString.split(" ", 2);
		String[] temp2 = newArr2[1].split(",", 2);
		String tempS2 = temp2[0].concat(temp2[1]);
		
		double firstPrice = Double.parseDouble(tempS1);
		double secondPrice = Double.parseDouble(tempS2);
		
		Assert.assertTrue(firstPrice > secondPrice);
		
	}
	
}
