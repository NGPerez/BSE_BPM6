/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author ngperez
 */
public class Parametros {

    /**
     * *****************************URL BUILDER*******************************
     */
    private static final String PROTOCOL = "http";

    /*                            TRAZABILIDAD                                */
    private static final String DOMAIN_TRAZABILIDAD = "jboss-test01";
    private static final String PORT_TRAZABILIDAD = "8080";
    private static final String SERVER_TRAZABILIDAD = "TrazaWeb";
    private static final String LOGIN_SITE_TRAZABILIDAD = "login.jsf";

    /*                              RECTOR                                    */
    private static final String DOMAIN_RECTOR = "desa-app";
    private static final String PORT_RECTOR = "8888";
    private static final String SERVER_RECTOR = "forms";
    private static final String LOGIN_SITE_RECTOR = "frmservlet?config=recTEST";

    /*                                BPM                                     */
    private static final String DOMAIN_BPM = "";
    private static final String PORT_BPM = "";
    private static final String SERVER_BPM = "";
    private static final String LOGIN_SITE_BPM = "";
    
    /******************************CREDENTIALS*********************************/
    
    /*                             TRAZABILIDAD                               */
    private static final String USERNAME_TRAZABILIDAD = "TALLER519";
    private static final String PASSWORD_TRAZABILIDAD = "Taller.519";
    
    /*                                RECTOR                                  */
    private static final String USERNAME_RECTOR = "TESTRECL2";
    private static final String PASSWORD_RECTOR = "TESTING-3";
    
    /*                                  BPM                                   */
    private static final String USERNAME_BPM = "";
    private static final String PASSWORD_BPM = "";
    
    private static String domain;
    private static String port;
    private static String server;
    private static String loginSite;
    private static String username;
    private static String password;

    private static Parametros INSTANCIA = null;

    private Parametros() {
        this.domain = DOMAIN_TRAZABILIDAD;
        this.port = PORT_TRAZABILIDAD;
        this.server = SERVER_TRAZABILIDAD;
        this.loginSite = LOGIN_SITE_TRAZABILIDAD;
        this.username = USERNAME_TRAZABILIDAD;
        this.password = PASSWORD_TRAZABILIDAD;
    }

    private Parametros(String api) {
        if (api.equalsIgnoreCase("TRAZABILIDAD")) {
            this.domain = DOMAIN_TRAZABILIDAD;
            this.port = PORT_TRAZABILIDAD;
            this.server = SERVER_TRAZABILIDAD;
            this.loginSite = LOGIN_SITE_TRAZABILIDAD;
            this.username = USERNAME_TRAZABILIDAD;
            this.password = PASSWORD_TRAZABILIDAD;
        }else if (api.equalsIgnoreCase("RECTOR")) {
            this.domain = DOMAIN_RECTOR;
            this.port = PORT_RECTOR;
            this.server = SERVER_RECTOR;
            this.loginSite = LOGIN_SITE_RECTOR;
            this.username = USERNAME_RECTOR;
            this.password = PASSWORD_RECTOR;
        }else if (api.equalsIgnoreCase("BPM")) {
            this.domain = DOMAIN_BPM;
            this.port = PORT_BPM;
            this.server = SERVER_BPM;
            this.loginSite = LOGIN_SITE_BPM;
            this.username = USERNAME_BPM;
            this.password = PASSWORD_BPM;
        }else{
            this.domain = "";
            this.port = "";
            this.server = "";
            this.loginSite = "";
            this.username = "";
            this.password = "";
        }

    }

    public static Parametros getInstance() {
        if (INSTANCIA == null) {
            INSTANCIA = new Parametros();
        }
        return INSTANCIA;
    }

    public static Parametros getInstance(String api) {
        if (INSTANCIA == null) {
            INSTANCIA = new Parametros(api);
        }
        return INSTANCIA;
    }

    public String getUrlBase() {
        return PROTOCOL + "://" + domain + ":" + port;
    }

    public String getLoginSite() {
        return getUrlBase() + "/" + server + "/" + loginSite;
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }
}
