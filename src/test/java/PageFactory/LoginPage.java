package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private WebDriver driver;

	//Arrage
	@FindBy(id="username")private WebElement text_username;
	@FindBy(id="password")private WebElement text_password;
	@FindBy(id="submit")private WebElement btn_submit;
	@FindBy(xpath="//div[text()='Your username is invalid!']")private WebElement userErrorText;
	@FindBy(xpath="//div[text()='Your password is invalid!']")private WebElement passwordErrorText;

	public LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}



	//Act
	public void enterUsername(String username) {
		text_username.sendKeys(username);
	}

	public void enterPassword(String password) {
		text_password.sendKeys(password);
	}

	public void clickOnSubmit() {
		btn_submit.click();	
	}
	public String getUserErrorText() {
		String text= userErrorText.getText();
		System.out.println("ErrorText:"+text);
		return text;
	}
	public String getPasswordErrorText() {
		String text= passwordErrorText.getText();
		System.out.println("ErrorText:"+text);
		return text;
	}

}
