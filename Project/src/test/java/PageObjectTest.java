import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class PageObjectTest extends BaseTest {

    @Test
    @Description("Тест авторизации и создания проекта")
    void loginInCrmWithPageObjTest() {

        driver.get("https://crm.geekbrains.space/");
        new LoginPage(driver)
                .fillInputLogin("Applanatest1")
                .fillInputPassword("Student2020!")
                .clickLoginButton()
                .navigationMenu.openNavigationMenuItem("Проекты");

        new ProjectSubMenu(driver).goToProjectsPage();

        new RequestsPage(driver)
                .createProject()
                .fillName("test_Project11111")
                .clickList()
                .inputOrganization("123")
                .organizationsSelect()
                .selectBusinessUnit("Research & Development")
                .selectCurator("Applanatest Applanatest Applanatest")
                .selectCrmProject("Applanatest Applanatest Applanatest")
                .selectAdministrator("Applanatest1 Applanatest1 Applanatest1")
                .selectManager("Амелин Владимир")
                .saveAndCloseButton.click();

        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(text(),'Загрузка')]")));
        assertThat(new CreateProjectPage(driver).requestSavedSuccessfullyElement, isDisplayed());
    }

    @Test
    @Description("Тест авторизации и создания контактного лица")
    void loginInCrmWithCreateContact() {
        driver.get("https://crm.geekbrains.space/");
        new LoginPage(driver)
                .fillInputLogin("Applanatest1")
                .fillInputPassword("Student2020!")
                .clickLoginButton()
                .navigationMenu.openNavigationMenuItem("Контрагенты");

        new ContactSubMenu(driver).goToContactsPage();

        new ContactsRequestsPage(driver)
                .createContacts()
                .fillLastName("Петров1")
                .fillFirstName("Петя")
                .inputOrganization("123")
                .organizationsSelect()
                .addJobTitle("Что-то")
                .saveAndCloseButton.click();

        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(text(),'Загрузка')]")));
        assertThat(new ContactCreatePage(driver).requestSavedSuccessfullyElement, isDisplayed());
    }
}
