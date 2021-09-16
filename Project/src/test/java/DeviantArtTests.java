import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class DeviantArtTests {

    static WebDriver driver;
    WebDriverWait webDriverWait;
    private static final String BASE_URL = "https://www.deviantart.com";

    @BeforeAll
    static void registerWebDriver(){ WebDriverManager.chromedriver().setup();}

    @BeforeEach
    void setupBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        webDriverWait = new WebDriverWait(driver, 5);
        authorization();
    }

    @Test
    void addNote() {
//        Actions actions = new Actions(driver);
//        WebElement menuElement = driver.findElement(By.xpath("//div/button[@role='link']"));
//        actions.moveToElement(menuElement).perform();

//        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Notes')]")));
//        driver.findElement(By.xpath("//a[contains(text(),'Notes')]")).click();

//        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'New Note')]")));
//        driver.findElement(By.xpath("//a[contains(text(),'New Note')]")).click();
//
//        driver.findElement(By.xpath("//label[text()='Subject']/following-sibling::input")).sendKeys("Testtest");
//
//        driver.findElement(By.xpath("//textarea")).click();
//
//        driver.findElement(By.xpath("//textarea")).sendKeys("New Note");
//
//        driver.findElement(By.xpath("//a[@class='send_note']")).click();
//        assert true;
    }

    @Test
    void addNewElementInCollections () {
//        driver.findElement(By.xpath("//a[@aria-label='DeviantArt - Home']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@data-hook='deviation_link']/div/img")));
        List<WebElement> vars = driver.findElements(By.xpath("//a[@data-hook='deviation_link']/div/img"));
        vars.get(4).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Add to Favourites']")));
        driver.findElement(By.xpath("//span[text()='Add to Favourites']")).click();

        Actions actions = new Actions(driver);
        WebElement loginElement = driver.findElement(By.xpath("//button[text()='User Menu']"));
        actions.moveToElement(loginElement).perform();

        driver.findElement(By.xpath("//a[@data-username='Applanatest1']")).click();

        driver.findElement(By.xpath("//a[text()='Favourites']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a/div/img")));
        List<WebElement> varsFavourites = driver.findElements(By.xpath("//a/div/img"));
        varsFavourites.get(0).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='In Favourites']")));
        assert true;
    }

    @Test
    void subscribeToUser () {
        driver.findElement(By.xpath("//a[@aria-label='DeviantArt - Home']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@data-hook='deviation_link']/div/img")));
        List<WebElement> vars = driver.findElements(By.xpath("//a[@data-hook='deviation_link']/div/img"));
        vars.get(2).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-hook='user_watch_button']")));
        driver.findElement(By.xpath("//button[@data-hook='user_watch_button']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Watching']")));
        assert true;
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    public static void authorization() {
        driver.get(BASE_URL);
        driver.findElement(By.xpath("//a[text()='Log in']")).click();
        driver.findElement(By.name("username")).sendKeys("Applanatest1");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("Student2020!");
        driver.findElement(By.id("loginbutton")).click();
    }

}
