package Stepdefinations;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.time.Duration;

public class Sign_In {
    private WebDriver driver;

    @Before
    public void setup() throws InterruptedException {

        System.setProperty("WebDriver.chrome.driver", System.getProperty("user.dir") + "src/main/java/driver/chromedriver.exe");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Given("Go to the site")
    public void go_to_the_site(){
       driver.get("https://career.techforing.com/");
    }
    @When("Click on Sign In button")
    public void click_on_sign_in_button() throws InterruptedException {
        driver.findElement(By.xpath("(//button[@tabindex='0'])[2]")).click();
        Thread.sleep(3000);
    }
    @And("At sign in tab, click on sign in button without entering any data")
    public void at_sign_in_tab_click_on_sign_in_button_without_entering_any_data() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
    @Then("Error message should be shown at email text field")
    public void error_message_should_be_shown_at_email_text_field(){
        WebElement emailerror=driver.findElement(By.id("email-helper-text"));
        Assert.assertTrue(emailerror.isDisplayed(),"This field is required");

    }
    @And ("Error message should be shown at password text field")
    public void error_message_should_be_shown_at_password_text_field(){
        WebElement passerr=driver.findElement(By.id("password-helper-text"));
        Assert.assertTrue(passerr.isDisplayed(),"This field is required");
    }

    @And("Enter not registered email")
    public void enter_not_registered_email(){
        driver.findElement(By.id("email")).sendKeys("jhgf@yopmail.com");
    }
    @And ("Enter a password")
    public void enter_a_password(){
        driver.findElement(By.id("password")).sendKeys("123456789Asd");
    }

    @And("Click on the sign in button")
    public void click_on_the_sign_in_button(){
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("No active account found with the given credential error message should appear")
    public void no_active_account_found_with_the_given_credential_error_message_should_appear(){
        WebElement notvalid =driver.findElement(By.xpath("//div[@class='MuiBox-root css-1lgcgsy']"));
        Assert.assertTrue(notvalid.isDisplayed(),"No active account found with the given credentials");
    }
    @And("Enter registered email")
    public void enter_registered_email(){
        driver.findElement(By.id("email")).sendKeys("hello1@yopmail.com");
    }
    @And("Enter a wrong password")
    public void enter_a_wrong_password(){
        driver.findElement(By.id("password")).sendKeys("123456789Asd");
    }
    @And("Enter the right password")
    public void enter_the_right_password(){
        driver.findElement(By.id("password")).sendKeys("12345678Asdf");
    }
    @Then("User should be signed in")
    public void user_should_be_signed_in(){
        WebElement login =driver.findElement(By.xpath("//div[@class='MuiAlert-message css-1xsto0d']"));
        Assert.assertTrue(login.isDisplayed(),"Please enter your education information or upload resume before applying otherwise you can't apply!");
    }
}
