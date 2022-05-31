import java.io.*;
public class Archivo
{
    /** METODO QUE GUARDA EN EL ARCHIVO LOS JUGADORES CREADOS (WRITE)**/
    public void GuardarJugador(ArregloJugador aj,String c){
        try{
            File archivoSalida=new File("Archivo/"+c+".txt");
            FileOutputStream Salida=new FileOutputStream(archivoSalida);
            ObjectOutputStream ObjetoSalida=new ObjectOutputStream(Salida);
            for(int i=0;i<aj.cuantosHay();i++){
                if(aj.regresarPos(i)!=null){
                    ObjetoSalida.writeObject(aj.regresarPos(i));
                }
            }
            ObjetoSalida.close();
        }catch(IOException Excepcion){}
    }

    /** METODO QUE RECUPERA LOS JUGADORES ESCRITOS EN EL ARCHIVO (READ)**/
    public ArregloJugador LeerJugador(String c) throws ClassNotFoundException, IOException{
        ArregloJugador aj=new ArregloJugador(100);
        try{
            File archivoEntrada=new File("Archivo/"+c+".txt");
            FileInputStream Entrada=new FileInputStream(archivoEntrada);
            ObjectInputStream ObjetoEntrada=new ObjectInputStream(Entrada);
            if(!archivoEntrada.exists()){
                System.out.println("El archivo no fue encontrado");
            }else{
                int tam=(int)archivoEntrada.length();
                for(int i=0;i<tam;i++){
                    aj.agregar((Jugador)ObjetoEntrada.readObject());
                }
            }
        }catch(IOException Excepcion){}
        return aj; 
    }

    /** METODO QUE GUARDA EN EL ARCHIVO LOS ENTRENADORES CREADOS (WRITE)**/
    public void GuardarEntrenador(ArregloEntrenador ae,String c){
        try{
            File archivoSalida=new File("Archivo/"+c+".txt");
            FileOutputStream Salida=new FileOutputStream(archivoSalida);
            ObjectOutputStream ObjetoSalida=new ObjectOutputStream(Salida);
            for(int i=0;i<ae.cuantosHay();i++){
                if(ae.regresarPos(i)!=null){
                    ObjetoSalida.writeObject(ae.regresarPos(i));
                }
            }
            ObjetoSalida.close();
        }catch(IOException Excepcion){}
    }

    /** METODO QUE RECUPERA LOS ENTRENADORES ESCRITOS EN EL ARCHIVO (READ)**/
    public ArregloEntrenador LeerEntrenador(String c) throws ClassNotFoundException, IOException{
        ArregloEntrenador ae=new ArregloEntrenador(100);
        try{
            File archivoEntrada=new File("Archivo/"+c+".txt");
            FileInputStream Entrada=new FileInputStream(archivoEntrada);
            ObjectInputStream ObjetoEntrada=new ObjectInputStream(Entrada);
            if(!archivoEntrada.exists()){
                System.out.println("El archivo no fue encontrado");
            }else{
                int tam=(int)archivoEntrada.length();
                for(int i=0;i<tam;i++){
                    ae.agregar((Entrenador)ObjetoEntrada.readObject());
                }
            }
        }catch(IOException Excepcion){}
        return ae; 
    }

    /** METODO QUE GUARDA EN EL ARCHIVO LAS DISCIPLINAS CREADAS  (WRITE)**/
    public void GuardarDisciplina(ArregloDisciplina ad,String c){
        try{
            File archivoSalida=new File("Archivo/"+c+".txt");
            FileOutputStream Salida=new FileOutputStream(archivoSalida);
            ObjectOutputStream ObjetoSalida=new ObjectOutputStream(Salida);
            for(int i=0;i<ad.cuantosHay();i++){
                if(ad.regresarPos(i)!=null){
                    ObjetoSalida.writeObject(ad.regresarPos(i));
                }
            }
            ObjetoSalida.close();
        }catch(IOException Excepcion){}
    }

