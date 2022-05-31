import java.io.Serializable;
public abstract class Persona implements Serializable
{
    protected String nombre;
    protected String apellidoP;
    protected String apellidoM;
    protected int edad;
    protected char sex;
    
    public Persona(String nom,String apeP,String apeM,int edad,char sex){
        this.nombre=nom;
        this.apellidoP=apeP;
        this.apellidoM=apeM;
        this.edad=edad;
        this.sex=sex;
    }

    public void setNom(String nom){
        this.nombre=nom;
    }

    public String getNom(){
        return nombre;
    }

    public void setApeP(String apeP){
        this.apellidoP=apeP;
    }

    public String getApeP(){
        return apellidoP;
    }

    public void setApeM(String apeM){
        this.apellidoM=apeM;
    }

    public String getApeM(){
        return apellidoM;
    }

    public void setEdad(int edad){
        this.edad=edad;
    }

    public int getEdad(){
        return edad;
    }

    public void setSex(char sex){
        this.sex=sex;
    }

    public char getSex(){
        return sex;
    }
    
    public String toString(){
    return "Nombre: "+nombre+"\n"+"Apellidos: "+ apellidoP +" "+apellidoM+"\n"+"EDAD: "+edad+"\n"+"SEXO: "+sex;
    }
}
