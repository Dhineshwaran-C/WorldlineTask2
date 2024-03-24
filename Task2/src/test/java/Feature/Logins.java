package Feature;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Logins {
	 WebDriver driver;
	 
	 @Given("User is on Home Page")
	 public void open_chrome_and_open_application() {
		 System.setProperty("webdriver.chrome.driver","G:\\worldline\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://practice.expandtesting.com/");
	 }
	 
	 @When("User navigate to Login Page")
	 public void login_page() {
		 WebElement login = driver.findElement(By.xpath("(//a[normalize-space()='Login Form'])[1]"));
		 login.click();
		 String expectedURL = "https://practice.expandtesting.com/login";
		 String actualURL = driver.getCurrentUrl();
		 Assert.assertEquals(expectedURL,actualURL);
	 }
	 
	 @Then("User enters {string} and {string}")
	 public void enter_username_and_password(String usernames,String passwords) {
		 WebElement user = driver.findElement(By.name("username"));
		 user.sendKeys(usernames);
		 WebElement pass = driver.findElement(By.name("password"));
		 pass.sendKeys(passwords);
	 }
	 
	 @And("Keeping case {string} as Valid")
	 public void valid(String cases) {
		 if(cases.equals("Valid")) {
			 System.out.println("It is a Valid User");
		 }
		 else {
			 System.out.println("It is and InValid User");
		 }
	 }
	 
	 @Then("User should get logged in")
	 public void login_with_credentials()  {
		 WebElement l = driver.findElement(By.xpath("(//button[normalize-space()='Login'])[1]"));
		 l.click();
	 }
	 
	 @And("Message displayed Login Successfully or not")
	 public void login_success() throws InterruptedException {
		 Thread.sleep(2000);
		 String expectedURL = "https://practice.expandtesting.com/secure";
		 String actualURL = driver.getCurrentUrl();
		 if (expectedURL.equals(actualURL)) {
			    System.out.println("Login Successful");
			} else {
			    System.out.println("Login Failed");
			}
	 }
	 
	 @Then("Keeping case {string} as InValid")
	 public void invalid(String cases) {
		 if(cases.equals("Valid")) {
		 System.out.println("It is a Valid User");
		 }
		 else {
			 System.out.println("It is and InValid User");
		 }
	 }
	 
	 @And("user will be asked to go back to login page if user is InValid {string}")
	 public void login_again(String cases) {
		 if(cases.equals("Valid")) {
			 System.out.println("User will not be asked to go back to login page");
		 }
		 else {
			 driver.navigate().refresh();
			 System.out.println("User went back to login page");
		 }
	 }
	 
	 @Then("Provide correct credentials if user is InValid {string}")
	 public void provide_valid_user(String cases) {
		 if(cases.equals("Valid")) {}
		 else {
			 System.out.println("Provide Valid Credentials");
		 }
		 driver.quit();
	 }
}
