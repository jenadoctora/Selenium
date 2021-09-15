package DeviantArt;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ImagePage extends BaseView{

    public ImagePage(WebDriver driver) {
        super(driver);
    }

//webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Add to Favourites']")));
    @FindBy(xpath = "//span[text()='Add to Favourites']")
    public WebElement favourite;

    @Step("Добавить в фавориты")
    public HeaderMenu addToFavourites() {
        favourite.click();
        return new HeaderMenu(driver);
    }

    @FindBy(xpath = "//button[@data-hook='user_watch_button']")
    public WebElement userWatchButton;

    @Step("Нажать на кнопку Смотреть")
    public ImagePage pushWatchButton() {
        userWatchButton.click();
        return this;
    }

//    public static final String watching = "//span[text()='Watching']";
//
//    @FindBy(xpath = watching)
//    public WebElement watchingButton;

}
