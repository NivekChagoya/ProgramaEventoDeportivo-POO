import java.io.*;
import java.util.*;
import java.lang.Exception;
public class Controlador
{
    private static ArregloParticipacion arrP;
    private static Archivo archivo=new Archivo();
    private static Vista vista=new Vista();
    private static ArregloJugador arrJ;
    private static ArregloEntrenador arrE;
    private static ArregloDisciplina arrD;
    private static ArregloEvento arrEv;

    /** >>>>>INICIO DE PROGRAMA<<<<< **/
    public static void main(String[] arg)throws ClassNotFoundException,IOException{
        arrJ=archivo.LeerJugador("Jugador");
        arrE=archivo.LeerEntrenador("Entrenador");
        arrD=archivo.LeerDiciplina("Disciplina");
        arrEv=archivo.LeerEvento("Evento");
        arrP=archivo.LeerParticipacion("Participacion");
        boolean ver=true;
        do{
            int a=vista.menu("BIENVENIDO \n ELIJA UNA OPCION \n1.- Agregar Elemento\n2.- Eliminar un Elemento\n3.- Estadisticas\n4.- Buscar Elemento\n5.-Actualizar Datos de Jugador\n6.- Salir",1,5);
            switch(a){

                /** AGREGAR ELEMENTOS **/
                case 1:
                boolean cerrar=true;
                while(cerrar){
                    int n=vista.menu("Opciones para Agregar\n1.- Agregar Jugador\n2.- Agregar Entrenador\n3.- Agregar Disciplina\n4.- Agregar Evento\n5.- Agregar Participación\n6.- Regresar",1,6);
                    switch(n){

                        /** AGREGAR JUGADOR**/
                        case 1:
                        boolean op=arrJ.agregar(vista.crearJugador(Claves()));
                        if(op==true){
                            vista.Mensaje("Se agrego correctamente el Jugador");
                        }else{
                            vista.Mensaje("Cancelado");
                        }
                        break;

                        /** AGREGAR ENTRENADOR**/
                        case 2:
                        boolean op2=arrE.agregar(vista.crearEntrenador(Claves()));
                        if(op2==true){
                            vista.Mensaje("Se agrego correctamente el Entrenador");
                        }else{
                            vista.Mensaje("Cancelado");
                        }
                        break;

                        /** AGREGAR DISCIPLINA**/
                        case 3:
                        boolean op3=arrD.agregar(vista.crearDiciplina(Claves()));
                        if(op3==true){
                            vista.Mensaje("Se agrego correctamente la Disciplina");
                        }else{
                            vista.Mensaje("Cancelado");
                        }
                        break;

                        /** AGREGAR EVENTO **/
                        case 4:
                        boolean op4=arrEv.agregar(vista.crearEvento(Claves()));
                        if(op4==true){
                            vista.Mensaje("Se agrego correctamente el Evento");
                        }else{
                            vista.Mensaje("Cancelado");
                        }
                        break;

                        /** AGREGAR PARTICIPACION **/
                        case 5:
                        boolean op5=arrP.agregar(vista.crearParticipacion(arrJ.Claves(),arrE.Claves(),arrD.Claves(),arrEv.Claves(),arrP));
                        if(op5==true){
                            vista.Mensaje("Se agrego correctamente la participacion");
                        }else{
                            vista.Mensaje(" Cancelado");
                        }
                        break;
                        case 6:
                        cerrar=false;
                    }
                }
                break;

                /** OPCIONES DE ELIMINACION **/
                case 2:
                OpcionesdeEliminacion();
                break;

                /**OPCIONES DE ESTADISTICAS**/
                case 3:
                OpcionesEstadistica();
                break;

                /** OPCIONES DE BUSQUEDA **/
                case 4:
                buscar();
                break;

                /** ACTUALIZAR DATOS DE JUGADOR **/
                case 5:
                arrJ.actualizardatos(Vista.leerLetrasNumeros("Ingrese la clave del Jugador"));
                
                break;

                /** SALIR DE PROGRAMA **/
                case 6:
                ver=false;
            }
        }while(ver);
        archivo.GuardarJugador(arrJ,"Jugador");
        archivo.GuardarEntrenador(arrE,"Entrenador");
        archivo.GuardarDisciplina(arrD,"Disciplina");
        archivo.GuardarEvento(arrEv,"Evento");
        archivo.GuardarParticipacion(arrP,"Participacion");
    }

