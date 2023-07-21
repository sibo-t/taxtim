package web;

import cucumber.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import rest.Preconditions;
import za.co.hotelrunner.data.DataProvider;
import za.co.hotelrunner.managers.PageObjectManager;
import za.co.hotelrunner.pages.AddonsPage;
import za.co.hotelrunner.pages.MenuPage;
import za.co.hotelrunner.utils.WebActions;

import java.time.Duration;

import static java.lang.invoke.MethodHandles.lookup;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.slf4j.LoggerFactory.getLogger;

public class AddonSteps {
    private final TestContext testContext;
    static final Logger logger = getLogger(lookup().lookupClass());
    private final WebDriver driver;
    private final PageObjectManager pageObjectManager;
    private final MenuPage menuPage;
    private final AddonsPage addonsPage;
    private final WebActions webActions;
    private String addonName;
    Preconditions preconditions;
    private String addonValue;

    public AddonSteps(TestContext context){
        testContext = context;
        driver = testContext.getDriver();
        pageObjectManager = testContext.getPageObjectManager();
        menuPage = pageObjectManager.getMenuPage();
        addonsPage = pageObjectManager.getAddonsPage();
        this.preconditions = new Preconditions();
        this.webActions = new WebActions(driver);
    }

    @Given("the user is in the addons page")
    public void theUserIsOnTheAddonsPage(){
        menuPage.clickOnAddons();
    }

    @When("the user creates an add-on with a random name")
    public void theUserCreatesAndAddonWithARandomName(){
        addonName = DataProvider.generateRandomName();
        addonsPage.createAddon(addonName, "100");
    }

    @Then("the add-on is in the add-ons list")
    public void thenTheAddonIsOnTheAddonsList(){
        assertTrue(addonsPage.isAddonPresent(addonName));
    }


    @Then("the add-on success message {string} is displayed")
    public void theAddOnSuccessMessageIsDisplayed(String expectedMessage) {
        assertTrue(expectedMessage + ": not shown", addonsPage.isTopBarMessageDisplayed(expectedMessage));
    }

    @When("the user deletes the add-on")
    public void theUserDeletesTheAddOn() {
        addonsPage.deleteAddon(addonName);
    }

    @Then("the add on is not in the add-ons list")
    public void theAddOnIsNotInTheListOfAddOns(){
        assertFalse(addonName + " still appears on add-ons list",addonsPage.isAddonPresent(addonName));
    }


    @Given("A random addon with price {string} is created")
    public void aRandomAddonWithPriceIsCreated(String price) {
        this.addonName = preconditions.createAnAddonWithPrice(price);
    }

    @When("the user updates the random add-on with the following field {string}, value {string}")
    public void theUserUpdatesTheRandomAddOnWithTheFollowingFieldValue(String field, String value) {
        this.addonValue = value;
        if(field.equals("name") && value.equals("random_name")){
            this.addonValue = DataProvider.generateRandomName();
        }

        addonsPage.updateAddon(addonName, field, addonValue);
    }

    @Then("the updated add-on value {string} is now {string} displayed")
    public void theUpdatedAddOnValueIsNowDisplayed(String field, String value) {
        String expectedValue=value;
        if(field.equals("name") && value.equals("random_name")){
            expectedValue = addonValue;
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By overlayLocator = By.cssSelector(".overlay");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(overlayLocator));
        assertEquals("The field "+expectedValue+" was not updated", expectedValue, addonsPage.getAddonField(addonName, field));
    }
}
