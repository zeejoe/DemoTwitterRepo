package DemoPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Twitter_Login {
	public static void main(String[] args) throws InterruptedException{
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\zee\\Documents\\Selenium_Jars\\geckodriver-v0.17.0-win64\\geckodriver.exe");
		driver =new FirefoxDriver();
		//Create explicit wait.
		//WebDriverWait myWait = new WebDriverWait(driver, 10);
		String baseUrl = "https://twitter.com";
		driver.get(baseUrl);
		Thread.sleep(2000);
		driver.findElement(By.className("js-login")).click();
		driver.findElement(By.className("js-signin-email")).sendKeys("zeejoe786");
		driver.findElement(By.cssSelector("input[type=password]")).sendKeys("Pakistan1");
		//driver.findElement(By.name("password")).submit();
		boolean x = driver.findElement(By.name("remember_me")).isSelected();
		if (x == true)
		driver.findElement(By.name("remember_me")).click();
		driver.findElement(By.className("js-submit")).click();
		String expectedUser = "zeejoe786";
		String actualUser = driver.findElement(By.className("u-linkComplex-target")).getText();
		if (actualUser.contentEquals(expectedUser)) {
			
			System.out.println("User Successfully Logged in to the Twitter Account!");
		}
		else
		{
			System.out.println("Login Unsuccessful please try again!");
		}
		
	    //close Fire fox
        driver.close();
       
        // exit the program explicitly
        System.exit(0);
        
		}	
}
