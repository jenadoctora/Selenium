import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;


public class CrmTests {

    static WebDriver driver;
    WebDriverWait webDriverWait;
    private static final String BASE_URL = "https://crm.geekbrains.space/";

    @BeforeAll
    static void registerWebDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser(){
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
        loginToCrm();
    }

    @Test
    void createProject() {
        Actions actions = new Actions(driver);
        WebElement menuElement = driver.findElement(By.xpath("//a/span[text()='Проекты']"));
        actions.moveToElement(menuElement).perform();

//        driver.findElement(By.xpath("//span[text()='Все проекты']")).click();
//        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Создать проект']")));
//        driver.findElement(By.xpath("//a[text()='Создать проект']")).click();

//        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.name("crm_project[name]")));
//        driver.findElement(By.name("crm_project[name]")).sendKeys("81NewProject");

//        driver.findElement(By.xpath("//span[text()='Укажите организацию']")).click();
//        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("123");

//        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='select2-result-label']")));
//        List<WebElement> vars = driver.findElements(By.xpath("//div[@class='select2-result-label']"));
//        vars.get(4).click();

//        Select businessUnitSelect = new Select(driver.findElement(By.xpath("//select[@name='crm_project[businessUnit]']")));
//        businessUnitSelect.selectByVisibleText("Research & Development");

//        Select curatorSelect = new Select(driver.findElement(By.xpath("//select[@name='crm_project[curator]']")));
//        curatorSelect.selectByVisibleText("Applanatest Applanatest Applanatest");

//        Select crmProjectSelect = new Select(driver.findElement(By.xpath("//select[@name='crm_project[rp]']")));
//        crmProjectSelect.selectByVisibleText("Applanatest Applanatest Applanatest");

//        Select administratorSelect = new Select(driver.findElement(By.xpath("//select[@name='crm_project[administrator]']")));
//        administratorSelect.selectByVisibleText("Applanatest1 Applanatest1 Applanatest1");

//        Select managerSelect = new Select(driver.findElement(By.xpath("//select[@name='crm_project[manager]']")));
//        managerSelect.selectByVisibleText("Амелин Владимир");

        driver.findElement(By.xpath("//button[contains(text(),'Сохранить и закрыть')]")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'Проект сохранен')]")));
        assert true;
    }

    @Test
    void createContact() {

        Actions actions = new Actions(driver);
        WebElement menuElement = driver.findElement(By.xpath("//a/span[text()='Контрагенты']"));
        actions.moveToElement(menuElement).perform();

        driver.findElement(By.xpath("//a/span[text()='Контактные лица']")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Создать контактное лицо']")));
//        driver.findElement(By.xpath("//a[@title='Создать контактное лицо']")).click();

//        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.name("crm_contact[lastName]")));
//        driver.findElement(By.name("crm_contact[lastName]")).sendKeys("Panov1");
        driver.findElement(By.name("crm_contact[lastName]")).click();
//        driver.findElement(By.name("crm_contact[firstName]")).sendKeys("Constantin9");

//        driver.findElement(By.xpath("//span[text()='Укажите организацию']")).click();
//        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("123");

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='select2-result-label']")));
//        List<WebElement> vars = driver.findElements(By.xpath("//div[@class='select2-result-label']"));
//        vars.get(4).click();

//        driver.findElement(By.name("crm_contact[jobTitle]")).click();
//        driver.findElement(By.name("crm_contact[jobTitle]")).sendKeys("интересная");

//        driver.findElement(By.xpath("//button[contains(text(),'Сохранить и закрыть')]")).click();
//
//        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'Контактное лицо сохранено')]")));
        assert true;

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    public static void loginToCrm() {
        driver.get(BASE_URL + "user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.xpath("//button")).click();
    }


}
