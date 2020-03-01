import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReUsMethods {
	
	static ExtentTest logger;
	static ExtentReports report;
	static WebDriver driver;

	public static void InitializeDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	public static void OpenUrl(String url) {
		driver.get(url);
		// driver.manage().window().maximize();
	}

	public static void CloseBrowser() {
		driver.quit();
	}

	public static void CloseReport() {
		report.flush();
	}
	
	public static void SwitchFrame(String id) {
		driver.switchTo().frame(id);
		logger.log(LogStatus.INFO, id + "frame is switched");
	}
	
	public static void SwitchFrame(WebElement element) {
		driver.switchTo().frame(element);
		logger.log(LogStatus.INFO, element + "frame is switched");
	}
	
	public static void SwitchFrame() {
		driver.switchTo().defaultContent();
		logger.log(LogStatus.INFO,  "frame is switched");
		
	}
     
	public static void MouseOver(WebDriver driver, WebElement obj) {
		if(obj.isDisplayed()) {
			Actions action = new Actions(driver);
			action.moveToElement(obj).build().perform();
			logger.log(LogStatus.PASS, obj + " is present");
		}else {
			logger.log(LogStatus.FAIL, obj + " is not present, please check application");
		}
		
	}
	/*
	 * name of the Method: CreateReport
	 * BriedDescriotion  : This will create a empty Extent Report.
	 * Arguments		 : No Arguments
	 * Created By 		 : Automation Team
	 * created Date		 : 14/02/2020
	 * Last Modified	 : 14/02/2020
	 */
	public static void CreateReport() {
		String fileName = new SimpleDateFormat("'SFDCReport_'YYYYMMddHHmm'.html'").format(new Date());
		String path = "C:\\Users\\sujit\\" + fileName;
		report = new ExtentReports(path);
	}

	/* name of the method:   EnterText
	 * BriefDescription  :   entering textvalue for textbox
	 * Arguments         :  element --->object
	 *                      text    --->to be entered 
	 *                      objName --->object name
	 *  createdby        :  Automation team 
	 *  created date     :  14/02/20209 
	 *  LastModified Date:  14/02/2020          
	 */
	public static void EnterText(WebElement element, String text, String objName) {
		if (element == null || !element.isDisplayed()) {
			logger.log(LogStatus.ERROR, objName + " Textbox is not found.");
		} else {
			logger.log(LogStatus.INFO, objName + " Textbox is found");
			element.sendKeys(text);
		}
	}

	public static void Click(WebElement element, String objName) {
		if (element == null || !element.isDisplayed()) {
			logger.log(LogStatus.ERROR, objName + " Element is not found.");
		} else {
			logger.log(LogStatus.INFO, objName + " Element is found");
			element.click();
		}
	}
    
	public static void SelectDropDown(WebElement element, String objName) {
		if (element == null || !element.isDisplayed()) {
			logger.log(LogStatus.ERROR, objName + " Element is not found.");
		} else {
			logger.log(LogStatus.INFO, objName + " Element is found");
			element.click();
		}
	}
}