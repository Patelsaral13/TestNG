package becometester;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class mousehover {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebElement accSign = driver.findElement(By.id("nav-link-accountList"));
	    Actions hover = new Actions(driver);
	    hover.moveToElement(accSign).perform();
	
	    driver.findElement(By.linkText("Account")).click();
	}
	
	
}
