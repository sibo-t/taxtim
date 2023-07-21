package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
    WebDriver driver;
    By bySelectTaxYear = By.id("yearsel");
    By byGross = By.id("//input[@id='gross']");
    By byPeriod = By.id("period");
    By byAge = By.id("age");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectTaxYear(String year){
        WebElement selectElement = driver.findElement(bySelectTaxYear);
        Select select = new Select(selectElement);
        // Select an option by visible text
        select.selectByValue(year);
    }

    public void selectPeriod(String period){
        WebElement selectElement = driver.findElement(byPeriod);
        Select select = new Select(selectElement);
        // Select an option by visible text
        select.selectByValue(period);
    }



}
