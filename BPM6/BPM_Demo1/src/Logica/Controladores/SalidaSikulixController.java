package Logica.Controladores;

import Entidades.SalidaSikulix;
import Logica.Interfaces.SalidaSikulixInterface;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SalidaSikulixController implements SalidaSikulixInterface {

    //Atributos
    List<SalidaSikulix> lstSikulix;

    private static SalidaSikulixController INSTANCIA = null;

    private SalidaSikulixController() {
        lstSikulix = new ArrayList<>();
    }

    public static SalidaSikulixController getIntancia() {
        if (INSTANCIA == null) {
            INSTANCIA = new SalidaSikulixController();
        }
        return INSTANCIA;
    }

    @Override
    public int sizeOfLstSikulix() {
        return lstSikulix.size();
    }

    @Override
    public boolean isEmptyOfLstSikulix() {
        return lstSikulix.isEmpty();
    }

    @Override
    public boolean containsOfLstSikulix(Object o) {
        return lstSikulix.contains(o);
    }

    @Override
    public boolean addOfLstSikulix(SalidaSikulix e) {
        return lstSikulix.add(e);
    }

    @Override
    public boolean addOfLstSikulix(String matricula, String dia, String mes, String anio, String serie, String nroDenuncia, String nroPoliza) {
        return lstSikulix.add(new SalidaSikulix(matricula, dia, mes, anio, serie, nroDenuncia, nroPoliza));
    }

    @Override
    public void clearOfLstSikulix() {
        lstSikulix.clear();
    }

    @Override
    public SalidaSikulix getOfLstSikulixFromMatricula(String matricula) {
        SalidaSikulix ss = null;
        for (SalidaSikulix ssAux : lstSikulix) {
            if (ssAux.getMatricula().equalsIgnoreCase(matricula)) {
                return ss = ssAux;
            }
        }
        return ss;
    }

    @Override
    public SalidaSikulix getOfLstSikulixFromNroDenuncia(String nroDenuncia) {
        SalidaSikulix ss = null;
        for (SalidaSikulix ssAux : lstSikulix) {
            if (ssAux.getNroDenuncia().equalsIgnoreCase(nroDenuncia)) {
                return ss = ssAux;
            }
        }
        return ss;
    }

    @Override
    public SalidaSikulix getOfLstSikulixFromNroPoliza(String nroPoliza) {
        SalidaSikulix ss = null;
        for (SalidaSikulix ssAux : lstSikulix) {
            if (ssAux.getNroPoliza().equalsIgnoreCase(nroPoliza)) {
                return ss = ssAux;
            }
        }
        return ss;
    }

    @Override
    public boolean removeOfLstSikulixFromMatricula(String matricula) {
        SalidaSikulix ss = getOfLstSikulixFromMatricula(matricula);
        return lstSikulix.remove(ss);
    }

    @Override
    public boolean removeOfLstSikulixFromNroDenuncia(String nroDenuncia) {
        SalidaSikulix ss = getOfLstSikulixFromNroDenuncia(nroDenuncia);
        return lstSikulix.remove(ss);
    }

    @Override
    public boolean removeOfLstSikulixFromNroPoliza(String nroPoliza) {
        SalidaSikulix ss = getOfLstSikulixFromNroPoliza(nroPoliza);
        return lstSikulix.remove(ss);
    }

    @Override
    public void mostrarListaSikulix() {
        System.out.println("mostrarListaSikulix -> INICIO");
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

    @Override
    public String getParentPathSikuliTextFile() {
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

    @Override
    public void cargarEnListaSalidaSikulix(String path) {
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
            System.out.println("cargarEnListaSalidaSikulix -> ANTES DE while ((linea = br.readLine()) != null)");
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
                switch (nroLinea % 7) {
                    case 0:
                        mes = linea;
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

    @Override
    public String getPathSikuliTextFile() {
        return getParentPathSikuliTextFile() + "\\Sikuli_Run\\Resultado.txt";
    }

}
