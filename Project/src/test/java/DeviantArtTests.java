import io.github.bonigarcia.wdm.WebDriverManager;
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

import java.sql.Driver;

public class DeviantArtTests {

    static WebDriver driver;
    WebDriverWait webDriverWait;
    private static final String BASE_URL = "https://www.deviantart.com";

    @BeforeAll
    static void registerWebDriver(){ WebDriverManager.chromedriver().setup();}

    @BeforeEach
    void setupBrowser(){
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
        authorization();
    }

    @Test
    void addNote() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement menuElement = driver.findElement(By.xpath("//div/button[@role='link']"));
        actions.moveToElement(menuElement).perform();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Notes')]")));
        driver.findElement(By.xpath("//a[contains(text(),'Notes')]")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'New Note')]")));
        driver.findElement(By.xpath("//a[contains(text(),'New Note')]")).click();

        driver.findElement(By.xpath("//label[text()='Subject']/following-sibling::input")).sendKeys("Testtest");

        driver.findElement(By.xpath("//textarea")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//textarea")).sendKeys("New Note");

        driver.findElement(By.xpath("//a[@class='send_note']")).click();
    }

    public static void authorization() {
        driver.get("https://www.deviantart.com");
        driver.findElement(By.xpath("//a[text()='Log in']")).click();
        driver.findElement(By.name("username")).sendKeys("Applanatest1");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("Student2020!");
        driver.findElement(By.id("loginbutton")).click();
    }

}
