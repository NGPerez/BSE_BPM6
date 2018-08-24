package Business.Logic;

import Configuration.NavigatorDriverConfiguration;
import Data.Parametros;
import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class BPMRutinas {

    private WebDriver driver;
    static NgWebDriver ngdriver;
    private static BPMRutinas INSTANCE = null;

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

    public void login() {
        driver.get(Parametros.getInstance(Parametros.getInstance("BPM").getApi()).getLoginSite());
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys(Parametros.getInstance(Parametros.getInstance("BPM").getApi()).getUsername());
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(Parametros.getInstance(Parametros.getInstance("BPM").getApi()).getPassword());
        driver.findElement(By.linkText("Continuar")).click();
    }

    public void aperturar(String nroDenuncia) {
        driver.findElement(By.xpath("//*[@id=\"div_1_2_1_2_1\"]/div/div[1]/div[1]/div[1]/input")).sendKeys(nroDenuncia);
        driver.findElement(By.xpath("//*[@id=\"div_1_2_1_2_1\"]/div/div[1]/div[2]/button/i")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(BPMRutinas.class.getName()).log(Level.SEVERE, null, ex);
        }
        driver.findElement(ByAngular.repeater("(rowRenderIndex, row) in rowContainer.renderedRows track by $index")).click();
        //driver.switchTo().alert().accept();
        //driver.findElement(By.xpath("//*[@id=\"div_31_1_1_1\"]/button")).click();
        
        //driver.findElement(ByAngular.repeater("tab in tabs track by tab.$id == 2")).click();
    }

    public void sprint4() {
        //driver.get("https://bpmd-pserver-cert.bse.com.uy:9443/ProcessPortal/dashboards/TWP/Processes");

        //driver.findElement(By.className("menu-button menu-button-left")).click();
        //Buscar algun registro en estado aperturar
        //BPMRutinas.getInstance().sprint4();
        //driver.findElement(By.className("menu-button menu-button-left")).click();
        //class="menu-button menu-button-left"
        //driver.findElement(By.xpath("//div[@id='frmPrincipal:menuEstados']/a/label")).click();
        //driver.findElement(By.linkText("Procesos")).click();
        //driver.findElement(By.id("taskListPaginationButton_PaginationBar_0")).click();
        //Parametrizar de un archivo. 
        //driver.findElement(By.id("frag0_BaseTextDirectionMixin_0")).sendKeys("217237"); 
        //driver.findElement(By.cssSelector("div.pillEditorMagnifyingGlass")).click();
        //css=div.pillEditorMagnifyingGlass
    }

}
