package stepDef;

import java.time.Instant;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utility.Constant;

public class Hook {
	public static WebDriver driver;
	

	@Before("@start")
	public void setUp() throws Exception {

		System.out.println("---------Browser is opening--------");
	

		System.out.println("\n" + Instant.now().toString() + " Initializing the setup");

		String os = System.getProperty("os.name").toLowerCase();
		System.out.println("\nOS :- "+os);
		
		if(os.equalsIgnoreCase("windows 10")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver_windows//chromedriver96.exe");
		} else if(os.equalsIgnoreCase("mac os x")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/java/drivers/chromedriver_3");
		} else {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Drivers/chromedriver_linux/chromedriver");
		}
		
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments(Constant.START_MAXIMIZED);
		options.addArguments(Constant.DISABLE_INFOBAR);
		options.setExperimentalOption(Constant.USE_AUTOMATION_EXTENTION, false);
		options.setExperimentalOption(Constant.EXCLUDE_SWITCHES, Collections.singletonList(Constant.ENABLE_AUTOMATION));
		options.addArguments(Constant.NO_SANDBOX);

		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put(Constant.CREDENTIALS_ENABLE_SERVICE, false);
		prefs.put(Constant.PASSWORD_MANAGER_ENABLED, false);

		options.setExperimentalOption(Constant.PREFS, prefs);

		driver = new ChromeDriver(options);
		
		Properties prop=new Properties();
		
		driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(Constant.WEB_URL);

	
	}

	/**
	 * This method is used get WebDriver object in whole project
	 * 
	 * @return
	 */

	public static WebDriver getDriver() {
		return driver;
	}

	@After("@stop")
	public void closeBrowser() throws Exception {
		driver.quit();
	}

}
