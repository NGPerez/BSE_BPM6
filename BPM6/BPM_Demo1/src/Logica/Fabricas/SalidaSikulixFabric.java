package Logica.Fabricas;

import Logica.Controladores.SalidaSikulixController;
import Logica.Interfaces.SalidaSikulixInterface;

public class SalidaSikulixFabric {
    
    private static SalidaSikulixFabric INSTANCIA = null;
    private SalidaSikulixFabric(){}
    
    public static SalidaSikulixFabric getInstancia(){
        if(INSTANCIA == null){
            INSTANCIA = new SalidaSikulixFabric();
        }
        return INSTANCIA;
    }
    
    public SalidaSikulixInterface getSalidaSikulixController(){
        return (SalidaSikulixInterface) SalidaSikulixController.getIntancia(); 
    }
}
