import java.io.Serializable;
public class Jugador extends Persona implements Serializable
{
    private String clave;
    private int tiempo;
    
    public Jugador(String nom,String apeP,String apeM,int edad,char sex,String clave,int t){
        super(nom,apeP,apeM,edad,sex);
        this.clave=clave;
        this.tiempo=t;
    }

    public void setClave(String clave){
        this.clave=clave;
    }

    public String getClave(){
        return clave;
    }

    public void setTiempo(int t){
        this.tiempo=t;
    }

    public int getTiempo(){
        return tiempo;
    }
    
    public String toString(String cad){
        
        return super.toString()+"\n"+"Clave: "+clave+"\n"+"Tiempo de Entrenamiento: "+tiempo;
    }
}
