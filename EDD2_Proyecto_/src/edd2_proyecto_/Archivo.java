package edd2_proyecto_;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Archivo {
    private ArrayList <Campo> listaCampo = new ArrayList();
    private File archivo = null;

    public Archivo(String path) throws IOException {
        archivo = new File(path);
        FileWriter fw = null;
       BufferedWriter bw = null;
        try {
            fw = new FileWriter(archivo,false);//Remplazar todo
            bw = new BufferedWriter(fw);
            bw.write("");
            bw.flush();
        } catch (Exception e) {
        }
        bw.close();
        fw.close();
    }

    public ArrayList<Campo> getListaCampo() {
        return listaCampo;
    }

    public void setlistaCampo(ArrayList<Campo> listaCampo) {
        this.listaCampo = listaCampo;
    }
    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }    
    
    public void setCampo(Campo p)
    {
       this.listaCampo.add(p);
    }

    @Override
    public String toString() {
        return "AdminCampo{" + "listaCampo=" + listaCampo + ", archivo=" + archivo + '}';
    }
    public void escribirArchivo() throws IOException
    {
       FileWriter fw = null;
       BufferedWriter bw = null;
        try {
            fw = new FileWriter(archivo,false);//Remplazar todo
            bw = new BufferedWriter(fw);
            bw.write("{");
            for (Campo t : listaCampo) {
                bw.write(t.getNombre()+":");
                bw.write(t.getTipo()+"[");
                bw.write(t.getLongitud()+"],");
            }
            bw.write("}");
            bw.flush();
        } catch (Exception e) {
        }
        bw.close();
        fw.close();
    }
    public void cargarArchivo()
    {
        
    }
}
