package cucumber;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import za.co.hotelrunner.managers.PageObjectManager;
import za.co.hotelrunner.utils.ConfigFileReader;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class TestContext {
    private WebDriver driver;
    private final PageObjectManager pageObjectManager;
    private final ConfigFileReader configFileReader;

    private String emailAddress;
    private final Map<String, Object> sharedData;

    public TestContext() {
        driver = getDriver();
        pageObjectManager = new PageObjectManager(driver);
        configFileReader = new ConfigFileReader();
        int implicitWait = Integer.parseInt(configFileReader.getConfig("implicitlyWait"));
        driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(implicitWait)));
        sharedData = new HashMap<>();
    }


    public ConfigFileReader getConfigFileReader() {
        return configFileReader;
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }

    private WebDriver createDriver(){
        switch (System.getProperty("browser").toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                //the sandbox removes unnecessary privileges from the processes that don't need them in Chrome, for security purposes. Disabling the sandbox makes your PC more vulnerable to exploits via webpages, so Google don't recommend it.
                options.addArguments("--no-sandbox");
                //"--disable-dev-shm-usage" Only added when CI system environment variable is set or when inside a docker instance. The /dev/shm partition is too small in certain VM environments, causing Chrome to fail or crash.
                options.addArguments("--disable-dev-shm-usage");
                if(!System.getProperty("os.name").contains("Windows")){
                    options.addArguments("--headless");
                }
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                break;
        }
        driver.manage().window().maximize();
        return driver;
    }

    public WebDriver getDriver() {
        if (driver == null) driver = createDriver();
        return driver;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setSharedData(String reference, Object value){
        this.sharedData.put(reference, value);
    }

    public Map<String, Object> getSharedData(){
        return this.sharedData;
    }

}
