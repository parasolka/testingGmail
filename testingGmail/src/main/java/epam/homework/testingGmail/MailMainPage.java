package epam.homework.testingGmail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class MailMainPage extends Page {
	@FindBy(css= "#Email") WebElement emailLogin;
	@FindBy(css="#next") WebElement nextbutton;
	@FindBy(css=".circle") WebElement UserSign;
	@FindBy(css="input#Passwd[name='Passwd']") WebElement password;
	@FindBy(xpath=".//*[@id='signIn']") WebElement loginBtn;
	public MailMainPage(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}



	public MailInbox loginPage(String loginName,String UserPassword) throws InterruptedException{

		emailLogin.sendKeys(loginName);
		nextbutton.click();
		webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		password.sendKeys(UserPassword);	
		loginBtn.click();
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return PageFactory.initElements(webDriver, MailInbox.class);
	}


}
