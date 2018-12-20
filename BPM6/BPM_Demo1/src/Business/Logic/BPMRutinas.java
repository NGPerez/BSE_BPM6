package Business.Logic;

import Configuration.NavigatorDriverConfiguration;
import Data.Parametros;
import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;
import com.sun.javafx.binding.Logging;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BPMRutinas {

    private WebDriver driver;
    static NgWebDriver ngdriver;
    private static BPMRutinas INSTANCE = null;
    //private SeleniumProvider selenium;

    private BPMRutinas() {
        NavigatorDriverConfiguration fcd = new NavigatorDriverConfiguration(Parametros.getInstance("BPM").getNavigator(), Parametros.getInstance("BPM").getApi());
        driver = fcd.getDriver();
        ngdriver = new NgWebDriver((JavascriptExecutor) driver);
    }

    public static BPMRutinas getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BPMRutinas();
        }
        return INSTANCE;
    }

    public WebDriver getWebDriver() {
        return driver;
    }

    public NgWebDriver getNgWebDriver() {
        return ngdriver;
    }

    public void login() {
        driver.get(Parametros.getInstance(Parametros.getInstance("BPM").getApi()).getLoginSite());
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys(Parametros.getInstance(Parametros.getInstance("BPM").getApi()).getUsername());
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(Parametros.getInstance(Parametros.getInstance("BPM").getApi()).getPassword());
        driver.findElement(By.linkText("Continuar")).click();
    }

    private int indexOfIframe(String xpath) {
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println();
        System.out.println("SE VA A BUSCAR EL INDICE DEL IFRAME");
        System.out.println("===================================");
        for (int i = 0; i <= size; i++) {
            driver.switchTo().frame(i);
            List<WebElement> elem = driver.findElements(By.xpath(xpath));
            int total = elem.size();
            System.out.println("Indice: " + i + " | valor: " + total + " | toString():" + elem.toString());
            driver.switchTo().defaultContent();
            if(total == 1){
                return i;
            }
        }
        System.out.println();
        return -1;
    }

    public void aperturar(String nroDenuncia) {
        //String recatalogar = "Audio";
        driver.findElement(By.xpath("//*[@id=\"div_1_2_1_2_1\"]/div/div[1]/div[1]/div[1]/input")).sendKeys(nroDenuncia);
        driver.findElement(By.xpath("//*[@id=\"div_1_2_1_2_1\"]/div/div[1]/div[2]/button/i")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(BPMRutinas.class.getName()).log(Level.SEVERE, null, ex);
        }
        driver.findElement(ByAngular.repeater("(rowRenderIndex, row) in rowContainer.renderedRows track by $index")).click();
        
        /*********************************************************************************************************/
        //xpath iframe
        driver.switchTo().frame(indexOfIframe("//*[@id=\"2025.9b014f18-12c0-45c7-80c1-78f2c2eb3fcb\"]"));
        driver.switchTo().frame(indexOfIframe("//*[@id=\"div_2_1_1_2_1_1\"]/ul/li[2]/a"));
        
        
        
        
        /***********************************************************************************************************/
        
//        int size = driver.findElements(By.tagName("iframe")).size();
//        System.out.println("Cantidad de iframes: " + size);
/*
        ngdriver.waitForAngularRequestsToFinish();
        try {
            Thread.sleep(5000); //Min 4500, Avg 6000
        } catch (InterruptedException ex) {
            Logger.getLogger(BPMRutinas.class.getName()).log(Level.SEVERE, null, ex);
        }
        driver.switchTo().frame(2);
        ngdriver.waitForAngularRequestsToFinish();
        
        driver.switchTo().frame(0);
*/
        driver.findElement(By.xpath("//*[@id=\"div_2_1_1_2_1_1\"]/ul/li[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"div_2_1_1_2_1_1_1_2_1_1_1_1_1_1_1_7\"]/div[2]/div/div[1]/table/thead/tr/th[1]/input")).click();
        driver.findElement(By.xpath("//*[@id=\"div_2_1_1_2_1_1_1_2_1_1_1_1_1_1_1_1_1_4\"]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"div_2_1_1_2_1_1_1_2_1_1_1_1_1_40_1_1_1_1_1_1_Input\"]")).click();
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_A);
            robot.keyPress(KeyEvent.VK_U);
            robot.keyPress(KeyEvent.VK_ENTER);
        } catch (AWTException a) {
            a.printStackTrace();
        }
        driver.findElement(By.xpath("//*[@id=\"div_2_1_1_2_1_1_1_2_1_1_1_1_1_40_1_1_1_3_1_2\"]/button")).click();
      
        //Asignarme tarea en caso de ser necesario
        
        //Pasar de aperturar a analizar amparo
        ngdriver.waitForAngularRequestsToFinish();
        try {
            Thread.sleep(2000); //Min 1000, Avg 1000
        } catch (InterruptedException ex) {
            Logger.getLogger(BPMRutinas.class.getName()).log(Level.SEVERE, null, ex);
        }
        driver.findElement(By.xpath("//*[@id=\"div_2_1_1_2_1_1\"]/ul/li[1]/a")).click();
        
    }
    
    public void analizarAmparo(){
        /*
        ngdriver.waitForAngularRequestsToFinish();
        try {
            Thread.sleep(2000); //Min 1000, Avg 1000
        } catch (InterruptedException ex) {
            Logger.getLogger(BPMRutinas.class.getName()).log(Level.SEVERE, null, ex);
        }
        driver.findElement(By.xpath("//*[@id=\"div_2_1_1_2_1_1\"]/ul/li[1]/a")).click();
        */
    }

    public void sprint4() {
        //driver.get("https://bpmd-pserver-cert.bse.com.uy:9443/ProcessPortal/dashboards/TWP/Processes");
    }

}
