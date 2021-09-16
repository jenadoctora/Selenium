package DeviantArt;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends BaseView{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div/button[@role='link']")
    public WebElement notes;

    @Step("Навести курсор на кнопку")
    public HomePage moveToNotes() {
        Actions actions = new Actions(driver);
        actions.moveToElement(notes).perform();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Notes')]")));
        return this;
    }

    @FindBy(xpath = "//a[contains(text(),'Notes')]")
    public WebElement notesButton;

    @Step("Нажать на записки")
    public InboxPage clickOnNotes() {
        notesButton.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'New Note')]")));
        return new InboxPage(driver);
    }

    @FindBy(xpath = "//a[@aria-label='DeviantArt - Home']")
    public WebElement home;

    @Step("Вернуться домой")
    public HomePage returnHome() {
        home.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@data-hook='deviation_link']/div/img")));
        return new HomePage(driver);
    }

    @FindBy(xpath = "//a[@data-hook='deviation_link']/div/img")
    public List<WebElement> images;

    @Step("Выбрать одну картинку")
    public ImagePage choosePicture() {
        images.get(2).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@aria-hidden]")));
        return new ImagePage(driver);
    }
}
