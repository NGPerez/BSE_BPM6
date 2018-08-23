package TestCases;

import Business.Logic.BPMRutinas;
import Business.Logic.TrazabilidadRutinas;
import Configuration.NavigatorDriverConfiguration;
import Data.Parametros;
import Entidades.SalidaSikulix;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
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

public class TrazabilidadTest3 extends TestCase {

    /*                          Navigators                                    */
    private static final String NAVIGATOR_RECTOR = "IE";
    private static final String NAVIGATOR_TRAZABILIDAD = "CHROME";
    private static final String NAVIGATOR_BPM = "FIREFOX";

    /*                          Atributes                                     */
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private List<SalidaSikulix> lstSikulix;

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
        lstSikulix = new ArrayList<>();
        driver = BPMRutinas.getInstance().getWebDriver();
       
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

    private void cargarEnListaSalidaSikulix(String path) {
        System.out.println("cargarEnListaSalidaSikulix -> INICIO");
        
        //Atributos
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String matricula = "";
        String dia = "";
        String mes = "";
        String anio = "";
        String serie = "";
        String nroDenuncia = "";
        String nroPoliza = "";

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(path);
            System.out.println("Path: " + path);
            System.out.println("Archivo Path: " + archivo.getAbsolutePath());
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            int nroLinea = 0;
            System.out.println("cargarEnListaSalidaSikulix -> ANTES DE while ((linea = br.readLine()) != null)") ;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
                switch (nroLinea % 7) {
                    case 0: mes = linea; break;
                    case 1: dia = linea; break;
                    case 2: mes = linea; break;
                    case 3: anio = linea; break;
                    case 4: serie = linea; break;
                    case 5: nroDenuncia = linea; break;
                    case 6: nroPoliza = linea; break;
                }
                System.out.println("cargarEnListaSalidaSikulix -> nroLinea: " + nroLinea + " | nroLinea%7: " + (nroLinea%7));
                if ((nroLinea > 0) && (nroLinea % 7 == 0)) {
                    lstSikulix.add(new SalidaSikulix(matricula, dia, mes, anio, serie, nroDenuncia, nroPoliza));
                }
                nroLinea++;
            }
            System.out.println("cargarEnListaSalidaSikulix -> DESPUES DE while ((linea = br.readLine()) != null)");
            if(lstSikulix.size() == 0){
                System.out.println("cargarEnListaSalidaSikulix -> La lista lstSikulix es vacia");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        System.out.println("cargarEnListaSalidaSikulix -> FIN");
    }

    private String getParentPathSikuliTextFile() {
        System.out.println("getParentPathSikuliTextFile -> INICIO");
        
        //Atributos
        String path_file = System.getProperty("user.dir");
        int k = 0;
        String parent = "";

        for (String retval : path_file.split("\\\\")) {
            if (!retval.equalsIgnoreCase("BPM6") && (k == 0)) {
                parent += retval + "\\";
            } else if (retval.equalsIgnoreCase("BPM6")) {
                parent += retval;
                k++;
            } else {}
        }
        System.out.println("getParentPathSikuliTextFile -> FIN");
        return parent;
    }
    
