import os
os.system("taskkill /f /im iexplore.exe")

f = open('Parametros.txt','r')
inp = open('Entradas.txt','r')
l = open('Resultado.txt','w')
Nav = f.readline()
Url = f.readline()
Nav = 'C:\Program Files\Internet Explorer\iexplore.exe'
openApp (Nav)
wait(2)
wait("1534436384508.png")
wait(4)
click("1534440084048.png")
paste(Pattern("1534355682379.png").similar(0.60), Url)
wait(3)
type (Key.ENTER)


if (exists("1534357421513.png")):
    click("1534355945133.png")

user = f.readline() 
pasw = f.readline()


l.write('Comienza el login  \n')

wait("1533657047081.png",20)
click("1533657066772.png")
paste("1533657077187.png", user)
type (Key.TAB)  
if exists("1533657127867.png"):
    l.write('>> ERROR_Usuario incorrecto.' + '\n') 
else:
    click("1533657177211.png")
    paste("1533657185033.png", pasw)
    type (Key.ENTER)
    click("1533657226998.png") 
    if exists("1534427094654.png"):
        l.write('>> ERROR_ Contraseña incorrecta.' + '\n') 
    else:
        if (exists("1534436463868.png")):
            click("1534436463868.png")
            if (exists("Varias.png")):
                click("Varias-1.png")
                if(exists("Poliza.png")):
                    click("Poliza-1.png")
                    cantMatriculas = inp.readline() 
                    Matricula = inp.readline()
                    paste("1534436811441.png", Matricula)
                    click("1534436556126.png")
                    wait("1534436610250.png")
                    m = find("1534439738589.png").left(83)
                    #l.write(m.getX())
                    #l.write(m.getY())
                    #l.write(m.text()) 
                    m.highlight (3)
                    fecha = m.text() 
                    dia = fecha[0:2]
                    mes = fecha[3:5]
                    anio = fecha[(len(fecha)-4):(len(fecha))]
                    DiaR = inp.readline()
                    MesR = inp.readline()
                    AnioR = inp.readline()
                    
                    l.write(dia+'/'+mes+'/'+anio)   
                    l.write(anio[3:3]) 
                    
                    if (anio[3:3] == 'S'):
                       anio[3:3] = 5
                       l.write(anio) 
                        
                    if ((int(AnioR)>=int(anio))and(int(MesR)>=int(mes))and(int(DiaR)>int(dia))):
                        ##Este funciona
                        l.write('EsteFunciona')
                    else:
                        #No funciona debo buscar otro
                        l.write('Nofunciono')  
                else:
                    l.write('>> ERROR_ Falta la opción de Consultas/Varias/Póliza por matrícula.' + '\n')
            else:
                l.write('>> ERROR_ Falta la opción de Consultas/Varias.' + '\n')             
        else:
            l.write('>> ERROR_ Falta la opción de Consultas.' + '\n')    
        
            
                      

#os.system("taskkill /f /im iexplore.exe")