import java.io.Serializable;
public class Evento implements Serializable
{
    private String clave;
    private String nombre;
    
    public Evento(String clave,String nombre){
        this.clave=clave;
        this.nombre=nombre;
    }

    public void setClave(String clave){
        this.clave=clave;
    }

    public String getClave(){
        return clave;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public String getNombre(){
        return nombre;
    }
}
