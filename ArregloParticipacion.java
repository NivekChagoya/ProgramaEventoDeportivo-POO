import java.util.*;
public class ArregloParticipacion
{
    static private Participacion[] a;
    static private int hay;
    static private int max;
    static private ArregloJugador arrJ;

    public ArregloParticipacion(int max){
        a=new Participacion[max];
        this.max=max;
        hay=-1;
    }

    public boolean lleno(){
        if(hay==a.length-1){
            return true;
        }
        else{
            return false;
        }
    }

    /** METODO QUE NOS INDICA LA CANTIDAD DE PARTICIPACIONES **/
    public int cuantosHay(){
        return hay+1;
    }

    /** METODO PARA AGREGAR UNA PARTICIPACION **/
    public boolean agregar(Participacion p){
        if(lleno()!=true){
            if(p!=null){
                hay+=1;
                a[hay]=p;
                return true;
            }else{return false;}
        }else{return false;}
    }

    /** METODO DE ELIMINACION DE PARTICIPACION **/
    public boolean eliminar(String claEvento,String claJugador){
        for(int x=0;x<hay+1;x++){
            if(a[x].getClaveEvento().equals(claEvento) && a[x].getClaveJugador().equals(claJugador)){
                for(int i=x;i<hay+1;i++){
                    a[i]=a[i+1];
                    a[i+1]=null;
                }
                hay--;
                return true;
            }
        }return false;
    }

    /** METODO QUE REGRESA UN PARTICIPACION APARTIR DE SU CLAVE**/
    public Participacion regresar(String clave){
        if(clave!=null){
            for(int i=0;i<hay+1;i++){
                int n=0;
                if(a[i].getClaveEvento().equals(clave)){
                    n=i;
                }
                return a[n];
            }
        }
        return null;
    }  

    /** METODO QUE REGRESA UN PARTICIPACION APARTIR DE SU POSICION**/
    public Participacion regresarPos(int pos){
        if(pos>=0 && pos<=hay){
            return a[pos];
        }
        else{
            return null;
        }
    }

    /** METODO QUE COMPARA LA CLAVE DE UN JUGADOR PARA SABER SI ESTE YA SE ENCUENTRA PARTICIPANDO EN UN EVENTO **/
    public boolean compararClaveJugador(String c){
        boolean Z=false;
        for(int i=0;i<hay+1;i++){
            if(a[i].getClaveJugador().equals(c)){
                Z=true;
            }
        }
        return Z;
    }

    /**METODO QUE COMPARA LA CLAVE DEL ENTRENADOR PARA SABER SI ESTE YA SE ENCUENTRA PARTICIPANDO EN UN EVENTO **/
    public boolean compararClaveEntrenador(String c){
        boolean v=false;
        for(int i=0;i<hay+1;i++){
            if(a[i].getClaveEntrenador().equals(c)){
                v=true;
            }
        }
        return v;
    }

    /** METODO QUE COMPARA LA CLAVE DE UNA DISCIPLINA PARA SABER SI SE ENCUENTRA ACTUALMENTE DISPONIBLE EN UN EVENTO **/
    public boolean compararClaveDiciplina(String c){
        boolean v=false;
        for(int i=0;i<hay+1;i++){
            if(a[i].getClaveDiciplina().equals(c)){
                v=true;
            }
        }
        return v;
    }

    /**METODO QUE COMPARA LA CLAVE DE UN EVENTO PARA SABER SI SE ENCUENTRA ACTIVO **/
    public boolean compararClaveEvento(String c){
        boolean v=false;
        for(int i=0;i<hay+1;i++){
            if(a[i].getClaveEvento().equals(c)){
                v=true;
            }
        }
        return v;
    }

    /**METODO QUE CONTIENE VECTOR CON LAS CLAVES DE LOS JUGADORES DE UN EVENTO DADO **/
    public Vector eventoJ(String c){
        Vector<String> v=new Vector<String>();
        for(int i=0;i<hay+1;i++){
            if(a[i].getClaveEvento().equals(c)){
                v.add(a[i].getClaveJugador());
            }
        }
        return v;
    }

    /**METODO PARA SABER SI EN UN EVENTO YA HAY UN JUGADOR INSCRITO**/
    public boolean yaRegistradoEvento(String cEvento,String cJugador){
        for(int i=0;i<hay+1;i++){
            if(a[i].getClaveEvento().equals(cEvento) && a[i].getClaveJugador().equals(cJugador)){
                return true;
            }
        }
        return false;
    }

    /**COMPARACION PARA SABER SI EN UN EVENTO YA HAY GANADORES**/
    public boolean yaHayGanadores(String E,String logro){
        for(int i=0;i<hay+1;i++){
            if(a[i].getClaveEvento().equals(E) && a[i].getLogro().equals(logro)){
                return true;
            }
        }
        return false;
    }

    /**METODO QUE REGRESA EL GANADOR DE UN EVENTO**/
    public String ganador(String E,String logro){
        for(int i=0;i<hay+1;i++){
            if(a[i].getClaveEvento().equals(E) && a[i].getLogro().equals(logro)){
                return a[i].getClaveJugador();
            }
        }
        return "No hay ganador actualmente";
    }

