import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeviantArtTests {

    public static WebDriver driver;
    public static WebDriverWait webDriverWait;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        webDriverWait = new WebDriverWait(driver, 9);
        authorization();
        addNote();
        Thread.sleep(5000);

        driver.quit();

    }

    public static void authorization() {

        driver.get("https://www.deviantart.com");
        driver.findElement(By.xpath("//a[text()='Log in']")).click();
        driver.findElement(By.name("username")).sendKeys("Applanatest1");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("Student2020!");
        driver.findElement(By.id("loginbutton")).click();

    }

    public static void addNote() throws InterruptedException {

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

}
