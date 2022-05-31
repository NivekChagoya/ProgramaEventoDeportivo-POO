import javax.swing.*;
import java.util.*;
import java.lang.Exception;
public class Vista
{
    public static String leerString(String c){
        return JOptionPane.showInputDialog(c);
    }

    /** VALIDACION DE PURAS LETRAS**/
    public static String leerLetras(String c){
        String cad=null;
        boolean correcto=false;
        while(!correcto){
            try{
                String cad2=leerString(c);
                if(cad2!=null){
                    if(cad2.equals("")){
                        throw new NumberFormatException();
                    }else{
                        char n='a';
                        for(int i=0;i<cad2.length();i++){
                            n=cad2.charAt(i);
                            if(!Character.isLetter(n)){
                                throw new NumberFormatException();
                            }
                        }
                    }
                    cad=cad2;
                }
                correcto=true;
            }catch(NumberFormatException Excepcion){}
        }
        return cad;
    }

    /**VALIDACION DE LETRAS CON NUMEROS**/
    public static String leerLetrasNumeros(String c){
        String cad=null;
        boolean correcto=false;
        while(!correcto){
            try{
                String cad2=leerString(c);
                if(cad2!=null){
                    if(cad2.equals("")){
                        throw new NumberFormatException();
                    }else{
                        char n='a';
                        for(int i=0;i<cad2.length();i++){
                            n=cad2.charAt(i);
                            if(!Character.isLetter(n) && !Character.isDigit(n)){
                                throw new NumberFormatException();
                            }
                        }
                    }
                    cad=cad2;
                }
                correcto=true;
            }catch(NumberFormatException Excepcion){}
        }
        return cad;
    }

    /** VALIDACION DE ENTEROS **/
    public static int leerEntero(String c){
        int entero=0;
        boolean correcto=false;
        while(!correcto){
            try{
                String cad2=leerString(c);
                if(cad2!=null){
                    entero=Integer.parseInt(cad2);
                    if(entero<1){
                        throw new NumberFormatException();
                    }
                }
                correcto=true;
            }catch(NumberFormatException Excepcion){}
        }
        return entero;
    }

    /** VALIDACION De RANGOS DE OPCION**/
    public static int menu(String c,int n,int m){
        int e=0;
        boolean correcto=false;
        while(!correcto){
            try{
                String cad=leerString(c);
                if(cad!=null){
                    int x=Integer.parseInt(cad);
                    if(x<n || x>m)
                    {throw new NumberFormatException();}
                    e=x;
                }else{e=m;}
                correcto=true;
            }catch(NumberFormatException Excepcion){}
        }
        return e;
    }

    /**MENSAJE EN PANTALLA**/
    public static void Mensaje(String c){
        JOptionPane.showMessageDialog(null,c);
    }

    /** INGRESO DE DATOS PARA CREAR JUGADOR**/
    public static Jugador crearJugador(Vector v){
        String nom=leerLetras("Ingrese un Nombre");
        if(nom==null){return null;}
        String ap=leerLetras("Ingrese el Apellido Paterno");
        if(ap==null){return null;}
        String am=leerLetras("Ingrese el Apellido Materno");
        if(am==null){return null;}
        int edad=leerEntero("Ingrese la Edad");
        if(edad==0){return null;}
        char sex='.';
        int z=menu("Ingrese el sexo\n1 Hombre\n2 Mujer",1,2);
        if(z==1){sex='H';}if(z==2){sex='M';}if(z==0){return null;}
        boolean correcto=false;
        String clave=null;
        while(!correcto){
            try{
                String c=leerLetrasNumeros("Ingrese la clave del Jugador");
                if(c==null){return null;}
                for(int i=0;i<v.size();i++){
                    if(c.equals(v.get(i))){
                        throw new Exception();
                    }
                }
                clave=c;
                correcto=true;
            }catch(Exception Excepcion){}
        }
        if(clave==null){return null;}
        int t=leerEntero("Ingrese el tiempo entrenado");
        return new Jugador(nom,ap,am,edad,sex,clave,t);
    }

    /** INGRESO DE DATOS PARA CREAR ENTRENADOR**/
    public static Entrenador crearEntrenador(Vector v){
        String nom=leerLetras("Ingrese un Nombre");
        if(nom==null){
            return null;
        }
        String ap=leerLetras("Ingrese el Apellido Paterno");
        if(ap==null){
            return null;
        }
        String am=leerLetras("Ingrese el Apellido Materno");
        if(am==null){
            return null;
        }
        int edad=leerEntero("Ingrese la Edad");
        if(edad==0){
            return null;
        }
        char sex='.';
        int z=menu("Ingrese el sexo\n1 Hombre\n2 Mujer",1,2);
        if(z==1){
            sex='H';
        }
        if(z==2){
            sex='M';
        }if(z==0){
            return null;
        }
        boolean correcto=false;
        String clave=null;
        while(!correcto){
            try{
                String c=leerLetrasNumeros("Ingrese la clave del Entrenador");
                if(c==null){
                    return null;
                }
                for(int i=0;i<v.size();i++){
                    if(c.equals(v.get(i))){
                        throw new Exception();
                    }
                }
                clave=c;
                correcto=true;
            }catch(Exception Excepcion){}
        }
        if(clave==null){
            return null;
        }
        return new Entrenador(nom,ap,am,edad,sex,clave);
    }