    /** MENU ELIMINAR**/
    public static void OpcionesdeEliminacion(){
        boolean cerrar=true;
        while(cerrar){
            int n=vista.menu("¿Que desea Eliminar?\n1 Eliminar Jugador\n2 Eliminar Entrenador\n3 Eliminar Diciplina\n4 Eliminar Evento\n5 Eliminar Participacion\n6.-Regresar",1,6);
            switch(n){

                /** ELIMINAR JUGADOR **/
                case 1:    
                boolean op1=true;
                boolean vf1=false;
                while(op1){
                    try{
                        String eliminacion1=vista.leerLetrasNumeros("Ingrese la clave del Jugador");
                        if(eliminacion1==null){op1=false;}
                        else{
                            boolean vr1=arrJ.compClaves(eliminacion1);
                            if(vr1==false){
                                vista.Mensaje("Elemento no existe");
                                throw new Exception();
                            }else{
                                boolean vt2=arrP.compararClaveJugador(eliminacion1);
                                if(vt2==true){
                                    vista.Mensaje("No se puede Eliminar ya que se encuentra participando en un Evento");
                                    throw new Exception();}
                                vf1=arrJ.eliminar(eliminacion1);
                                op1=false;
                            }
                        }
                    }catch(Exception Excepcion){}
                }
                if(vf1==true){vista.Mensaje("Eliminacion correcta");}
                else{vista.Mensaje("Eliminacion Cancelada");}
                break;

                /** ELIMINAR ENTRENADOR **/
                case 2:         
                boolean op2=true;
                boolean vf2=false;
                while(op2){
                    try{
                        String eliminacion2=vista.leerLetrasNumeros("Ingrese la clave del Entrenador");
                        if(eliminacion2==null){op2=false;}
                        else{
                            boolean vr1=arrE.compClaves(eliminacion2);
                            if(vr1==false){
                                vista.Mensaje("Elemento no existe");
                                throw new Exception();
                            }else{
                                boolean vt2=arrP.compararClaveEntrenador(eliminacion2);
                                if(vt2==true){
                                    vista.Mensaje("No se puede Eliminar al Entrenador ya que se encuentra participando en un Evento");
                                    throw new Exception();}
                                vf2=arrE.eliminar(eliminacion2);
                                op2=false;
                            }
                        }
                    }catch(Exception Excepcion){}
                }
                if(vf2==true){vista.Mensaje("Eliminacion correcta");}
                else{vista.Mensaje("Eliminacion Cancelada");}
                break;

                /** ELIMINAR DISCIPLINA **/
                case 3:               
                boolean op3=true;
                boolean vf3=false;
                while(op3){
                    try{
                        String eliminacion3=vista.leerLetrasNumeros("Ingrese la clave de la Disciplina");
                        if(eliminacion3==null){op3=false;}
                        else{
                            boolean vr1=arrD.compClaves(eliminacion3);
                            if(vr1==false){
                                vista.Mensaje("Elemento no existe");
                                throw new Exception();
                            }else{
                                boolean vt2=arrP.compararClaveDiciplina(eliminacion3);
                                if(vt2==true){
                                    vista.Mensaje("No se puede Eliminar ya que hay eventos activos en esta disciplina");
                                    throw new Exception();}
                                vf3=arrD.eliminar(eliminacion3);
                                op3=false;
                            }
                        }
                    }catch(Exception Excepcion){}
                }
                if(vf3==true){vista.Mensaje("Eliminacion correcta");}
                else{vista.Mensaje("Eliminacion Cancelada");}
                break;

                /** ELIMINAR EVENTO **/
                case 4:               
                boolean op4=true;
                boolean vf4=false;
                while(op4){
                    try{
                        String eliminacion4=vista.leerLetrasNumeros("Ingrese la clave del Evento");
                        if(eliminacion4==null){op4=false;}
                        else{
                            boolean vr1=arrEv.compClaves(eliminacion4);
                            if(vr1==false){
                                vista.Mensaje("Elemento que quiere eliminar no existe");
                                throw new Exception();
                            }else{
                                boolean vt2=arrP.compararClaveEvento(eliminacion4);
                                if(vt2==true){
                                    vista.Mensaje("No se puede Eliminar un Evento con Participantes");
                                    throw new Exception();}
                                vf4=arrEv.eliminar(eliminacion4);
                                op4=false;
                            }
                        }
                    }catch(Exception Excepcion){}
                }
                if(vf4==true){vista.Mensaje("Eliminacion correcta");}
                else{vista.Mensaje("Error no se completo la eliminacion");}
                break;

                /** ELIMINAR PARTICIPACION **/
                case 5:
                boolean vf5=arrP.eliminar(vista.leerLetrasNumeros("Ingresa la clave del Evento"),vista.leerLetrasNumeros("Ingresa la clave del Jugador"));
                if(vf5==true){vista.Mensaje("Eliminacion correcta");}
                else{vista.Mensaje("Eliminacion Cancelada");}
                break;

                /** REGRESAR **/
                case 6:
                cerrar=false;
            }
        }
    }

