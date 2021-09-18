import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactsRequestsPage extends BaseView{
    public ContactsRequestsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = createContactXpathLocator)
    public WebElement createContactButton;

    @Step("Создать контактное лицо")
    public ContactCreatePage createContacts() {
        createContactButton.click();
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath(ContactCreatePage.saveAndCloseButtonXpathLocator)));
        return new ContactCreatePage(driver);
    }

    public static final String createContactXpathLocator = "//a[@title='Создать контактное лицо']";
}
