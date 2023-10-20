package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Login {
    WebDriver driver;

    @Given("Open browser")
    public void openBrowser() {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        System.setProperty("webdriver.edge.driver", dir+"/driver/msedgedriver.exe");
        driver = new EdgeDriver();
    }

    @And("Open saucedemo Web App")
    public void openSaucedemoWebApp() throws InterruptedException {
        driver.get("https://www.saucedemo.com");
        Thread.sleep(1000);
    }

    @And("Located on saucedemo website")
    public void locatedOnSaucedemoWebsite() {
        driver.findElement(By.id("login_button_container")).isDisplayed();
    }

    @When("The Users input with registered username")
    public void theUsersInputWithRegisteredUsername() {
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
    }

    @And("The Users input with registered Password")
    public void theUsersInputWithRegisteredPassword() {
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
    }

    @And("The User click button Login")
    public void theUserClickButtonLogin() {
        driver.findElement(By.name("login-button")).click();
    }

    @Then("user is on dashboard page")
    public void userIsOnDashboardPage() {
        String dashboardPageAssert = driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span")).getText();
        Assert.assertEquals(dashboardPageAssert, "Products");
        driver.close();
    }

    @When("The Users input with random or unregistered username")
    public void theUsersInputWithRandomOrUnregisteredUsername() {
        driver.findElement(By.name("user-name")).sendKeys("test_user");
    }

    @And("The Users input with random or unregistered password")
    public void theUsersInputWithRandomOrUnregisteredPassword() {
        driver.findElement(By.name("password")).sendKeys("secret_number");
    }

    @Then("user get error message")
    public void userGetErrorMessage() {
        String ErrorLogin;
        ErrorLogin = driver.findElement(By.xpath("//*[@id='login_button_container']/div/form/div[3]")).getText();
        Assert.assertEquals(ErrorLogin, "Epic sadface: Username and password do not match any user in this service");
        driver.close();
    }
}
