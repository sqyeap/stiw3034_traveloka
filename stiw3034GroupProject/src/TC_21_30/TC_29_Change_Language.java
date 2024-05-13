package TC_21_30;

import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Test Case for Traveloka - Change Language
 * 
 * @author Yeap
 *
 */

public class TC_29_Change_Language {
	
	/**
	 * Test Case for Changing Language to Thai Language
	 */

	@Test
	public void TC27() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Webdriver\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.manage().window().maximize();
		driver.get("https://www.traveloka.com/en-my/v2");
		Thread.sleep(1000);
		
		// Click on EN|MYR button
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[1]/div/div/div[2]/div[1]/div[1]/div/div")).click();
		Thread.sleep(1000);
		
		// Click on Thai Language
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[1]/div/div/div[2]/div[1]/div[2]/div/div/div/div[1]/div/div[9]/div[1]/div")).click();
		Thread.sleep(1000);
		
		// Click on Done button
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[1]/div/div/div[2]/div[1]/div[2]/div/div/div/div[2]/div[2]/div/div[2]/div")).click();
		Thread.sleep(5000);
		
		String actualObject = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div[1]/div[1]/div")).getText();
		Thread.sleep(1000);
		
		String expectedObject = "จากเอเชียตะวันออกเฉียงใต้สู่โลกทั้งใบเพื่อคุณ";
		
		Assert.assertEquals(expectedObject, actualObject);
		
	}
	
}
