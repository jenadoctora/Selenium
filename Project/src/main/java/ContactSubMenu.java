import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactSubMenu extends BaseView{
    public ContactSubMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a/span[text()='Контрагенты']")
    public WebElement subMenuContacts;

    @Step("Перейти на страницу контактов")
    public void goToContactsPage() {
        subMenuContacts.click();
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated
                        (By.xpath(ContactsRequestsPage.createContactXpathLocator)));
    }
}
