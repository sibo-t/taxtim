package cucumber;

import io.github.bonigarcia.wdm.WebDriverManager;
import managers.PageObjectManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.time.Duration;

public class TestContext {
    private WebDriver driver;
    private final PageObjectManager pageObjectManager;

    public TestContext() {
        driver = getDriver();
        pageObjectManager = new PageObjectManager(driver);
        int implicitWait = 30;
        driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(implicitWait)));
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }

    private WebDriver createDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        return driver;
    }

    public WebDriver getDriver() {
        if (driver == null) driver = createDriver();
        return driver;
    }


}
