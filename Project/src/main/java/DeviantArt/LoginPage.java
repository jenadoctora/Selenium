package DeviantArt;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseView{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()='Log in']")
    public WebElement logIn;

    @FindBy(name = "username")
    public WebElement inputLogin;

    @FindBy(name = "password")
    public WebElement inputPassword;

    @FindBy(id = "loginbutton")
    public WebElement loginButton;


    @Step("Перейти на страницу авторизации")
    public LoginPage goToLoginPage() {
        logIn.click();
        return this;
    }

    @Step("Заполнить поле логина")
    public LoginPage fillInputLogin(String login) {
        inputLogin.sendKeys(login);
        return this;
    }

    @Step("Заполнить поле пароля")
    public LoginPage fillInputPassword(String password) {
        inputPassword.click();
        inputPassword.sendKeys(password);
        return this;
    }

    @Step("Клик на кнопку логина")
    public HomePage clickLoginButton() {
        loginButton.click();
        return new HomePage(driver);
    }
}
