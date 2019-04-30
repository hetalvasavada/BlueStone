package CommonUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebIntegration {
	public static WebDriver driver;
	public static WebElement webelement;
	public static Properties config;
	public static Properties locators;
	public static FileInputStream file;
	public WebIntegration() {
	
		config=new Properties();
		try {
			file=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Properties\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			config.load(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		locators=new Properties();
		try {
			file=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Properties\\locators.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			locators.load(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void OpenBrowser(String browser) {
		if(browser.equalsIgnoreCase("firefox"))
		{
		System.setProperty("webdriver.firefox.driver", "C:\\webdriver\\geckodriver.exe");
		driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
			driver=new ChromeDriver();
				
		}
		else if(browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\webdriver\\iedriver.exe");
			driver=new InternetExplorerDriver();
				
		}
	}
	public void GetURL(String url) {
		
		driver.get("https://www.aussie.com.au/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		}
	
	public void WaitUntilElementVisible(String locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}
	
	public void ClickElement(String locator)
	{
		System.out.println(locators.getProperty(locator));
		driver.findElement(By.xpath(locators.getProperty(locator))).click();
	}
	
	public void ClickElementUsingID(String locator)
	{
		System.out.println(locators.getProperty(locator));
		driver.findElement(By.id(locators.getProperty(locator))).click();
	}
	
	public void GetText(String locator,String expectedText)
	{
		String Text = driver.findElement(By.className(locators.getProperty(locator))).getText();
		if(Text.equalsIgnoreCase(expectedText)!=true)
		{
			Assert.fail();
		}
	}
	public void SendKeys(String locator,String value)
	{
		driver.findElement(By.id(locators.getProperty(locator))).sendKeys(value);
	}
	
	public void KeyDown() {
		webelement.sendKeys(Keys.UP);
		webelement.sendKeys(Keys.UP);
		webelement.sendKeys(Keys.ENTER);
		webelement.sendKeys(Keys.ENTER);
	}
	public void CloseBrowser()
	{
		driver.quit();
	}

}
