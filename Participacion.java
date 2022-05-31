import java.io.Serializable;
public class Participacion implements Serializable
{
    private String clave_evento;
    private String clave_jugador;
    private String clave_entrenador;
    private String clave_disiplina;
    private String logro;
    
    public Participacion(String cv,String cj,String ce,String cd,String logro){
        clave_evento=cv;
        clave_jugador=cj;
        clave_entrenador=ce;
        clave_disiplina=cd;
        this.logro=logro;
    }

    public void setClaveEvento(String c){
        clave_evento=c;
    }

    public String getClaveEvento(){
        return clave_evento;
    }

    public void setClaveJugador(String c){
        clave_jugador=c;
    }

    public String getClaveJugador(){
        return clave_jugador;
    }

    public void setClaveEntrenador(String c){
        clave_entrenador=c;
    }

    public String getClaveEntrenador(){
        return clave_entrenador;
    }

    public void setClaveDiciplina(String c){
        clave_disiplina=c;
    }

    public String getClaveDiciplina(){
        return clave_disiplina;
    }

    public void setLogro(String logro){
        logro=logro;
    }

    public String getLogro(){
        return logro;
    }
}
