package Configuration;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class FirefoxDriverConfiguration {
    //private static FirefoxDriverConfiguration INSTANCIA = null;
    private static WebDriver driver;
    private static String baseUrl;

    private String URLTrazabilidad = "http://jboss-test01:8080/TrazaWeb/login.jsf"; 
    
    public FirefoxDriverConfiguration(){
        System.setProperty ("webdriver.firefox.marionette", URLTrazabilidad);
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        driver = new FirefoxDriver(capabilities);
        baseUrl = "http://jboss-test:9080/";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    
/*
    public static FirefoxDriverConfiguration getInstancia(){
        if(INSTANCIA == null){
            INSTANCIA = new FirefoxDriverConfiguration();
        }
        return INSTANCIA;
    }
*/
    public static WebDriver getDriver() {
        return driver;
    }

    public  static String getBaseUrl() {
        return baseUrl;
    }
    
}
