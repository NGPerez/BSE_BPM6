package Data;

public class Parametros {

    /**
     * *****************************URL BUILDER*******************************
     */
    private static final String PROTOCOL = "http";
    private static final String PROTOCOLs = "https";

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
        this.domain = DOMAIN_TRAZABILIDAD;
        this.port = PORT_TRAZABILIDAD;
        this.server = SERVER_TRAZABILIDAD;
        this.loginSite = LOGIN_SITE_TRAZABILIDAD;
        this.username = USERNAME_TRAZABILIDAD;
        this.password = PASSWORD_TRAZABILIDAD;
        this.api = API_TRAZABILIDAD;
        this.navigator = NAVIGATOR_TRAZABILIDAD;
        this.webDriverProperty = WEB_DRIVER_CHROME_PROPERTY;
        this.webDriverPath = WEB_DRIVER_CHROME_PATH;
        this.protocol = PROTOCOL; 
    }

    private Parametros(String api) {
        if (api.equalsIgnoreCase("TRAZABILIDAD")) {
            this.domain = DOMAIN_TRAZABILIDAD;
            this.port = PORT_TRAZABILIDAD;
            this.server = SERVER_TRAZABILIDAD;
            this.loginSite = LOGIN_SITE_TRAZABILIDAD;
            this.username = USERNAME_TRAZABILIDAD;
            this.password = PASSWORD_TRAZABILIDAD;
            this.api = API_TRAZABILIDAD;
            this.navigator = NAVIGATOR_TRAZABILIDAD;
            this.webDriverProperty = WEB_DRIVER_CHROME_PROPERTY;
            this.webDriverPath = WEB_DRIVER_CHROME_PATH;
            this.protocol = PROTOCOL; 
        }else if (api.equalsIgnoreCase("RECTOR")) {
            this.domain = DOMAIN_RECTOR;
            this.port = PORT_RECTOR;
            this.server = SERVER_RECTOR;
            this.loginSite = LOGIN_SITE_RECTOR;
            this.username = USERNAME_RECTOR;
            this.password = PASSWORD_RECTOR;
            this.api = API_RECTOR;
            this.navigator = NAVIGATOR_RECTOR;
            this.webDriverProperty = WEB_DRIVER_IE_PROPERTY;
            this.webDriverPath = WEB_DRIVER_IE_PATH;
            this.protocol = PROTOCOLs; 
        }else if (api.equalsIgnoreCase("BPM")) {
            this.domain = DOMAIN_BPM;
            this.port = PORT_BPM;
            this.server = SERVER_BPM;
            this.loginSite = LOGIN_SITE_BPM;
            this.username = USERNAME_BPM;
            this.password = PASSWORD_BPM;
            this.api = API_BPM;
            this.navigator = NAVIGATOR_BPM;
            this.webDriverProperty = WEB_DRIVER_CHROME_PROPERTY;
            this.webDriverPath = WEB_DRIVER_CHROME_PATH;
            this.protocol = PROTOCOLs;
        }else{
            this.domain = "";
            this.port = "";
            this.server = "";
            this.loginSite = "";
            this.username = "";
            this.password = "";
            this.api = "";
            this.navigator = "";
            this.webDriverProperty = "";
            this.webDriverPath = "";
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
}
