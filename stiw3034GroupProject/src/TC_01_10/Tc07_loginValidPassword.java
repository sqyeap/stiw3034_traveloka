package TC_01_10;

import java.time.Duration;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Tc07_loginValidPassword {
	public ErrorCollector errCol = new ErrorCollector();

	// to test login with valid password & email in order to get the code validation
	@Test
	public void Tc07() throws InterruptedException {
		// driver class
		System.setProperty("webdriver.chrome.driver",
				"C:\\Selenium Webdriver\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver ggl = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(ggl, Duration.ofSeconds(50)); // Explicit Wait
		ggl.manage().window().maximize();
		ggl.get("https://www.traveloka.com/en-my/v2");
		Thread.sleep(1000);

		// Click on Login Page
		WebElement buttonRegis = ggl
				.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[1]/div/div/div[2]/div[3]/div[1]/div/div[2]"));
		buttonRegis.click();
		Thread.sleep(1000);

		//filling the information to login
		WebElement loginEmailInput = ggl.findElement(By.xpath("//*[@id=\"username\"]"));
		String expectedEmail = "testingprojectsem6@gmail.com";
		loginEmailInput.sendKeys(expectedEmail);// valid email
		Thread.sleep(1000);

		WebElement loginPassInput = ggl.findElement(By.xpath("//*[@id=\"password\"]"));
		String expectedPass = "testingsem6";// valid password
		loginPassInput.sendKeys(expectedPass);
		Thread.sleep(1000);
		
		//click on login button
		WebElement buttonLogin = ggl.findElement(By.xpath(
				"//*[@id=\"__next\"]/div[1]/div[1]/div/div/div[2]/div[3]/div[2]/div/div/div/div[1]/div[3]/div[1]"));
		buttonLogin.click();
		Thread.sleep(1000);
		
		System.out.println("GO thru");
	    WebElement confirmationCodePopup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(), 'Confirmation Needed')]")));
		System.out.println("Checking");
		Thread.sleep(1000);

		try {
			Assert.assertTrue(confirmationCodePopup.isDisplayed());//check either the confirmation message pop up or not 
			System.out.println("Got the ConfirmationDialog");
			

		} catch (Throwable e) {
			// Fail test case
			System.out.println("Error:" + e.getMessage());
			errCol.addError(e);
		}

		// Close window
		ggl.quit();

	}
}
