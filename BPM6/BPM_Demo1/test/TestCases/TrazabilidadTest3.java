package TestCases;

import Business.Logic.BPMRutinas;
import Logica.Fabricas.SalidaSikulixFabric;
import com.paulhammant.ngwebdriver.NgWebDriver;
import junit.framework.TestCase;
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

public class TrazabilidadTest3 extends TestCase {

    /*                          Atributes                                     */
    private WebDriver driver;
    static NgWebDriver ngdriver;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    public TrazabilidadTest3() {
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
        driver = BPMRutinas.getInstance().getWebDriver();
        ngdriver = BPMRutinas.getInstance().getNgWebDriver();
    }

    @After
    @Override
    public void tearDown() throws Exception {
        //driver.close();
        //String verificationErrorString = verificationErrors.toString();
        //if (!"".equals(verificationErrorString)) {
        //    fail(verificationErrorString);
        //}
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
    public void testFlujo1() throws Exception {
        String path = SalidaSikulixFabric.getInstancia().getSalidaSikulixController().getPathSikuliTextFile();
        String nroDenuncia = "217237";

        System.out.println("Path: " + path);
        SalidaSikulixFabric.getInstancia().getSalidaSikulixController().cargarEnListaSalidaSikulix(path);

        BPMRutinas.getInstance().login();
        BPMRutinas.getInstance().aperturar(nroDenuncia);
        
/*
        if (driver.findElement(ByAngular.repeater("item in binding.value.dataStore.data | apexOrderBy:columnSort.col:columnSort.reverse | startFrom: options.firstItemIndex | limitTo: options.itemsPerPage track by item.bpm_id")).getText().equalsIgnoreCase("Genérico de taller")) {
            if(!driver.findElement(ByAngular.model("$parent.selectedIds[item.bpm_id]")).isSelected()){
                driver.findElement(ByAngular.model("$parent.selectedIds[item.bpm_id]")).click();
            }
        }
        
        */
//Este valor es leido de un archivo. 

        //Dentro del bucle. 
        //for (SalidaSikulix listaEntradas : lstSikulix) {
        //driver.findElement(By.xpath("//*[@id=\"div_1_2_1_2_1\"]/div/div[1]/div[1]/div[1]/input")).sendKeys(listaEntradas.getNroDenuncia());
        //driver.findElement(By.xpath("//*[@id=\"div_1_2_1_2_1\"]/div/div[1]/div[1]/div[1]/input")).sendKeys("217237");
        //driver.findElement(By.xpath("//*[@id=\"div_1_2_1_2_1\"]/div/div[1]/div[2]/button/i")).click();
        //driver.findElement(ByAngular.repeater("(rowRenderIndex, row) in rowContainer.renderedRows track by $index")).click();
    }
}