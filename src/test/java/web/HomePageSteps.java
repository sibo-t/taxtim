package web;

import cucumber.TestContext;
import io.cucumber.java.en.Given;
import managers.PageObjectManager;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import page.HomePage;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

public class HomePageSteps {
    private final TestContext testContext;
    static final Logger logger = getLogger(lookup().lookupClass());
    private final WebDriver driver;
    private final PageObjectManager pageObjectManager;
    private final HomePage homePage;


    public HomePageSteps(TestContext context){
        testContext = context;
        driver = testContext.getDriver();
        pageObjectManager = testContext.getPageObjectManager();
        homePage = pageObjectManager.getHomePage();
    }

    @Given("the user gross salary is {string}")
    public void aUserGrossSalary(String price) {

    }

    @Given("the user sets tax year {string}")
    public void aUserTaxYear(String year) {

    }

    @Given("the salary is received {string}")
    public void aUsersSalaryFrequency(String year) {

    }
}
