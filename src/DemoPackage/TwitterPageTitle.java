package DemoPackage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TwitterPageTitle {
	public static void main(String[] args) throws InterruptedException{
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\zee\\Documents\\Selenium_Jars\\geckodriver-v0.17.0-win64\\geckodriver.exe");
		driver =new FirefoxDriver();
		
		String baseUrl = "https://twitter.com";
		String expectedTitle = "Twitter. It's what's happening.";
		//String actualTitle = "";
		driver.get(baseUrl);
		
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		Thread.sleep(5000);
		if (actualTitle.contentEquals(expectedTitle))
			
			{
			System.out.println("Login Passed!");
			}
			else
			{
			System.out.println("Login Failed!");
			}
        //close Fire fox
        driver.close();
       
        // exit the program explicitly
        System.exit(0);
        
		}	
}
