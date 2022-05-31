import java.io.Serializable;
public class Entrenador extends Persona implements Serializable
{
    private String clave;
    
    public Entrenador(String nom,String apeP,String apeM,int edad,char sex,String clave){
        super(nom,apeP,apeM,edad,sex);
        this.clave=clave;
    }

    public void setClave(String clave){
        this.clave=clave;
    }

    public String getClave(){
        return clave;
    }
}
