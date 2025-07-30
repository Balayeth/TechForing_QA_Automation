package Stepdefinations;

import io.cucumber.java.After;
import io.cucumber.java.Before;
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

public class Sign_Up {
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
    @Given("Go to site")
    public void go_to_site() {
       driver.get("https://career.techforing.com/");
    }
    @When("Click on Sign up button")
    public void click_on_sign_up_button() {
            driver.findElement(By.xpath("(//button[@tabindex='0'])[3]")).click();
    }
    @When("Enter the correct reCAPTCHA")
    public void enter_the_correct_re_captcha() throws InterruptedException {
            driver.findElement(By.xpath("//input[@placeholder='Enter the characters you see above']")).click();
            Thread.sleep(15000);

    }
    @When("Click on Verify Captcha button")
    public void click_on_verify_captcha_button() {
            driver.findElement(By.xpath("//button[@tabindex='0']")).click();
    }
    @When("Click on SignUp button")
    public void click_on_signup_button() throws InterruptedException {
            driver.findElement(By.xpath("(//button[@tabindex='0'])[2]")).click();
        Thread.sleep(5000);
    }
    @Then("Please fill out this field tooltip error message should not be able to sign up")
    public void please_fill_out_this_field_tooltip_error_message_should_appear_and_user_should_not_be_able_to_sign_up() throws InterruptedException {
        WebElement tooltip=driver.findElement(By.xpath("//input[@name='phone_number']"));
        WebElement focuspoint=driver.switchTo().activeElement();
        Assert.assertEquals(tooltip, focuspoint, "Please fill out this field tooltip should show");
        Thread.sleep(5000);
    }
    @When("Enter all data except email")
    public void enter_all_data_except_email() throws InterruptedException {
        driver.findElement(By.id("fullName")).sendKeys("Hasan");
        driver.findElement(By.name("phone_number")).sendKeys("01567832145");
        driver.findElement(By.xpath("//input[@type='date']")).sendKeys("12121990");
        Thread.sleep(2000);
        driver.findElement(By.id("gender")).click();
        driver.findElement(By.xpath("//li[@data-value='Male']")).click();
        Thread.sleep(2000);
    }
    @Then("This field is required error message should be shown")
    public void this_field_is_required_error_message_should_be_shown() throws InterruptedException {
         WebElement errormessage1=driver.findElement(By.id("email-helper-text"));
         Assert.assertTrue(errormessage1.isDisplayed(),"This field is required");
        Thread.sleep(2000);
    }
    @When("Enter all data")
    public void enter_all_data() throws InterruptedException {
        driver.findElement(By.id("fullName")).sendKeys("Hasan");
        driver.findElement(By.name("phone_number")).sendKeys("01567832145");
        driver.findElement(By.xpath("//input[@type='date']")).sendKeys("12121990");
        Thread.sleep(2000);
        driver.findElement(By.id("gender")).click();
        driver.findElement(By.xpath("//li[@data-value='Male']")).click();
        driver.findElement(By.id("password")).sendKeys("A2123456As");
        driver.findElement(By.name("confirm_password")).sendKeys("A2123456As");
    }
    @When("Enter an already registered email")
    public void enter_an_already_registered_email() {
            driver.findElement(By.id("email")).sendKeys("hasan.qups@gmail.com");
    }
    @Then("Error popup should appear")
    public void error_popup_should_appear() throws InterruptedException {
        WebElement errorMsg = driver.findElement(By.xpath("//div[@class='swal-title']"));
        Assert.assertTrue(errorMsg.isDisplayed(),"Error!");
        Thread.sleep(2000);
    }
    @When("Enter all data except Password")
    public void enter_all_data_except_password() throws InterruptedException {
        driver.findElement(By.id("fullName")).sendKeys("Hasan");
        driver.findElement(By.name("phone_number")).sendKeys("01567832145");
        driver.findElement(By.xpath("//input[@type='date']")).sendKeys("12121990");
        Thread.sleep(2000);
        driver.findElement(By.id("gender")).click();
        driver.findElement(By.xpath("//li[@data-value='Male']")).click();
        driver.findElement(By.id("email")).sendKeys("456@yopmail.com");
    }
    @Then("This field is required error message should be shown at the password section")
    public void this_field_is_required_error_message_should_be_shown_at_the_password_section() throws InterruptedException {
        WebElement passerror=driver.findElement(By.id("password-helper-text"));
        Assert.assertTrue(passerror.isDisplayed(),"This field is required");
        Thread.sleep(2000);
    }
    @When("Enter all required data")
    public void enter_all_required_data() throws InterruptedException {
        driver.findElement(By.id("fullName")).sendKeys("Hasan");
        driver.findElement(By.name("phone_number")).sendKeys("01567832145");
        driver.findElement(By.xpath("//input[@type='date']")).sendKeys("12121990");
        Thread.sleep(2000);
        driver.findElement(By.id("gender")).click();
        driver.findElement(By.xpath("//li[@data-value='Male']")).click();
        driver.findElement(By.id("email")).sendKeys("4567@yopmail.com");
    }
    @When("Enter a password without any uppercase letter")
    public void enter_a_password_without_any_uppercase_letter() {
        driver.findElement(By.id("password")).sendKeys("456123987");
        driver.findElement(By.name("confirm_password")).sendKeys("456123987");

    }
    @Then("Error message should be shown at the password input field")
    public void error_message_should_be_shown_at_the_password_input_field() throws InterruptedException {
        WebElement passerror2=driver.findElement(By.id("password-helper-text"));
        Assert.assertTrue(passerror2.isDisplayed(),"Password must be at least 8 characters, 1 uppercase and 1 number");
        Thread.sleep(2000);
    }
    @When("Enter a valid password")
    public void enter_a_valid_password() {
        driver.findElement(By.id("password")).sendKeys("A2123456As");
        driver.findElement(By.name("confirm_password")).sendKeys("A2123456As");
    }
    @Then("Congratulations success popup should appear")
    public void congratulations_success_popup_should_appear() throws InterruptedException {
         WebElement success=driver.findElement(By.xpath("//div[@class='swal-title']"));
         Assert.assertTrue(success.isDisplayed(),"Congratulations!");
         Thread.sleep(2000);

    }
}
