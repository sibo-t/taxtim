package managers;

import org.openqa.selenium.WebDriver;
import page.HomePage;

public class PageObjectManager {

    private final WebDriver driver;
    private HomePage homePage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage(){
        if (homePage == null){
            homePage = new HomePage(driver);
        }
        return homePage;
    }
}