    /** METODO QUE RECUPERA LAS DISCIPLINAS ESCRITAS EN EL ARCHIVO (READ)**/
    public ArregloDisciplina LeerDiciplina(String c) throws ClassNotFoundException, IOException{
        ArregloDisciplina ad=new ArregloDisciplina(100);
        try{
            File archivoEntrada=new File("Archivo/"+c+".txt");
            FileInputStream Entrada=new FileInputStream(archivoEntrada);
            ObjectInputStream ObjetoEntrada=new ObjectInputStream(Entrada);
            if(!archivoEntrada.exists()){
                System.out.println("El archivo no fue encontrado");
            }else{
                int tam=(int)archivoEntrada.length();
                for(int i=0;i<tam;i++){
                    ad.agregar((Disciplina)ObjetoEntrada.readObject());
                }
            }
        }catch(IOException Excepcion){}
        return ad; 
    }

    /** METODO QUE GUARDA EN EL ARCHIVO LOS EVENTOS CREADOS (WRITE) **/
    public void GuardarEvento(ArregloEvento ae,String c){
        try{
            File archivoSalida=new File("Archivo/"+c+".txt");
            FileOutputStream Salida=new FileOutputStream(archivoSalida);
            ObjectOutputStream ObjetoSalida=new ObjectOutputStream(Salida);
            for(int i=0;i<ae.cuantosHay();i++){
                if(ae.regresarPos(i)!=null){
                    ObjetoSalida.writeObject(ae.regresarPos(i));
                }
            }
            ObjetoSalida.close();
        }catch(IOException Excepcion){}
    }

    /** METODO QUE RECUPERA LOS EVENTOS ESCRITOS EN EL ARCHIVO (READ)**/
    public ArregloEvento LeerEvento(String c) throws ClassNotFoundException, IOException{
        ArregloEvento ae=new ArregloEvento(100);
        try{
            File archivoEntrada=new File("Archivo/"+c+".txt");
            FileInputStream Entrada=new FileInputStream(archivoEntrada);
            ObjectInputStream ObjetoEntrada=new ObjectInputStream(Entrada);
            if(!archivoEntrada.exists()){
                System.out.println("El archivo no fue encontrado");
            }else{
                int tam=(int)archivoEntrada.length();
                for(int i=0;i<tam;i++){
                    ae.agregar((Evento)ObjetoEntrada.readObject());
                }
            }
        }catch(IOException Excepcion){}
        return ae; 
    }

    /** METODO QUE GUARDA EN EL ARCHIVO LAS PARTICIPACIONES CREADAS (WRITE) **/
    public void GuardarParticipacion(ArregloParticipacion ap,String c){
        try{
            File archivoSalida=new File("Archivo/"+c+".txt");
            FileOutputStream Salida=new FileOutputStream(archivoSalida);
            ObjectOutputStream ObjetoSalida=new ObjectOutputStream(Salida);
            for(int i=0;i<ap.cuantosHay();i++){
                if(ap.regresarPos(i)!=null){
                    ObjetoSalida.writeObject(ap.regresarPos(i));
                }
            }
            ObjetoSalida.close();
        }catch(IOException Excepcion){}
    }

    /** METODO QUE RECUPERA LAS PARTICIPACIONES ESCRITAS EN EL ARCHIVO (READ)**/
    public ArregloParticipacion LeerParticipacion(String c) throws ClassNotFoundException, IOException{
        ArregloParticipacion ap=new ArregloParticipacion(100);
        try{
            File archivoEntrada=new File("Archivo/"+c+".txt");
            FileInputStream Entrada=new FileInputStream(archivoEntrada);
            ObjectInputStream ObjetoEntrada=new ObjectInputStream(Entrada);
            if(!archivoEntrada.exists()){
                System.out.println("El archivo no fue encontrado");
            }else{
                int tam=(int)archivoEntrada.length();
                for(int i=0;i<tam;i++){
                    ap.agregar((Participacion)ObjetoEntrada.readObject());
                }
            }
        }catch(IOException Excepcion){}
        return ap; 
    }
}
