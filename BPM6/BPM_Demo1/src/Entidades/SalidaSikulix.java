package Entidades;

public class SalidaSikulix {
    private String matricula;
    private String dia;
    private String mes;
    private String anio;
    private String serie;
    private String nroDenuncia;
    private String nroPoliza;

    public SalidaSikulix() {
    }

    public SalidaSikulix(String matricula, String dia, String mes, String anio, String serie, String nroDenuncia, String nroPoliza) {
        this.matricula = matricula;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.serie = serie;
        this.nroDenuncia = nroDenuncia;
        this.nroPoliza = nroPoliza;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNroDenuncia() {
        return nroDenuncia;
    }

    public void setNroDenuncia(String nroDenuncia) {
        this.nroDenuncia = nroDenuncia;
    }

    public String getNroPoliza() {
        return nroPoliza;
    }

    public void setNroPoliza(String nroPoliza) {
        this.nroPoliza = nroPoliza;
    }

}
