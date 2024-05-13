package TC_11_20;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_20_searchActivites_Invalid {
	
	
	@Test
	public void tc20() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Webdriver\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.traveloka.com/en-my/v2");
		
		
		Thread.sleep(2000);
		// Click the Things to do menu
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div[1]/div[2]/div/div[1]/div/div/div[5]/div")).click();
		
		
		Thread.sleep(2000);
		// Click the search bar 
		driver.findElement(By.xpath("//input[@placeholder=\"Search activities or destinations\"]")).click();
		
		Thread.sleep(1000);
		//send input to the search bar
		driver.findElement(By.xpath("//input[@placeholder =\"Search activities or destinations\"]")).sendKeys("asdasd");
		
		Thread.sleep(1000);
		// Click the search button
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div/div[2]/div/div[3]/div/div/div/div/div/div[2]/div[1]/div/div[2]/div/div")).click();;
		
		Thread.sleep(2000);
		
		//Check for the no result
		String ActualTitle = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[5]/div/div[2]/div/div/div/div[2]/div[2]/div[3]/div[2]")).getText();
		String ExpectedTitle = "Oops, We Couldn't Find Any Activities";
		Assert.assertEquals(ExpectedTitle, ActualTitle);
	
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
