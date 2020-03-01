//import java.text.SimpleDateFormat;
//import java.util.Date;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCasesMainClass extends ReUsMethods {

	@BeforeTest
	public void Initialize() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		/*if(browserName.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}*/
		CreateReport();
	}
	
	@Test
	//@Parameters("browser")
	public void LoginSFDC() throws InterruptedException {
		logger = report.startTest("LoginSFDC");
		OpenUrl("https://login.salesforce.com");
		Thread.sleep(2000);
		logger.log(LogStatus.INFO, "URL opened successfully");
		WebElement Uname = driver.findElement(By.xpath("//input[@id='username']"));
		EnterText(Uname, "Pooja.M@abc.com", "Username");
		
		Thread.sleep(7000);
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		EnterText(pwd, "Saanvi@2020", "Password");
		// pwd.sendKeys("Test4321");
		WebElement loginBtn = driver.findElement(By.xpath("//*[@id='Login']"));
		Click(loginBtn, "Login Button");
		// loginBtn.click();
	}
	
	@AfterTest
	public void CloseTest() {
		CloseBrowser();
		CloseReport();
	}
}
