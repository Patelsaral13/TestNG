package demo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VerifyPageTitle {

	WebDriver driver;

	@BeforeTest
	public void openapp() {
		System.setProperty("WebDriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://testers.testerwork.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@Test

	public void verifyTitle() {

		String actualTitle = driver.getTitle();
		String expectedTitle = "Tester Work | Tester Work";

		Assert.assertEquals(actualTitle, expectedTitle);

	}

	@AfterTest

	public void closeApp() {

		driver.close();

	}

}
