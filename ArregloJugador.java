import java.util.*;
public class ArregloJugador
{
    private static Jugador[] a;
    private static int hay;
    private static int max;
    
    public ArregloJugador(int max){
        a=new Jugador[max];
        this.max=max;
        hay=-1;
    }

    public boolean lleno(){
        if(hay==a.length-1){return true;}
        else{return false;}
    }

    public int cuantosHay(){
        return hay+1;
    }

    public boolean agregar(Jugador j){
        if(lleno()!=true){
            if(j!=null){
                hay+=1;
                a[hay]=j;
                return true;
            }else{return false;}
        }else{return false;}
    }

    public boolean eliminar(String clave){
        for(int x=0;x<hay+1;x++){
            if(a[x].getClave().equals(clave)){
                for(int i=x;i<hay+1;i++){
                    a[i]=a[i+1];
                    a[i+1]=null;
                }
                hay--;
                return true;
            }
        }return false;
    }

    public Jugador regresar(String clave){
        if(clave!=null){
            for(int i=0;i<hay+1;i++){
                int n=0;
                if(a[i].getClave().equals(clave)){
                    n=i;
                }
                return a[n];
            }
        }
        return null;
    }

    public Jugador regresarPos(int pos){
        if(pos>=0 && pos<=hay){
            return a[pos];
        }
        else{
            return null;
        }
    }

    public Vector Claves(){
        Vector<String> c=new Vector<String>();
        for(int i=0;i<hay+1;i++){
            c.add(a[i].getClave());
        }
        return c;
    }

    public boolean compClaves(String c){
        boolean v=false;
        for(int i=0;i<hay+1;i++){
            if(a[i].getClave().equals(c)){
                v=true;
            }
        }
        return v;
    }

    public static String imprimirDatos(String c){
        for(int i=0;i<hay+1;i++){
            if(a[i].getClave().equals(c)){
                return a[i].getNom()+" "+a[i].getApeP()+" "+a[i].getApeM();
            }
        }
        return "No se encontraron Datos";
    }

    public static String datos(String c){
        for(int i=0;i<hay+1;i++){
            if(a[i].getClave().equals(c)){
                return "Nombre: "+a[i].getNom()+" "+a[i].getApeP()+" "+a[i].getApeM()+"\n"+"Edad: "+
                String.valueOf(a[i].getEdad()+"\n"+"Sexo: "+a[i].getSex())+"\n"+"Tiempo de Entrenamiento: "+String.valueOf(a[i].getTiempo());
            }
        }
        return "No se encontraron Datos";
    }
    
      /** ACTUALIZAR DATOS DE JUGADOR **/
    public static void actualizardatos(String c){
        for(int i=0;i<hay+1;i++){
            if(a[i].getClave().equals(c)){
                 a[i]=Vista.crearJugador(Controlador.Claves());
                   Vista.Mensaje("Datos Actualizados");
            }
        }
        
    }
    
    
    }

