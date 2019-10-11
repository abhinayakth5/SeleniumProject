
import java.io.File;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;






public class Operations extends LaunchBrowser{
	

	
	  

		  By MyAccountButton = By.xpath("//ul[@class='nav navbar-nav navbar-right hidden-sm go-left']//a[@class='dropdown-toggle go-text-right'][contains(text(),'My Account')]");
		  By SignUpButton = By.xpath("/html[1]/body[1]/nav[1]/div[1]/div[2]/ul[2]/ul[1]/li[1]/ul[1]/li[2]/a[1]");
		  By LoginBtn=By.xpath("//ul[@class='nav navbar-nav navbar-right hidden-sm go-left']//ul[@class='nav navbar-nav navbar-side navbar-right sidebar go-left user_menu']//li[@id='li_myaccount']//ul[@class='dropdown-menu']//li//a[@class='go-text-right'][contains(text(),'Login')]");
		  By LoginEmail=By.xpath("//input[@placeholder='Email']");
		  By LoginPassword=By.xpath("//input[@placeholder='Password']");
		  By LoginButton=By.xpath("//button[@class='btn btn-action btn-lg btn-block loginbtn']");
		  By Firstname = By.xpath("//input[@placeholder='First Name']");
		  By Lastname = By.xpath("//input[@name='lastname']");
		  By MNumber = By.xpath("//input[@name='phone']");
		  By MailId = By.xpath("//input[@name='email']");
		  By Password = By.xpath("//input[@name='password']");
		  By CnfPassword = By.xpath("//input[@name='confirmpassword']");
		  By SighnupBtn = By.xpath("//button[@class='signupbtn btn_full btn btn-action btn-block btn-lg']");
		  By Cookie=By.xpath("//button[@id='cookyGotItBtn']");
		  By HotelLink=By.xpath("//li[@class='active text-center']//a[@class='text-center']");
		  By HotelSearchField=By.xpath("//div[@id='s2id_location']//a[@class='select2-choice select2-default']");
	      By Select=By.xpath("//div[contains(text(),'galore, India')]");  
		  By Checkin=By.xpath("//div[@id='dpd1']//input[@placeholder='Check in']");
		  By CheckinDate=By.xpath("/html[1]/body[1]/div[14]/div[1]/table[1]/tbody[1]/tr/td[@class='day '][contains(text(),"+prop.getProperty("checkindate")+")]");
	      By CheckoutDate=By.xpath("/html[1]/body[1]/div[15]/div[1]/table[1]/tbody[1]/tr/td[@class='day '][contains(text(),"+prop.getProperty("checkoutdate")+")]");
		  By Next=By.xpath("/html/body/div[14]/div[1]/table/thead/tr[1]/th[3]");
		  By Checkout=By.xpath("/html/body/div[15]/div[1]/table/thead/tr[1]/th[2]");
		  By Next1=By.xpath("/html/body/div[15]/div[1]/table/thead/tr[1]/th[3]");
		  By Guest=By.xpath("//input[@id='htravellersInput']");
		  By Adult=By.xpath("//input[@id='hadultInput']");
		  By Child=By.xpath("//input[@id='hchildInput']");
		  By Click_Search=By.xpath("//button[@class='btn btn-lg btn-block btn-primary pfb0 loader']");
		 
		  public void HotelSearch() throws Exception {
			  //driver.findElement(HotelLink).click();
			  driver.findElement(HotelSearchField).click();
			  driver.findElement(HotelSearchField).sendKeys(prop.getProperty("CityNameOfHotel"));
			  Thread.sleep(5000);
			  driver.findElement(HotelSearchField).sendKeys((Keys.DOWN));
			  driver.findElement(Select).click();
			  driver.findElement(Checkin).click();
			  while(true){
				  	String str=driver.findElement(By.xpath("/html/body/div[14]/div[1]/table/thead/tr[1]/th[2]")).getText();
				  	if(str.equals(prop.getProperty("checkinmonth")))
				  	{
				  		break;
				  	}
				  	else
				  	{
				  	driver.findElement(Next).click();
				  	}
				}
			  driver.findElement(CheckinDate).click();
			  driver.findElement(Checkout).click();
			  while(true){
				  	String str=driver.findElement(By.xpath("//div[15]//div[1]//tr[1]//th[2]")).getText();
				  	if(str.equals(prop.getProperty("checkoutmonth")))
				  	{
				  		break;
				  	}
				  	else
				  	{
				  	driver.findElement(Next1).click();
				  	}
				}
			  
			    driver.findElement(CheckoutDate).click();
			    driver.findElement(Guest).click();
			    driver.findElement(Adult).sendKeys(Keys.BACK_SPACE);
				driver.findElement(Adult).sendKeys(prop.getProperty("adult"));
				driver.findElement(Child).sendKeys(Keys.BACK_SPACE);
				driver.findElement(Child).sendKeys(prop.getProperty("child"));
				driver.findElement(Click_Search).click();
			  
			  
			  }
	
		  public void SignUpPage() throws Exception 
		  {
		 /* Properties prop=new Properties();
		  FileInputStream fis =new FileInputStream("C:\\Users\\Online Test\\Desktop\\mahaboob\\SeleniumTestScripts\\src\\Data.properties");
		  prop.load(fis);*/
		 
		  
		  driver.findElement(MyAccountButton).click();
		  driver.findElement(SignUpButton).click();
		  driver.findElement(Firstname).sendKeys(prop.getProperty("Fname"));
		  driver.findElement(Lastname).sendKeys(prop.getProperty("Lname"));
		  driver.findElement(MNumber).sendKeys(prop.getProperty("Mnumber"));
		  driver.findElement(MailId).sendKeys(prop.getProperty("MailId"));
		  driver.findElement(Password).sendKeys(prop.getProperty("password"));
		  driver.findElement(CnfPassword).sendKeys(prop.getProperty("password"));
		  Thread.sleep(3000);
		  driver.findElement(Cookie).click();
		  driver.findElement(SighnupBtn).click();
		
		}
		  public void LoginPage() throws Exception 
		  {
			
		 driver.findElement(MyAccountButton).click();
		 driver.findElement(LoginBtn).click();
		 driver.findElement(LoginEmail).sendKeys(prop.getProperty("LoginEmail"));
	     driver.findElement(LoginPassword).sendKeys(prop.getProperty("LoginPassword"));
	     driver.findElement(LoginButton).click();
	     String Url=driver.getCurrentUrl();
	     String ActualUrl=prop.getProperty("TitleOfHomePage");
			  
		if(Url!=ActualUrl) 
		{
			File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    FileUtils.copyFile(src, new File ("C:\\Users\\Online Test\\Desktop\\selenium\\Screenshots\\LoginFail.png"));
		}
	   else {
				System.out.println("Login successfully");
			}
			  
		}
		  

}
