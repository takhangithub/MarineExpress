package CargoOperation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static CargoOperation.CargoOperationLocators.cargo_Allocation_Tab;
import static CargoOperation.CargoOperationLocators.cargo_Operation_Menu;


public class CargoAllocation {

    private static WebDriverWait wait;
    private static WebDriver driver;

    public static void main(String[] args){

        cargo_OperationMenu();
        CargoBooking.cargoBooking();
        cargo_Allocation();
    }

    public static void cargo_OperationMenu(){

        fleetManagement.DriverManager.initDriver(CargoOperationData.web_Driver);
        wait = fleetManagement.DriverManager.getWait();
        driver = fleetManagement.DriverManager.getDriver();
        fleetManagement.DriverManager.navigateURL(CargoOperationData.marineExpress_URL);
        WebElement cargoOperationMenu = wait.until(ExpectedConditions.elementToBeClickable(cargo_Operation_Menu));
        cargoOperationMenu.click();
    }

    public static void cargo_Allocation(){

        WebElement cargoAllocationTab = wait.until(ExpectedConditions.visibilityOfElementLocated(cargo_Allocation_Tab));
        cargoAllocationTab.click();

        WebElement cargoIDList = wait.until(ExpectedConditions.visibilityOfElementLocated(CargoOperationLocators.cargo_ID_List));
        Select select = new Select(cargoIDList);
        select.selectByIndex(1);

        WebElement selectVessel = driver.findElement(CargoOperationLocators.select_Vessel);
        Select select1 = new Select(selectVessel);
        select1.selectByIndex(1);

        WebElement loadingDate = driver.findElement(CargoOperationLocators.LoadingDate);
        loadingDate.sendKeys(CargoOperationData.Data_Loading_Date);

        WebElement arrivalDate = driver.findElement(CargoOperationLocators.ExpArrival);
        arrivalDate.sendKeys(CargoOperationData.Data_Estimated_Arrival);

        WebElement allocateCargo = driver.findElement(CargoOperationLocators.AllocateButton);
        allocateCargo.click();

    }
}
