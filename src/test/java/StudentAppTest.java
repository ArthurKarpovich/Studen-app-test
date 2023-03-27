import com.github.javafaker.Faker;
import constants.AllConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import page_objects.AddStudentPage;
import page_objects.AllStudentsPage;

import java.time.Duration;

import static constants.AllConstants.GenderConstants.MALE;
import static org.testng.Assert.assertTrue;

public class StudentAppTest {

    WebDriver driver;
    private final String APP_URL = "http://acodemystudentapp-env.eba-d2vctp4d.eu-north-1.elasticbeanstalk.com/";
    WebDriverWait driverWait;
    Faker dataFaker = new Faker();
    AllStudentsPage allStudentsPage;
    AddStudentPage addStudentPage;
    private final String APP_URL = "http://app.acodemy.lv/";

    @BeforeMethod
    public void initialize() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(APP_URL);
        allStudentsPage = new AllStudentsPage(driver);
        addStudentPage = new AddStudentPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    @Test
    public void openStudentApp() {
        WebElement addStudentButton = driver.findElement(By.xpath("//div[@class='ant-table-title']//button"));
        addStudentButton.click();
        allStudentsPage.waitAndClickOnAddStudentButton();
        addStudentPage.waitAndSetValueForNameField();
        addStudentPage.waitAndSetValueForEmailField();
        addStudentPage.waitAndSetGender(MALE);
        addStudentPage.clickOnSubmitButton();

        driverWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("ant-notification-notice-message")));
        WebElement notificationMessage = driver.findElement(
                By.className("ant-notification-notice-message"));
        WebElement notificationDescription = driver.findElement(
                By.className("ant-notification-notice-description"));

        WebElement nameField = driver.findElement(By.id("name"));
        nameField.sendKeys("John Doe");
        Assert.assertEquals(notificationMessage.getText(), "Student successfully added");
        //        Assert.assertEquals(notificationDescription.getText(), name + " was added to the system");

        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("nikita@milka.me");
        WebElement popUpCloseButton = driver.findElement(By.className("ant-notification-notice-close"));
        popUpCloseButton.click();
        assertTrue(driverWait.until(ExpectedConditions.invisibilityOf(popUpCloseButton)));
    }
}import com.github.javafaker.Faker;
        import constants.AllConstants;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.chrome.ChromeOptions;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;
        import org.testng.Assert;
        import org.testng.annotations.*;
        import page_objects.AddStudentPage;
        import page_objects.AllStudentsPage;

        import java.time.Duration;

        import static constants.AllConstants.GenderConstants.MALE;
        import static org.testng.Assert.assertTrue;

public class StudentAppTest {

    WebDriver driver;
    private final String APP_URL = "http://acodemystudentapp-env.eba-d2vctp4d.eu-north-1.elasticbeanstalk.com/";
    WebDriverWait driverWait;
    Faker dataFaker = new Faker();
    AllStudentsPage allStudentsPage;
    AddStudentPage addStudentPage;
    private final String APP_URL = "http://app.acodemy.lv/";

    @BeforeMethod
    public void initialize() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(APP_URL);
        allStudentsPage = new AllStudentsPage(driver);
        addStudentPage = new AddStudentPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    @Test
    public void openStudentApp() {
        WebElement addStudentButton = driver.findElement(By.xpath("//div[@class='ant-table-title']//button"));
        addStudentButton.click();
        allStudentsPage.waitAndClickOnAddStudentButton();
        addStudentPage.waitAndSetValueForNameField();
        addStudentPage.waitAndSetValueForEmailField();
        addStudentPage.waitAndSetGender(MALE);
        addStudentPage.clickOnSubmitButton();

        driverWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("ant-notification-notice-message")));
        WebElement notificationMessage = driver.findElement(
                By.className("ant-notification-notice-message"));
        WebElement notificationDescription = driver.findElement(
                By.className("ant-notification-notice-description"));

        WebElement nameField = driver.findElement(By.id("name"));
        nameField.sendKeys("John Doe");
        Assert.assertEquals(notificationMessage.getText(), "Student successfully added");
        //        Assert.assertEquals(notificationDescription.getText(), name + " was added to the system");

        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("nikita@milka.me");
        WebElement popUpCloseButton = driver.findElement(By.className("ant-notification-notice-close"));
        popUpCloseButton.click();
        assertTrue(driverWait.until(ExpectedConditions.invisibilityOf(popUpCloseButton)));
    }
}