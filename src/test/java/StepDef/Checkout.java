package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Checkout {
    WebDriver driver;

    @Given("Open browser Apps")
    public void openBrowserApps() {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        System.setProperty("webdriver.edge.driver", dir+"/driver/msedgedriver.exe");
        driver = new EdgeDriver();
    }

    @And("Open saucedemo Website")
    public void openSaucedemoWebsite() throws InterruptedException {
        driver.get("https://www.saucedemo.com");
        Thread.sleep(1000);
    }

    @And("Located on saucedemo web")
    public void locatedOnSaucedemoWeb() {
        driver.findElement(By.id("login_button_container")).isDisplayed();
    }

    @When("Users input username and Password and then login")
    public void usersInputUsernameAndPasswordAndThenLogin() {
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("login-button")).click();
    }

    @And("Users click Add to cart Button to buy one or more product")
    public void usersClickAddToCartButtonToBuyOneOrMoreProduct() {
        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();
    }

    @And("User click icon cart")
    public void userClickIconCart() {
        driver.findElement(By.id("shopping_cart_container")).click();
    }

    @And("User click checkout button")
    public void userClickCheckoutButton() {
        driver.findElement(By.name("checkout")).click();
    }

    @And("Input Firstname, Lastname and Zip Code")
    public void inputFirstnameLastnameAndZipCode() {
        driver.findElement(By.name("firstName")).sendKeys("Ryan");
        driver.findElement(By.name("lastName")).sendKeys("Hardian");
        driver.findElement(By.name("postalCode")).sendKeys("77566");
    }

    @And("Click Continue Button")
    public void clickContinueButton() {
        driver.findElement(By.name("continue")).click();
    }

    @And("Click Finish")
    public void clickFinish() {
        driver.findElement(By.id("finish")).click();
    }

    @Then("user is on checkout complete page")
    public void userIsOnCheckoutCompletePage() {
        String checkoutCompletePage;
        checkoutCompletePage = driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span")).getText();
        Assert.assertEquals(checkoutCompletePage, "Checkout: Complete!");
        driver.close();
    }
}
