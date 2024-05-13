package TC_21_30;

import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Test Case for Traveloka - Download From Google Play Store
 * 
 * @author Yeap
 *
 */

public class TC_26_Download_From_Play_Store {
	
	/**
	 * Test Case for Download Application From Google Play Store
	 */

	@Test
	public void TC26() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Webdriver\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.manage().window().maximize();
		driver.get("https://www.traveloka.com/en-my/v2");
		Thread.sleep(1000);
		
		// Scroll to the bottom of the page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(1000);
		
		// Click on Google Play button
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[6]/div/div[1]/div[2]/div[3]/div[2]/div[2]/a")).click();
		Thread.sleep(5000);
		
		String actualObject1 = driver.findElement(By.xpath("//*[@id=\"kO001e\"]/header/nav/a/span")).getText();
		Thread.sleep(1000);
		
		String actualObject2 = driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz[2]/div/div/div[2]/div[1]/div/div/div/div[1]/div/c-wiz/div/div/div/div/button/span")).getText();
		Thread.sleep(1000);
		
		String expectedObject1 = "google_logo Play";
		String expectedObject2 = "Install";
		
		Assert.assertEquals(expectedObject1, actualObject1);
		Assert.assertEquals(expectedObject2, actualObject2);
		
	}
	
}
