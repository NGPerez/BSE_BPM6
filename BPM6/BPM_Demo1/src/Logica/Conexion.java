package Logica;

import Data.Parametros;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    
    private Connection conn;
    
    private Conexion() {
        conn = null;
    }
    
    public static Conexion getInstance() {
        return ConexionHolder.INSTANCE;
    }
    
    private static class ConexionHolder {
        private static final Conexion INSTANCE = new Conexion();
    }
    
    public Connection conectar() {
        try {
            Class.forName(Parametros.getRECTOR_DATABASE_DRIVER());
            conn = DriverManager.getConnection(Parametros.getRECTOR_DATABASE_DATASOURCE(),Parametros.getRECTOR_DATABASE_USERNAME(),Parametros.getRECTOR_DATABASE_PASSWORD());        
        } catch (ClassNotFoundException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, "Donde esta el Driver?", e);
        } catch(SQLException e1){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, "Connection fallida! Revisa la consola", e1);
        }
        if (conn != null) {
            Logger.getLogger(Conexion.class.getName()).log(Level.INFO, "Conexion exitosa!");
        } else {
            Logger.getLogger(Conexion.class.getName()).log(Level.INFO, "Conexion fallida!");
        }     
        return conn;
    }
    
    public Connection ejecutar_y_desconectar(){
        try {
            conn.commit();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
