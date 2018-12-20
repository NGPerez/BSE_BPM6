package Data;

public class Parametros {
    
    /*****************************URL BUILDER**********************************/
    private static final String RECTOR_DATABASE_USERNAME = "consulta";
    private static final String RECTOR_DATABASE_PASSWORD = "entrenomas";
    private static final String RECTOR_DATABASE_HOST = "desa-db";
    private static final String RECTOR_DATABASE_PORT = "1521";
    private static final String RECTOR_DATABASE_NAME = "rectest";
    private static final String RECTOR_DATABASE_DRIVER = "oracle.jdbc.OracleDriver";
    private static final String RECTOR_DATABASE_DRIVER_TYPE = "thin";
    private static final String RECTOR_DATABASE_DATASOURCE = "jdbc:oracle:"+RECTOR_DATABASE_DRIVER_TYPE+":@"+RECTOR_DATABASE_HOST+":"+RECTOR_DATABASE_PORT+":"+RECTOR_DATABASE_NAME;

    /*****************************URL BUILDER**********************************/
    private static final String PROTOCOL = "http";
    private static final String SECURE_PROTOCOL = "https";

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
    private static final String DOMAIN_BPM = "bpmd-pserver-cert.bse.com.uy";
    private static final String PORT_BPM = "9443";
    private static final String SERVER_BPM = "ProcessPortal";
    private static final String LOGIN_SITE_BPM = "login.jsp";
    //https://bpmd-pserver-cert.bse.com.uy:9443/ProcessPortal/login.jsp
    //http://bpmd-pserver-cert.bse.com.uy:9443/ProcessPortal/login.jsp
    //https://bpmd-pserver-cert.bse.com.uy:9443/ProcessPortal/login.jsp
    //http://https//bpmd-pserver-cert.bse.com.uy:9443/ProcessPortal/login.jsp:9443/ProcessPortal/login.jsp
    
    /******************************CREDENTIALS*********************************/
    
    /*                             TRAZABILIDAD                               */
    private static final String USERNAME_TRAZABILIDAD = "TALLER519";
    private static final String PASSWORD_TRAZABILIDAD = "Taller.519";
    
    /*                                RECTOR                                  */
    private static final String USERNAME_RECTOR = "TESTRECL2";
    private static final String PASSWORD_RECTOR = "TESTING-3";
    
    /*                                  BPM                                   */
    private static final String USERNAME_BPM = "kamaro";
    private static final String PASSWORD_BPM = "Nicholas5.";
    
    /*******************************CONSTANTES*********************************/
    
    /*                             TRAZABILIDAD                               */
    private static final String API_TRAZABILIDAD = "TRAZABILIDAD";
    private static final String NAVIGATOR_TRAZABILIDAD = "CHROME";
    
    /*                                RECTOR                                  */
    private static final String API_RECTOR = "RECTOR";
    private static final String NAVIGATOR_RECTOR = "IE";
    
    /*                                  BPM                                   */
    private static final String API_BPM = "BPM";
    private static final String NAVIGATOR_BPM = "CHROME";
    
    /*                                 NAVEGADORES                            */
    private static final String WEB_DRIVER_FIREFOX_PROPERTY = "webdriver.firefox.marionette";
    private static final String WEB_DRIVER_FIREFOX_PATH = System.getProperty("user.dir") + "\\Insumos\\FirefoxDriverServer.exe";
    private static final String WEB_DRIVER_CHROME_PROPERTY = "webdriver.chrome.driver";
    private static final String WEB_DRIVER_CHROME_PATH = System.getProperty("user.dir") + "\\Insumos\\ChromeDriverServer.exe";
    private static final String WEB_DRIVER_IE_PROPERTY = "webdriver.ie.driver";
    private static final String WEB_DRIVER_IE_PATH = System.getProperty("user.dir") + "\\Insumos\\IEDriverServer.exe";
    
    /********************************VARIABLES*********************************/
    private static String domain;
    private static String port;
    private static String server;
    private static String loginSite;
    private static String username;
    private static String password;
    private static String api;
    private static String navigator;
    private static String webDriverProperty;
    private static String webDriverPath;
    private static String protocol; 

    /*********************************INSTANCIA********************************/
    private static Parametros INSTANCIA = null;
    
