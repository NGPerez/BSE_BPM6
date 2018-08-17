package Configuration;

import Data.Parametros;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class NavigatorDriverConfiguration {

    private static WebDriver driver;
    private static String baseUrl;
    private static String webDriverProperty;
    private static String webDriverPath;

    public NavigatorDriverConfiguration(String navigator, String api) {
        if (navigator.equalsIgnoreCase("FIREFOX")) {
            webDriverProperty = "webdriver.firefox.marionette";
            System.out.println("Path: " + System.getProperty("user.dir") + "\\Insumos\\FirefoxDriverServer.exe");
            webDriverPath = System.getProperty("user.dir") + "\\Insumos\\FirefoxDriverServer.exe";
        } else if (navigator.equalsIgnoreCase("CHROME")) {
            webDriverProperty = "webdriver.chrome.driver";
            System.out.println("Path: " + System.getProperty("user.dir") + "\\Insumos\\ChromeDriverServer.exe");
            webDriverPath = System.getProperty("user.dir") + "\\Insumos\\ChromeDriverServer.exe";
        } else if (navigator.equalsIgnoreCase("IE")) {
            webDriverProperty = "webdriver.ie.driver";
            System.out.println("Path: " + System.getProperty("user.dir") + "\\Insumos\\IEDriverServer.exe");
            webDriverPath = System.getProperty("user.dir") + "\\Insumos\\IEDriverServer.exe";
        } else {
            webDriverProperty = "";
        }
        init(navigator, api);
    }

    private void init(String navigator, String api) {
        DesiredCapabilities capabilities;
        System.setProperty(webDriverProperty, webDriverPath);
        if (navigator.equalsIgnoreCase("FIREFOX")) {
            capabilities = DesiredCapabilities.firefox();
            capabilities.setCapability("marionette", true);
            driver = new FirefoxDriver(capabilities);
        } else if (navigator.equalsIgnoreCase("CHROME")) {
            capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability("marionette", true);
            driver = new ChromeDriver(capabilities);
        } else if (navigator.equalsIgnoreCase("IE")) {
            capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setCapability("marionette", true);
            driver = new InternetExplorerDriver(capabilities);
        }
        if (navigator.equalsIgnoreCase("FIREFOX") || navigator.equalsIgnoreCase("CHROME") || navigator.equalsIgnoreCase("IE")) {
            baseUrl = Parametros.getInstance(api).getUrlBase();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static String getBaseUrl() {
        return baseUrl;
    }

}
