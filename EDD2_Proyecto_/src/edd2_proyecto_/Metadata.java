/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd2_proyecto_;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Workstation DSY
 */
public class Metadata implements Serializable{
    private String nombre;
    private ArrayList <Campo>campos = new ArrayList();
    private ArrayList tipos = new ArrayList();
    private int numregistros = 0;

    private long Campos_en_Archivo;
    Btree ArbolB;
    private int sizeMeta;
    
    private static final long SerialVersionUID=777L;

    public Btree getArbolB() {
        return ArbolB;
    }

    public void setArbolB(Btree ArbolB) {
        this.ArbolB = ArbolB;
    }

    public Metadata() {
       // estado = false;
       ArbolB = new Btree();
    }

    public int getSizeMeta() {
        return sizeMeta;
    }

    public void setSizeMeta(int sizeMeta) {
        this.sizeMeta = sizeMeta;
    }
    

    public ArrayList getTipos() {
        return tipos;
    }

    public void setTipos(ArrayList tipos) {
        this.tipos = tipos;

    }

    public int getNumregistros() {
        return numregistros;
    }

    public void setNumregistros(int numregistros) {
        this.numregistros = numregistros;
    }

    public void addnumregistros() {
        System.out.println("ADDING ON METADATA!");
        this.numregistros++;
    }
    public void subtractnumregistros(){
        System.out.println("SUBTRACTING ON METADAT.");
        this.numregistros--;
    }

    public ArrayList<Campo> getCampos() {
        return campos;
    }

    public void setCampos(ArrayList campos) {
        this.campos = campos;

    }

    public Metadata(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getCampos_en_Archivo() {
        return Campos_en_Archivo;
    }

    public void setCampos_en_Archivo(long Campos_en_Archivo) {
        this.Campos_en_Archivo = Campos_en_Archivo;
    }
    

    @Override
    public String toString() {
        return "Metadata{" + "nombre=" + nombre + '}';
    }

}
