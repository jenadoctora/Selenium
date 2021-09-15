package DeviantArt;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeviantPageTest extends BaseTest{

    @Test
    @Description("Тест авторизации и создания записки")
    void loginInDeviantArtWithCreateNoteTest() {
        driver.get("https://www.deviantart.com");

        new LoginPage(driver)
                .goToLoginPage()
                .fillInputLogin("Applanatest1")
                .fillInputPassword("Student2020!")
                .clickLoginButton()
                .headerMenu.moveToNotes();

        new HomePage(driver)
                .clickOnNotes();

        new InboxPage(driver)
                .clickNewNote()
                .fillTo("TTTTT")
                .fillTextArea("Text)))")
                .sendNote();
        assert true;
    }

    @Test
    @Description("Тест авторизации и добавления картинки в фавориты")
    void addNewElementInCollectionsTest() {
        driver.get("https://www.deviantart.com");

        new LoginPage(driver)
                .goToLoginPage()
                .fillInputLogin("Applanatest1")
                .fillInputPassword("Student2020!")
                .clickLoginButton()
                .headerMenu.returnHome();

        new HomePage(driver)
                .choosePicture();

        new ImagePage(driver)
                .addToFavourites()
                .headerMenu.openUserMenu();

        new AccountPage(driver)
                .openAccount()
                .openFavourites()
                .openPicture();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='In Favourites']")));
        assert true;
    }

    @Test
    @Description("Тест авторизаци и добавления картинки в фавориты")
    void subscribeToUserTest() {
        driver.get("https://www.deviantart.com");

        new LoginPage(driver)
                .goToLoginPage()
                .fillInputLogin("Applanatest1")
                .fillInputPassword("Student2020!")
                .clickLoginButton()
                .headerMenu.returnHome();

        new HomePage(driver)
                .choosePicture();

        new ImagePage(driver)
                .pushWatchButton();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Watching']")));
        assert true;

    }




}
