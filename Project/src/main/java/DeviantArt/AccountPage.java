package DeviantArt;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AccountPage extends BaseView{

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()='Favourites']")
    public WebElement favourites;

    @Step("Открыть вкладку Фавориты")
    public AccountPage openFavourites() {
        favourites.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a/div/img")));
        return this;
    }

    @FindBy(xpath = "//a/div/img")
    public List<WebElement> varsFavourites;

    @Step("Выбрать картинку")
    public AccountPage openPicture() {
        varsFavourites.get(0).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='In Favourites']")));
        return this;
    }

    @FindBy(xpath = "//a[@data-username='Applanatest1']")
    public WebElement account;

    @Step("Перейти в аккаунт")
    public AccountPage openAccount() {
        account.click();
        return this;
    }
}
