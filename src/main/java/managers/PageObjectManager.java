package za.co.hotelrunner.managers;

import org.openqa.selenium.WebDriver;
import za.co.hotelrunner.pages.*;

public class PageObjectManager {

    private final WebDriver driver;
    private LoginPage loginPage;
    private PortalPage portalPage;
    private RoomPage roomPage;
    private HomePage homePage;
    private MenuPage menuPage;
    private RegistrationPage registrationPage;
    private EmployeePage employeePage;
    private AddonsPage addonsPage;
    private ReservationPage reservationPage;
    private NewReservationPage newReservationPage;
    private ReservationDetailsPage reservationDetailsPage;

    /** 
    * This is a constructor for the `PageObjectManager` class that takes a `WebDriver` object as a
    *parameter and assigns it to the `driver` instance variable. This allows the `PageObjectManager`
    * to have access to the `WebDriver` instance and use it to interact with web pages.
    */
    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

   /**
    * The function returns an instance of the LoginPage class, creating a new instance if one does not
    * already exist.
    * 
    * @return The method is returning an instance of the LoginPage class.
    */
    public LoginPage getLoginPage() {
        if (loginPage == null){
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }
/**
 * The function returns a PortalPage object, creating a new one if it doesn't already exist.
 * 
 * @return A PortalPage object is being returned.
 */
    public PortalPage getPortalPage() {
        if (portalPage == null){
            portalPage = new PortalPage(driver);
        }
        return portalPage;
    }

   /**
    * The function returns an instance of the RoomPage class, creating a new one if it doesn't already
    * exist.
    * 
    * @return The method is returning an instance of the RoomPage class.
    */
    public RoomPage getRoomPage() {
        if (roomPage == null){
            roomPage = new RoomPage(driver);
        }

        return roomPage;
    }

   /**
    * The function returns an instance of the HomePage class, creating a new one if it doesn't already
    * exist.
    * 
    * @return The method is returning an instance of the HomePage class.
    */
    public HomePage getHomePage() {
        if (homePage == null){
            homePage = new HomePage(driver);
        }
        return homePage;
    }

  /**
   * The function returns an instance of the MenuPage class, creating a new one if it doesn't already
   * exist.
   * 
   * @return The method `getMenuPage()` is returning an instance of the `MenuPage` class.
   */
    public MenuPage getMenuPage() {
        if (menuPage == null){
            menuPage = new MenuPage(driver);
        }
        return menuPage;
    }
    
/**
 * The function returns a RegistrationPage object and creates a new one if it doesn't exist.
 * 
 * @return The method is returning an instance of the RegistrationPage class.
 */
    public RegistrationPage getRegistrationPage() {
        if (registrationPage == null){
            registrationPage = new RegistrationPage(driver);
        }
        return registrationPage;
    }

    public EmployeePage getEmployeePage() {
        if (employeePage == null){
            employeePage = new EmployeePage(driver);
        }
        return employeePage;
    }

    public AddonsPage getAddonsPage() {
        if (addonsPage == null){
            addonsPage = new AddonsPage(driver);
        }
        return addonsPage;
    }

    public ReservationPage getReservationPage() {
        if (reservationPage == null){
            reservationPage = new ReservationPage(driver);
        }
        return reservationPage;
    }

    public NewReservationPage getNewReservationPage() {
        if (newReservationPage == null){
            newReservationPage = new NewReservationPage(driver);
        }
        return newReservationPage;
    }

    public ReservationDetailsPage getReservationDetailsPage(){
        if (reservationDetailsPage == null){
            reservationDetailsPage = new ReservationDetailsPage(driver);
        }
        return reservationDetailsPage;
    }
}