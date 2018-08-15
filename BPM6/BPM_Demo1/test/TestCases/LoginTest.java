package TestCases;

import Configuration.FirefoxDriverConfiguration;
import junit.framework.TestCase;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class LoginTest extends TestCase {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    public LoginTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    @Override
    public void setUp() {
        FirefoxDriverConfiguration fcd = new FirefoxDriverConfiguration();
        driver = fcd.getDriver();
        baseUrl = fcd.getBaseUrl();
    }

    @After
    @Override
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

    @Test
    public void testLoginCorrecto() throws Exception {
        driver.get(baseUrl + "/afiliacionesUi/login.xhtml");
      //  driver.findElement(By.id("username")).clear();
      //  driver.findElement(By.id("username")).sendKeys("iferreira");
      //  driver.findElement(By.id("password")).clear();
      //  driver.findElement(By.id("password")).sendKeys("Sistemas2018");
//        driver.findElement(By.id("frmLogin:login")).click();
//        driver.findElement(By.cssSelector("img.user-image")).click();
//        try {
//            assertEquals("Ingrid Ferreira", driver.findElement(By.partialLinkText("Ingrid")).getText());
//        } catch (Error e) {
//            verificationErrors.append(e.toString());
//        }
    }

}
