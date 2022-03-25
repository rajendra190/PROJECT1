package com.vtiger; 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectrepo.HomePage;
import objectrepo.LoginPage;

public class Base_class {
	public WebDriver driver; 
	public FileUtils fu=new FileUtils();
	public 	WebDriverUtility wl= new WebDriverUtility();
	JavaUtil jv = new JavaUtil();
	public static WebDriver sdriver;

	@BeforeSuite(groups= {"Smoke","Regression"})
	public void bs() {
		System.out.println("Database connected");
	}

	//	@Parameters("BROWSER")

	@BeforeClass(groups= {"Smoke","Regression"})

	public void clas() throws Throwable {

		String BROWSER = fu.Readdatafromprop("Browser");
		if(BROWSER.equals("Chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		}

		else if(BROWSER.equalsIgnoreCase("FIREFOX"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();

		}

		else if(BROWSER.equalsIgnoreCase("Edge")) 
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();

		}

		else
		{
			driver=new FirefoxDriver();
		}
		sdriver=driver;

		driver.get(fu.Readdatafromprop("URL"));
		driver.manage().window().maximize();
	}


	@BeforeMethod(groups= {"Smoke","Regression"})
	public void method() throws Throwable {
		LoginPage login=new LoginPage(driver);

		login.getUsernametxtfld().sendKeys(fu.Readdatafromprop("UN"));
		login.getPasswordtxtfld().sendKeys(fu.Readdatafromprop("PW"));
		login.getLoginbtn().click();
	}


	@AfterMethod(groups= {"Smoke","Regression"})
	public void afterMethod() {
		HomePage HP =new HomePage(driver);
		WebElement path = HP.getSignoutimg();
		wl.movetolement(driver, path);
		HP.getSignoutlink().click();

	}

	@AfterClass(groups= {"Smoke","Regression"})
	public void aftclass() throws Throwable {
		Thread.sleep(2000);
		driver.close();
	}

	@AfterSuite(groups= {"Smoke","Regression"})
	public void aftersuite() {
		System.out.println("connection closed");

	}

}