    /** MENU ESTADISTICAS**/
    public static void OpcionesEstadistica(){
        boolean co=true;
        while(co){
            int n=vista.menu("Estadisticas \n ELIJA UNA OPCION \n1.-Cantidad de elementos\n2.-Estadisticas de un Jugador\n3.-Estadisticas de un Entrenador\n4.-Estadisticas de un Evento\n5.-Estadisticas de una Disciplina\n6.-Regresar",1,6);
            switch(n){

                /** CANTIDAD DE ELEMENTOS**/
                case 1:
                boolean op=true;
                while(op){
                    int m=vista.menu("Opciones\n1.- Cantidad Jugadores \n2.- Cantidad Entrenadores\n3.- Cantidad Eventos\n4.- Cantidad Diciplinas\n5.- Regresar",1,5);
                    switch(m){

                        /** LLAMADO DE METODO DE CANTIDAD DE JUGADORES **/
                        case 1:
                        vista.Mensaje("JUGADORES \n"+String.valueOf(arrJ.cuantosHay()));
                        break;

                        /** LLAMADO DE METODO DE CANTIDAD DE ENTRENADORES **/
                        case 2:
                        vista.Mensaje("ENTRENADORES: \n"+String.valueOf(arrE.cuantosHay()));
                        break;

                        /** LLAMADO DE METODO DE CANTIDAD DE EVENTOS **/
                        case 3:
                        vista.Mensaje("EVENTOS: \n"+String.valueOf(arrEv.cuantosHay()));
                        break;

                        /** LLAMADO DE METODO DE CANTIDAD DE DISCIPLINAS **/
                        case 4:
                        vista.Mensaje("DISCIPLINAS: \n"+String.valueOf(arrD.cuantosHay()));
                        break;

                        /** REGRESAR **/
                        case 5:
                        op=false;
                    }
                }
                break;

                /** LLAMADO DE METODO DE ESTADISTICAS JUGADOR **/
                case 2:
                OpEstadisticasJugador();
                break;

                /** LLAMADO DE METODO DE ESTADISTICAS ENTRENADOR **/
                case 3:
                OpEstadisticasEntrenador();
                break;

                /** LLAMADO DE METODO DE ESTADISTICAS EVENTO **/
                case 4:
                OpEstadisticasEvento();
                break;

                /** LLAMADO DE METODO DE ESTADISTICAS DISCIPLINAS **/
                case 5:
                OpDiciplinas();

                /** SALIR**/
                break;
                case 6:
                co=false;
            }
        }
    }

