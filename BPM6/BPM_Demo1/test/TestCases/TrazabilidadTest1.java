package TestCases;

import Business.Logic.TrazabilidadRutinas;
import Configuration.NavigatorDriverConfiguration;
import Data.Parametros;
import Entidades.SalidaSikulix;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
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

public class TrazabilidadTest1 extends TestCase {

    /*                          Atributes                                     */
    private WebDriver driver;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    List<SalidaSikulix> lstEntradaSikulix;

    public TrazabilidadTest1() {
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
        lstEntradaSikulix = new ArrayList<>();
        driver = TrazabilidadRutinas.getInstance().getWebDriver();
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
    
    private void mostrarListaSikulix(){
        System.out.println("mostrarListaSikulix -> INICIO");
        for(SalidaSikulix s : lstEntradaSikulix){
            System.out.println();
            System.out.println("Matricula: " + s.getMatricula());
            System.out.println("Fecha: " + s.getDia() + "/" + s.getMes() + "/" + s.getAnio());
            System.out.println("Serie: " + s.getSerie());
            System.out.println("Numero de Denuncia: " + s.getNroDenuncia());
            System.out.println("Numero de Poliza: " + s.getNroPoliza());
            System.out.println();
            System.out.println("===========================================================");
        }
        System.out.println("mostrarListaSikulix -> FIN");
    }

    @Test
    public void testLoginCorrecto() throws Exception {

        String fecha = "";
        FileWriter fileWriter = new FileWriter("..//Sikuli_Run//Entradas.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        

        driver.get(Parametros.getInstance("TRAZABILIDAD").getLoginSite());
        driver.findElement(By.id("usuario")).sendKeys(Parametros.getInstance("TRAZABILIDAD").getUsername());
        driver.findElement(By.id("clave")).sendKeys(Parametros.getInstance("TRAZABILIDAD").getPassword());
        driver.findElement(By.id("btnIngresar")).click();
        driver.findElement(By.cssSelector("span.ui-menuitem-text")).click();
        driver.findElement(By.xpath("//div[@id='frmPrincipal:menuEstados']/a/label")).click();
        driver.findElement(By.xpath("//div[@id='frmPrincipal:menuEstados_panel']/div[2]/ul/li[2]/div/div/span")).click();
        driver.findElement(By.xpath("//div[@id='frmPrincipal:menuEstados']/a/label")).click();
        driver.findElement(By.cssSelector("span.ui-button-text.ui-c")).submit();
        System.out.println("ANTES DE DO WHILE");
        int inicio = 1;
        do {
            System.out.println("DENTRO INICIO DE DO WHILE");
            
            for (int i = 1; i < 11; i++) {
                SalidaSikulix entradaSikulix = new SalidaSikulix();
                for (int j = 1; j < 9; j++) {
                    if (j == 3) {
                        entradaSikulix.setSerie(driver.findElement(By.xpath("//div[@class='ui-datatable-tablewrapper']/table/tbody/tr[" + i + "]/td[" + j + "]/span")).getText());
                    }
                    if (j == 4) {
                        entradaSikulix.setNroDenuncia(driver.findElement(By.xpath("//div[@class='ui-datatable-tablewrapper']/table/tbody/tr[" + i + "]/td[" + j + "]/span")).getText());
                    }
                    if (j == 5) {
                        entradaSikulix.setMatricula(driver.findElement(By.xpath("//div[@class='ui-datatable-tablewrapper']/table/tbody/tr[" + i + "]/td[" + j + "]/span")).getText());
                    }
                    if (j == 8) {
                        fecha = driver.findElement(By.xpath("//div[@class='ui-datatable-tablewrapper']/table/tbody/tr[" + i + "]/td[" + j + "]/span")).getText();
                    }
                }
                int k = 0;
                for (String retval : fecha.split("/")) {
                    if (k == 0) {
                        entradaSikulix.setDia(retval);
                    }
                    if (k == 1) {
                        entradaSikulix.setMes(retval);
                    }
                    if (k == 2) {
                        entradaSikulix.setAnio(retval);
                    }
                    k++;
                }
                entradaSikulix.setNroPoliza("*");
                lstEntradaSikulix.add(entradaSikulix);
            }
            driver.findElement(By.cssSelector("span.ui-button-text.ui-c")).click();
            
            mostrarListaSikulix();
            
            System.out.println("DENTRO FIN DE DO WHILE");
            driver.findElement(By.xpath("//span[5]/span")).click();
            inicio++;
        } while (!(inicio == 39));
        System.out.println("DESPUES DE DO WHILE");
        //FOR PARA ITERAR EN LISTA
        printWriter.println(lstEntradaSikulix.size());
        for (SalidaSikulix s : lstEntradaSikulix) {
            printWriter.println(s.getMatricula());
            printWriter.println(s.getDia());
            printWriter.println(s.getMes());
            printWriter.println(s.getAnio());
            printWriter.println(s.getSerie());
            printWriter.println(s.getNroDenuncia());
            printWriter.println(s.getNroPoliza());
        }

        /*

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
         */
    }

}
