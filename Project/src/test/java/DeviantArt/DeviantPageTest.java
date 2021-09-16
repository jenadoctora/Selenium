package DeviantArt;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DeviantPageTest extends BaseTest{

    @Test
    @Description("Тест авторизации и создания записки")
    void loginInDeviantArtWithCreateNoteTest() {
        driver.get("https://www.deviantart.com");

        new LoginPage(driver)
                .goToLoginPage()
                .fillInputLogin("Applanatest1")
                .fillInputPassword("Student2020!")
                .clickLoginButton();

        new HomePage(driver)
                .moveToNotes()
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
                .clickLoginButton();

        new HomePage(driver)
                .returnHome()
                .choosePicture();

        new ImagePage(driver)
                .addToFavourites()
                .openUserMenu();

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
                .clickLoginButton();

        new HomePage(driver)
                .returnHome()
                .choosePicture();

        new ImagePage(driver).pushWatchButton();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Watching']")));
        assert true;

    }




}
