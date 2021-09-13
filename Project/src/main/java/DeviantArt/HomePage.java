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
    public HomePage clickOnNotes() {
        notesButton.click();
        return this;
    }
//
//    @FindBy(xpath = "//a[contains(text(),'New Note')]")
//    public WebElement newNote;
//
//    @Step("Добавить новую заметку")
//    public HomePage clickNewNote() {
//        newNote.click();
//        return this;
//    }

    @FindBy(xpath = "//label[text()='Subject']/following-sibling::input")
    public WebElement fieldTo;

    @Step("Заполнить поле Кому")
    public HomePage fillTo(String to) {
        fieldTo.sendKeys(to);
        return this;
    }

    @FindBy(xpath = "//textarea")
    public WebElement textArea;

    @Step("Заполнить поле")
    public HomePage fillTextArea(String text) {
        textArea.click();
        textArea.sendKeys(text);
        return this;
    }

    @FindBy(xpath = "//a[@class='send_note']")
    public WebElement noteSend;

    @Step("Отправить записку")
    public HomePage sendNote() {
        noteSend.click();
        return this;
    }


}
