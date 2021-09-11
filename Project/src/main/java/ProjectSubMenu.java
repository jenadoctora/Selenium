import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProjectSubMenu extends BaseView{
    public ProjectSubMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Все проекты']")
    public WebElement subMenuProjects;

    @Step("Перейти на страницу проектов")
    public void goToProjectsPage() {
        subMenuProjects.click();
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated
                        (By.xpath(RequestsPage.createProjectXpathLocator)));
    }
}
