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

public class Tc10_NavigateYouTube {
	@Rule
	public ErrorCollector errCol = new ErrorCollector();

	// To test web site is navigate to the correct web page
	@Test
	public void Tc10() throws InterruptedException {
		// driver class
		System.setProperty("webdriver.chrome.driver",
				"C:\\Selenium Webdriver\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver ggl = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(ggl, Duration.ofSeconds(100)); // Explicit Wait
		ggl.manage().window().maximize();
		ggl.get("https://www.traveloka.com/en-my/v2");
		Thread.sleep(1000);

		// Locate the "Follow us on YouTube" button using XPath
		WebElement followInsButton = ggl
				.findElement(By.xpath("//*[@id=\"__next\"]/div[6]/div/div[1]/div[2]/div[1]/div[2]/ul/li[4]/a"));
		followInsButton.click();
		Thread.sleep(1000);

		// Switch to the new window or tab that opens after clicking the button
		for (String handle : ggl.getWindowHandles()) {
			ggl.switchTo().window(handle);
		}

		// Now you are on the YouTube page. Get the current URL
		String currentUrl = ggl.getCurrentUrl();

		// Verify the current URL to ensure you are on the expected page

		try {
			Assert.assertEquals("https://www.youtube.com/@travelokamy", currentUrl);// Valid expected URL
			System.out.println("Success");
			WebElement videoBtn = ggl
					
					.findElement(By.xpath("//*[@id=\"tabsContent\"]/tp-yt-paper-tab[2]/div/div[1]"));//go to the list of videos page
			videoBtn.click();
			Thread.sleep(1000);
			
			WebElement selecteBtn = ggl
					.findElement(By.xpath("//*[@id=\"video-title-link\"]"));//display video
			selecteBtn.click();
			Thread.sleep(1000);


		} catch (Throwable e) {
			// Fail test case
			System.out.println("Error:" + e.getMessage());
			errCol.addError(e);
		}

		// Close window
		ggl.quit();
}
}