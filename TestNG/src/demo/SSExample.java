package demo;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SSExample {

	WebDriver driver;

	@BeforeTest
	public void openapp() {
		System.setProperty("WebDriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://zero.webappsecurity.com/login.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@Test
	public void verifyFundTransfer() throws IOException {
		try {
			driver.findElement(By.id("user_login")).sendKeys("username");
			driver.findElement(By.id("user_password")).sendKeys("password");
			driver.findElement(By.name("submit")).click();

		driver.navigate().back();

			driver.findElement(By.id("transfer_funds_link")).click();
			driver.findElement(By.id("tf_amount")).sendKeys("500");
			driver.findElement(By.id("btn_submit")).click();

			driver.findElement(By.id("btn_submit")).click();

			String actualText = driver
					.findElement(By.cssSelector("#transfer_funds_content > div > div > div.alert.alert-success"))
					.getText();
			String expectedText = "You successfully submitted your transaction.";
			Assert.assertEquals(actualText, expectedText);

		} 
		catch (Exception ab) {
               takeScreenshot();
               Assert.fail("script fail "+ab);
		}
	}

	private void takeScreenshot() throws IOException {
		File ss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(ss, new File("D:\\QA & SQL\\selenium-java\\Document" + (new Random().nextInt()) + ".jpg"));
	}

	@AfterTest
	public void closeapp() {

		driver.close();
	}
}