    /** METODO QUE MUESTRA EL LOGRO DE UN JUGADOR POR MEDIO DE SU CLAVE ASI COMO LA DEL EVENTO**/
    public String logroDeJugador(String E,String J){
        for(int i=0;i<hay+1;i++){
            if(a[i].getClaveEvento().equals(E) && a[i].getClaveJugador().equals(J)){
                return a[i].getLogro();
            }
        }
        return "Participante";
    }

    public static boolean logroDeJug(String c){

        for(int x=0;x<hay+1;x++) {
            if (a[x].getClaveJugador().equals(c)){

                Vista.Mensaje(ArregloJugador.datos(c)+"\n"+"Clave de Disciplina: "+a[x].getClaveDiciplina()+"\n"+"Logro obtenido como Jugador: "+a[x].getLogro()); return true;
            }
        }
        return false;

    }

    public boolean logroDeEntrenador(String c){
        for(int x=0;x<hay+1;x++) {
            if (a[x].getClaveEntrenador().equals(c)){
                Vista.Mensaje(ArregloEntrenador.datos(c)+"\n"+ "Clave de Disciplina: "+a[x].getClaveDiciplina()+"\n"+"Logro obtenido como Entrenador: "+a[x].getLogro()); return true;
            }
        }
        return false;
    }

    public boolean DisEntre(String c,String e){
        for(int i=0;i<hay+1;i++){
            if(a[i].getClaveDiciplina().equals(c) && a[i].getClaveEntrenador().equals(e)){
                return true;
            }
        }
        return false;
    }

    public boolean DisJugador(String c,String e){
        for(int i=0;i<hay+1;i++){
            if(a[i].getClaveDiciplina().equals(c) && a[i].getClaveJugador().equals(e)){
                return true;
            }
        }
        return false;
    }

    /**METODO QUE CUENTA LAS PARTICIPACIONES DE UN JUGADOR EN UN EVENTO**/
    public int participaciones(String cad){
        int c=0;
        for(int i=0;i<hay+1;i++){
            if(a[i].getClaveJugador().equals(cad)){c++;}
        }
        return c;
    }

    /**METODO CON VECTOR QUE CONTIENE LAS CLAVES DE LOS EVENTOS DONDE PARTICIPO UN JUGADOR**/
    public Vector dodeParticipo(String c){
        Vector<String> v=new Vector<String>();
        for(int i=0;i<hay+1;i++){
            if(a[i].getClaveJugador().equals(c)){
                v.add(a[i].getClaveEvento());
            }
        }
        return v;
    }

    /**METODO CON VECTOR QUE CONTIENE LAS CLAVES DE LOS ENTRENADORES DE UN JUGADOR**/
    public Vector susEntrenadores(String c){
        Vector<String>v=new Vector<String>();
        for(int i=0;i<hay+1;i++){
            if(a[i].getClaveJugador().equals(c)){
                v.add(a[i].getClaveEntrenador());
            }
        }
        return v;
    }

    /**METODO CON VECTOR QUE CONTIENE LAS CLAVES DE LAS DISCIPLINAS QUE PRACTICA UN JUGADOR**/
    public Vector susDiciplinas(String c){
        Vector<String>v=new Vector<String>();
        for(int i=0;i<hay+1;i++){
            if(a[i].getClaveJugador().equals(c)){
                v.add(a[i].getClaveDiciplina());
            }
        }
        return v;
    }

    /**METODO CON VECTOR QUE CONTIENE LAS CLAVES DE LOS EVENTOS DONDE PARTICIPO UN ENTRENADOR**/
    public Vector donParticipo(String c){
        Vector<String> v=new Vector<String>();
        for(int i=0;i<hay+1;i++){
            if(a[i].getClaveEntrenador().equals(c)){
                v.add(a[i].getClaveEvento());
            }
        }
        return v;
    }

    /**METODO CON VECTOR QUE CONTIENE LAS CLAVES DE LOS JUGADORES DE UN ENTRENADOR**/
    public Vector susJugadores(String c){
        Vector<String>v=new Vector<String>();
        for(int i=0;i<hay+1;i++){
            if(a[i].getClaveEntrenador().equals(c)){
                v.add(a[i].getClaveJugador());
            }
        }
        return v;
    }

    /**METODO CON VECTOR QUE CONTIENE LAS CLAVES DE LAS DISCIPLINAS QUE DESEMPEÑA UN ENTRENADOR**/
    public Vector enDiciplinas(String c){
        Vector<String>v=new Vector<String>();
        for(int i=0;i<hay+1;i++){
            if(a[i].getClaveEntrenador().equals(c)){
                v.add(a[i].getClaveDiciplina());
            }
        }
        return v;
    }

    /** ESTADISTICAS DE DISCIPLINAS**/
    public boolean hayDiciplinas(String c){
        Vector<String>v=new Vector<String>();
        for(int i=0;i<hay+1;i++){
            if(a[i].getClaveDiciplina().equals(c)){
                return true;
            }
        }
        return false;
    }
        
}
