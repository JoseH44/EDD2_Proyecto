package edd2_proyecto_;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author jrdjh
 */
public class Data {
    int key;
    long ubicacion;
    String marcado;
    ArrayList<Object> datos = new ArrayList();

    

    public Data() {
        this.marcado = "|";
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public long getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(long ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getMarcado() {
        return marcado;
    }

    public void setMarcado(String marcado) {
        this.marcado = marcado;
    }

    public ArrayList<Object> getDatos() {
        return datos;
    }

    public void setDatos(ArrayList<Object> datos) {
        this.datos = datos;
        key = (int)datos.get(0);
    }
    
    
    
    
    
    
}

