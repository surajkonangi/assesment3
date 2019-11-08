package com.atmecs.AssesmentAutomationProject.utils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.atmecs.AssesmentAutomationProject.utils.ConstantPaths;
import com.atmecs.AssesmentAutomationProject.utils.LogReports;
import com.atmecs.AssesmentAutomationProject.utils.Readproperties;

public class TestBase {

	public WebDriver driver;
	LogReports log = new LogReports();

	@SuppressWarnings("deprecation")
	//@Parameters("browsername")
	@BeforeTest
	public void invokeBrowser() throws IOException {
         String modeofrunning="browser";
         if(modeofrunning.equalsIgnoreCase("grid")) {
        	 //driver =SeleniumGrid.getGrid(browsername);
        	 //System.out.println(driver);
         }
	      
         else { 
        	 String browsername = Readproperties.readPropertiesFile("Browser", ConstantPaths.CONFIG_FILE);
		if (browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ConstantPaths.CHROME_FILE);
			driver = new ChromeDriver();
			log.info("Chrome browser launched...");

		} else if (browsername.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ConstantPaths.FIREFOX_FILE);
			driver = new FirefoxDriver();
			log.info("Firefox browser launched...");

		} else if (browsername.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", ConstantPaths.IE_FILE);
			DesiredCapabilities ieCaps = DesiredCapabilities.internetExplorer();
			ieCaps.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "");
			driver = new InternetExplorerDriver(ieCaps);
			log.info("IE browser started...");
		}
		//driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.MINUTES);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		log.info("Application is open...");
	}

//	@AfterSuite
//	public void closeBrowser() {
//		driver.quit();
//	}

}
}