import DeviantArt.CostomLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
    EventFiringWebDriver driver;
    WebDriverWait webDriverWait;
    private static final String BASE_URL = "https://crm.geekbrains.space/";

    @BeforeAll
    static void registerWebDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser(){
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.register(new CostomLogger());
        webDriverWait = new WebDriverWait(driver, 5);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }



}
