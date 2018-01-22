package drivers;


import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverImplementation {
	
	public static RemoteWebDriver driver;
	//protected static Properties prop;
	public String sUrl;
	ResourceBundle config;
	String browser;
	
	public DriverImplementation(String browser) {
        this.browser = browser;
        config = ResourceBundle.getBundle("utils.config");
        sUrl = config.getString("URL");
    }
	
	public DriverImplementation() {
        
    }
	
	public void invokeApp(){
	
	DesiredCapabilities dc = new DesiredCapabilities();
	dc.setBrowserName(browser);
	dc.setPlatform(Platform.WINDOWS);

	// this is for grid run
	if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}else{
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.get(sUrl);
	}
	
	public void closeBrowser() {
		driver.quit();
	}


}