    /** SUBMENU ESTATDISTICAS JUGADOR**/
    public static void OpEstadisticasJugador(){
        boolean cerrar=true;
        while(cerrar){
            int n=vista.menu("Opciones de Estadisticas de Jugador\n1.-Eventos donde participo \n2.- Entrenadores del jugador \n3.- Disciplinas donde participo \n4.- Listado de Jugadores\n5.-Que gano \n 6.-Regresar",1,6);
            switch(n){

                /** LLAMADO DE METODO DE PARTICIPACIONES **/
                case 1:
                boolean op1=true;
                while(op1){
                    try{
                        String c=vista.leerLetrasNumeros("Ingrese la clave del Jugador");
                        if(c==null){op1=false;}
                        else{
                            boolean d=arrP.compararClaveJugador(c);
                            if(d==false){
                                vista.Mensaje("La Clave no se encuentra registrada en un evento");                               
                                throw new Exception();
                            }else{

                                vista.Mensaje("Eventos donde a Participado el Jugador: "+"\n"+arrJ.imprimirDatos(c));
                                Vector g=arrP.dodeParticipo(c);
                                for(int i=0;i<g.size();i++){
                                    vista.Mensaje(arrEv.imprimirDatos((String)g.get(i)));
                                }
                                op1=false;
                            }
                        }
                    }catch(Exception Excepcion){}
                }
                break;

                /** LLAMADO DE METODO DE ENTRENADORES DE UN JUGADOR**/
                case 2:
                boolean op2=true;
                while(op2){
                    try{
                        String c=vista.leerLetrasNumeros("Ingrese la clave del Jugador");
                        if(c==null){op2=false;}
                        else{
                            boolean d=arrJ.compClaves(c);
                            if(d==false){
                                vista.Mensaje("Ingrese la clave del Jugador ");
                                throw new Exception();
                            }else{
                                vista.Mensaje("Entrenadores del Jugador: "+"\n"+arrJ.imprimirDatos(c));
                                Vector g=arrP.susEntrenadores(c);
                                for(int i=0;i<g.size();i++){

                                    vista.Mensaje(arrE.imprimirDatos((String)g.get(i)));
                                }
                                op2=false;
                            }
                        }
                    }catch(Exception Excepcion){}
                }
                break;
                case 3:
                boolean op3=true;
                while(op3){
                    try{
                        String c=vista.leerLetrasNumeros("Ingrese la clave del Jugador");
                        if(c==null){op3=false;}
                        else{
                            boolean d=arrP.compararClaveJugador(c);
                            if(d==false){
                                vista.Mensaje("La Clave no se encuentra participando en una Disciplina");
                                throw new Exception();
                            }else{
                                vista.Mensaje("Disciplinas que desempeña el Jugador: "+"\n"+arrJ.imprimirDatos(c));
                                Vector g=arrP.susDiciplinas(c);
                                for(int i=0;i<g.size();i++){
                                    vista.Mensaje(arrD.imprimirDatos((String)g.get(i)));
                                }
                                op3=false;
                            }
                        }
                    }catch(Exception Excepcion){}
                }
                break;
                case 4:
                Vector<String>v=arrJ.Claves();
                vista.Mensaje("Listado de Jugadores");
                for(int i=0;i<v.size();i++){
                    vista.Mensaje(String.valueOf(i+1)+"\n"+arrJ.imprimirDatos(v.get(i))+"\n"+"Clave: "+arrJ.regresarPos(i).getClave());
                }
                break;

                case 5:
                if(arrP.logroDeJug(Vista.leerLetrasNumeros("Ingrese la clave del Jugador"))==true){}
                else{Vista.Mensaje("Jugador no tiene registro");}
                break;
                case 6:
                cerrar=false;
            }
        }
    }

