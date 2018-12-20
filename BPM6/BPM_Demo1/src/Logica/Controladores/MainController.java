/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Controladores;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;

/**
 *
 * @author fguarisco
 */
public class MainController {

    private MainController() {
    }

    private static Screen s;
    
    public static MainController getInstance() {
        s = new Screen();
        return MainControllerHolder.INSTANCE;
    }

    private static class MainControllerHolder {

        private static final MainController INSTANCE = new MainController();
    }
	
    public void searchInstance(String nroInstancia){
        try {
            s.wait(Data.Constantes.getBOTON_TRABAJO());
            s.click(Data.Constantes.getBOTON_TRABAJO());
            s.click(Data.Constantes.getCAMPO_BUSCAR());
            s.type(nroInstancia + "#ENTER");
        } catch (FindFailed ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
		
    public void searchButtonPushedAndWait(String nroInstancia){
        searchInstance(nroInstancia);
        s.type(Key.TAB);
        s.type(Key.TAB);
        s.type(Key.ENTER);
    }
}
/*	
    public void ejecutarAperturar_AnalizarAmparo(String nroInstancia){
        if(s.exists(Data.Constantes.getBOTON_APERTURAR()) != null){
            try {
                s.click(Data.Constantes.getBOTON_APERTURAR());
                modulos.logica.BPMRoutines.aperturar_analizarAmparo()
                searchButtonPushedAndWait(nroInstancia)
                modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.BOTON_ANALIZAR_AMPARO)
                                   
            } catch (FindFailed ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    
    
    
    }
	if(pyautogui.locateOnScreen(modulos.globales.Constantes.BOTON_APERTURAR) != None):
		modulos.logica.MouseController.clickTo(modulos.globales.Constantes.BOTON_APERTURAR)
		modulos.logica.BPMRoutines.aperturar_analizarAmparo()
		searchButtonPushedAndWait(nroInstancia)
		modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.BOTON_ANALIZAR_AMPARO)
    }
        

def ejecutarAnalizarAmparo_EstudiarAnalizar(nroInstancia):
	if(pyautogui.locateOnScreen(modulos.globales.Constantes.BOTON_ANALIZAR_AMPARO) != None or (pyautogui.locateOnScreen(modulos.globales.Constantes.BOTON_ANALIZAR_AMPARO_Y_TASACION) != None)):
		modulos.logica.MouseController.click2ImagesTo(modulos.globales.Constantes.BOTON_ANALIZAR_AMPARO,modulos.globales.Constantes.BOTON_ANALIZAR_AMPARO_Y_TASACION)
		if(pyautogui.locateOnScreen(modulos.globales.Constantes.BOTON_ANALIZAR_AMPARO_Y_TASACION) != None):
			modulos.logica.BPMRoutines.analizarAmparo_estudiarAnalizar('SI')
			searchButtonPushedAndWait(nroInstancia)
			modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.BOTON_TASAR)
		else:
			modulos.logica.BPMRoutines.analizarAmparo_estudiarAnalizar('NO')
			searchButtonPushedAndWait(nroInstancia)
			modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.BOTON_ESTUDIAR_ANALIZAR)

def ejecutarRechazar_RetomaAnalizarAmparo(nroInstancia):
	if(pyautogui.locateOnScreen(modulos.globales.Constantes.BOTON_RECHAZAR_RETOMA_ANALIZAR_AMPARO) != None):
		modulos.logica.MouseController.clickTo(modulos.globales.Constantes.BOTON_ANALIZAR_AMPARO)
		modulos.logica.BPMRoutines.analizarAmparo_Liquidar()
		searchButtonPushedAndWait(nroInstancia)
		modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.BOTON_ANALIZAR_AMPARO)
		
def ejecutarAnalizarAmparo_PasarSupervisor(nroInstancia):
	if(pyautogui.locateOnScreen(modulos.globales.Constantes.BOTON_ANALIZAR_AMPARO) != None):
		modulos.logica.MouseController.clickTo(modulos.globales.Constantes.BOTON_ANALIZAR_AMPARO)
		modulos.logica.BPMRoutines.analizarAmparo_pasarSupervisor()
		searchButtonPushedAndWait(nroInstancia)
		modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.BOTON_PASAR_SUPERVISOR)

def ejecutarAnalizarAmparo_finalizar(nroInstancia):
	if(pyautogui.locateOnScreen(modulos.globales.Constantes.BOTON_ANALIZAR_AMPARO) != None):
		modulos.logica.MouseController.clickTo(modulos.globales.Constantes.BOTON_ANALIZAR_AMPARO)
		modulos.logica.BPMRoutines.analizarAmparo_finalizar()
	
def ejecutarRetomaAnalizarAmparo_EstudiarAnalizar(nroInstancia):
	if(pyautogui.locateOnScreen(modulos.globales.Constantes.BOTON_ANALIZAR_AMPARO) != None):
		modulos.logica.MouseController.clickTo(modulos.globales.Constantes.BOTON_ANALIZAR_AMPARO)
		modulos.logica.BPMRoutines.retomaAnalizarAmparo_estudiarAnalizar()
		searchButtonPushedAndWait(nroInstancia)
		modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.BOTON_ESTUDIAR_ANALIZAR)

def ejecutarPasarSupervisor_rechazar(nroInstancia):
	if(pyautogui.locateOnScreen(modulos.globales.Constantes.BOTON_PASAR_SUPERVISOR) != None):
		modulos.logica.MouseController.clickTo(modulos.globales.Constantes.BOTON_PASAR_SUPERVISOR)
		modulos.logica.BPMRoutines.pasarSupervisor_rechazar()
		searchButtonPushedAndWait(nroInstancia)
		modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.BOTON_RECHAZAR)
		
def ejecutarAnalizarAmparo_Liquidar(nroInstancia):
	if(pyautogui.locateOnScreen(modulos.globales.Constantes.BOTON_ANALIZAR_AMPARO) != None):
		modulos.logica.MouseController.clickTo(modulos.globales.Constantes.BOTON_ANALIZAR_AMPARO)
		modulos.logica.BPMRoutines.analizarAmparo_Liquidar()
		searchButtonPushedAndWait(nroInstancia)
		modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.BOTON_LIQUIDAR)

def ejecutarAnalizarAmparo_Rechazar(nroInstancia):
	if(pyautogui.locateOnScreen(modulos.globales.Constantes.BOTON_ANALIZAR_AMPARO) != None):
		modulos.logica.MouseController.clickTo(modulos.globales.Constantes.BOTON_ANALIZAR_AMPARO)
		modulos.logica.BPMRoutines.analizarAmparo_Rechazar()
		searchButtonPushedAndWait(nroInstancia)
		modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.BOTON_ESPERAR)

def ejecutarLiquidar_Devolver(nroInstancia):
	if(pyautogui.locateOnScreen(modulos.globales.Constantes.BOTON_LIQUIDAR) != None):
		modulos.logica.MouseController.clickTo(modulos.globales.Constantes.BOTON_LIQUIDAR)
		modulos.logica.BPMRoutines.liquidar_devolver()
		searchButtonPushedAndWait(nroInstancia)
		modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.BOTON_ANALIZAR_AMPARO)
	
def ejecutarEstudiarAnalizar_ConsultarAsesoria(nroInstancia):
	if(pyautogui.locateOnScreen(modulos.globales.Constantes.BOTON_ESTUDIAR_ANALIZAR) != None):
		modulos.logica.MouseController.clickTo(modulos.globales.Constantes.BOTON_ESTUDIAR_ANALIZAR)
		modulos.logica.BPMRoutines.estudiarAnalizar_consultarAsesoria()
		searchButtonPushedAndWait(nroInstancia)
		modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.BOTON_CONSULTAR_ASESORIA)

def ejecutarEstudiarAnalizar_EsperarPorEvento(nroInstancia):
	if(pyautogui.locateOnScreen(modulos.globales.Constantes.BOTON_ESTUDIAR_ANALIZAR) != None):
		modulos.logica.MouseController.clickTo(modulos.globales.Constantes.BOTON_ESTUDIAR_ANALIZAR)
		modulos.logica.BPMRoutines.estudiarAnalizar_esperarPorEvento()
		searchButtonPushedAndWait(nroInstancia)
		modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.BOTON_ESPERAR)
		
def ejecutarEsperarPorEvento_EstudiarAnalizar(nroInstancia):
	if(pyautogui.locateOnScreen(modulos.globales.Constantes.BOTON_ESPERAR) != None):
		modulos.logica.MouseController.clickTo(modulos.globales.Constantes.BOTON_ESPERAR)
		modulos.logica.BPMRoutines.esperarPorEvento_EstudiarAnalizar()
		searchButtonPushedAndWait(nroInstancia)
		modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.BOTON_ESTUDIAR_ANALIZAR)

def ejecutarConsultarAsesoria_EstudiarAnalizar(nroInstancia):
	if(pyautogui.locateOnScreen(modulos.globales.Constantes.BOTON_CONSULTAR_ASESORIA) != None):
		modulos.logica.MouseController.clickTo(modulos.globales.Constantes.BOTON_CONSULTAR_ASESORIA)
		modulos.logica.BPMRoutines.consultarAsesoria_EstudiarAnalizar()
		searchButtonPushedAndWait(nroInstancia)
		modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.BOTON_ESTUDIAR_ANALIZAR)

def ejecutarEstudiarAnalizar_Liquidar(nroInstancia):
	if(pyautogui.locateOnScreen(modulos.globales.Constantes.BOTON_ESTUDIAR_ANALIZAR) != None):
		modulos.logica.MouseController.clickTo(modulos.globales.Constantes.BOTON_ESTUDIAR_ANALIZAR)
		modulos.logica.BPMRoutines.estudiarAnalizar_liquidar()
		searchButtonPushedAndWait(nroInstancia)
		modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.BOTON_LIQUIDAR)

def ejecutarTasar_Liquidar(nroInstancia):
	if(pyautogui.locateOnScreen(modulos.globales.Constantes.BOTON_TASAR) != None):
		modulos.logica.MouseController.clickTo(modulos.globales.Constantes.BOTON_TASAR)
		modulos.logica.BPMRoutines.tasar_liquidar()
		searchButtonPushedAndWait(nroInstancia)
		modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.BOTON_LIQUIDAR)

def ejecutarLiquidar_Controlar(nroInstancia):
	if(pyautogui.locateOnScreen(modulos.globales.Constantes.BOTON_LIQUIDAR) != None):
		modulos.logica.MouseController.clickTo(modulos.globales.Constantes.BOTON_LIQUIDAR)
		modulos.logica.BPMRoutines.liquidar_controlar()
		searchButtonPushedAndWait(nroInstancia)
		modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.BOTON_CONTROLAR)

def ejecutarLiquidarProvyTec_Controlar(nroInstancia):
	if(pyautogui.locateOnScreen(modulos.globales.Constantes.BOTON_LIQUIDAR_PROVYTEC) != None):
		modulos.logica.MouseController.clickTo(modulos.globales.Constantes.BOTON_LIQUIDAR_PROVYTEC)
		modulos.logica.BPMRoutines.liquidarProvyTec_controlar()
		searchButtonPushedAndWait(nroInstancia)
		modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.BOTON_CONTROLAR)
		
def ejecutarControlar_LiquidarProvyTec(nroInstancia):
	if(pyautogui.locateOnScreen(modulos.globales.Constantes.BOTON_CONTROLAR) != None):
		modulos.logica.MouseController.clickTo(modulos.globales.Constantes.BOTON_CONTROLAR)
		modulos.logica.BPMRoutines.controlar_liquidarProvytec()
		searchButtonPushedAndWait(nroInstancia)
		modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.BOTON_LIQUIDAR_PROVYTEC)
		
def ejecutarControlar_AgendarPagos(nroInstancia):
	if(pyautogui.locateOnScreen(modulos.globales.Constantes.BOTON_CONTROLAR) != None):
		modulos.logica.MouseController.clickTo(modulos.globales.Constantes.BOTON_CONTROLAR)
		modulos.logica.BPMRoutines.controlar_agendarPagos()
		searchButtonPushedAndWait(nroInstancia)
		modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.BOTON_AGENDAR_PAGOS)

def ejecutarAgendarPagos_Pagar(nroInstancia):
	if(pyautogui.locateOnScreen(modulos.globales.Constantes.BOTON_AGENDAR_PAGOS) != None):
		modulos.logica.MouseController.clickTo(modulos.globales.Constantes.BOTON_AGENDAR_PAGOS)
		modulos.logica.BPMRoutines.agendarPagos_pagar()
		searchButtonPushedAndWait(nroInstancia)
		modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.BOTON_PAGAR)

def ejecutarPagar_ControlarVale(nroInstancia):
	if(pyautogui.locateOnScreen(modulos.globales.Constantes.BOTON_PAGAR) != None):
		modulos.logica.MouseController.clickTo(modulos.globales.Constantes.BOTON_PAGAR)
		modulos.logica.BPMRoutines.pagar_controlarVale()
		searchButtonPushedAndWait(nroInstancia)
		modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.BOTON_CONTROLAR_VALE)

def ejecutarPagar_Recuperar(nroInstancia):
	if(pyautogui.locateOnScreen(modulos.globales.Constantes.BOTON_PAGAR) != None):
		modulos.logica.MouseController.clickTo(modulos.globales.Constantes.BOTON_PAGAR)
		modulos.logica.BPMRoutines.pagar_recuperar()
		searchButtonPushedAndWait(nroInstancia)
		modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.BOTON_RECUPERAR)

def ejecutarPagar_ConsultarSupervisor(nroInstancia):
	if(pyautogui.locateOnScreen(modulos.globales.Constantes.BOTON_PAGAR) != None):
		modulos.logica.MouseController.clickTo(modulos.globales.Constantes.BOTON_PAGAR)
		modulos.logica.BPMRoutines.pagar_consultarSupervisor()
		searchButtonPushedAndWait(nroInstancia)
		modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.BOTON_CONSULTAR)

def ejecutarPagar_finalizar(nroInstancia):
	if(pyautogui.locateOnScreen(modulos.globales.Constantes.BOTON_PAGAR) != None):
		modulos.logica.MouseController.clickTo(modulos.globales.Constantes.BOTON_PAGAR)
		modulos.logica.BPMRoutines.pagar_finalizar()
	
def ejecutarConsultarSupervisor_EsperarPorEvento(nroInstancia):
	if(pyautogui.locateOnScreen(modulos.globales.Constantes.BOTON_CONSULTAR) != None):
		modulos.logica.MouseController.clickTo(modulos.globales.Constantes.BOTON_CONSULTAR)
		modulos.logica.BPMRoutines.consultarSupervisor_esperarPorEvento()
		searchButtonPushedAndWait(nroInstancia)
		modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.BOTON_ESPERAR)

def ejecutarEsperarPorEvento_Recuperar(nroInstancia):
	if(pyautogui.locateOnScreen(modulos.globales.Constantes.BOTON_ESPERAR) != None):
		modulos.logica.MouseController.clickTo(modulos.globales.Constantes.BOTON_ESPERAR)
		modulos.logica.BPMRoutines.esperarPorEvento_Recuperar()
		searchButtonPushedAndWait(nroInstancia)
		modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.BOTON_RECUPERAR)
		
def ejecutarEstudiarAnalizar_Devolver(nroInstancia):
	if(pyautogui.locateOnScreen(modulos.globales.Constantes.BOTON_ESTUDIAR_ANALIZAR) != None):
		modulos.logica.MouseController.clickTo(modulos.globales.Constantes.BOTON_ESTUDIAR_ANALIZAR)
		modulos.logica.BPMRoutines.estudiarAnalizar_Devolver()
		searchButtonPushedAndWait(nroInstancia)
		modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.BOTON_ANALIZAR_AMPARO)

def ejecutarRecuperar_Finalizar(nroInstancia):
	if(pyautogui.locateOnScreen(modulos.globales.Constantes.BOTON_RECUPERAR) != None):
		modulos.logica.MouseController.clickTo(modulos.globales.Constantes.BOTON_RECUPERAR)
		modulos.logica.BPMRoutines.recuperar_finalizar()
		
def ejecutarControlarVale_Finalizar(nroInstancia):
	if(pyautogui.locateOnScreen(modulos.globales.Constantes.BOTON_CONTROLAR_VALE) != None):
		modulos.logica.MouseController.clickTo(modulos.globales.Constantes.BOTON_CONTROLAR_VALE)
		modulos.logica.BPMRoutines.controlarVale_finalizar()
}
*/