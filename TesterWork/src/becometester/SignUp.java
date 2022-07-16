package becometester;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SignUp {


	public static void main(String[] args)
	{
		
		
		System.setProperty("WebDriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://testers.testerwork.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 
		driver.findElement(By.name("email")).sendKeys("patelsaral13@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Saral@123");
		
		driver.findElement(By.cssSelector("#app > div > div.auth > div.container-fluid > div:nth-child(2) > div.col-xs-12.col-sm-12.col-md-7 > div > div > form > button")).click();
		
		String ActualErrMsg = driver.findElement(By.cssSelector("#app > div > div.auth > div.container-fluid > div:nth-child(2) > div.col-xs-12.col-sm-12.col-md-7 > div > div > form > div:nth-child(5) > span > span")).getText();	
		String ExpectedErrMsg = "Credentials that you provided are incorrect. Please try again or use the 'Forgotten password?'";
		
		if(ActualErrMsg.equals(ExpectedErrMsg)) {
			
			System.out.println("Test is Passed");
		}
		else {
			
			 System.out.println("Test is Fail");
				
		}
	
	     driver.close();
	}
}