    /** SUBMENU ESTADISTICAS ENTRENADOR**/
    public static void OpEstadisticasEntrenador(){
        boolean cerrar=true;
        while(cerrar){
            int n=vista.menu("Opciones de Estadisticas de Entrenador\n1.-Jugadores Dirigidos\n2.-Disciplinas desempeñadas\n3.- Eventos donde participo\n4.-Listado de Entrenadores\n5.-que Gano \n6.-Regresar",1,6);
            switch(n){
                /** OPCION QUE MUESTRA LOS DIRIGIDOS DEL ENTRENADOR**/
                case 1:               
                boolean vr1=true;
                while(vr1){
                    try{
                        String c=vista.leerLetrasNumeros("Ingrese la clave del Entrenador");
                        if(c==null){vr1=false;}
                        else{
                            boolean d=arrE.compClaves(c);
                            if(d==false){
                                vista.Mensaje("Ingrese la clave del Entrenador");
                                throw new Exception();
                            }else{
                                vista.Mensaje("Dirigidos del Entrenador: "+"\n"+arrE.imprimirDatos(c));
                                Vector g=arrP.susJugadores(c);
                                for(int i=0;i<g.size();i++){
                                    vista.Mensaje("DIRIGIDO"+(i+1)+"\n"+arrJ.imprimirDatos((String)g.get(i)));
                                }
                                vr1=false;
                            }
                        }
                    }catch(Exception Excepcion){}
                }
                break;

                /** OPCION QUE MUESTRA LAS DISCIPLINAS EN LAS QUE DESEMPEÑA UN ENTRENADOR**/
                case 2:              
                boolean vr2=true;
                while(vr2){
                    try{
                        String c=vista.leerLetrasNumeros("Ingrese la clave del Entrenador");
                        if(c==null){vr2=false;}
                        else{
                            boolean d=arrE.compClaves(c);
                            if(d==false){
                                vista.Mensaje("Ingrese la clave del Entrenador");
                                throw new Exception();
                            }else{
                                vista.Mensaje("Las Diciplinas en las que se desempeña "+"\n"+arrE.imprimirDatos(c));
                                Vector g=arrP.enDiciplinas(c);
                                for(int i=0;i<g.size();i++){
                                    vista.Mensaje(arrD.imprimirDatos((String)g.get(i)));
                                }
                                vr2=false;
                            }
                        }
                    }catch(Exception Excepcion){}
                }
                break;

                /**OPCION QUE MUESTRA LOS EVENTOS DONDE PARTICIPO EL ENTRENADOR**/
                case 3:               
                boolean vr3=true;
                while(vr3){
                    try{
                        String c=vista.leerLetrasNumeros("Ingrese la clave del Entrenador");
                        if(c==null){vr3=false;}
                        else{
                            boolean d=arrE.compClaves(c);
                            if(d==false){
                                vista.Mensaje("Ingrese la clave del Entrenador");
                                throw new Exception();
                            }else{
                                vista.Mensaje("Los Eventos en los que a participado "+"\n"+arrE.imprimirDatos(c));
                                Vector g=arrP.donParticipo(c);
                                for(int i=0;i<g.size();i++){
                                    vista.Mensaje(arrEv.imprimirDatos((String)g.get(i)));
                                }
                                vr3=false;
                            }
                        }
                    }catch(Exception Excepcion){}
                }
                break;

                /** OPCION DE LISTADO DE ENTRENADORES **/
                case 4:
                Vector<String>v=arrE.Claves();
                vista.Mensaje("Listado de Entrenadores");
                for(int i=0;i<v.size();i++){
                    vista.Mensaje(String.valueOf(i+1)+"\n"+arrE.imprimirDatos(v.get(i))+"\n"+"Clave: "+arrE.regresarPos(i).getClave());
                }
                break;

                /**OPCION DE QUE GANO**/
                case 5:
                if(arrP.logroDeEntrenador(Vista.leerLetrasNumeros("Ingrese la clave del Entrenador"))==true){}
                else{Vista.Mensaje("Entrenador no tiene registro");}

                /** REGRESAR **/
                case 6:
                cerrar=false;
            }
        }
    }