    private void mostrarListaSikulix(){
        System.out.println("mostrarListaSikulix -> INICIO");
        for(SalidaSikulix s : lstSikulix){
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
    public void testFlujo1() throws Exception {
         BPMRutinas.getInstance().login();
         //Este valor es leido de un archivo. 
         
         //Dentro del bucle. 
            driver.findElement(By.xpath("//*[@id=\"div_1_2_1_2_1\"]/div/div[1]/div[1]/div[1]/input")).clear();
            driver.findElement(By.xpath("//*[@id=\"div_1_2_1_2_1\"]/div/div[1]/div[1]/div[1]/input")).sendKeys("217237");
            driver.findElement(By.xpath("//*[@id=\"div_1_2_1_2_1\"]/div/div[1]/div[2]/button/i")).click();

                  

//driver.findElement(By.className("form-control ng-pristine ng-valid ng-touched")).clear();
         //ie9-placeholder ng-binding"
         //driver.findElement(By.xpath("//*[@id=\"dashboard-menu-item-2015.25\"]/div/div[2]/a")).click();
         //driver.findElement(By.xpath("//*[@id=\"frag0_BaseTextDirectionMixin_0\"]")).sendKeys("22222");
         
                 //driver.findElement(By.className("form-control ng-pristine ng-valid ng-touched")).sendKeys("217237");
         
        // driver.findElement(By.className("form-control ng-pristine ng-valid ng-touched")).sendKeys("217237");
        //driver.findElement(By.xpath("//*[@id=\"div_1_2_1_2_1\"]/div/div[1]/div[1]/div[1]")).sendKeys("217237");
        
        // driver.findElement(By.xpath("//*[@id=\"dashboard-menu-item-2015.25\"]/div/div[2]/a")).click();
         //driver.findElement(By.id("frag0_BaseTextDirectionMixin_0")).
         //driver.findElement(By.xpath("//*[@id=\"frag0_BaseTextDirectionMixin_0\"]")).click(); 
         
         //driver.findElement(By.xpath("//*[@id=\"editor_BaseTextDirectionMixin_0\"]")).sendKeys("217237"); 
       //  driver.findElement(By.xpath("//*[@id=\"frag0_BaseTextDirectionMixin_0\"]")).sendKeys("217237");
//         driver.findElement(By.id("frag0_BaseTextDirectionMixin_0")).sendKeys("217237"); 
         //frag0_BaseTextDirectionMixin_0
         // //*[@id="editor_BaseTextDirectionMixin_0"]
         // //*[@id="frag0_BaseTextDirectionMixin_0"]
         
        //driver.get("https://bpmd-pserver-cert.bse.com.uy:9443/ProcessPortal/dashboards/TWP/Processes");
        //Buscar algun registro en estado aperturar
       // BPMRutinas.getInstance().sprint4();
       
       //class="menu-button menu-button-left"
       //driver.findElement(By.xpath("//div[@id='frmPrincipal:menuEstados']/a/label")).click();
         //driver.findElement(By.linkText("Procesos")).click();
        //driver.findElement(By.id("taskListPaginationButton_PaginationBar_0")).click();
         
       //Parametrizar de un archivo. 
       //driver.findElement(By.id("frag0_BaseTextDirectionMixin_0")).sendKeys("217237"); 
       //driver.findElement(By.cssSelector("div.pillEditorMagnifyingGlass")).click();
        //css=div.pillEditorMagnifyingGlass
    }
    @Test
    public void testSecuencia2() throws Exception {
        //BPMRutinas.getInstance().login();
        
        
        
//        driver.findElement(By.partialLinkText("Bandeja")).click();
//        String parent = getParentPathSikuliTextFile();
//        String path = parent + "\\Sikuli_Run\\Resultado.txt";
//        System.out.println("Path: " + path);
//        cargarEnListaSalidaSikulix(path);
//        mostrarListaSikulix();
//        System.out.println("Despues de mostrar");
//        for (SalidaSikulix listaEntradas : lstSikulix) {
//            driver.findElement(By.id("frmPrincipal:buscarTxt")).sendKeys(listaEntradas.getNroDenuncia());
//            driver.findElement(By.xpath("//button[@id='frmPrincipal:listaReclamos:0:selectButton']/span")).click();
//            driver.findElement(By.linkText("Documentos Adjuntos")).click();
//            driver.findElement(By.id("frmPrincipal:viewPppal:pfile_input")).sendKeys(path);
//            driver.findElement(By.xpath("//a[@id='frmPrincipal:viewPppal:j_idt155']/img")).submit();
//            driver.findElement(By.xpath("//a[@id='frmPrincipal:j_idt53']/img")).click();
//        }
    }
}
