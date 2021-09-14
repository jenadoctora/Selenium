package DeviantArt;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class InboxPage extends BaseView{

    public InboxPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'New Note')]")
    public WebElement newNote;

    @Step("Добавить новую заметку")
    public InboxPage clickNewNote() {
        newNote.click();
        return this;
    }

    @FindBy(xpath = "//label[text()='Subject']/following-sibling::input")
    public WebElement fieldTo;

    @Step("Заполнить поле Кому")
    public InboxPage fillTo(String to) {
        fieldTo.sendKeys(to);
        return this;
    }

    @FindBy(xpath = "//textarea")
    public WebElement textArea;

    @Step("Заполнить поле")
    public InboxPage fillTextArea(String text) {
        textArea.click();
        textArea.sendKeys(text);
        return this;
    }

    @FindBy(xpath = "//a[@class='send_note']")
    public WebElement noteSend;

    @Step("Отправить записку")
    public InboxPage sendNote() {
        noteSend.click();
        return this;
    }
    //
    @FindBy(xpath = "//a[@aria-label='DeviantArt - Home']")
    public WebElement home;

    @Step("Вернуться домой")
    public HomePage returnHome() {
       home.click();
       return new HomePage(driver);
    }

    @FindBy(xpath = "//a[@data-hook='deviation_link']/div/img")
    public List<WebElement> images;

    @Step("Выбрать одну картинку")
    public ImagePage choosePicture() {
        images.get(5).click();
        return new ImagePage(driver);
    }
}
