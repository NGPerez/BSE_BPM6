package TestCases;

import Business.Logic.TrazabilidadRutinas;
import Entidades.SalidaSikulix;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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

public class TrazabilidadTest2 extends TestCase {

    /*                          Atributes                                     */
    private WebDriver driver;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private List<SalidaSikulix> lstSikulix;

    public TrazabilidadTest2() {
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
            String linea = "";
            int nroLinea = 0;
            System.out.println("cargarEnListaSalidaSikulix -> ANTES DE while ((linea = br.readLine()) != null)");
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
                switch (nroLinea % 7) {
                    case 0:
                        matricula = linea;
                        break;
                    case 1:
                        dia = linea;
                        break;
                    case 2:
                        mes = linea;
                        break;
                    case 3:
                        anio = linea;
                        break;
                    case 4:
                        serie = linea;
                        break;
                    case 5:
                        nroDenuncia = linea;
                        break;
                    case 6:
                        nroPoliza = linea;
                        break;
                }
                System.out.println("cargarEnListaSalidaSikulix -> nroLinea: " + nroLinea + " | nroLinea%7: " + (nroLinea % 7));
                if ((nroLinea > 0) && (nroLinea % 7 == 0)) {
                    lstSikulix.add(new SalidaSikulix(matricula, dia, mes, anio, serie, nroDenuncia, nroPoliza));
                }
                nroLinea++;
            }
            System.out.println("cargarEnListaSalidaSikulix -> DESPUES DE while ((linea = br.readLine()) != null)");
            if (lstSikulix.size() == 0) {
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
            } else {
            }
        }
        System.out.println("getParentPathSikuliTextFile -> FIN");
        return parent;
    }

    private void mostrarListaSikulix() {
        System.out.println("mostrarListaSikulix -> INICIO");
/*
        lstSikulix.stream().map((s) -> {
            System.out.println();
            return s;
        }).map((s) -> {
            System.out.println("Matricula: " + s.getMatricula());
            return s;
        }).map((s) -> {
            System.out.println("Fecha: " + s.getDia() + "/" + s.getMes() + "/" + s.getAnio());
            return s;
        }).map((s) -> {
            System.out.println("Serie: " + s.getSerie());
            return s;
        }).map((s) -> {
            System.out.println("Numero de Denuncia: " + s.getNroDenuncia());
            return s;
        }).map((s) -> {
            System.out.println("Numero de Poliza: " + s.getNroPoliza());
            return s;
        }).map((_item) -> {
            System.out.println();
            return _item;
        }).forEachOrdered((_item) -> {
            System.out.println("===========================================================");
        });
*/
        for (SalidaSikulix s : lstSikulix) {
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
    public void testSecuencia2() throws Exception {
        TrazabilidadRutinas.getInstance().login();
        driver.findElement(By.partialLinkText("Bandeja")).click();
        String parent = getParentPathSikuliTextFile();
        String path = parent + "\\Sikuli_Run\\Resultado.txt";
        String imgPath = parent + "\\Sikuli_Run\\Testing.jpg";
        System.out.println("Path: " + path);
        cargarEnListaSalidaSikulix(path);
        mostrarListaSikulix();
        System.out.println("Despues de mostrar");
        boolean present = false;
        for (SalidaSikulix listaEntradas : lstSikulix) {
            Thread.sleep(250);
            driver.findElement(By.id("frmPrincipal:buscarTxt")).click();
            driver.findElement(By.id("frmPrincipal:buscarTxt")).sendKeys(listaEntradas.getNroDenuncia());
            driver.findElement(By.id("frmPrincipal:btnBuscar")).click();
            try {
                System.out.println("texto tabla: "+ driver.findElement(By.xpath("/html/body/div[3]/form/div/div/table[2]/tbody/tr[2]/td/div/div[2]/table/tbody/tr/td")).getText());
                if (driver.findElement(By.xpath("/html/body/div[3]/form/div/div/table[2]/tbody/tr[2]/td/div/div[2]/table/tbody/tr/td")).getText().equalsIgnoreCase("Ninguna línea que mostrar ...")) {
                    present = true;
                }else{
                    present = false;
                }
            } catch (NoSuchElementException e) {
                present = false;
            }
            System.out.println("valor de present: " + present);
            if (!present) {
                driver.findElement(By.xpath("//div[2]/table/tbody/tr/td/button")).click();
                driver.findElement(By.linkText("Documentos Adjuntos")).click();
                driver.findElement(By.id("frmPrincipal:viewPppal:pfile_input")).sendKeys(imgPath);
                driver.findElement(By.xpath("//a[@id='frmPrincipal:viewPppal:j_idt155']/img")).submit();
                driver.findElement(By.xpath("//a[@id='frmPrincipal:j_idt53']/img")).click();
            }
            driver.findElement(By.id("frmPrincipal:buscarTxt")).clear();
        }
    }
}
