package StepDefinition;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageFactory.HomePage;
import PageFactory.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class loginSteps   {
	public WebDriver driver=null;
	public LoginPage login;
	public HomePage home;

	@Given("Browser is open")
	public void setup() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
	}


	@And("I am on login page")
	public void i_am_on_login_page() {
		driver.get("https://practicetestautomation.com/practice-test-login/");
	}


	@When("^I enter (.*) and (.*)$")
	public void i_enter_student_and_password123(String username, String password) {
		login =new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
	}

	@And("I hit submit button")
	public void i_hit_submit_button() {
		login.clickOnSubmit();	    
	}

	@Then("I am navigated to home page")
	public void i_am_navigated_to_home_page() {
		home=new HomePage(driver);
		String actualPageTitle=driver.getTitle();
		String expectedPageTitle="Logged In Successfully | Practice Test Automation";
		Assert.assertEquals(expectedPageTitle,actualPageTitle);
		home.hitLogout();
	}


	@Then("I get error message- Your username is invalid")
	public void i_get_error_message_Your_username_is_invalid() throws InterruptedException{
		String actualErrorText=login.getUserErrorText();
		Thread.sleep(200);
		String expectedErrorText="Your username is invalid!"; //"Your username is invalid!" text is not available/reachable other than text() locator with xpath
		Assert.assertEquals(expectedErrorText, actualErrorText);
		
	}
	@Then("I get error message- Your password is invalid")
	public void i_get_error_message_Your_password_is_invalid() throws InterruptedException {
		String actualErrorText=login.getPasswordErrorText();
		Thread.sleep(200);
		String expectedErrorText="Your password is invalid!"; //"Your password is invalid!" text is not available/reachable
		Assert.assertEquals(expectedErrorText, actualErrorText);
	}

	@And ("I click X button to close page")
	public void teardown() {
		driver.close();
		driver.quit();
	}
}
