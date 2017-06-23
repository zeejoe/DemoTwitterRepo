package DemoPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TweetsCountAfterPost {
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
	driver.findElement(By.cssSelector("input[type=password]")).sendKeys("Pakistan1");
	driver.findElement(By.className("js-submit")).click();
	driver.findElement(By.className("ProfileCardStats-statLabel")).click();
	Thread.sleep(3000);
	// Post new tweet
	
	WebElement tweetContainer = driver.findElement(By.className("content"));
	List<WebElement> totalTweets = tweetContainer.findElements(By.cssSelector("p.TweetTextSize"));
	java.util.Iterator<WebElement> i = totalTweets.iterator();
	while(i.hasNext()) {
		// Copy the same posted text in the expectedTweetText variable.
		String expectedTweetText = "Hey, this is test msg 5.";
	    WebElement tweet2 = i.next();
	    String postedText = tweet2.getText();
	    System.out.println(postedText);
	    if (expectedTweetText.equals(postedText)) 
		    
	    {
	    Thread.sleep(2000);
	    System.out.println("Test Passed, Tweet posted");
	    }
	    else 
	    {
	    System.out.println("Test Failed, Tweet posted unsuccessful");
        }   
	
	// Refresh page
	driver.navigate().refresh();    
	WebElement tweetCount1 = driver.findElement(By.cssSelector("a[data-nav='tweets']"));
	String attValue = tweetCount1.findElement(By.cssSelector("span.ProfileNav-value")).getText();
	System.out.println("Total Number of Posted Tweets: " +attValue);
	Thread.sleep(3000);
	WebElement postedTweet = driver.findElement(By.cssSelector("div.js-tweet-text-container"));
	String postedAttValue = postedTweet.findElement(By.cssSelector("p[data-aria-label-part='0']")).getText();
	System.out.println("Newly Posted Tweet is: " +postedAttValue);
		}
    //close Fire fox
    driver.close();
   
    // exit the program explicitly
    System.exit(0);
	}
	
}