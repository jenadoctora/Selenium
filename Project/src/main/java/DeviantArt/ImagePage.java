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
    public AccountPage openUserMenu() {
        Actions actions = new Actions(driver);
        actions.moveToElement(userMenu).perform();
        return new AccountPage(driver);
    }

    @FindBy(xpath = "//button[@data-hook='user_watch_button']")
    public WebElement userWatchButton;

    @Step("Нажать на кнопку Смотреть")
    public ImagePage pushWatchButton() {
        userWatchButton.click();
        return this;
    }
}
