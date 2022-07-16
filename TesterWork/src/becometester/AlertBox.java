package becometester;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class AlertBox {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.cssSelector("#content > ul > li:nth-child(29) > a")).click();
		driver.findElement(By.cssSelector("#content > div > ul > li:nth-child(1) > button")).click();
		
		Thread.sleep(1000);
		
        driver.switchTo().alert().accept();
		
		
	}
}
