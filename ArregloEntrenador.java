import java.util.*;
public class ArregloEntrenador
{
    private static Entrenador[] a;
    private static int hay;
    private static int max;

    public ArregloEntrenador(int max){
        a=new Entrenador[max];
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

    public boolean agregar(Entrenador e){
        if(lleno()!=true){
            if(e!=null){
                hay+=1;
                a[hay]=e;
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

    public Entrenador regresar(String clave){
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

    public Entrenador regresarPos(int pos){
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

    public String imprimirDatos(String c){
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
                return "Nombre Completo: "+a[i].getNom()+" "+a[i].getApeP()+" "+a[i].getApeM()+"\n"+"Edad: "+
                String.valueOf(a[i].getEdad()+"\n"+"Sexo: "+a[i].getSex());
            }
        }
        return "No se encontraron Datos";
    }
}