    /** SUBMENU ESTADISTICAS EVENTO**/
    public static void OpEstadisticasEvento(){
        boolean cerrar=true;
        while(cerrar){
            int n=vista.menu("Estadisticas de Eventos\n1.- Listado de Eventos \n2.- Listado de participantes \n3.-Ganadores de un Evento \n 4.-Regresar",1,4);
            switch(n){

                /** LISTADO DE EVENTOS**/
                case 1:
                if(arrEv.cuantosHay()==0){
                    vista.Mensaje("No se encuentra registrado ningun Evento");
                }else{
                    vista.Mensaje("   Listado  de Eventos  ");
                    for(int i=0;i<arrEv.cuantosHay();i++){
                        vista.Mensaje(String.valueOf(i+1)+"\n"+arrEv.regresarPos(i).getNombre()+"\n"+"Clave: "+arrEv.regresarPos(i).getClave());
                    }
                }
                break;

                /** LISTADO DE PARTICIPANTES **/
                case 2:
                boolean op2=true;
                while(op2){
                    try{
                        String cad=vista.leerLetrasNumeros("Ingresa la clave del Evento");
                        Vector<String>v=arrP.eventoJ(cad);
                        if(cad==null){
                            op2=false;
                        }else{
                            if(!arrP.compararClaveEvento(cad)){
                                vista.Mensaje("No existen participantes en el Evento");
                                throw new Exception();
                            }else{
                                vista.Mensaje("\n "+arrEv.datos(cad));
                                for(int i=0;i<v.size();i++){
                                    Vista.Mensaje(String.valueOf(i+1)+"\n"+arrJ.imprimirDatos(v.get(i))+"\n"+"Logro obtenido: "+arrP.logroDeJugador(cad,v.get(i)));
                                }
                                op2=false;
                            }
                        }       
                    }catch(Exception Excepcion){}
                }
                break;

                /** GANADORES DE UN EVENTO **/
                case 3:
                logroEvento();
                break;

                /** SALIR **/               
                case 4:
                cerrar=false;

            }
        }
    }

    /** METODO DE MUESTRA LOS GANADORES DE UN EVENTO**/
    public static void logroEvento(){

        int n=vista.menu("GANADORES DE UN EVENTO \n 1.- Primer Lugar de un Evento \n 2.- Segundo Lugar de un Evento \n 3.- Tercer Lugar de un Evento \n 4.- Regresar",1,4);
        switch(n){

            /** PRIMER LUGAR DE UN EVENTO **/
            case 1:
            boolean op1=true;
            while(op1){
                try{
                    String c=vista.leerLetrasNumeros("Ingresa la clave del Evento");
                    if(c==null){
                        op1=false;
                    }
                    else{if(arrP.yaHayGanadores(c,"Primer Lugar")){
                            vista.Mensaje("Aun no hay Primer Lugar");
                            throw new Exception();
                        }
                        else{                      
                            vista.Mensaje(arrJ.imprimirDatos(arrP.ganador(c,"Primer Lugar")));
                            op1=false;
                        }
                    }
                }catch(Exception Excepcion){}
            }
            break;

            /** SEGUNDO LUGAR DE UN EVENTO **/
            case 2:
            boolean op2=true;
            while(op2){
                try{
                    String c=vista.leerLetrasNumeros("Ingresa la clave del Evento");
                    if(c==null){
                        op2=false;}
                    else{if(!arrP.yaHayGanadores(c,"Segundo Lugar")){
                            vista.Mensaje("Aun no hay Segundo Lugar");
                            throw new Exception();
                        }
                        else{                             
                            vista.Mensaje(arrJ.imprimirDatos(arrP.ganador(c,"Segundo Lugar")));
                            op2=false;
                        }
                    }
                }catch(Exception Excepcion){}
            }
            break;

            /** TERCER LUGAR DE UN EVENTO **/
            case 3:
            boolean op3=true;
            while(op3){
                try{
                    String d=vista.leerLetrasNumeros("Ingresa la clave del Evento");
                    if(d==null){
                        op3=false;}
                    else{if(!arrP.yaHayGanadores(d,"Tercer Lugar")){
                            vista.Mensaje("Aun no hay Tercer Lugar");
                            throw new Exception();
                        }
                        else{                                
                            vista.Mensaje(arrJ.imprimirDatos(arrP.ganador(d,"Tercer Lugar")));
                            op3=false;
                        }
                    }
                }catch(Exception Excepcion){}
            }
            break;

            /** REGRESAR **/
            case 4:
            OpEstadisticasEvento();
            break;
        }

    }

