package becometester;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class dropDown {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	    driver.findElement(By.linkText("Create new account"));
	    
	    WebElement monthDD = driver.findElement(By.id("month"));
	    Select dropdown = new Select(monthDD);
	    dropdown.selectByVisibleText("Sep");
	    
	}
	
	
}
