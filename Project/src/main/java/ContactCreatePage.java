import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class ContactCreatePage extends BaseView {
    public ContactCreatePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "crm_contact[lastName]")
    public WebElement fildLastName;

    @Step("Заполнить фамилию")
    public ContactCreatePage fillLastName(String lastName) {
        fildLastName.sendKeys(lastName);
        return this;
    }

//    возможно придется дописать еще один шаг

    @FindBy(name = "crm_contact[firstName]")
    public WebElement firstName;

    @Step("Заполнить имя")
    public ContactCreatePage fillFirstName(String name) {
        firstName.sendKeys(name);
        return this;
    }

    @FindBy(xpath = "//div[@id='select2-drop']//input")
    public WebElement inputOrg;

    @Step("Указать организацию")
    public ContactCreatePage inputOrganization(String nameOrganizations){
        inputOrg.sendKeys(nameOrganizations);
        return this;
    }

    @FindBy(xpath = "//div[@class='select2-result-label']")
    public List<WebElement> listOrganization;

    @Step("Выбрать одну организацию из списка")
    public ContactCreatePage organizationsSelect() {
        listOrganization.get(2).click();
        return this;
    }

    @FindBy(xpath = "crm_contact[jobTitle]")
    public WebElement jobTitle;

    @Step(" ")
    public ContactCreatePage addJobTitle(String job) {
        jobTitle.click();
        jobTitle.sendKeys(job);
        return this;
    }

    @FindBy(xpath = saveAndCloseButtonXpathLocator)
    public WebElement saveAndCloseButton;

    public static final String saveAndCloseButtonXpathLocator = "//button[contains(text(), 'Сохранить и закрыть')]";

    @FindBy(xpath = "//*[contains(text(), 'Контактное лицо сохранено')]")
    public WebElement requestSavedSuccessfullyElement;
}