    /** SUBMENU ESTADISTICAS DISCIPLINAS **/
    public static void OpDiciplinas(){
        boolean cerrar=true;
        while(cerrar){
            int n=vista.menu("Estadisticas de Disciplinas\n1.- Listado de Disciplinas\n2.- Entrenadores que se desempeñan en una Disciplina\n3.- Jugadores que se desempeñan en una Disciplina\n4.- Regresar",1,4);
            switch(n){

                /** LISTADO DE DISCIPLINAS **/
                case 1:
                if(arrD.cuantosHay()==0){
                    vista.Mensaje("No hay disciplinas actualmente");
                }else{vista.Mensaje("Diciplinas Registradas");
                    for(int i=0;i<arrD.cuantosHay();i++){
                        vista.Mensaje(String.valueOf(i+1)+"\n"+arrD.regresarPos(i).getNombre()+"\n"+"Tipo: "+arrD.regresarPos(i).getTipo());
                    }
                }
                break;

                /** ENTRENADORES QUE SE DESEMPEÑAN EN UNA DISCIPLINA **/
                case 2:
                boolean op2=true;
                while(op2){
                    try{
                        String cad=vista.leerLetrasNumeros("Ingrese la clave de la Disciplina");
                        if(cad==null){op2=false;}
                        else{if(!arrP.hayDiciplinas(cad)){
                                vista.Mensaje("No hay entrenadores actualmente" +arrD.regresar(cad).getNombre());
                                throw new Exception();
                            }else{
                                vista.Mensaje("Entrenadores desempeñados en la disciplina "+"\n"+arrD.regresar(cad).getNombre());
                                Vector<String>v=arrE.Claves();
                                for(int i=0;i<v.size();i++){
                                    if(arrP.DisEntre(cad,v.get(i))){
                                        vista.Mensaje(arrE.imprimirDatos(v.get(i)));
                                    }
                                }
                                op2=false;
                            }
                        }
                    }catch(Exception Excepcion){}
                }
                break;

                /** JUGADORES QUE SE DESEMPEÑAN EN UNA DISCIPLINA **/
                case 3:
                boolean op3=true;
                while(op3){
                    try{
                        String cad=vista.leerLetrasNumeros("Ingrese la clave de la Disciplina");
                        if(cad==null){op3=false;}
                        else{if(!arrP.hayDiciplinas(cad)){
                                vista.Mensaje("No hay jugadores actualmente en la Disciplina: "+"\n"+arrD.regresar(cad).getNombre());
                                throw new Exception();
                            }else{
                                vista.Mensaje("Jugadores desempeñados en la disciplina "+"\n"+arrD.regresar(cad).getNombre());
                                Vector<String>v=arrJ.Claves();
                                for(int i=0;i<v.size();i++){
                                    if(arrP.DisJugador(cad,v.get(i))){
                                        vista.Mensaje(arrJ.imprimirDatos(v.get(i)));
                                    }
                                }
                                op3=false;
                            }
                        }
                    }catch(Exception Excepcion){}
                }
                break;

                /** REGRESAR **/
                case 4:
                cerrar=false;
            }
        }

    }

    /** MENU BUSCAR ELEMENTO **/
    public static void buscar(){
        while(true){
            try{
                String c=vista.leerLetrasNumeros("Ingrese una clave");
                if(c==null){return;}
                if(arrJ.compClaves(c)){
                    vista.Mensaje(arrJ.datos(c));
                    return;
                }
                if(arrE.compClaves(c)){
                    vista.Mensaje(arrE.datos(c));
                    return;
                }
                if(arrD.compClaves(c)){
                    vista.Mensaje(arrD.imprimirDatos(c));
                    return;
                }
                if(arrEv.compClaves(c)){
                    vista.Mensaje(arrEv.datos(c));
                    return;
                }
                else{vista.Mensaje("Error de busqueda \n Elemento no existe");}
            }catch(Exception Excepcion){}
        }
    }

    public static Vector Claves(){
        Vector<String> v=new Vector<String>();
        for(int i=0;i<arrJ.Claves().size();i++)
        {
            v.add((String)arrJ.Claves().get(i));
        }
        for(int i=0;i<arrE.Claves().size();i++)
        {
            v.add((String)arrE.Claves().get(i));
        }
        for(int i=0;i<arrD.Claves().size();i++)
        {
            v.add((String)arrD.Claves().get(i));
        }
        for(int i=0;i<arrEv.Claves().size();i++)
        {
            v.add((String)arrEv.Claves().get(i));
        }
        return v;
    }
}
