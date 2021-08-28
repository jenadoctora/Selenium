import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.List;

public class CrmTests {
    public static WebDriver driver;
    public static WebDriverWait webDriverWait;

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        webDriverWait = new WebDriverWait(driver, 7);
        loginCrm();
        createProject();
        Thread.sleep(5000);
        createContact();
        driver.quit();
    }

    public static void loginCrm() {
        driver.get("https://crm.geekbrains.space/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.xpath("//button")).click();
    }

    public static void createProject() throws InterruptedException {

        Actions actions = new Actions(driver);
        WebElement menuElement = driver.findElement(By.xpath("//a/span[text()='Проекты']"));
        actions.moveToElement(menuElement).perform();

        driver.findElement(By.xpath("//span[text()='Все проекты']")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Создать проект']")));
        driver.findElement(By.xpath("//a[text()='Создать проект']")).click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.name("crm_project[name]")));
        driver.findElement(By.name("crm_project[name]")).sendKeys("5NewProject");

        driver.findElement(By.xpath("//span[text()='Укажите организацию']")).click();
        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("123");

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='select2-result-label']")));
        List<WebElement> vars = driver.findElements(By.xpath("//div[@class='select2-result-label']"));
        vars.get(4).click();

        Select businessUnitSelect = new Select(driver.findElement(By.xpath("//select[@name='crm_project[businessUnit]']")));
        businessUnitSelect.selectByVisibleText("Research & Development");

        Select curatorSelect = new Select(driver.findElement(By.xpath("//select[@name='crm_project[curator]']")));
        curatorSelect.selectByVisibleText("Applanatest Applanatest Applanatest");

        Select crmProjectSelect = new Select(driver.findElement(By.xpath("//select[@name='crm_project[rp]']")));
        crmProjectSelect.selectByVisibleText("Applanatest Applanatest Applanatest");

        Select administratorSelect = new Select(driver.findElement(By.xpath("//select[@name='crm_project[administrator]']")));
        administratorSelect.selectByVisibleText("Applanatest1 Applanatest1 Applanatest1");

        Select managerSelect = new Select(driver.findElement(By.xpath("//select[@name='crm_project[manager]']")));
        managerSelect.selectByVisibleText("Амелин Владимир");

        driver.findElement(By.xpath("//button[contains(text(),'Сохранить и закрыть')]")).click();

    }

    public static void createContact() {

        Actions actions = new Actions(driver);
        WebElement menuElement = driver.findElement(By.xpath("//a/span[text()='Контрагенты']"));
        actions.moveToElement(menuElement).perform();

        driver.findElement(By.xpath("//a/span[text()='Контактные лица']")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Создать контактное лицо']")));
        driver.findElement(By.xpath("//a[@title='Создать контактное лицо']")).click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.name("crm_contact[lastName]")));
        driver.findElement(By.name("crm_contact[lastName]")).sendKeys("Panov");
        driver.findElement(By.name("crm_contact[lastName]")).click();
        driver.findElement(By.name("crm_contact[firstName]")).sendKeys("Constantin");

        driver.findElement(By.xpath("//span[text()='Укажите организацию']")).click();
        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("123");

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='select2-result-label']")));
        List<WebElement> vars = driver.findElements(By.xpath("//div[@class='select2-result-label']"));
        vars.get(4).click();

        driver.findElement(By.name("crm_contact[jobTitle]")).click();
        driver.findElement(By.name("crm_contact[jobTitle]")).sendKeys("интересная");

        driver.findElement(By.xpath("//button[contains(text(),'Сохранить и закрыть')]")).click();

    }

}
