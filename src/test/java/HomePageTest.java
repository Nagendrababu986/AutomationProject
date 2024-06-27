import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;
import java.time.Duration;
@Listeners(JobbyAppReport.class)
public class HomePageTest {
    public WebDriver driver;
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\nagen\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://qajobbyapp.ccbp.tech/login");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test(priority=1)
    public void testHomepageHeading() throws InterruptedException{
        WebElement Username1=driver.findElement(By.id("userNameInput"));
        Username1.sendKeys("rahul");
        WebElement Password1=driver.findElement(By.id("passwordInput"));
        Password1.sendKeys("rahul@2021");
        WebElement Login5=driver.findElement(By.className("login-button"));
        Login5.click();

        Thread.sleep(1000);
        WebDriverWait wait3=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait3.until(ExpectedConditions.visibilityOfElementLocated(By.className("home-heading")));
        WebElement Heading=driver.findElement(By.className("home-heading"));
        String actual=Heading.getText();
        Assert.assertEquals(actual, "Find The Job That Fits Your Life", "Heading text does not match");
    }
    @Test(priority=2)
    public void testLogoutFunctionality() throws InterruptedException{
        WebElement Username1=driver.findElement(By.id("userNameInput"));
        Username1.sendKeys("rahul");
        WebElement Password1=driver.findElement(By.id("passwordInput"));
        Password1.sendKeys("rahul@2021");
        WebElement Login5=driver.findElement(By.className("login-button"));
        Login5.click();
        Thread.sleep(1000);
        WebElement LogOut=driver.findElement(By.className("logout-desktop-btn"));
        LogOut.click();
        Alert alert=driver.switchTo().alert();
        alert.accept();
        String ExpectedUrl="https://qajobbyapp.ccbp.tech/login";
        WebDriverWait wait2=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait2.until(ExpectedConditions.urlToBe(ExpectedUrl));
        String Actual=driver.getCurrentUrl();
        Assert.assertEquals(Actual,  ExpectedUrl, "Login URL do not match");
    }
}
