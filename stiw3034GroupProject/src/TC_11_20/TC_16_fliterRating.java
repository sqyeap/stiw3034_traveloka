package TC_11_20;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class TC_16_fliterRating {
	
	@Test
	public void tc16() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Webdriver\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.get("https://www.traveloka.com/en-my/v2");
		
		
		Thread.sleep(2000);
		// Click the hotel menu
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div[1]/div[2]/div/div[1]/div/div/div[1]/div/div[2]/div")).click();
		Thread.sleep(2000);
		// Click the search bar 
		driver.findElement(By.xpath("//input[@placeholder=\"City, hotel, place to go\"]")).click();
		
		Thread.sleep(1000);
		//send input to the search bar
		driver.findElement(By.xpath("//input[@placeholder =\"City, hotel, place to go\"]")).sendKeys("Melaka");
		
		Thread.sleep(3000);
		
		// Click the most top result
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div[1]/div[2]/div/div[3]/div/div/div/div/div[2]/div[1]/div/div/div[2]/div/div/div/div[1]/div[2]/div")).click();;
		
		Thread.sleep(2000);
		
		// Click the search button
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div[1]/div[2]/div/div[3]/div/div/div/div/div[2]/div[7]/div/div/div")).click();
		
		Thread.sleep(2000);
		
		//scroll down the page until the star rating visible  
        js.executeScript("window.scrollBy(0,1000)");
        
        Thread.sleep(3000);
		
		//check the 4 star rating tick box
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[5]/div[1]/div[3]/div[1]/div/div[5]/div[5]/div/div[2]/div/div/div[7]/div/div[1]/div[3]/img")).click();
		
		
		
		Thread.sleep(5000);
		
		List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"__next\"]/div[5]/div[1]/div[3]/div[2]/div[4]/div/div[1]/div/div/div/div[1]/div[3]/div[1]/div[3]/div[2]/div/div/img"));
		int actualStars = elements.size();
		
		Thread.sleep(3000);
		int expectedStars = 4;
		// Check the star rating is 4
		Assert.assertEquals(actualStars, expectedStars);
		

	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
