package TestCases;

import Configuration.NavigatorDriverConfiguration;
import Data.Parametros;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
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
import org.openqa.selenium.WebElement;

public class TrazabilidadTest extends TestCase {

    /*                          Navigators                                    */
    private static final String NAVIGATOR_RECTOR = "IE";
    private static final String NAVIGATOR_TRAZABILIDAD = "CHROME";
    private static final String NAVIGATOR_BPM = "FIREFOX";

    /*                          Atributes                                     */
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    public TrazabilidadTest() {
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
        NavigatorDriverConfiguration fcd = new NavigatorDriverConfiguration(NAVIGATOR_TRAZABILIDAD, "TRAZABILIDAD");
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

        String matricula = "";
        String fecha = "";
        String dia = "", mes = "", anio = "";
        String serie = "";
        String nroDenuncia = "";
        String cantElementos = "";
        
        FileWriter fileWriter;
        PrintWriter printWriter;

        System.out.println("LoginSite: " + Parametros.getInstance("TRAZABILIDAD").getLoginSite());
        driver.get(Parametros.getInstance("TRAZABILIDAD").getLoginSite());
        driver.findElement(By.id("usuario")).clear();
        driver.findElement(By.id("usuario")).sendKeys(Parametros.getInstance("TRAZABILIDAD").getUsername());
        driver.findElement(By.id("clave")).clear();
        driver.findElement(By.id("clave")).sendKeys(Parametros.getInstance("TRAZABILIDAD").getPassword());
        driver.findElement(By.id("btnIngresar")).click();
        driver.findElement(By.partialLinkText("Bandeja")).click();
        driver.findElement(By.partialLinkText("Estados")).click();
        driver.findElement(By.xpath("//*[@class='ui-selectcheckboxmenu-items-wrapper']//*[text()='Devuelto al Taller']")).click();
        driver.findElement(By.partialLinkText("Estados")).click();
        driver.findElement(By.xpath("//button[@id='frmPrincipal:btnBuscar']")).submit();
        cantElementos = driver.findElement(By.xpath("//div[@id='frmPrincipal:listaReclamos_paginator_top']/select")).getText();
        cantElementos = cantElementos.substring(0, 2);
        fileWriter = new FileWriter("..//Sikuli_Run//Entradas.txt");
        printWriter = new PrintWriter(fileWriter);
        printWriter.println(cantElementos);
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 9; j++) {
                if (j == 3) {
                    serie = driver.findElement(By.xpath("//div[@class='ui-datatable-tablewrapper']/table/tbody/tr[" + i + "]/td[" + j + "]/span")).getText();
                }
                if (j == 4) {
                    nroDenuncia = driver.findElement(By.xpath("//div[@class='ui-datatable-tablewrapper']/table/tbody/tr[" + i + "]/td[" + j + "]/span")).getText();
                }
                if (j == 5) {
                    matricula = driver.findElement(By.xpath("//div[@class='ui-datatable-tablewrapper']/table/tbody/tr[" + i + "]/td[" + j + "]/span")).getText();
                }
                if (j == 8) {
                    fecha = driver.findElement(By.xpath("//div[@class='ui-datatable-tablewrapper']/table/tbody/tr[" + i + "]/td[" + j + "]/span")).getText();
                }
            }
            int k = 0;
            for (String retval : fecha.split("/")) {
                if (k == 0) {
                    dia = retval;
                }
                if (k == 1) {
                    mes = retval;
                }
                if (k == 2) {
                    anio = retval;
                }
                k++;
            }
            printWriter.println(matricula);
            printWriter.println(dia);
            printWriter.println(mes);
            printWriter.println(anio);
            printWriter.println(serie);
            printWriter.println(nroDenuncia);
            printWriter.println("*");
        }
        printWriter.close();
        
    }

}
