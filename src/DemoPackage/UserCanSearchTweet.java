package DemoPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UserCanSearchTweet {
	public static void main(String[] args) throws InterruptedException{
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
	driver.findElement(By.cssSelector("input[type=password]")).sendKeys("");
	driver.findElement(By.className("js-submit")).click();
	driver.findElement(By.cssSelector("input#search-query")).sendKeys("Hey, this is test msg 5.");
    //close Fire fox
    driver.close();
   
    // exit the program explicitly
    System.exit(0);
}
}