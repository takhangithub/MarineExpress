package CargoOperation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CargoBooking {

    private static String webDriver = "Chrome";
    private static WebDriverWait wait;
    private static WebDriver driver;


    public static void main(String[] args){

        cargo_OperationMenu();

        cargoBooking();

    }

    public static void cargo_OperationMenu(){

        fleetManagement.DriverManager.initDriver(webDriver);
        wait = fleetManagement.DriverManager.getWait();
        driver = fleetManagement.DriverManager.getDriver();
        fleetManagement.DriverManager.navigateURL(CargoOperationData.marineExpress_URL);
        WebElement cargoOperationMenu = wait.until(ExpectedConditions.elementToBeClickable(CargoOperationLocators.cargo_Operation_Menu));
        cargoOperationMenu.click();
    }

    public static void cargoBooking(){

        wait = fleetManagement.DriverManager.getWait();
        driver = fleetManagement.DriverManager.getDriver();

        WebElement cargoBookingMenu = wait.until(ExpectedConditions.elementToBeClickable(CargoOperationLocators.cargo_Booking_Tab));
        cargoBookingMenu.click();

        WebElement cargoType = wait.until(ExpectedConditions.visibilityOfElementLocated(CargoOperationLocators.cargo_Type));
        //WebElement cargoType = driver.findElement(CargoOperationLocators.cargo_Type);
        Select select = new Select(cargoType);
        select.selectByValue(CargoOperationData.Data_cargo_Type);

        WebElement cargoWeight = driver.findElement(CargoOperationLocators.cargo_Weight);
        cargoWeight.sendKeys(CargoOperationData.Data_Cargo_Weight);

        WebElement cargoOrigin = driver.findElement(CargoOperationLocators.cargo_Origin);
        cargoOrigin.sendKeys(CargoOperationData.Data_Cargo_Origin);

        WebElement cargoDestination = driver.findElement(CargoOperationLocators.cargo_Destination);
        cargoDestination.sendKeys(CargoOperationData.Data_Cargo_Destination);

        WebElement bookCargoButton = driver.findElement(CargoOperationLocators.bookCargo_Button);
        bookCargoButton.click();

        WebElement cargo_ID = driver.findElement(CargoOperationLocators.cargo_ID);
        CargoOperationData.Data_Cargo_ID = cargo_ID.getText();
        System.out.println(CargoOperationData.Data_Cargo_ID);
    }

}
