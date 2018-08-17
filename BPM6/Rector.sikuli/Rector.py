import os
os.system("taskkill /f /im iexplore.exe")

f = open('Parametros.txt','r')
inp = open('Entradas.txt','r')
l = open('Log.txt','w')
S = open ('Resultado.txt','w')
Nav = f.readline()
Url = f.readline()
Nav = 'C:\Program Files\Internet Explorer\iexplore.exe'
openApp (Nav)
wait(2)
#wait("Home.PNG")
wait(4)
click("1534440084048.png")
wait(1)
paste("1534508316424.png", Url)
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
                    for x in range(0, int(cantMatriculas)):
                        Matricula = inp.readline()
                        DiaR = inp.readline()
                        MesR = inp.readline()
                        AnioR = inp.readline()
                        Serie = inp.readline()
                        NroD = inp.readline()
                        paste("1534436811441.png", Matricula)
                        click("1534436556126.png")
                        wait("1534436610250.png")
                        m = find("1534439738589.png").left(83)
                        m.highlight (3)
                        fecha = m.text() 
                        dia = fecha[0:2]
                        mes = fecha[3:5]
                        anio = fecha[(len(fecha)-4):(len(fecha))]
                        #l.write(dia+'/'+mes+'/'+ str(anio) +'\n')   
                      
                        if (anio == '201S'):
                            anio = '2015'
                           
                        if ((int(AnioR)>=int(anio))and(int(MesR)>=int(mes))and(int(DiaR)>int(dia))):
                            m2 = find("1534439738589.png").left(121).below(13)
                            m2.highlight (3)
                            fechaA = m2.text()
                            DiaA = fechaA[1:3]
                            MesA = fechaA[4:6]
                            AnioA = fechaA[7:11]
                            l.write(DiaA+'/'+MesA+'/'+ AnioA +'\n')
                            m3=find("1534514242355.png").below(17)
                            m3.highlight (3)
                            dato = m3.text()                            
                            if ( (int(AnioA)>int(AnioR)) or ( (int(AnioA)==int(AnioR)) and (int(MesA)>int(MesR)) ) or ( (int(AnioA)==int(AnioR)) and (int(MesA)==int(MesR)) and (int(DiaA)>int(DiaR)))):
                                S.write(Matricula+DiaR+MesR+AnioR+Serie+NroD+dato+'\n')
                                l.write(Matricula + 'Correcta'+'\n')
                            else:
                                l.write(Matricula + 'Incorrecta: Fecha hasta inferior'+'\n')
                        else:
                            l.write(Matricula + 'Incorrecta: Fecha desde superior'+'\n')
                        extra = inp.readline()
                        click("1534515934104.png")
                        
                else:
                    l.write('>> ERROR_ Falta la opción de Consultas/Varias/Póliza por matrícula.' + '\n')
            else:
                l.write('>> ERROR_ Falta la opción de Consultas/Varias.' + '\n')             
        else:
            l.write('>> ERROR_ Falta la opción de Consultas.' + '\n')    
        
#os.system("taskkill /f /im iexplore.exe")