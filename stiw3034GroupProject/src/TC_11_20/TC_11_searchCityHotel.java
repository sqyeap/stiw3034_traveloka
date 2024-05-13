package TC_11_20;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TC_11_searchCityHotel {
	
	@Test
	public void tc11() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Webdriver\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
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
		driver.findElement(By.xpath("//input[@placeholder =\"City, hotel, place to go\"]")).sendKeys("Kuala Lumpur");
		
		Thread.sleep(2000);
		// Click the most top result
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div[1]/div[2]/div/div[3]/div/div/div/div/div[2]/div[1]/div/div/div[2]/div/div/div/div[1]/div[2]/div")).click();;
		
		Thread.sleep(2000);
		
		// Click the search button
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div[1]/div[2]/div/div[3]/div/div/div/div/div[2]/div[7]/div/div/div")).click();
		
		//driver.quit();
		
		
		//Check for the  result
		String ActualTitle = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[5]/div[1]/div[1]/div/div[1]/h2")).getText();
		String ExpectedTitle = "Your search results in Kuala Lumpur, Malaysia";
		Assert.assertEquals(ExpectedTitle, ActualTitle);
	}

	public static void main(String[] args) throws InterruptedException {
		

	}
	
}
