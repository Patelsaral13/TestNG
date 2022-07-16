package becometester;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class explicitwait {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.findElement(By.cssSelector("#content > ul > li:nth-child(14) > a")).click();

		driver.findElement(By.partialLinkText("Example 1")).click();
		driver.findElement(By.cssSelector("#start > button")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#finish > h4")));

		String actualText = driver.findElement(By.cssSelector("#finish > h4")).getText();
		System.out.println("Text is:  " +actualText);
		

		String expectedText = "Hello World!";

		if (actualText.equals(expectedText)) {

			System.out.println("Test Passed:- Syntax Match");
		} else {

			System.out.println("Test Failed:- Syntax Not Match");
		}

	}
}
