package TC_11_20;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_13_searchFlight_CabinClass {
	
	@Test
	public void tc13() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Webdriver\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.traveloka.com/en-my/v2");
		
		
		Thread.sleep(5000);
		// Click the flight menu
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div[1]/div[2]/div/div[1]/div/div/div[2]/div")).click();
		
		// Click the search bar 
		WebElement origin = driver.findElement(By.xpath("//input[@placeholder =\"Origin\"]"));
		
		
		//Clear the default input text
		origin.clear();
		Thread.sleep(1000);
		
		//send input to the origin search bar
		origin.sendKeys("Kota Kinabalu");
		
		
		Thread.sleep(1000);
		
		// Click the most top result
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div[1]/div[2]/div/div[3]/div/div/div/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/div[2]/div/div/div/div/div[2]/div")).click();
		
		Thread.sleep(2000);
		
		
		
		// Click the destination search bar
		WebElement destination = driver.findElement(By.xpath("//input[@placeholder =\"Destination\"]"));
		
		//Clear the default input text
		destination.clear();
		
		Thread.sleep(1000);
		
		
		//send input to the destination search bar
		driver.findElement(By.xpath("//input[@placeholder =\"Destination\"]")).sendKeys("Singapore");
		
		Thread.sleep(2000);
		
		// Click the most top result
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div[1]/div[2]/div/div[3]/div/div/div/div/div[2]/div/div/div[2]/div[1]/div[1]/div[3]/div[2]/div/div/div/div/div[2]/div")).click();;
		
		Thread.sleep(1000);
		
		//Click the cabin class option
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div[1]/div[2]/div/div[3]/div/div/div/div/div[2]/div/div/div[1]/div/div[3]/div/div[1]")).click();
		
		//Select the first class cabin option
		driver.findElement(By.id("1-FIRST")).click();
		
		Thread.sleep(2000);
		
		// Click the search button
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div[1]/div[2]/div/div[3]/div/div/div/div/div[2]/div/div/div[2]/div[2]/div/div")).click();
		
		
		Thread.sleep(2000);
		
		//Check for the no result
		String ActualTitle = driver.findElement(By.xpath("//*[@id=\"FLIGHT_SEARCH_RESULT_CONTENT\"]/div[5]/div[2]/div[1]/div/div[2]/h2")).getText();
		String ExpectedTitle = "No flights available";
		Assert.assertEquals(ExpectedTitle, ActualTitle);
		
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

	}

}
