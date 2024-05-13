package TC_01_10;

import java.time.Duration;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Tc06_loginInvalidPassword {
	@Rule
	public ErrorCollector errCol = new ErrorCollector();
// to test login with invalid password 
	@Test
	public void Tc06() throws InterruptedException {
		// driver class
		System.setProperty("webdriver.chrome.driver",
				"C:\\Selenium Webdriver\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver ggl = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(ggl, Duration.ofSeconds(30)); // Explicit Wait
		ggl.manage().window().maximize();
		ggl.get("https://www.traveloka.com/en-my/v2");
		Thread.sleep(1000);

		// Click on Login Page
		WebElement buttonRegis = ggl
				.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[1]/div/div/div[2]/div[3]/div[1]/div"));
		buttonRegis.click();
		Thread.sleep(1000);

		//filling the information to login
		WebElement loginEmailInput = ggl.findElement(By.xpath("//*[@id=\"username\"]"));
		String expectedEmail = "testingprojectsem6@gmail.com";
		loginEmailInput.sendKeys(expectedEmail);// valid email
		Thread.sleep(1000);

		WebElement loginPassInput = ggl.findElement(By.xpath("//*[@id=\"password\"]"));
		String expectedPass = "ProjectSem";// invalid password
		loginPassInput.sendKeys(expectedPass);
		Thread.sleep(1000);
		
		//click on login button
		WebElement buttonLogin = ggl.findElement(By.xpath(
				"//*[@id=\"__next\"]/div[1]/div[1]/div/div/div[2]/div[3]/div[2]/div/div/div/div[1]/div[3]/div[1]/div[2]/div"));
		buttonLogin.click();
		Thread.sleep(1000);
		

		WebElement confirmationNotification = ggl.findElement(By.xpath("/html/body/div[11]/div/div[2]/div"));

		try {
			Assert.assertTrue(confirmationNotification.isDisplayed());//check either the confirmation message pop up or not 
			
		} catch (Throwable e) {
			// Fail test case
			System.out.println("Error:" + e.getMessage());
			errCol.addError(e);
		}

// Close window
		ggl.quit();

	}
}