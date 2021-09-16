import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CreateProjectPage extends BaseView {

    public CreateProjectPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "crm_project[name]")
    public WebElement projectName;

    @Step("Заполнить имя")
    public CreateProjectPage fillName(String name) {
        projectName.sendKeys(name);
        return this;
    }

    @FindBy(xpath = "//span[text()='Укажите организацию']")
    public WebElement selectOrganizations;

    @Step("Нажать на список организаций")
    public CreateProjectPage clickList() {
        selectOrganizations.click();
        return this;
    }

    @FindBy(xpath = "//div[@id='select2-drop']//input")
    public WebElement inputOrg;

    @Step("Указать организацию")
    public CreateProjectPage inputOrganization(String nameOrganizations){
        inputOrg.sendKeys(nameOrganizations);
        return this;
    }

    @FindBy(xpath = "//div[@class='select2-result-label']")
    public List<WebElement> listOrganization;

    @Step("Выбрать одну организацию из списка")
    public CreateProjectPage organizationsSelect() {
        listOrganization.get(2).click();
        return this;
    }

    @FindBy(name = "crm_expense_request[businessUnit]")
    public WebElement businessUnitSelect;

    @Step("Выбрать бизнесс юнит")
    public CreateProjectPage selectBusinessUnit(String businessUnit) {
        new Select(businessUnitSelect).selectByVisibleText(businessUnit);
        return this;
    }

    @FindBy(name = "'crm_project[curator]")
    public WebElement curatorSelect;

    @Step("Выбрать куратора")
    public CreateProjectPage selectCurator(String curator) {
        new Select(curatorSelect).selectByVisibleText(curator);
        return this;
    }

    @FindBy(name = "crm_project[rp]")
    public WebElement crmProjectSelect;

    @Step("Выбрать ")
    public CreateProjectPage selectCrmProject (String crmProject) {
        new Select(crmProjectSelect).selectByVisibleText(crmProject);
        return this;
    }

    @FindBy(name = "crm_project[administrator]")
    public WebElement administratorSelect;

    @Step("Выбрать администратора")
    public CreateProjectPage selectAdministrator (String administrator) {
        new Select(administratorSelect).selectByVisibleText(administrator);
        return this;
    }

    @FindBy(name = "crm_project[manager]")
    public WebElement managerSelect;

    @Step("Выбрать менеджера")
    public CreateProjectPage selectManager(String manager) {
        new Select(managerSelect).selectByVisibleText(manager);
        return this;
    }

    @FindBy(xpath = saveAndCloseButtonXpathLocator)
    public WebElement saveAndCloseButton;

    public static final String saveAndCloseButtonXpathLocator = "//button[contains(text(), 'Сохранить и закрыть')]";

    @FindBy(xpath = "//*[text()='Проект сохранен']")
    public WebElement requestSavedSuccessfullyElement;
}
