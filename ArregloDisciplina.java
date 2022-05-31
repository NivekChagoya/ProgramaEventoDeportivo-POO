import java.util.*;
public class ArregloDisciplina
{
    private Disciplina[] a;
    private int hay;
    private int max;
    public ArregloDisciplina(int max){
        a=new Disciplina[max];
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

    public boolean agregar(Disciplina d){
        if(lleno()!=true){
            if(d!=null){
                hay+=1;
                a[hay]=d;
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

    public Disciplina regresar(String clave){
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

    public Disciplina regresarPos(int pos){
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
                return "Disciplina: "+a[i].getNombre()+"\n"+"Tipo: "+a[i].getTipo();
            }
        }
        return "No se encontraron Datos";
    }
}
