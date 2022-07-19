package demo;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.*;

@RunWith(Parameterized.class)

public class VerifyInvalidLoginTest {

	WebDriver driver;
	String emailID;
	String password;

	public VerifyInvalidLoginTest(String emailAddress, String password) {

		this.emailID = emailAddress;
		this.password = password;

	}

	@Before
	public void OpenBrowse() {

		System.setProperty("webdrier.chrome.driver", "Chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.facebook.com/");
	}

	@Test

	public void VerifyInvalidLogin() {
		driver.findElement(By.id("email")).sendKeys(emailID);
		driver.findElement(By.id("pass")).sendKeys(password);
		driver.findElement(By.name("login")).click();

		String actualErrMsg = driver.findElement(By.cssSelector("#email_container > div._9ay7")).getText();
		String expectedErrMsg = "The email you entered isn’t connected to an account. Find your account and log in.";
		Assert.assertEquals(actualErrMsg, expectedErrMsg);
		
	}

	@Parameters

	public static Collection<Object[]> getData() {

		Object[][] data = new Object[3][2];

		data[0][0] = "ironman4234@hotmail.com";
		data[0][1] = "pass123456";
		data[1][0] = "spidern4215@gmail.com";
		data[1][1] = "pass456";
		data[2][0] = "spiderman23423@hotmail.com";
		data[2][1] = "pass123";

		return Arrays.asList(data);
	}

	@After

	public void closeBroweser() {
		driver.close();

	}
}