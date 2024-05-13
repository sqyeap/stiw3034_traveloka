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

public class Tc05_RegisValidPassword {
	// test registration input information
	@Rule
	public ErrorCollector errCol = new ErrorCollector();

	@Test
	public void Tc05() throws InterruptedException {
		// driver class
		System.setProperty("webdriver.chrome.driver",
				"C:\\\\Selenium Webdriver\\\\ChromeDriver\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver ggl = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(ggl, Duration.ofSeconds(30)); // Explicit Wait
		ggl.manage().window().maximize();
		ggl.get("https://www.traveloka.com/en-my/user/verify/signup?method=TV&username=testingprojectsem6%40gmail.com");
		Thread.sleep(1000);

		// enter the valid code
		WebElement codeInput = ggl.findElement(
				By.xpath("//*[@id=\"__next\"]/div[4]/div[2]/div/div[3]/div[1]/div[2]/div/div[1]/div[1]/div[1]/input"));
		String expectedCode = "602049";
		codeInput.sendKeys(expectedCode);// valid code
		Thread.sleep(1000);

		// click submit button
		WebElement buttonSubmit = ggl.findElement(By
				.xpath("//*[@id=\"__next\"]/div[4]/div[2]/div/div[3]/div[1]/div[2]/div/div[1]/div[2]/div/div[2]/div"));
		buttonSubmit.click();
		Thread.sleep(1000);

		// enter the name
		WebElement nameInput = ggl.findElement(
				By.xpath("//*[@id=\"__next\"]/div[4]/div[2]/div/div[3]/div[1]/div[2]/div/div[3]/div[1]/input"));
		String expectedName = "Testingproject";
		nameInput.sendKeys(expectedName);// valid name
		String nameEntered = nameInput.getAttribute("value");
		Thread.sleep(1000);

		// check password validation
		try {
			Assert.assertEquals(expectedName, nameEntered);
			WebElement passInput = ggl.findElement(
					By.xpath("//*[@id=\"__next\"]/div[4]/div[2]/div/div[3]/div[1]/div[2]/div/div[5]/div[1]/input"));
			String pass = "testingsem6";
			passInput.sendKeys(pass);// valid password
			String passEntered = passInput.getAttribute("value");
			Thread.sleep(1000);

			WebElement pass2ndInput = ggl.findElement(
					By.xpath("//*[@id=\"__next\"]/div[4]/div[2]/div/div[3]/div[1]/div[2]/div/div[7]/div[1]/input"));
			String secondPass = "testingsem6";
			pass2ndInput.sendKeys(secondPass);// Valid password
			String secondPassEntered = pass2ndInput.getAttribute("value");
			Thread.sleep(1000);

			try {
				Assert.assertEquals(passEntered, secondPassEntered);
				WebElement buttonDone = ggl
						.findElement(By.xpath("//*[@id=\"__next\"]/div[4]/div[2]/div/div[3]/div[1]/div[2]/div/div[9]"));
				buttonDone.click();
				Thread.sleep(1000);
				
				
			} catch (Throwable e) {
				// Fail test case
				System.out.println("Error:" + e.getMessage());
				errCol.addError(e);
			}

		} catch (Throwable e) {
			// Fail test case
			System.out.println("Error:" + e.getMessage());
			errCol.addError(e);
		}

		// Close window
		ggl.quit();

	}
}