    private Parametros() {
        Parametros.domain = DOMAIN_TRAZABILIDAD;
        Parametros.port = PORT_TRAZABILIDAD;
        Parametros.server = SERVER_TRAZABILIDAD;
        Parametros.loginSite = LOGIN_SITE_TRAZABILIDAD;
        Parametros.username = USERNAME_TRAZABILIDAD;
        Parametros.password = PASSWORD_TRAZABILIDAD;
        Parametros.api = API_TRAZABILIDAD;
        Parametros.navigator = NAVIGATOR_TRAZABILIDAD;
        Parametros.webDriverProperty = WEB_DRIVER_CHROME_PROPERTY;
        Parametros.webDriverPath = WEB_DRIVER_CHROME_PATH;
        Parametros.protocol = PROTOCOL; 
    }

    private Parametros(String api) {
        if (api.equalsIgnoreCase("TRAZABILIDAD")) {
            Parametros.domain = DOMAIN_TRAZABILIDAD;
            Parametros.port = PORT_TRAZABILIDAD;
            Parametros.server = SERVER_TRAZABILIDAD;
            Parametros.loginSite = LOGIN_SITE_TRAZABILIDAD;
            Parametros.username = USERNAME_TRAZABILIDAD;
            Parametros.password = PASSWORD_TRAZABILIDAD;
            Parametros.api = API_TRAZABILIDAD;
            Parametros.navigator = NAVIGATOR_TRAZABILIDAD;
            Parametros.webDriverProperty = WEB_DRIVER_CHROME_PROPERTY;
            Parametros.webDriverPath = WEB_DRIVER_CHROME_PATH;
            Parametros.protocol = PROTOCOL; 
        }else if (api.equalsIgnoreCase("RECTOR")) {
            Parametros.domain = DOMAIN_RECTOR;
            Parametros.port = PORT_RECTOR;
            Parametros.server = SERVER_RECTOR;
            Parametros.loginSite = LOGIN_SITE_RECTOR;
            Parametros.username = USERNAME_RECTOR;
            Parametros.password = PASSWORD_RECTOR;
            Parametros.api = API_RECTOR;
            Parametros.navigator = NAVIGATOR_RECTOR;
            Parametros.webDriverProperty = WEB_DRIVER_IE_PROPERTY;
            Parametros.webDriverPath = WEB_DRIVER_IE_PATH;
            Parametros.protocol = SECURE_PROTOCOL; 
        }else if (api.equalsIgnoreCase("BPM")) {
            Parametros.domain = DOMAIN_BPM;
            Parametros.port = PORT_BPM;
            Parametros.server = SERVER_BPM;
            Parametros.loginSite = LOGIN_SITE_BPM;
            Parametros.username = USERNAME_BPM;
            Parametros.password = PASSWORD_BPM;
            Parametros.api = API_BPM;
            Parametros.navigator = NAVIGATOR_BPM;
            Parametros.webDriverProperty = WEB_DRIVER_CHROME_PROPERTY;
            Parametros.webDriverPath = WEB_DRIVER_CHROME_PATH;
            Parametros.protocol = SECURE_PROTOCOL;
        }else{
            Parametros.domain = "";
            Parametros.port = "";
            Parametros.server = "";
            Parametros.loginSite = "";
            Parametros.username = "";
            Parametros.password = "";
            Parametros.api = "";
            Parametros.navigator = "";
            Parametros.webDriverProperty = "";
            Parametros.webDriverPath = "";
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
        return protocol + "://" + domain + ":" + port;
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
    
    public String getApi(){
        return api;
    }
    
    public String getNavigator(){
        return navigator;
    }
    
    public String getWebDriverProperty(){
        return webDriverProperty;
    }
    
    public String getWebDriverPath(){
        return webDriverPath;
    }

    public static String getRECTOR_DATABASE_DRIVER() {
        return RECTOR_DATABASE_DRIVER;
    }

    public static String getRECTOR_DATABASE_DATASOURCE() {
        return RECTOR_DATABASE_DATASOURCE;
    }

    public static String getRECTOR_DATABASE_USERNAME() {
        return RECTOR_DATABASE_USERNAME;
    }

    public static String getRECTOR_DATABASE_PASSWORD() {
        return RECTOR_DATABASE_PASSWORD;
    }
    
    
    
}
