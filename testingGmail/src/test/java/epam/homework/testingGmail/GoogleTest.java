package epam.homework.testingGmail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import epam.homework.driverFactory.DriverFactory;


public class GoogleTest {
	public WebDriver driver;
	MailMainPage mpage;
	MailInbox inboxPage;

	public final String PAGE_TITLE = "Gmail";
	public final String PAGE_URL = "https://mail.google.com/";

	@BeforeClass(alwaysRun = true)
	@Parameters("browser")
	public void setUp(String browser) throws Exception {
		driver = DriverFactory.getInstance(browser);
//		driver= new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(PAGE_URL);
		mpage = PageFactory.initElements(driver, MailMainPage.class);
		Assert.assertEquals(driver.getTitle(), PAGE_TITLE);

	}

	@Test (priority=1)
	public void loadPage() throws InterruptedException {
		inboxPage = mpage.loginPage("marickaporicka", "marika38");
		Assert.assertTrue(inboxPage.writeButton.isDisplayed());

	}

	@Test (priority=2)
	public void markAsImportant() {
		inboxPage.markImp();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Assert.assertEquals(inboxPage.goToImportant().checkNumberOfImportantMsg(inboxPage.msg),3);

	}
	 @Test (priority=3)
	 public void deleteMsg() {
	 inboxPage.deleteMsg();
	 Assert.assertEquals(inboxPage.checkNumberOfImportantMsg(inboxPage.msg),0);
	 }

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}