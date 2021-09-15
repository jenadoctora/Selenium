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

//     webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Notes')]")));
    @FindBy(xpath = "//a[contains(text(),'Notes')]")
    public WebElement notesButton;

    @Step("Нажать на записки")
    public InboxPage clickOnNotes() {
        notesButton.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'New Note')]")));
        return new InboxPage(driver);
    }
//
//
//webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@data-hook='deviation_link']/div/img")));
    @FindBy(xpath = "//a[@data-hook='deviation_link']/div/img")
    public List<WebElement> images;

    @Step("Выбрать одну картинку")
    public ImagePage choosePicture() {
        images.get(5).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Add to Favourites']")));
        return new ImagePage(driver);
    }



}
