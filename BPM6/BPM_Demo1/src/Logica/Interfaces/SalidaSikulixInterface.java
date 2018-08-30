package Logica.Interfaces;

import Entidades.SalidaSikulix;

public interface SalidaSikulixInterface {
    public int sizeOfLstSikulix();
    public boolean isEmptyOfLstSikulix();
    public boolean containsOfLstSikulix(Object o);
    public boolean addOfLstSikulix(SalidaSikulix e);
    public boolean addOfLstSikulix(String matricula, String dia, String mes, String anio, String serie, String nroDenuncia, String nroPoliza);
    public void clearOfLstSikulix();
    public SalidaSikulix getOfLstSikulixFromMatricula(String matricula);
    public SalidaSikulix getOfLstSikulixFromNroDenuncia(String nroDenuncia);
    public SalidaSikulix getOfLstSikulixFromNroPoliza(String nroPoliza);
    public boolean removeOfLstSikulixFromMatricula(String matricula);
    public boolean removeOfLstSikulixFromNroDenuncia(String nroDenuncia);
    public boolean removeOfLstSikulixFromNroPoliza(String nroPoliza);
    public void mostrarListaSikulix();
    public String getParentPathSikuliTextFile();
    public String getPathSikuliTextFile();
    public void cargarEnListaSalidaSikulix(String path);
}