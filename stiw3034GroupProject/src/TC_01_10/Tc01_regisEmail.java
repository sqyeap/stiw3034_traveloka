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

public class Tc01_regisEmail {
	// test registration email
		@Rule
		public ErrorCollector errCol = new ErrorCollector();

		@Test
		public void Tc01() throws InterruptedException {
			// driver class
			System.setProperty("webdriver.chrome.driver",
					"C:\\Selenium Webdriver\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
			WebDriver ggl = new ChromeDriver();
			WebDriverWait wait = new WebDriverWait(ggl, Duration.ofSeconds(30)); // Explicit Wait
			ggl.manage().window().maximize();
			ggl.get("https://www.traveloka.com/en-my/v2");
			Thread.sleep(1000);

			// Go to Registration Page
			WebElement buttonRegis = ggl.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[1]/div/div/div[2]/div[4]"));
			buttonRegis.click();
			Thread.sleep(1000);

			// enter email
			WebElement emailInput = ggl.findElement(
					By.xpath("//*[@id=\"__next\"]/div[4]/div[2]/div/div[3]/div[1]/div[1]/div/div[5]/div[1]/div/input"));
			Thread.sleep(1000);
			String expectedEmail = "testingprojectsem6@gmail.com";// valid email
			emailInput.sendKeys(expectedEmail);
			String enteredEmail = emailInput.getAttribute("value");// get entered email
			System.out.println(enteredEmail);
			Thread.sleep(1000);
			try {
				Assert.assertEquals(expectedEmail, enteredEmail);// check the email
				// click "Join" button
				WebElement buttonJoin = ggl.findElement(By.xpath(
						"//*[@id=\"__next\"]/div[4]/div[2]/div/div[3]/div[1]/div[1]/div/div[5]/div[2]/div/div[2]/div"));
				buttonJoin.click();
				Thread.sleep(1000);

			} catch (Throwable e) {
				System.out.println("Error:" + e.getMessage());
				errCol.addError(e);// will throw an error
			}

//			 Close window
//			ggl.quit();

		}

}
