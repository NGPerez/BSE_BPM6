package TestCases;

import Business.Logic.TrazabilidadRutinas;
import Data.Parametros;
import Entidades.SalidaSikulix;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import oracle.jdbc.*;
import oracle.core.lmx.*;
import oracle.jpub.runtime.*;
import oracle.sql.*;
import java.util.Date;
import static org.apache.xalan.lib.ExsltDatetime.date;

public class TrazabilidadTest1_5 extends TestCase {

    /*                          Atributes                                     */
    private WebDriver driver;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    List<SalidaSikulix> lstEntradaSikulix;
    List<SalidaSikulix> lstSalida;

    public TrazabilidadTest1_5() {
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
        //lstEntradaSikulix = new ArrayList<>();
        //driver = TrazabilidadRutinas.getInstance().getWebDriver();
    }

    @After
    @Override
    public void tearDown() throws Exception {
        //driver.quit();
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

    private Connection conexion;
    public void conectar() {
        try {
             Class.forName("oracle.jdbc.OracleDriver");
             String BaseDeDatos = "jdbc:oracle:thin:@desa-db:1521:rectest";
             
            conexion = DriverManager.getConnection(BaseDeDatos, "consulta","entrenomas"); 
            if (conexion != null) {
                System.out.println("Conexion exitosa!");
            } else {
                System.out.println("Conexion fallida!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ResultSet consultar(String sql) {
        ResultSet resultado = null;
        try {
            Statement sentencia;
            sentencia = conexion.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            resultado = sentencia.executeQuery(sql);
            conexion.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }        return resultado;
    }
    public String CrearConsulta(String matricula){
        return "select cace_capo_nu_poliza,cace_nu_certificado,crpd_nu_endoso,cace_fe_desde,cace_fe_hasta,cacw_fe_desde,cacw_fe_hasta,cace_st_certificado,cacw_came_tp_transac" + 
                     " from cret_productos_datos,cart_certificados,cart_certificados_endosos" +
                     " where crpd_carp_Cd_ramo=4 " +
                        " and crpd_dato='"+matricula+"'" +
                        " and crpd_carp_cd_ramo=cace_carp_cd_ramo" +
                        " and crpd_capo_nu_poliza=cace_capo_nu_poliza" +
                        " and crpd_cace_nu_certificado=cace_nu_certificado" +
                        " and cacw_carp_cd_ramo=cace_carp_cd_ramo" +
                        " and cacw_capo_nu_poliza=cace_capo_nu_poliza" +
                        " and cacw_cace_nu_certificado=cace_nu_certificado" +
                        " and cacw_nu_endoso=crpd_nu_endoso" +
                        " order by crpd_nu_endoso desc ";       
//return "select *" + " from cret_productos_datos"; 
        
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
    public List<SalidaSikulix> CargarLista() throws Exception {
        List<SalidaSikulix> lstSikulix2 = null;
        lstSikulix2 = new ArrayList<>();
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
        
       
        String path = getParentPathSikuliTextFile() + "\\Sikuli_Run\\Entradas.txt";
        
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
            int max = 1000; 
            while (((linea = br.readLine()) != null) && (max != 0)) {
                if (nroLinea == 0){
                    max= Integer.parseInt(linea);	
                }else{
                    
                    switch (nroLinea % 7) {
                        case 1:
                            matricula = linea;
                            break;
                        case 2:
                            dia = linea;
                            break;
                        case 3:
                            mes = linea;
                            break;
                        case 4:
                            anio = linea;
                            break;
                        case 5:
                            serie = linea;
                            break;
                        case 6:
                            nroDenuncia = linea;
                            break;
                        }
                    
                    if ((nroLinea > 0) && (nroLinea % 7 == 0)) {
                        SalidaSikulix s = new SalidaSikulix(matricula, dia, mes, anio, serie, nroDenuncia, nroPoliza);
                        lstSikulix2.add(s);
                        max--; 
                    }
                }    
                nroLinea++;
            }
            if (lstSikulix2.size() == 0) {
               System.out.println("cargarEnListaSalidaSikulix -> La lista lstSikulix es vacia");
            }else{
               System.out.println(lstSikulix2.size());
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
        return lstSikulix2;
    }
    
    @Test
    public void testLoginCorrecto() throws Exception {
        FileWriter fileWriter = new FileWriter("..//Sikuli_Run//Resultado.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        
        conectar(); 
        ResultSet resultado = null;
        String consulta = ""; 
        try{
            List<SalidaSikulix> Lista = CargarLista();
            
            for(int indice = 0;indice<Lista.size();indice++){
                //System.out.println(Lista.get(indice).getMatricula());
                
                ResultSet resultados = consultar(CrearConsulta(Lista.get(indice).getMatricula()));
                if ( resultados != null){
                    try {
                        boolean bandera = true;
                        while (resultados.next() && bandera) {
                            
                            Calendar Medio = Calendar.getInstance();
                            Medio.set(Integer.parseInt(Lista.get(indice).getAnio()), Integer.parseInt(Lista.get(indice).getMes()) -1 , Integer.parseInt(Lista.get(indice).getDia()), 0, 0);
                            Date desde = resultados.getDate("CACW_FE_DESDE");
                            Date hasta = resultados.getDate("CACW_FE_HASTA");
                            if (desde.before(Medio.getTime()) && hasta.after(Medio.getTime())){
                                //System.out.println("Este" +indice);
                                bandera = false; 
                                String poliza = resultados.getNString("CACE_CAPO_NU_POLIZA");
                                    printWriter.println(Lista.get(indice).getMatricula());
                                    printWriter.println(Lista.get(indice).getDia());
                                    printWriter.println(Lista.get(indice).getMes());
                                    printWriter.println(Lista.get(indice).getAnio());
                                    printWriter.println(Lista.get(indice).getSerie());
                                    printWriter.println(Lista.get(indice).getNroDenuncia());
                                    printWriter.println(resultados.getNString("CACE_CAPO_NU_POLIZA"));
    
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }catch(NoAlertPresentException e) {}  
        //printWriter.println("&&");
        printWriter.close();
        fileWriter.close(); 
        
          
    }
}

