package epam.homework.testingGmail;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailInbox extends Page {

	@FindBy(xpath = ".//*[@id=':4i']/div/div")
	WebElement writeButton;
	@FindBy(xpath = ".//*[@id=':3f']")
	WebElement checkBox1;
	@FindBy(xpath = ".//*[@id=':3p']")
	WebElement checkBox2;
	@FindBy(xpath = ".//*[@id=':3z']")
	WebElement checkBox3;
	@FindBy(xpath = ".//*[@id=':3a']")
	WebElement moreBtn;

	@FindBy(css = "span.CJ")
	WebElement moreOption;
	@FindBy(xpath = ".//*[@title='Важливі']")
	WebElement folderimportant;

	@FindBy(css = "span.bofITb")
	WebElement chain;
	@FindBy(xpath = ".//*[@class='av'][text()=\"Вхідні\"]")
	List<WebElement> msg;

	@FindBy(xpath = ".//*[@id='gbqfq']")
	WebElement inputSearch;

	@FindBy(xpath = "(.//*[@class='G-Ni J-J5-Ji']/div[@aria-label='Вибрати'])[2]")
	WebElement ch2;

	@FindBy(xpath = "((.//*[@class='asa'])/div[@class='ar9 T-I-J3 J-J5-Ji'])[2]")
	WebElement deleteBtn;

	public MailInbox(WebDriver webDriver) {
		super(webDriver);
	}

	public void markImp() {
		checkBox1.click();
		checkBox2.click();
		checkBox3.click();
		moreBtn.sendKeys(Keys.ARROW_DOWN);
		moreBtn.sendKeys(Keys.ARROW_DOWN);
		moreBtn.sendKeys(Keys.ENTER);
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	public  MailInbox goToImportant() {
		moreOption.click();
		folderimportant.click();
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return this;
	}
	public int checkNumberOfImportantMsg(List<WebElement> messages){
		return messages.size();
	}
	public MailInbox deleteMsg(){
		deleteBtn.click();
		return this;
	}


}