    /** INGRESO DE DATOS PARA CREAR EVENTO**/
    public static Evento crearEvento(Vector v){
        String nom=leerLetras("Ingrese el Nombre del Evento");
        if(nom==null){
            return null;
        }
        boolean correcto=false;
        String clave=null;
        while(!correcto){
            try{
                String c=leerLetrasNumeros("Ingrese la clave del Evento");
                if(c==null){return null;}
                for(int i=0;i<v.size();i++){
                    if(c.equals(v.get(i))){
                        throw new Exception();
                    }
                }
                clave=c;
                correcto=true;
            }catch(Exception Excepcion){}
        }
        if(clave==null){return null;}
        return new Evento(clave,nom);
    }

    /** INGRESO DE DATOS PARA CREAR UNA DISCIPLINA**/
    public static Disciplina crearDiciplina(Vector v){
        String nom=leerLetras("Ingrese el Nombre de la Diciplina");
        if(nom==null){
            return null;
        }
        int t=menu("Tipo de Disciplina\n1 Grupal\n2 Individual",1,2);
        String tipo="";
        if(t==1){
            tipo="Grupal";
        }
        else{
            tipo="Individual";
        }
        boolean correcto=false;
        String clave=null;
        while(!correcto){
            try{
                String c=leerLetrasNumeros("Ingrese la clave de la Disciplina");
                if(c==null){return null;}
                for(int i=0;i<v.size();i++){
                    if(c.equals(v.get(i))){
                        throw new Exception();
                    }
                }
                clave=c;
                correcto=true;
            }catch(Exception Excepcion){}
        }
        if(clave==null){return null;}
        return new Disciplina(clave,nom,tipo);
    }

    /** INGRESO DE DATOS PARA CREAR UNA PARTICIPACION**/
    public static Participacion crearParticipacion(Vector v1,Vector v2,Vector v3,Vector v4,ArregloParticipacion arr){
        boolean ver4=false;
        String c4=null;
        while(!ver4){
            try{
                String c=leerLetrasNumeros("Ingrese la clave del Evento");
                if(c==null){return null;}
                boolean cr4=false;
                for(int i=0;i<v4.size();i++){
                    if(v4.get(i).equals(c)){cr4=true;}
                }
                if(cr4==false){
                    Mensaje("Evento no Registrado");
                    throw new Exception();
                }
                c4=c;
                ver4=true;
            }catch(Exception Excepcion){}
        }
        boolean ver1=false;
        String c1=null;
        while(!ver1){
            try{
                String c=leerLetrasNumeros("Ingrese la clave del Jugador");
                if(c==null){return null;}
                boolean cr1=false;
                for(int i=0;i<v1.size();i++){
                    if(v1.get(i).equals(c)){cr1=true;}
                }
                if(cr1==false){
                    Mensaje("Jugador no Registrado");
                    throw new Exception();}
                boolean part=arr.yaRegistradoEvento(c4,c);
                if(part==true){
                    Mensaje("El Jugador ya esta participando en el Evento");
                    throw new Exception();}
                c1=c;
                ver1=true;
            }catch(Exception Excepcion){}
        }
        boolean ver2=false;
        String c2=null;
        while(!ver2){
            try{
                String c=leerLetrasNumeros("Ingrese la clave del Entrenador");
                if(c==null){return null;}
                boolean cr2=false;
                for(int i=0;i<v2.size();i++){
                    if(v2.get(i).equals(c)){cr2=true;}
                }
                if(cr2==false){
                    Mensaje("Entrenador no Registrado");
                    throw new Exception();
                }
                c2=c;
                ver2=true;
            }catch(Exception Excepcion){}
        }
        boolean ver3=false;
        String c3=null;
        while(!ver3){
            try{
                String c=leerLetrasNumeros("Ingrese la clave de la Disciplina");
                if(c==null){return null;}
                boolean cr3=false;
                for(int i=0;i<v3.size();i++){
                    if(v3.get(i).equals(c)){cr3=true;}
                }
                if(cr3==false){
                    Mensaje("Disciplina no Registrada");
                    throw new Exception();
                }
                c3=c;
                ver3=true;
            }catch(Exception Excepcion){}
        }
        String logro=Logro(c4,arr);
        if(logro==null){return null;}
        return new Participacion(c4,c1,c2,c3,logro);
    }

    /** METODO GANADORES DE EVENTO**/
    public static String Logro(String e,ArregloParticipacion arr){
        boolean v=true;
        String logro=null;
        while(v){
            try{
                int n=menu("Logro\n1 Primer Lugar\n2 Segundo Lugar\n3 Tercer Lugar\n4 Participante",1,5);
                if(n==1){
                    if(arr.yaHayGanadores(e,"Primer Lugar")){
                        Mensaje("Ya hay un Primer Lugar");
                        throw new Exception();
                    }
                    logro="Primer Lugar(ORO)";
                    v=false;
                }
                if(n==2){
                    if(arr.yaHayGanadores(e,"Segundo Lugar")){
                        Mensaje("Ya hay un Segundo Lugar");
                        throw new Exception();
                    }
                    logro="Segundo Lugar(PLATA)";
                    v=false;
                }
                if(n==3){
                    if(arr.yaHayGanadores(e,"Tercer Lugar")){
                        Mensaje("Ya hay un Tercer Lugar");
                        throw new Exception();
                    }
                    logro="Tercer Lugar(BRONCE)";
                    v=false;
                }
                if(n==4){logro="Participante";v=false;}
                if(n==5){logro=null;}
            }catch(Exception Excepcion){}
        }
        return logro;
    }
}
