package DeviantArt;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HeaderMenu extends BaseView{

    public HeaderMenu headerMenu;

    public HeaderMenu(WebDriver driver) {
        super(driver);
        headerMenu = new HeaderMenu(driver);
    }

    @FindBy(xpath = "//div/button[@role='link']")
    public WebElement notes;

    @Step("Навести курсор на кнопку")
    public void moveToNotes() {
        Actions actions = new Actions(driver);
        actions.moveToElement(notes).perform();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Notes')]")));
    }

    @FindBy(xpath = "//button[text()='User Menu']")
    public WebElement userMenu;

    @Step("Открыть меню юзера")
    public void openUserMenu() {
        Actions actions = new Actions(driver);
        actions.moveToElement(userMenu).perform();
    }

    @FindBy(xpath = "//a[@aria-label='DeviantArt - Home']")
    public WebElement home;

    @Step("Вернуться домой")
    public HomePage returnHome() {
        home.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@data-hook='deviation_link']/div/img")));
        return new HomePage(driver);
    }




}
