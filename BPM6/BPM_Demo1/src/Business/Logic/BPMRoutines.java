package Business.Logic;

import Logica.Conexion;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;

public class BPMRoutines {
    
    private static Screen s;
    
    private BPMRoutines() {
        s = new Screen();
    }
    
    public static BPMRoutines getInstance() {
        return BPMRoutinesHolder.INSTANCE;
    }
    
    private static class BPMRoutinesHolder {
        private static final BPMRoutines INSTANCE = new BPMRoutines();
    }
    
    public void login(){
        //Esperamos 1 segundo
	//time.sleep(1)
	
	//Ponemos el navegador en pantalla completa
	s.type(Key.F11);
	
	//Se ingresa el usuario
        s.type(Data.Constantes.getUSUARIO());
	
	//Nos posicionamos en el campo contraseña
        s.type(Key.TAB);
	
	//Se ingresa la contraseña
        s.type(Data.Constantes.getCONTRASEÑA());
	
	//Nos posicionamos en el boton Continuar y presionamos la tela Enter
	s.type(Key.TAB);
        s.type(Key.ENTER);
    }

	
    public void aperturar_analizarAmparo(){
        try {
            //Imprimimos en pantalla el mensaje "Inicio del proceso APERTURAR"
            System.out.println("Inicio del proceso APERTURAR");
            
            //Bandera para salir
            boolean fin = false;
            
            //Esperamos a que aparezca la pestaña Expediente
            s.wait(Data.Constantes.getPESTAÑA_EXPEDIENTE());
            
            //Esperamos 4 segundos
            //time.sleep(4)
                    
            //Preguntamos si no hay un mensaje correspondiente a la aucencia de resultado de actividad
            if(s.exists(Data.Constantes.getMENSAJE_ERROR_RESULTADO_DE_ACTIVIDAD()) == null){
            
                //if(pyautogui.locateOnScreen('lblPolizaNA.png') != None):
                
                //Preguntamos si no tiene siniestro
                if(s.exists(Data.Constantes.getETIQUETA_TIENE_SINIESTRO()) == null){
                    
                    //Avanzamos 4 componentes con la tecla Tab hasta posicionarnos en el boton Asociar siniestro
                    for(int i=0; i<4; i++){
                        s.type(Key.TAB);
                    }
                    
                    //Digitamos la tecla enter para acceder a Asociar siniestro
                    s.type(Key.ENTER);
                    
                    //modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.BOTON_ASOCIAR_SINIESTRO)
                    //print("modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.BOTON_ASOCIAR_SINIESTRO)")
                    //modulos.logica.MouseController.clickTo(modulos.globales.Constantes.BOTON_ASOCIAR_SINIESTRO)
                    //print("modulos.logica.MouseController.clickTo(modulos.globales.Constantes.BOTON_ASOCIAR_SINIESTRO)")
                    //modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.ETIQUETA_VEHICULOS)
                    //print("modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.ETIQUETA_VEHICULOS)")
                    
                    //Preguntamos si no tiene subsiniestros nuevos para asociar
                    if(s.exists(Data.Constantes.getMENSAJE_ERROR_NO_SUBSINIESTROS_NUEVOS()) == null){
                        
                        //Esperamos a que aparezca el boton Asociar
                        s.wait(Data.Constantes.getBOTON_ASOCIAR());
                        
                        //Preguntamos si se encuentra la etiqueta Asociar siniestro
                        if(s.exists(Data.Constantes.getETIQUETA_ASOCIAR_SINIESTRO()) != null){
                            
                            //Hacemos clic en la etiqueta Asociar siniestro
                            s.click(Data.Constantes.getETIQUETA_ASOCIAR_SINIESTRO());
                            
                            //for x in range(11):
                            //	pyautogui.hotkey('tab')

                            //Esperamos 1 segundo
                            //time.sleep( 1 )
                            
                            //Hacemos clic en el radiobutton del siniestro
                            s.type(Key.TAB);
                            //time.sleep( 2 )
                            s.type(Key.SPACE);
                            //time.sleep( 1 )
                            s.type(Key.SPACE);
                            //time.sleep( 1 )
                            s.type(Key.SPACE);
                            //time.sleep( 1 )
                            //for x in range(2):
                            //	pyautogui.hotkey('tab')
                            //pyautogui.hotkey('enter')
                            //time.sleep( 1 )
                            
                            //Preguntamos si existen subsiniestros
                            if(s.exists(Data.Constantes.getETIQUETA_TIENE_SUBSINIESTROS()) != null){
                                
                                //Hacemos clic en el subsiniestros
                                s.type(Key.TAB);
                                //time.sleep( 1 )
                                s.type(Key.SPACE);
                                //time.sleep( 1 )
                                s.type(Key.SPACE);
                            }
                            //Hacemos clic en el boton Asociar
                            s.click(Data.Constantes.getBOTON_ASOCIAR());

                            //Esperamos a la etiqueta Vehiculos
                            s.wait(Data.Constantes.getETIQUETA_VEHICULOS());

                            //Imprimimos en pantalla el mensaje "Se asocio un siniestro satisfactoriamente"
                            Logger.getLogger(BPMRoutines.class.getName()).log(Level.INFO, "Se asocio un siniestro satisfactoriamente");
                        }else{
                            
                            //Imprimimos en pantalla el mensaje "No existe el formulario de asociar sinietro"
                            Logger.getLogger(BPMRoutines.class.getName()).log(Level.WARNING, "No existe el formulario de asociar sinietro");

                            //Seteamos la bandera a que llego el final
                            fin = true;
                        }
                    }else{
                        
                        //Imprimimos en pantalla el mensaje "No existen sub siniestros nuevos para asociar, debe generar uno en rector y luego repetir la prueba para este caso"
                        Logger.getLogger(BPMRoutines.class.getName()).log(Level.WARNING, "No existen sub siniestros nuevos para asociar, debe generar uno en rector y luego repetir la prueba para este caso");

                        //Seteamos la bandera a que llego el final
                        fin = true;
                    }      
                }else{
                    //Imprimimos en pantalla el mensaje "No existe el formulario de asociar sinietro"
                    Logger.getLogger(BPMRoutines.class.getName()).log(Level.INFO, "Ya tiene un siniestro asociado");
                }
                //Esperamos 1 segundo
                //time.sleep( 1 )

                //Preguntamos si no ha finalizado
                if(!fin){
                    //TODO: CHECK
                    //Preguntamos si esta presente la alerta de que no existen subsiniestros nuevos para asociar
                    if(s.exists(Data.Constantes.getMENSAJE_ERROR_NO_SUBSINIESTROS_NUEVOS()) != null){
                        
                        //Hacemos clic en la alerta
                        s.click(Data.Constantes.getMENSAJE_ERROR_NO_SUBSINIESTROS_NUEVOS());

                        //Esperamos 1 segundo
                        //time.sleep( 1 )
                    }
                    
                    //Preguntamos si existe alguna advertencia
                    if(s.exists(Data.Constantes.getMENSAJE_ADVERTENCIA_SIMPLE()) != null){

                        //Hacemos clic en la advertencia
                        s.click(Data.Constantes.getMENSAJE_ADVERTENCIA_SIMPLE());

                        //Esperamos 1 segundo
                        //time.sleep( 1 )
                    }
                    
                    //Nos dirigimos al final de la pagina
                    s.type(Key.PAGE_UP);

                    //Hacemos clic en la pestaña Expediente
                    s.click(Data.Constantes.getPESTAÑA_EXPEDIENTE());

                    //Esperamos la prescencia de los controles del expediente
                    s.wait(Data.Constantes.getCONTROLES_EXPEDIENTE());

                    //Preguntamos si se exhibe el mensaje que se ha asociado el siniestro correctamente
                    if(s.exists(Data.Constantes.getMENSAJE_CONFIRMACION_SINIESTRO_ASOCIADO()) != null){

                        //Hacemos clic en el mensaje
                        s.click(Data.Constantes.getMENSAJE_CONFIRMACION_SINIESTRO_ASOCIADO());

                        //Esperamos 1 segundo
                        //time.sleep( 1 )
                    }
                    
                    //Preguntamos si se exhibe la etiqueta Lista documentos
                    if(s.exists(Data.Constantes.getETIQUETA_LISTA_DOCUMENTOS()) != null){

                        //Esperamos a la prescencia del boton Filtrar
                        s.wait(Data.Constantes.getBOTON_FILTRAR());

                        //Hacemos clic en el boton Filtrar
                        s.click(Data.Constantes.getBOTON_FILTRAR());

                        //modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.ETIQUETA_VEHICULOS)
                        //print("modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.ETIQUETA_VEHICULOS)")
                    }                    
                    
                    //if(pyautogui.locateOnScreen(modulos.globales.Constantes.CHECKBOX_TODOS_NO_SELECCIONADO) != None):

                    //Esperamos por las imagenes correspondientes al checkbox Todos en caso de que este en foco o no
                    s.wait(Data.Constantes.getCHECKBOX_TODOS_EN_FOCO());
                    //modulos.logica.MouseController.waitBy2Image(modulos.globales.Constantes.CHECKBOX_TODOS_EN_FOCO,modulos.globales.Constantes.CHECKBOX_TODOS_SIN_FOCO)

                    //Esperamos por la imagen Vehiculos
                    s.wait(Data.Constantes.getETIQUETA_VEHICULOS());

                    //Hacemos clic en el checkbox Todos
                    s.click(Data.Constantes.getCHECKBOX_TODOS_EN_FOCO());
                    //modulos.logica.MouseController.click2ImagesTo(modulos.globales.Constantes.CHECKBOX_TODOS,modulos.globales.Constantes.CHECKBOX_TODOS_EN_FOCO)

                    //Esperamos por la imagen del checkbox Todos en modo no seleccionado
                    s.wait(Data.Constantes.getCHECKBOX_TODOS_NO_SELECCIONADO());

                    //Avanzamos hasta el checkbox Generico de Taller
                    for(int i=0; i<27; i++){
                        s.type(Key.TAB);
                    }

                    //Seleccionamos el checkbox Generico de Taller
                    s.type(Key.SPACE);

                    //Hacemos clic en el boton Buscar
                    s.click(Data.Constantes.getBOTON_BUSCAR());

                    //Esperamos 2 segundos
                    //time.sleep( 2 )

                    //Preguntamos si esta presente la etiqueta Generico de Taller
                    if((s.exists(Data.Constantes.getETIQUETA_GENERICO_DE_TALLER()) != null) || (s.exists(Data.Constantes.getETIQUETA_GENERICO_DE_TALLER2()) != null)){

                        //Avanzamos hasta el checkbox Seleccionar todos
                        s.type(Key.TAB);
                        s.type(Key.TAB);

                        //Hacemos clic en el checkbox Seleccionar todos
                        s.type(Key.SPACE);

                        //Esperamos por la prescencia del boton Recatalogar
                        s.wait(Data.Constantes.getBOTON_RECATALOGAR());

                        //Hacemos clic en el boton Recatalogar
                        s.click(Data.Constantes.getBOTON_RECATALOGAR());

                        //Preguntamos si exist el mensaje de error que nos avisa que tenemos que seleccionar un elemento antes de recatalogar
                        if(s.exists(Data.Constantes.getMENSAJE_ERROR_SELECCIONAR_ELEMENTO_ANTES_DE_RECATALOGAR()) == null){

                            //Esperamos por la lista desplegable clase documental
                            s.wait(Data.Constantes.getCOMBOBOX_CLASE_DOCUMENTAL());

                            //Hacemos clic en la lista desplegable clase documental
                            s.click(Data.Constantes.getCOMBOBOX_CLASE_DOCUMENTAL());

                            //Seleccionamos la clase documental Autos
                            s.type("AU#ENTER");

                            //Avanzamos hasta el boton Recatalogar
                            for(int i=0; i<3; i++){
                                s.type(Key.TAB);
                            }

                            //Hacemos clic en el boton Recatalogar
                            s.type(Key.ENTER);

                            //Imprimimos en pantalla el mensaje "Se recatalogo satisfactoriamente"
                            Logger.getLogger(BPMRoutines.class.getName()).log(Level.INFO, "Se recatalogo satisfactoriamente");

                            //Esperamos 1 segundo
                            //time.sleep( 1 )

                            //Subimos a la parte superior de la pagina
                            s.type(Key.PAGE_UP);
                        }
                        
                        //Esperamos a la pestaña Datos generales
                        s.wait(Data.Constantes.getPESTAÑA_DATOS_GENERALES());

                        //Hacemos clic en la pestaña Datos generales
                        s.click(Data.Constantes.getPESTAÑA_DATOS_GENERALES());

                    }else{
                        //Imprimimos en pantalla el mensaje "Se debe de subir un archivo en trazabilidad para continuar con la prueba"
                        Logger.getLogger(BPMRoutines.class.getName()).log(Level.WARNING, "Se debe de subir un archivo en trazabilidad para continuar con la prueba");

                        //Seteamos la bandera a que llego el final
                        fin = true;
                    }
                }
            }else{

                //hacemos clic en el mensaje de error correspondiente al resultado de actividad
                s.click(Data.Constantes.getMENSAJE_ERROR_RESULTADO_DE_ACTIVIDAD());
            }
                    
            //Preguntamos si no ha llegado al final
            if(!fin){
                //Avanzamos hasta la lista desplegable de resultado de actividad
                for(int i=0; i<4; i++){
                    s.type(Key.TAB);
                }

                //Seleccionamos la opcion Analizar Amparo
                s.type(Key.DOWN);

                //Esperamos 1 segundo
                //time.sleep( 1 )

                //Avanzamos hasta el boton Continuar
                for(int i=0; i<4; i++){
                    s.type(Key.TAB);
                }

                //Hacemos clic en el boton Continuar
                s.type(Key.ENTER);
            }
            
            //Preguntamos si no hay un mensaje de error corespondiente a asociar siniestro
            if(s.exists(Data.Constantes.getMENSAJE_ERROR_ASOCIAR_SINIESTRO()) == null){

                //Imprimimos en pantalla el mensaje "Fin del proceso APERTURAR"
                Logger.getLogger(BPMRoutines.class.getName()).log(Level.INFO, "Fin del proceso APERTURAR");

            }else{

                //Imprimimos en pantalla el mensaje "Se debe de asociar un siniestro en rector y despues ejecutar la automatizacion de nuevo"
                Logger.getLogger(BPMRoutines.class.getName()).log(Level.WARNING, "Se debe de asociar un siniestro en rector y despues ejecutar la automatizacion de nuevo");
            }
        } catch (FindFailed ex) {
            Logger.getLogger(BPMRoutines.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
    
/*			
def analizarAmparo_estudiarAnalizar(tasacion):

	#Imprimimos en pantalla el mensaje "Inicio del proceso ANALIZAR AMPARO"
	print('Inicio del proceso ANALIZAR AMPARO')
	
	#Esperamos por la pestaña Expediente
	modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.PESTAÑA_EXPEDIENTE)
	
	#hacemos clic en la pestaña Expediente
	modulos.logica.MouseController.clickTo(modulos.globales.Constantes.PESTAÑA_EXPEDIENTE)
	
	#Preguntamos si no esta presente el checkbox todos
	if(pyautogui.locateOnScreen(modulos.globales.Constantes.CHECKBOX_TODOS) == None):
	
		#Esperamos por el boton Filtrar
		modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.BOTON_FILTRAR)
		
		#Hacemos clic en el boton Filtrar
		modulos.logica.MouseController.clickTo(modulos.globales.Constantes.BOTON_FILTRAR)
	
	#Esperamos por la etiqueta Vehiculos
	modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.ETIQUETA_VEHICULOS)
	
	#Esperamos por el checkbox todos
	modulos.logica.MouseController.waitBy2Image(modulos.globales.Constantes.CHECKBOX_TODOS_SIN_FOCO,modulos.globales.Constantes.CHECKBOX_TODOS_EN_FOCO)
	
	#Esperamos por la etiqueta Vehiculos
	modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.ETIQUETA_VEHICULOS)
	
	#Hacemos clic en el checkbox Todos
	modulos.logica.MouseController.clickTo(modulos.globales.Constantes.CHECKBOX_TODOS)
	
	#Esperamos a que el checkbox todos quede no seleccionado
	modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.CHECKBOX_TODOS_NO_SELECCIONADO)
	
	#Avanzamos hasta el checkbox Autos
	for x in range(4):
		pyautogui.hotkey('tab')
		
	#Hacemos clic en el checkbox Autos
	pyautogui.hotkey('space')
	
	#Hacemos clic en el boton Buscar
	modulos.logica.MouseController.clickTo(modulos.globales.Constantes.BOTON_BUSCAR)
	
	#Esperamos 2 segundos
	time.sleep( 2 )
	
	#Avanzamos hasta el checkbox Seleccionar todos
	pyautogui.hotkey('tab')
	pyautogui.hotkey('tab')
	
	#Hacemos clic en el checkbox seleccionar todos
	pyautogui.hotkey('space')
	
	#Hacemos clic en el boton Agregar Documento
	modulos.logica.MouseController.clickTo(modulos.globales.Constantes.BOTON_AGREGAR_DOCUMENTO)
	
	#Esperamos por la lista desplegable clase documental
	modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.COMBOBOX_CLASE_DOCUMENTAL)
	
	#Hacemos clic en la lista desplegable clase documental
	modulos.logica.MouseController.clickTo(modulos.globales.Constantes.COMBOBOX_CLASE_DOCUMENTAL)
	
	#Selecionamos la opcion Autos
	pyautogui.hotkey('A')
	pyautogui.hotkey('U')
	pyautogui.hotkey('enter')
	
	#Nos dirigimos al boton de Subir Archivo
	pyautogui.hotkey('tab')
	
	#Hacemos clic en el boton Subir Archivo
	pyautogui.hotkey('enter')
	
	#Esperamos 2 segundos
	time.sleep( 2 )
	
	#Avanzamos hasta encontrar una imagen
	for x in range(8):
		pyautogui.hotkey('tab')
		
	#Seleccionamos la imagen
	pyautogui.hotkey('space')
	
	#Confirmamos el ingreso de la imagen
	pyautogui.hotkey('enter')
	
	#pyautogui.typewrite('desert')
	
	#Esperamos 1 segundo
	time.sleep( 1 )
	
	#pyautogui.hotkey('enter')
	#time.sleep( 2 )
	
	#Esperamos por la comparacion del nombre de la imagen con el del archivo subido
	modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.ARCHIVO)
	
	#Avanzamos hasta el boton Aceptar
	for x in range(4):
		pyautogui.hotkey('tab')
		
	#Hacemos clic en el boton Aceptar
	pyautogui.hotkey('enter')
	
	#Imprimimos en pantalla el mensaje "Se agrego el documento satisfactoriamente"
	print('Se agrego el documento satisfactoriamente')
	
	#Esperamos 2 segundos
	time.sleep( 2 )
	
	#Esperamos por la etiqueta Vehiculos
	modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.ETIQUETA_VEHICULOS)
	
	#Preguntamos si la pestaña Datos generales no esta seleccionada
	if(pyautogui.locateOnScreen(modulos.globales.Constantes.PESTAÑA_DATOS_GENERALES_SELECCIONADA) == None):
	
		#Esperamos por la pestaña Datos generales
		modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.PESTAÑA_DATOS_GENERALES)
		
		#Hacemos clic en la pestaña Datos generales
		modulos.logica.MouseController.clickTo(modulos.globales.Constantes.PESTAÑA_DATOS_GENERALES)
	else:
	
		#Esperamos por la pestaña Datos generales
		modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.PESTAÑA_DATOS_GENERALES_SELECCIONADA)
		
		#Hacemos clic en la pestaña Datos generales
		modulos.logica.MouseController.clickTo(modulos.globales.Constantes.PESTAÑA_DATOS_GENERALES_SELECCIONADA)
		
	#Avanzamos hasta el boton Amparar
	for x in range(2):
		pyautogui.hotkey('tab')
	
	#Hacemos clic en el boton Amparar
	pyautogui.hotkey('enter')
	
	#Esperamos 2 segundos
	time.sleep( 2 )
	
	#Avanzamos hasta la lista desplegable de resultado de actividad
	for x in range(3):
		pyautogui.hotkey('tab')
		
	#Preguntamos si tiene tasacion
	if(tasacion == 'SI'):
		
		#Avanzamos hasta la opcion Tasar
		for x in range(3):
			pyautogui.hotkey('down')
			time.sleep( 1 )
	pyautogui.hotkey('down')
	time.sleep( 2 )
	
	#Preguntamos si no tiene tasacion
	if(tasacion != 'SI'):
		
		#Esperamos por la etiqueta Sub Notas
		modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.ETIQUETA_SUB_NOTAS)
		
		#Hacemos clic en la etiqueta Sub Notas
		modulos.logica.MouseController.clickTo(modulos.globales.Constantes.ETIQUETA_SUB_NOTAS)
		
		#x, y = pyautogui.position()
		#pyautogui.click(x, y - 80)
		#pyautogui.hotkey('tab')
		
		#Seleccionamos la primer Sub Nota
		pyautogui.hotkey('down')
		
	#Avanzamos hasta el boton Continuar
	for x in range(4):
		pyautogui.hotkey('tab')
		
	#Hacemos clic en el boton Continuar
	pyautogui.hotkey('enter')
	
	#Preguntamos si no hay un mensaje de error correspondiente a asociar siniestro
	if(pyautogui.locateOnScreen(modulos.globales.Constantes.MENSAJE_ERROR_ASOCIAR_SINIESTRO) == None):
	
		#Imprimimos en pantalla el mensaje "Fin del proceso ANALIZAR AMPARO"
		print('Fin del proceso ANALIZAR AMPARO')

def analizarAmparo_Liquidar():
	print('Inicio del proceso ANALIZAR AMPARO')
	print('NO IMPLEMENTADA')
	print('Fin del proceso ANALIZAR AMPARO')

def analizarAmparo_Rechazar():
	print('Inicio del proceso ANALIZAR AMPARO')
	print('NO IMPLEMENTADA')
	print('Fin del proceso ANALIZAR AMPARO')

def retomaAnalizarAmparo_estudiarAnalizar():
	print('Inicio del proceso ANALIZAR AMPARO')
	print('NO IMPLEMENTADA')
	print('Fin del proceso ANALIZAR AMPARO')

def estudiarAnalizar_consultarAsesoria():
	print('Inicio del proceso ESTUDIAR ANALIZAR')
	print('NO IMPLEMENTADA')
	print('Fin del proceso ESTUDIAR ANALIZAR')

def analizarAmparo_pasarSupervisor():
	print('Inicio del proceso ANALIZAR AMPARO')
	print('NO IMPLEMENTADA')
	print('Fin del proceso ANALIZAR AMPARO')

def analizarAmparo_finalizar():
	print('Inicio del proceso ANALIZAR AMPARO')
	print('NO IMPLEMENTADA')
	print('Fin del proceso ANALIZAR AMPARO')

def pasarSupervisor_rechazar():
	print('Inicio del proceso PASAR SUPERVISOR')
	print('NO IMPLEMENTADA')
	print('Fin del proceso PASAR SUPERVISOR')

def liquidar_devolver():
	print('Inicio del proceso LIQUIDAR')
	print('NO IMPLEMENTADA')
	print('Fin del proceso LIQUIDAR')
	
def estudiarAnalizar_esperarPorEvento():
	print('Inicio del proceso ESTUDIAR ANALIZAR')
	print('NO IMPLEMENTADA')
	print('Fin del proceso ESTUDIAR ANALIZAR')

def esperarPorEvento_EstudiarAnalizar():	
	print('Inicio del proceso ESPERAR POR EVENTO')
	print('NO IMPLEMENTADA')
	print('Fin del proceso ESPERAR POR EVENTO')

def consultarAsesoria_EstudiarAnalizar():
	print('Inicio del proceso CONSULTAR ASESORIA')
	print('NO IMPLEMENTADA')
	print('Fin del proceso CONSULTAR ASESORIA')
	
def estudiarAnalizar_liquidar():

	#Imprimimos en pantalla el mensaje "Inicio del proceso ESTUDIAR ANALIZAR"
	print('Inicio del proceso ESTUDIAR ANALIZAR')
	
	#Esperamos a la pestaña Expediente
	modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.PESTAÑA_EXPEDIENTE)
	
	#Hacemos clic en la pestaña Expediente
	modulos.logica.MouseController.clickTo(modulos.globales.Constantes.PESTAÑA_EXPEDIENTE)
	
	#Preguntamos si no esta presente el checkbox todos
	if(pyautogui.locateOnScreen(modulos.globales.Constantes.CHECKBOX_TODOS) == None):
	
		#Esepramos por el boton Filtrar
		modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.BOTON_FILTRAR)
		
		#Hacemos clic en el boton Filtrar
		modulos.logica.MouseController.clickTo(modulos.globales.Constantes.BOTON_FILTRAR)
	
	#Esperamos por la etiqueta Vehiculos
	modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.ETIQUETA_VEHICULOS)
	
	#Esperamos por el checkbox Todos
	modulos.logica.MouseController.waitBy2Image(modulos.globales.Constantes.CHECKBOX_TODOS_SIN_FOCO,modulos.globales.Constantes.CHECKBOX_TODOS_EN_FOCO)
	
	#Esperamos por la etiqueta Vehiculos
	modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.ETIQUETA_VEHICULOS)
	
	#modulos.logica.MouseController.click2ImagesTo(modulos.globales.Constantes.CHECKBOX_TODOS,modulos.globales.Constantes.CHECKBOX_TODOS_EN_FOCO)
	
	#Hacemos clic en el checkbox Todos
	modulos.logica.MouseController.clickTo(modulos.globales.Constantes.CHECKBOX_TODOS)
	
	#Esperamos a que el checkbox todos no este seleccionado
	modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.CHECKBOX_TODOS_NO_SELECCIONADO)
	
	#Avanzamos hasta el checkbox Autos
	for x in range(4):
		pyautogui.hotkey('tab') 
		
	#Seleccionamos el checkbox Autos
	pyautogui.hotkey('space')
	
	#Hacemos clic en el boton buscar
	modulos.logica.MouseController.clickTo(modulos.globales.Constantes.BOTON_BUSCAR)
	
	#Esperamos 2 segundos
	time.sleep( 2 )
	
	#Avanzamos hasta el boton editar
	for x in range(5):
		pyautogui.hotkey('tab')
	
	#Hacemos clic en el boton Editar
	pyautogui.hotkey('space')
	
	#modulos.logica.MouseController.clickTo(modulos.globales.Constantes.BOTON_EDITAR_CLASE_DOCUMENTAL)
	
	#Esperamos a que la lista desplegable clase documental este deshabilitada
	modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.COMBOBOX_CLASE_DOCUMENTAL_DESHABILITADO)
	
	#Hacemos clic en la lista desplegable deshabilitada
	modulos.logica.MouseController.clickTo(modulos.globales.Constantes.COMBOBOX_CLASE_DOCUMENTAL_DESHABILITADO)
	
	#Avanzamos hasta el boton Subir Archivo
	x, y = pyautogui.position()
	pyautogui.click(x, y - 80)
	pyautogui.hotkey('tab')
	
	#Esperamos 2 segundos
	time.sleep( 2 )
	
	#Hacemos clic en el boton Subir Archivo
	pyautogui.hotkey('enter')
	
	#Esperamos 1 segundo
	time.sleep( 1 )
	
	#Avanzamos hasta encontrar una imagen
	for x in range(9):
		pyautogui.hotkey('tab')
	
	#Seleccionamos la imagen
	pyautogui.hotkey('space')
	
	#Confirmamos la seleccion de la imagen
	pyautogui.hotkey('enter')
	
	#Esperamos por la imagen con el nombre del archivo
	modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.ARCHIVO)
	
	#Esperamos 1 segundo
	time.sleep( 1 )
	
	#Avanzamos hasta el boton Aceptar
	for x in range(4):
		pyautogui.hotkey('tab') 
		
	#Hacemos clic en el boton Aceptar
	pyautogui.hotkey('enter')
	
	#Imprimimos en pantalla el mensaje "Se subio y versiono el documento satisfactoriamente"
	print('Se subio y versiono el documento satisfactoriamente')
	
	#Esperamos por el boton Recatalogar
	modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.BOTON_RECATALOGAR)
	
	#Preguntamos si la pestaña Datos generales no esta seleccionada
	if(pyautogui.locateOnScreen(modulos.globales.Constantes.PESTAÑA_DATOS_GENERALES_SELECCIONADA) == None):
		
		#Esperamos por la pestaña Datos generales
		modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.PESTAÑA_DATOS_GENERALES)
		
		#Hacemos clic en la pestaña Datos generales
		modulos.logica.MouseController.clickTo(modulos.globales.Constantes.PESTAÑA_DATOS_GENERALES)
	else:
	
		#Esperamos por la pestaña Datos generales
		modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.PESTAÑA_DATOS_GENERALES_SELECCIONADA)
		
		#Hacemos clic en la pestaña Datos generales
		modulos.logica.MouseController.clickTo(modulos.globales.Constantes.PESTAÑA_DATOS_GENERALES_SELECCIONADA)
		
	#Avanzamos hasta la lista desplegable Realizar actividad
	for x in range(3):
		pyautogui.hotkey('tab')
	
	#Esperamos 1 segundo
	time.sleep( 1 )
	
	#Seleccionamos la opcion Liquidar
	for x in range(3):
		pyautogui.hotkey('down')
		time.sleep( 1 )
	
	#Esperamos 1 segundo
	time.sleep( 1 )
	
	#Avanzamos hasta el boton Continuar
	for x in range(4):
		pyautogui.hotkey('tab')
		
	#Hacemos clic en el boton Continuar	
	pyautogui.hotkey('enter')
	
	#Preguntamos si no esta presente el mensaje de error asociado a asociar siniestro
	if(pyautogui.locateOnScreen(modulos.globales.Constantes.MENSAJE_ERROR_ASOCIAR_SINIESTRO) == None):
	
		#Imprimimos en pantalla el mensaje "Fin del proceso ESTUDIAR ANALIZAR"
		print('Fin del proceso ESTUDIAR ANALIZAR')

def estudiarAnalizar_Devolver():
	print('Inicio del proceso ESTUDIAR ANALIZAR')
	print('NO IMPLEMENTADA')
	print('Fin del proceso ESTUDIAR ANALIZAR')

def tasar_liquidar():

	#Imprimimos en pantalla el mensaje "Inicio del proceso TASAR"
	print('Inicio del proceso TASAR')
	
	#Esperamos por la pestaña expediente
	modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.PESTAÑA_EXPEDIENTE)
	
	#Esperamos 1 segundo
	time.sleep( 1 )
	
	#Vamos hasta el final de la pagina
	pyautogui.hotkey('pagedown')
	
	#Avanzacmos hasta la lista desplegable realizar actividad
	for x in range(4):
		pyautogui.hotkey('tab') 
	
	#Esperamos 1 segundo
	time.sleep( 1 )
	
	#Seleccionamos la opcion liquidar
	pyautogui.hotkey('down')
	
	#Esperamos 2 segundos
	time.sleep( 2 )
	
	#Esperamos por la etiqueta sub notas
	modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.ETIQUETA_SUB_NOTAS)
	
	#Seleccionamos una sub nota
	pyautogui.hotkey('tab')
	time.sleep( 1 )
	pyautogui.hotkey('down')
	pyautogui.hotkey('down')
	
	#Avanzamos hasta el boton Continuar
	for x in range(4):
		pyautogui.hotkey('tab')
		
	#Hacemos clic en el boton Continuar
	pyautogui.hotkey('enter')
	
	#Imprimimos en pantalla el mensaje "Fin del proceso TASAR"
	print('Fin del proceso TASAR')

def liquidar_controlar():

	#Imprimimos en pantalla el mensaje "Inicio del proceso LIQUIDAR"
	print('Inicio del proceso LIQUIDAR')
	
	#Esperamo por la pestaña Expediente
	modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.PESTAÑA_EXPEDIENTE)
	
	#pyautogui.hotkey('end')
	
	#Avanzamos hasta la lista desplegable realizar actividad
	for x in range(4):
		pyautogui.hotkey('tab')
	
	#Esperamos 1 segundo
	time.sleep( 1 )
	
	#Seleccionamos la opcion Controlar
	for x in range(3):
		pyautogui.hotkey('down')
		time.sleep( 1 )
	
	#Esperamos 3 segundos
	time.sleep( 3 )
	
	#Seleccionamos la opcion Contralor 1
	pyautogui.hotkey('tab')
	pyautogui.hotkey('down')
	
	#Avanzamos hasta el boton Continuar
	for x in range(4):
		pyautogui.hotkey('tab')
	
	#Hacemos clic en el boton Continuar
	pyautogui.hotkey('enter')
	
	#Imprimimos en pantalla el mensaje "Fin del proceso LIQUIDAR"
	print('Fin del proceso LIQUIDAR')

def liquidarProvyTec_controlar():
	print('Inicio del proceso LIQUIDAR')
	print('NO IMPLEMENTADA')
	print('Fin del proceso LIQUIDAR')

def controlar_agendarPagos():

	#Imprimimos en pantalla el mensaje "Inicio del proceso CONTROLAR"
	print('Inicio del proceso CONTROLAR')
	
	#Esperamos por la pestaña Expediente
	modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.PESTAÑA_EXPEDIENTE)
	
	#Avanzamos hasta la lista desplegable realizar actividad
	for x in range(4):
		pyautogui.hotkey('tab') 
	
	#Esperamos 1 segundo
	time.sleep( 1 )
	
	#Seleccionamos la opcion Agendar Pagos
	pyautogui.hotkey('down')
	
	#Esperamos 3 segundos
	time.sleep( 3 )
	
	#Avanzamos hasta la lista desplegable de sub notas
	pyautogui.hotkey('tab')
	
	#Seleccionamos la opcion Contralor 1
	pyautogui.hotkey('down')
	
	#Avanzamos hastas el boton Continuar
	for x in range(4):
		pyautogui.hotkey('tab')
		
	#Hacemos clic en el boton Continuar
	pyautogui.hotkey('enter')
	
	#Imprimimos en pantalla el mensaje "Fin del proceso CONTROLAR"
	print('Fin del proceso CONTROLAR')

def controlar_liquidarProvytec():
	print('Inicio del proceso CONTROLAR')
	print('NO IMPLEMENTADA')
	print('Fin del proceso CONTROLAR')
	
def agendarPagos_pagar():

	#Imprimimos en pantalla el mensaje "Inicio del proceso AGENDAR PAGOS"
	print('Inicio del proceso AGENDAR PAGOS')
	
	#Esperamos a la pestaña Expediente
	modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.PESTAÑA_EXPEDIENTE)
	
	#Avanzamos hasta la lista desplegable realizar actividad
	for x in range(4):
		pyautogui.hotkey('tab')
		
	#Esperamos 1 segundo
	time.sleep( 1 )
	
	#Seleccionamos la opcion Pagar
	pyautogui.hotkey('down')
	
	#Esperamos 2 segundos
	time.sleep( 2 )
	
	#Avanzamos hasta el boton Continuar
	for x in range(4):
		pyautogui.hotkey('tab')
	
	#Hacemos clic en el boton Continuar
	pyautogui.hotkey('enter')
	
	#Imprimimos en pantalla el mensaje "Fin del proceso AGENDAR PAGOS"
	print('Fin del proceso AGENDAR PAGOS')
		
def pagar_controlarVale():

	#Imprimimos en pantalla el mensaje "Inicio del proceso PAGAR"
	print('Inicio del proceso PAGAR')
	
	#Esperamos a la pestaña Expediente
	modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.PESTAÑA_EXPEDIENTE)
	
	#Avanzamos hasta la lista desplegable realizar actividad
	for x in range(4):
		pyautogui.hotkey('tab') 
	
	#Esperamos 1 segundo
	time.sleep( 1 )
	
	#Seleccionamos la opcion Controlar Vale
	for x in range(2):
		pyautogui.hotkey('down')
		time.sleep( 1 )
	
	#Esperamos 2 segundos
	time.sleep( 2 )
	
	#Esperamos por la etiqueta sub notas
	modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.ETIQUETA_SUB_NOTAS)
	
	#Avanzamos hasta la lista desplegable sub notas
	pyautogui.hotkey('tab')
	
	#Esperamos 1 segundo
	time.sleep( 1 )
	
	#Seleccionamos una sub nota
	pyautogui.hotkey('down')
	
	#Avanzamos hasta el boton Continuar
	for x in range(4):
		pyautogui.hotkey('tab')
		
	#Hacemos clic en el boton Continuar
	pyautogui.hotkey('enter')
	
	#Imprimimos en pantalla el mensaje "Fin del proceso PAGAR"
	print('Fin del proceso PAGAR')

def pagar_finalizar():
	print('Inicio del proceso PAGAR')
	print('NO IMPLEMENTADA')
	print('Fin del proceso PAGAR')
	
def pagar_recuperar():
	print('Inicio del proceso PAGAR')
	print('NO IMPLEMENTADA')
	print('Fin del proceso PAGAR')
	
def pagar_consultarSupervisor():
	print('Inicio del proceso PAGAR')
	print('NO IMPLEMENTADA')
	print('Fin del proceso PAGAR')

def consultarSupervisor_esperarPorEvento():
	print('Inicio del proceso CONSULTAR SUPERVISOR')
	print('NO IMPLEMENTADA')
	print('Fin del proceso CONSULTAR SUPERVISOR')

def esperarPorEvento_Recuperar():
	print('Inicio del proceso ESPERAR POR EVENTO')
	print('NO IMPLEMENTADA')
	print('Fin del proceso ESPERAR POR EVENTO')
	
def controlarVale_finalizar():

	#Imprimimos en pantalla el mensaje "Inicio del proceso CONTROLAR VALE"
	print('Inicio del proceso CONTROLAR VALE')
	
	#Esperamos a la pestaña Expediente
	modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.PESTAÑA_EXPEDIENTE)
	
	#Avanzamos hasta la lista desplegable realizar actividad
	for x in range(4):
		pyautogui.hotkey('tab') 
	
	#Esperamos 1 segundo
	time.sleep( 1 )
	
	#Selecionamos la opcion Finalizar
	pyautogui.hotkey('down')
	
	#Esperamos 2 segundos
	time.sleep( 2 )
	
	#Avanzamos hasta el boton Continuar
	for x in range(4):
		pyautogui.hotkey('tab')
	
	#Hacemos clic en el boton Continuar
	pyautogui.hotkey('enter')

	#Esperamos a la etiqueta ajuste de reserva
	modulos.logica.MouseController.waitByImage(modulos.globales.Constantes.ETIQUETA_AJUSTE_RESERVA)
	
	#Hacemos clic en el boton Aceptar
	modulos.logica.MouseController.clickTo(modulos.globales.Constantes.BOTON_ACEPTAR)
	
	#Imprimimos en pantalla el mensaje "Fin del proceso CONTROLAR VALE"
	print('Fin del proceso CONTROLAR VALE')
	
def recuperar_finalizar():
	print('Inicio del proceso RECUPERAR')
	print('NO IMPLEMENTADA')
	print('Fin del proceso RECUPERAR')
}
*/