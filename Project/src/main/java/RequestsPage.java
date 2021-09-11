import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RequestsPage extends BaseView{


    public RequestsPage(WebDriver driver) {
        super(driver);
    }

    public static final String createProjectXpathLocator = "//a[text()='Создать проект']";

    @FindBy(xpath = createProjectXpathLocator)
    public WebElement createProjectButton;

    @Step("Создать проект")
    public CreateProjectPage createProject() {
        createProjectButton.click();
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath(CreateProjectPage.saveAndCloseButtonXpathLocator)));
        return new CreateProjectPage(driver);
    }
}
