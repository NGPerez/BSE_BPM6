package TestCases;

import Business.Logic.TrazabilidadRutinas;
import Data.Parametros;
import Entidades.SalidaSikulix;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;
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

    private void mostrarListaSikulix() {
        int i = 1;
        for (SalidaSikulix s : lstEntradaSikulix) {
            System.out.println();
            System.out.println("==========================" + i + "================================");
            System.out.println("Matricula: " + s.getMatricula());
            System.out.println("Fecha: " + s.getDia() + "/" + s.getMes() + "/" + s.getAnio());
            System.out.println("Serie: " + s.getSerie());
            System.out.println("Numero de Denuncia: " + s.getNroDenuncia());
            System.out.println("Numero de Poliza: " + s.getNroPoliza());
            System.out.println();
            System.out.println("===========================================================");
            i++;
        }
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
        WebElement nextPage = driver.findElement(By.cssSelector("span.ui-paginator-next.ui-state-default.ui-corner-all"));
        int inicio = 1;
        while (!driver.findElement(By.cssSelector("span.ui-paginator-next.ui-state-default.ui-corner-all")).getAttribute("class").contains("ui-state-disabled")) {
            for (int i = 1; i < 11; i++) {
                SalidaSikulix entradaSikulix = new SalidaSikulix();
                for (int j = 1; j < 9; j++) {
                    if (j == 3) {
                        //*[@id="frmPrincipal:listaReclamos_data"]/tr[1]/td[4]/span
                        entradaSikulix.setSerie(driver.findElement(By.xpath("//*[@id=\"frmPrincipal:listaReclamos_data\"]/tr[" + i + "]/td[" + j + "]/span")).getText());
                        //entradaSikulix.setSerie(driver.findElement(By.xpath("//*[@id=\"frmPrincipal:listaReclamos_data\"]/tr[1]/td[4]/span")).getText());
                    }
                    if (j == 4) {
                        entradaSikulix.setNroDenuncia(driver.findElement(By.xpath("//*[@id=\"frmPrincipal:listaReclamos_data\"]/tr[" + i + "]/td[" + j + "]/span")).getText());
                    }
                    if (j == 5) {
                        entradaSikulix.setMatricula(driver.findElement(By.xpath("//*[@id=\"frmPrincipal:listaReclamos_data\"]/tr[" + i + "]/td[" + j + "]/span")).getText());
                    }
                    if (j == 8) {
                        fecha = driver.findElement(By.xpath("//*[@id=\"frmPrincipal:listaReclamos_data\"]/tr[" + i + "]/td[" + j + "]/span")).getText();
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
            nextPage.click();
            inicio++;

        }
        for (int i = 1; i < 11; i++) {

            boolean present;
            try {
                driver.findElement(By.xpath("//*[@id=\"frmPrincipal:listaReclamos_data\"]/tr[" + i + "]"));
                present = true;
            } catch (NoSuchElementException e) {
                present = false;
            }

            if (present) {
                SalidaSikulix entradaSikulix = new SalidaSikulix();
                for (int j = 1; j < 9; j++) {
                    if (j == 3) {
                        //*[@id="frmPrincipal:listaReclamos_data"]/tr[1]/td[4]/span
                        entradaSikulix.setSerie(driver.findElement(By.xpath("//*[@id=\"frmPrincipal:listaReclamos_data\"]/tr[" + i + "]/td[" + j + "]/span")).getText());
                        //entradaSikulix.setSerie(driver.findElement(By.xpath("//*[@id=\"frmPrincipal:listaReclamos_data\"]/tr[1]/td[4]/span")).getText());
                    }
                    if (j == 4) {
                        entradaSikulix.setNroDenuncia(driver.findElement(By.xpath("//*[@id=\"frmPrincipal:listaReclamos_data\"]/tr[" + i + "]/td[" + j + "]/span")).getText());
                    }
                    if (j == 5) {
                        entradaSikulix.setMatricula(driver.findElement(By.xpath("//*[@id=\"frmPrincipal:listaReclamos_data\"]/tr[" + i + "]/td[" + j + "]/span")).getText());
                    }
                    if (j == 8) {
                        fecha = driver.findElement(By.xpath("//*[@id=\"frmPrincipal:listaReclamos_data\"]/tr[" + i + "]/td[" + j + "]/span")).getText();
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
        }

        mostrarListaSikulix();
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
        printWriter.close();
        fileWriter.close();
    }

}
