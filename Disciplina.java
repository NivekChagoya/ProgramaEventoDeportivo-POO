import java.io.Serializable;
public class Disciplina implements Serializable
{
    private String clave;
    private String nombre;
    private String tipo;
    
    public Disciplina(String clave,String nombre,String tipo){
        this.clave=clave;
        this.nombre=nombre;
        this.tipo=tipo;
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

    public void setTipo(String tipo){
        this.tipo=tipo;
    }

    public String getTipo(){
        return tipo;
    }
}
