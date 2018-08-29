package Business.Logic;

import Configuration.NavigatorDriverConfiguration;
import Data.Parametros;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TrazabilidadRutinas {
    
    private WebDriver driver;
    private static TrazabilidadRutinas INSTANCE = null;
    private TrazabilidadRutinas(){
        NavigatorDriverConfiguration fcd = new NavigatorDriverConfiguration(Parametros.getInstance().getNavigator(), Parametros.getInstance().getApi());
        driver = fcd.getDriver();
    }

    public static TrazabilidadRutinas getInstance(){
        if(INSTANCE == null){
           INSTANCE = new TrazabilidadRutinas();
        }
        return INSTANCE;
    }
    
    public WebDriver getWebDriver(){
        return driver;
    }
    
    public void login(){
        driver.get(Parametros.getInstance(Parametros.getInstance().getApi()).getLoginSite());
        driver.findElement(By.id("usuario")).clear();
        driver.findElement(By.id("usuario")).sendKeys(Parametros.getInstance(Parametros.getInstance().getApi()).getUsername());
        driver.findElement(By.id("clave")).clear();
        driver.findElement(By.id("clave")).sendKeys(Parametros.getInstance(Parametros.getInstance().getApi()).getPassword());
        driver.findElement(By.id("btnIngresar")).click();
    }
    
    public void sprint4(){}
    
}
