/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd2_proyecto_;
import java.io.Serializable;
/**
 *
 * @author jrdjh
 */
public class Campo implements Serializable{
    String nombre;
    String tipo;
    boolean llave_primaria;
    int longitud;

     private static final long SerialVersionUID=777L;
    
    public Campo() {
    }

    public Campo(String nombre, String tipo, boolean llave_primaria, int longitud) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.llave_primaria = llave_primaria;
        this.longitud = longitud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isLlave_primaria() {
        return llave_primaria;
    }

    public void setLlave_primaria(boolean llave_primaria) {
        this.llave_primaria = llave_primaria;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return  nombre;
    }

    
    
    
}
