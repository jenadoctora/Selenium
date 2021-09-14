package DeviantArt;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

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
        return this;
    }

    @FindBy(xpath = "//a[contains(text(),'Notes')]")
    public WebElement notesButton;

    @Step("Нажать на записки")
    public InboxPage clickOnNotes() {
        notesButton.click();
        return new InboxPage(driver);
    }
//
//


}
