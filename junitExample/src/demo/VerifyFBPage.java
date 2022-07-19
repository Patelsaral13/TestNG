package demo;

import java.time.Duration;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class VerifyFBPage {

	WebDriver driver;

	@Before
	public void OpenBrowse() {

		System.setProperty("webdrier.chrome.driver", "Chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.facebook.com/");
	}

	@Test

	public void a_verifyPageTitle() {

		String actualTitle = driver.getTitle();
		String expectedTitle = "Facebook - log in or sign up";
		Assert.assertEquals(actualTitle, expectedTitle);

	}

	@Test

	public void b_verifyText() {

		String actualTxt = driver.findElement(By.cssSelector("#content > div > div > div > div._8esl > h2")).getText();

		String expectedTxt = "Connect with friends and the world around you on Facebook.";

		Assert.assertEquals(actualTxt, expectedTxt);

	}

	@After

	public void closeBroweser() {

		driver.close();

	}

}
