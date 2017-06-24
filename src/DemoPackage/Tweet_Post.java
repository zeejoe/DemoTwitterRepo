package DemoPackage;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Tweet_Post {
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
		driver.findElement(By.cssSelector("input[type=password]")).sendKeys("");
		driver.findElement(By.className("js-submit")).click();
		// Post a tweet.
		driver.findElement(By.id("global-new-tweet-button")).click();
		driver.findElement(By.id("tweet-box-global")).sendKeys("Hey, there tweet 9.");
		Thread.sleep(2000);
		WebElement tweetButtons = driver.findElement(By.xpath(".//*[@id='global-tweet-dialog-dialog']/div[2]/div[4]/form/div[3]/div[2]/button"));
		tweetButtons.click();
		driver.navigate().refresh(); 
		Thread.sleep(2000);
		driver.findElement(By.className("ProfileCardStats-statLabel")).click();
		WebElement postedTweet = driver.findElement(By.cssSelector("div.js-tweet-text-container"));
		String postedAttValue = postedTweet.findElement(By.cssSelector("p[data-aria-label-part='0']")).getText();
		System.out.println("Newly Posted Tweet is: " +postedAttValue);
		
		WebElement tweetContainer = driver.findElement(By.className("content"));
		List<WebElement> totalTweets = tweetContainer.findElements(By.cssSelector("p.TweetTextSize"));
		
		java.util.Iterator<WebElement> i = totalTweets.iterator();
		while(i.hasNext()) {
			String expectedTweetText = "Hey, there tweet 9.";
		    WebElement tweet2 = i.next();
		    String postedText = tweet2.getText();
		    System.out.println(postedText);
		    Thread.sleep(2000);
		    if (expectedTweetText.equals(postedText)) 
		    
		    {
		    Thread.sleep(2000);
		    System.out.println("Test Passed, Tweet posted");
		    }
		    else {
		    System.out.println("Test Failed, Tweet posted unsuccessful");
		}
}

	    //close Fire fox
        driver.close();
       
        // exit the program explicitly
        System.exit(0);
        
		}	
}

