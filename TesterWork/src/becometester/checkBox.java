package becometester;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class checkBox {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
		driver.findElement(By.linkText("Checkboxes")).click();
		
		 boolean IscheckBoxselected  = driver.findElement(By.cssSelector("#checkboxes > input[type=checkbox]:nth-child(1)")).isSelected();
	
	     if(IscheckBoxselected == false) {
	    	 
	    	 driver.findElement(By.cssSelector("#checkboxes > input[type=checkbox]:nth-child(1)")).click();
	     }
	
	
	}
	
	
}
