package DeviantArt;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ImagePage extends BaseView{

    public ImagePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Add to Favourites']")
    public WebElement favourite;

    @Step("Добавить в фавориты")
    public ImagePage addToFavourites() {
        favourite.click();
        return this;
    }

    @FindBy(xpath = "//button[text()='User Menu']")
    public WebElement userMenu;

    @Step("Открыть меню юзера")
    public ImagePage openUserMenu() {
        Actions actions = new Actions(driver);
        actions.moveToElement(userMenu).perform();
        return this;
    }

    @FindBy(xpath = "//a[@data-username='Applanatest1']")
    public WebElement account;

    @Step("Перейти в аккаунт")
    public AccountPage openAccount() {
        account.click();
        return new AccountPage(driver);
    }
}
