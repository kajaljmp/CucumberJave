package StepDefinition;

import java.time.Duration;
//import java.util.List;
//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//import io.cucumber.core.gherkin.vintage.internal.gherkin.ast.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Estimate {
	WebDriver driver = new ChromeDriver();
	@Given("^User navigates to home page \"([^\"]*)\"$") 
	public void user_navigates_to_home_page(String Ar1) throws Throwable{
		System.setProperty("Webdriver.chrome.driver","C:\\kajal\\path\\chrome.exe");
		driver.get(Ar1);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.manage().window().maximize();
	}

	@When("user enters Specific Your Application Type and type of property")
	public void user_enters_Specific_Your_Application_Type_and_type_of_property()throws Throwable{
	WebElement Single =	driver.findElement(By.xpath("//*[@id='application_type_single']"));
	WebElement home = driver.findElement(By.xpath("//*[@id='borrow_type_home']"));
		
		if (Single.isSelected()== true)
			{	System.out.println("Application type single is selected");
		
			}
		else
			{
			Single.click();
			}
		if (home.isSelected()== true)
			{	
				System.out.println("Property type Home to live in is selected");
		
			}
		else
			{
			home.click();
			}
}

		@When("User enters number of dependants as {int}")
		public void user_enters_number_of_dependants_as(Integer STR1)throws Throwable {

			WebElement drop = driver.findElement(By.xpath("//select[@title='Number of dependants']"));
			Select sel= new Select(drop);
			sel.selectByIndex(STR1);

		}
		
		@When("^Income \"([^\"]*)\" and other income \"([^\"]*)\" and Living Expenses \"([^\"]*)\" and Home loan repayment \"([^\"]*)\" and other loan repayment \"([^\"]*)\" and other commitment \"([^\"]*)\" and credit card limit \"([^\"]*)\"$")
		public void income_and_other_income_and_Living_Expenses_and_Home_loan_repayment_and_other_loan_repayment_and_other_commitment_and_credit_card_limit(String str3, String str4, String str5, String str6, String str7, String str8, String str9)throws Throwable {
			driver.findElement(By.xpath("//input[@aria-labelledby='q2q1']")).sendKeys(str3);
			driver.findElement(By.xpath("//input[@aria-labelledby='q2q2']")).sendKeys(str4);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
			driver.findElement(By.xpath("//input[@aria-labelledby='q3q1']")).sendKeys(str5);
		    driver.findElement(By.xpath("//input[@aria-labelledby='q3q2']")).sendKeys(str6);
		    driver.findElement(By.xpath("//input[@aria-labelledby='q3q3']")).sendKeys(str7);
		    driver.findElement(By.xpath("//input[@aria-labelledby='q3q4']")).sendKeys(str8);
		    driver.findElement(By.xpath("//input[@aria-labelledby='q3q5']")).sendKeys(str9);
			
		}

		@When("clicks on Borrow")
		public void clicks_on_Borrow() {
			driver.findElement(By.id("btnBorrowCalculater")).click();

		}

		@Then("Gets Estimate")
		public void gets_Estimate() {
			
		String borrowEst = driver.findElement(By.className("borrow__result__text")).getText();
		
		String ExpectedEst = "479000";
		  if(ExpectedEst==borrowEst) {
			  System.out.println("Test passes");
		  }
			  else
			  {
				  System.out.println("caluculated amount is different than Expected");
		  }
		  
		  
		    driver.findElement(By.className("start-over")).click();




	}

			@Then("Return error message")
			public void return_message() {
			    System.out.println(driver.findElement(By.className("borrow__error__text")).getText());

			}
				
			}
