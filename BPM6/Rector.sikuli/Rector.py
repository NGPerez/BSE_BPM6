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
#click("1534440084048.png")
#wait(1)
paste("1534508316424.png", Url)
wait(3)
type (Key.ENTER)


if (exists("1534357421513.png")):
    click("1534355945133.png")

user = f.readline() 
pasw = f.readline()
ejecutivo = f.readline()

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
                    i = 1
                    cantidad = 0; 
                    x = 0
                    while ((x < int(cantMatriculas)) && (cantidad <= 6)):
                        
                        Matricula = inp.readline()
                        DiaR = inp.readline()
                        MesR = inp.readline()
                        AnioR = inp.readline()
                        Serie = inp.readline()
                        NroD = inp.readline()
                        paste(Pattern("1534523704756.png").targetOffset(17,-1), Matricula)
                        click("1534436556126.png")
                        wait(1)
                        
                        if(exists("1534523222471.png")):
                            click(Pattern("1534522382155.png").similar(0.65))
                            doubleClick(Pattern("1534523704756.png").targetOffset(17,-1))
                            type (Key.DELETE)
                            extra = inp.readline()
                        else:
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
                                    cantidad = cantidad + 1; 
                                    l.write(Matricula + 'Correcta'+'\n')
                                else:
                                    l.write(Matricula + 'Incorrecta: Fecha hasta inferior'+'\n')
                            else:
                                l.write(Matricula + 'Incorrecta: Fecha desde superior'+'\n')
                            extra = inp.readline()
                            click("1534515934104.png")
                            x = x+1
                            
                    S.close ()
                    click("1534526678006.png")
                    click("1534526694204.png")
                    click("Decla.png")
                    click("Declarar.png")
                    SS = open ('Resultado.txt','r')

                    i = 1;
                    while (i < 2):
                        i=i+2
                        paste(Pattern("1534526928983.png").targetOffset(12,0), '4')
                        type (Key.TAB)
                        Aux1 = SS.readline()
                        Aux2 = SS.readline()
                        Aux3 = SS.readline()
                        Aux4 = SS.readline()
                        Serie = SS.readline()
                        Parte = SS.readline()
                        Poliza = SS.readline()
                        paste(Pattern("1534528579411.png").targetOffset(41,0),Serie)
                        paste(Pattern("1534530348596.png").targetOffset(-30,0),Parte)
                        type (Key.TAB)
                        paste(Pattern("1534528685082.png").targetOffset(-35,0),Poliza)
                        type (Key.TAB)
                        click("1534528770815.png")
                        click("1534528787433.png")
                        if (exists("1534528813101.png")):
                            click("1534528826726.png")
                        type (Key.TAB)
                        if(exists("1534528914255.png")):
                            click("1534528924103.png")
                        paste(Pattern("1534528945608.png").targetOffset(23,0),'02')
                        type (Key.TAB)
                        click(find("1534531266929.png").right(6))  
                        type (Key.TAB)
                        #paste(find("1534531266929.png").right(6),'3999')  
                        doubleClick(find("1534790574066.png").right(6))
                        type(Key.DELETE)
                        paste(find("1534790574066.png").right(6),'3999')
                        click("1534790645595.png")
                        click("1534790688721.png")
                        click("1534790700051.png")
                        #paste(Pattern("1534790733909.png").targetOffset(25,0),ejecutivo)
                        #type (Key.TAB)                        
                        paste(find("1534529127934.png").right(5),ejecutivo)
                        type(Key.TAB)
                        paste(find("1534529173382.png").right(5),'200')
                        type(Key.TAB)
                        click("1534529195660.png")
                        if(exists("1534791857774.png")):
                            click("1534791866109.png")
                        if(exists("1534791919535.png")):
                            click("1534791925951.png")
                        
                else:
                    l.write('>> ERROR_ Falta la opción de Consultas/Varias/Póliza por matrícula.' + '\n')
            else:
                l.write('>> ERROR_ Falta la opción de Consultas/Varias.' + '\n')             
        else:
            l.write('>> ERROR_ Falta la opción de Consultas.' + '\n')    
        
#os.system("taskkill /f /im iexplore.exe")