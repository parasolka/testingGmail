package epam.homework.driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	private static final String CHROME = "chrome";
	private static final String FIREFOX = "firefox";
	private static WebDriver driver;

	private DriverFactory() {

	}

	public static WebDriver getInstance(String browser) throws Exception {
		if (driver == null) {
			if (CHROME.equals(browser)) {
				String chromeBinaryPath = new String("resources/chromedriver.exe");
				System.setProperty("webdriver.chrome.driver", chromeBinaryPath);
				driver = new ChromeDriver();
			} else if (FIREFOX.equals(browser)) {
				driver = new FirefoxDriver();
			} else
				throw new Exception("Invalid browser property set in configuration file");
		}
		return driver;
	}

}
