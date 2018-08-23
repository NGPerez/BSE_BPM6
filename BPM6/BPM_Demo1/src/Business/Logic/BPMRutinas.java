package Business.Logic;

import Configuration.NavigatorDriverConfiguration;
import Data.Parametros;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BPMRutinas {
    
    private WebDriver driver;
    private static BPMRutinas INSTANCE = null;
    private BPMRutinas(){
        NavigatorDriverConfiguration fcd = new NavigatorDriverConfiguration(Parametros.getInstance("BPM").getNavigator(), Parametros.getInstance("BPM").getApi());
        driver = fcd.getDriver();
    }
    
    
    public static BPMRutinas getInstance(){
        if(INSTANCE == null){
           INSTANCE = new BPMRutinas();
        }
        return INSTANCE;
    }
    
    public WebDriver getWebDriver(){
        return driver;
    }
    
    public void login(){
        driver.get(Parametros.getInstance(Parametros.getInstance("BPM").getApi()).getLoginSite());
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys(Parametros.getInstance(Parametros.getInstance("BPM").getApi()).getUsername());
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(Parametros.getInstance(Parametros.getInstance("BPM").getApi()).getPassword());
        driver.findElement(By.linkText("Continuar")).click();
    }
    
    public void sprint4(){
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
