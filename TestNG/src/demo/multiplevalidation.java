package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class multiplevalidation {

	WebDriver driver;

	@BeforeTest
    @Parameters("browser")
	public void openmonster(String browser) {
		if (browser.equals("chrome")) {
            System.setProperty("WebDriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
		} 
		else if (browser.equals("Edge")) {
			System.setProperty("WebDriver.edge.driver", "msedgedriver.exe");
			driver = new EdgeDriver();
		}
		driver.get("https://www.monsterindia.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Test(priority = 0)

	public void verifymonsterpageTitle() {

		String actualTitle = driver.getTitle();
		String expectedTitle = "Job Vacancy - Latest Job Openings - Job Search Online - Monster India";

		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test(priority = 1)
	public void veriftText() {

		String actualText = driver
				.findElement(By.cssSelector(
						"#user-signup-actions > div:nth-child(1) > div.engage.w100.fl.tc.engage-desktop > h2"))
				.getText();
		String expectedText = "NEW TO MONSTER?";
		Assert.assertEquals(actualText, expectedText);

	}

	@Test(priority = 2)
	public void loginbtnvisible() {

		boolean Isbtnvisible = driver.findElement(By.xpath("(//li[contains(@class,'box-nav btn-link seeker-li')])[2]"))
				.isDisplayed();
		Assert.assertTrue(Isbtnvisible);

	}

	@Test(priority = 3)

	public void searchbtnenable() {

		boolean searchbtnvisible = driver
				.findElement(By.cssSelector(
						"#searchForm > div > div.col-xl-2.col-lg-3.col-sm-2.col-xxs-12.fl.no-padding > input"))
				.isDisplayed();
		Assert.assertTrue(searchbtnvisible);

	}

	@AfterTest

	public void closeapp() {

		driver.close();

	}
}
