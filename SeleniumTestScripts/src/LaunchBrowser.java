import java.io.FileInputStream;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;



public class LaunchBrowser {
	public static WebDriver driver;
	public static Properties prop=new Properties();
	
	@BeforeTest
	public WebDriver browser() throws Exception {
		
		
		FileInputStream fis=new FileInputStream("C:\\Users\\Online Test\\Desktop\\mahaboob\\SeleniumTestScripts\\src\\Data.properties");
		prop.load(fis);
		
	
		//if(prop.getProperty("browser").equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Online Test\\Desktop\\selenium\\Selenium\\Driver\\chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get(prop.getProperty("baseURL"));
	        driver.manage().deleteAllCookies();
		
		/*else if(prop.getProperty("browser").equals("firefox")) {
			System.setProperty("webdriver.firefox.driver", "C:\\Users\\Online Test\\Desktop\\selenium\\Driver\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else
		{
			driver=new InternetExplorerDriver();
		}*/
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;

		
		
	}

}
