package DemoPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DeleteTweet {
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
		driver.findElement(By.className("js-submit")).click();
		driver.findElement(By.className("ProfileCardStats-statLabel")).click();
		Thread.sleep(3000);
		WebElement contentContainer = driver.findElement(By.xpath("(//button[@type='button'])[29]"));
		contentContainer.click();
		WebElement tweetCount1 = driver.findElement(By.cssSelector("a[data-nav='tweets']"));
		String attValue = tweetCount1.findElement(By.cssSelector("span.ProfileNav-value")).getText();
		System.out.println("Total Number of Posted Tweets: " +attValue);
		
		Thread.sleep(3000);
	    WebElement deleteBtn = driver.findElement(By.cssSelector("li.js-actionDelete"));
	    deleteBtn.click();
		driver.findElement(By.xpath(".//*[@id='delete-tweet-dialog-dialog']/div[2]/div[4]/button[1]")).click();
		driver.navigate().refresh();
		if (attValue.equalsIgnoreCase(attValue)){
		System.out.println("Test Failed, Tweet Not Deleted, please try again!");
		}
		else {
		System.out.println("Test Passed, Tweet Deleted!");
		}
        //close Fire fox
        driver.close();
       
        // exit the program explicitly
        System.exit(0);
	}	
}
