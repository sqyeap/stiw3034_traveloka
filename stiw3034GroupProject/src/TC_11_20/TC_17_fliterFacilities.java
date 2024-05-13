package TC_11_20;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class TC_17_fliterFacilities {
	
	@Test
	public void tc17() throws InterruptedException {
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
		
		Thread.sleep(2000);
		//send input to the search bar
		driver.findElement(By.xpath("//input[@placeholder =\"City, hotel, place to go\"]")).sendKeys("Melaka");
		
		Thread.sleep(2000);
		
		// Click the most top result
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div[1]/div[2]/div/div[3]/div/div/div/div/div[2]/div[1]/div/div/div[2]/div/div/div/div[1]/div[2]/div")).click();;
		
		Thread.sleep(2000);
		
		// Click the search button
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div[1]/div[2]/div/div[3]/div/div/div/div/div[2]/div[7]/div/div/div")).click();
		
		Thread.sleep(3000);
		
		//scroll down the page until the facilities visible  
        js.executeScript("window.scrollBy(0,1200)");
        
        Thread.sleep(3000);
		
		//check the all the facilities
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[5]/div[1]/div[3]/div[1]/div/div[5]/div[6]/div/div[2]/div/div/div[1]/div/div[1]/div[3]/img")).click();
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[5]/div[1]/div[3]/div[1]/div/div[5]/div[6]/div/div[2]/div/div/div[3]/div/div[1]/div[3]/img")).click();
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[5]/div[1]/div[3]/div[1]/div/div[5]/div[6]/div/div[2]/div/div/div[5]/div/div[1]/div[3]/img")).click();
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[5]/div[1]/div[3]/div[1]/div/div[5]/div[6]/div/div[2]/div/div/div[7]/div/div[1]/div[3]/img")).click();
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[5]/div[1]/div[3]/div[1]/div/div[5]/div[6]/div/div[2]/div/div/div[9]/div/div[1]/div[3]/img")).click();
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[5]/div[1]/div[3]/div[1]/div/div[5]/div[6]/div/div[2]/div/div/div[11]/div/div[1]/div[3]/img")).click();
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[5]/div[1]/div[3]/div[1]/div/div[5]/div[6]/div/div[2]/div/div/div[13]/div/div[1]/div[3]/img")).click();	
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[5]/div[1]/div[3]/div[1]/div/div[5]/div[6]/div/div[2]/div/div/div[15]/div/div[1]/div[3]/img")).click();
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[5]/div[1]/div[3]/div[1]/div/div[5]/div[6]/div/div[2]/div/div/div[17]/div/div[1]/div[3]/img")).click();
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[5]/div[1]/div[3]/div[1]/div/div[5]/div[6]/div/div[2]/div/div/div[19]/div/div[1]/div[3]/img")).click();
		
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,500)");
		//Check for the filter result
		String ActualTitle = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[5]/div[1]/div[3]/div[2]/div[4]/div/div[6]/div/div[2]")).getText();
		String ExpectedTitle = "We found only a few hotels matching your criteria. Please reset your filter.";
		Assert.assertEquals(ExpectedTitle, ActualTitle);
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
