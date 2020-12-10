package edd2_proyecto_;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
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

    public Archivo(File file) {
        archivo = file;
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
    public void cargarArchivo() throws IOException
    {
       try {            
            listaCampo= new ArrayList();
            Campo temp;
            if (archivo.exists()) {
                FileInputStream entrada
                    = new FileInputStream(archivo);
                ObjectInputStream objeto
                    = new ObjectInputStream(entrada);
                try {
                    while ((temp = (Campo) objeto.readObject()) != null) {
                        listaCampo.add(temp);
                    }
                } catch (EOFException e) {
                    //encontro el final del archivo
                }
                objeto.close();
                entrada.close();
            }            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void escribirArchivo()
    {
        FileOutputStream fw = null;
        ObjectOutputStream bw = null;
        try {
            fw = new FileOutputStream(archivo);
            bw = new ObjectOutputStream(fw);
            for (Campo t : listaCampo) {
                bw.writeObject(t);
            }
            bw.flush();
        } catch (Exception ex) {
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (Exception ex) {
            }
        }
    }
    
    public void ModificarDatoArchivo(ArrayList<Object> arrayList, AVL avl, Btree arbol,RandomAccessFile RAfile) {
        try {
            Registro temporal = new Registro(Integer.parseInt(arrayList.get(0).toString()));
            if (BuscarDatoArchivo(temporal,arbol,RAfile) != null) {
                System.out.println("===========================================================");
                System.out.println("MODIFICANDO NODO...");
                Data temp = BuscarDatoArchivo(temporal,arbol,RAfile);
                temporal.setByteOffset(temp.ubicacion);
                RAfile.seek(temp.ubicacion);
                int size_act = RAfile.readInt();//Este es el tamaño actual

                Data new_size = new Data();
                new_size.setKey((int) arrayList.get(0));
                new_size.setDatos(arrayList);
                new_size.setUbicacion(temp.getUbicacion());
                ByteArrayOutputStream obArray = new ByteArrayOutputStream();
                ObjectOutputStream objeto = new ObjectOutputStream(obArray);
                objeto.writeObject(new_size);
                byte[] dat = obArray.toByteArray();

                System.out.println("NEW SIZE" + dat.length + " ---- " + "SIZE ORIGINAL:" + size_act);
                if (dat.length <= size_act) {//Este if permite entrar si es mas peqeño
                    System.out.println("EL NUEVO REGISTRO ES MAS PEQUEÑO O IGUAL, SE ADAPATARA PARA QUE SEAN DEL MISMO TAMAÑO SI ES NECESARIO");
                    for (int i = 0; i < (size_act - dat.length); i++) {//El for lo que hace es meter caracteres para igualar los size de ambos
                        new_size.setMarcado(new_size.getMarcado() + "|");
                    }//Igualo los size para solo pegar el nuevo dato sobre el viejo y asi no generar errores
                    obArray = new ByteArrayOutputStream();
                    objeto = new ObjectOutputStream(obArray);
                    objeto.writeObject(new_size);
                    dat = obArray.toByteArray();//Actulizando 
                    RAfile.write(dat);
                    System.out.println("NEW SIZE" + dat.length + " ---- " + "SIZE ORIGINAL:" + size_act);
                } else {
                    System.out.println("EL NUEVO REGISTRO ES MUY GRANDE IRA AL FINAL DEL ARCHIVO");
                    temp.setMarcado("*"); //Pone un aterisco que marca ese registro o dato como eliminado
                    obArray = new ByteArrayOutputStream();
                    objeto = new ObjectOutputStream(obArray);
                    objeto.writeObject(temp);
                    byte[] dat2 = obArray.toByteArray();
                    RAfile.write(dat2);

                    //ESPACIO RESERVADO PARA EL AVAILlIST
                    long byteOffset = RAfile.length();

                    new_size.setUbicacion(byteOffset);
                    obArray = new ByteArrayOutputStream();
                    objeto = new ObjectOutputStream(obArray);
                    objeto.writeObject(new_size);
                    dat = obArray.toByteArray();

                    RAfile.seek(byteOffset);//ahora nos vamos al final de archivo a poner el El registro ya que es muy grande
                    RAfile.writeInt(dat.length);
                    RAfile.write(dat);

                    Bnode tmp = arbol.search(temporal);
                    int ubicacion = searchEnNodo(tmp, temp.getKey());
                    tmp.key[ubicacion].byteOffset = byteOffset;

                    System.out.println("LLamar metodo del AvailList...");                    avl.BestFit(size_act, temporal.byteOffset);
                    avl.PrintList(avl.head);
                    System.out.println("Antes de Borrar el Registro...." + arbol.search(temporal));
                    System.out.println("Despues de Borrar el Registro...." + arbol.search(temporal));
                    System.out.println("");

                    System.out.println("Key: " + tmp.key[ubicacion].key + " ------------------ ByteOfsset" + tmp.key[ubicacion].byteOffset);

                    //Espera implementarse mas adelante
                }
                System.out.println("OPERACION REALIZADA EXITOSAMENTE");
                System.out.println("===========================================================");
            }
        } catch (Exception ex) {
            //Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void EliminarDatoArchivo(ArrayList<Object> arrayList, AVL avl, Btree arbol,RandomAccessFile RAfile) {

        try {
            Registro temporal = new Registro(Integer.parseInt(arrayList.get(0).toString()));
            if (BuscarDatoArchivo(temporal,arbol,RAfile) != null) {
                System.out.println("===========================================================");
                System.out.println("ELIMANDO NODO...");
                Data temp = BuscarDatoArchivo(temporal,arbol,RAfile);
                RAfile.seek(temp.ubicacion);
                int size_act = RAfile.readInt();//Este es el tamaño actual
                temp.setMarcado("*"); //Pone un aterisco que marca ese registro o dato como eliminado
                temp.marcado = "*";
                Bnode b = arbol.search(temporal);
                int pos = searchEnNodo(b, temporal.key);
                long ubicacion = b.key[pos].getByteOffset();
                temp.ubicacion = ubicacion;

                ByteArrayOutputStream obArray = new ByteArrayOutputStream();
                ObjectOutputStream objeto = new ObjectOutputStream(obArray);

                obArray = new ByteArrayOutputStream();
                objeto = new ObjectOutputStream(obArray);
                objeto.writeObject(temp);

                byte[] dat2 = obArray.toByteArray();
                System.out.println(temp.getMarcado() + " ----------------------------" + temp.ubicacion);
                RAfile.write(dat2);

                System.out.println("LLamar metodo del AvailList...");
                avl.BestFit(size_act, temp.ubicacion);
                avl.PrintList(avl.head);
                System.out.println("Antes de Borrar el Registro...." +arbol.search(temporal));
                arbol.remove(temporal);
                System.out.println("Despues de Borrar el Registro...." + arbol.search(temporal));
                System.out.println("===========================================================");
                //Avai

            }
        } catch (Exception ex) {
            //ex.printStackTrace();
        }
    }
    
    
    public Data BuscarDatoArchivo(Registro r, Btree arbol,RandomAccessFile RAfile) throws IOException, ClassNotFoundException{//Metodo para Buscar El Registro en el Archivo
        if (arbol.search(r) != null) {//Solo uso la key del Arbol y lo pido de forma constante al Randomaccesfile
            Bnode contenido = arbol.search(r);
            int pos = searchEnNodo(contenido, r.getKey());
            long byteOffset = contenido.key[pos].byteOffset;
            RAfile.seek(byteOffset);
            int tamaño = RAfile.readInt();
            byte[] data = new byte[tamaño];
            RAfile.read(data);
            ByteArrayInputStream in = new ByteArrayInputStream(data);
            ObjectInputStream read = new ObjectInputStream(in);
            Data d = (Data) read.readObject();//guardo el array de bytes en una variable temporal

            return d;
        } else {
            System.out.println("No se encontro el Nodo");

            return null;
        }

    }
    
    public void LeerDatosRegistro(RandomAccessFile RAfile,AVL avl, Btree arbol) throws ClassNotFoundException {
        try {//Este metodo quedara available cuando Se habilite la fncion Load File
            System.out.println("=========================================");
            System.out.println("Cargando Registros a la Table");

            RAfile = new RandomAccessFile(archivo, "rw");
            RAfile.seek(0);
            int tamaño = RAfile.readInt();
            RAfile.seek(tamaño + 4);
            //System.out.println(tamaño);
            boolean eliminado = false;//boolen que marca que el registro leido esta eliminado
            while (RAfile.getFilePointer() < RAfile.length()) {
                System.out.println("----------------------------------------------");
                eliminado = false;
                tamaño = RAfile.readInt();
                System.out.println("New Tamaño: " + tamaño);
                byte[] data = new byte[tamaño];
                RAfile.read(data);
                ByteArrayInputStream in = new ByteArrayInputStream(data);
                ObjectInputStream read = new ObjectInputStream(in);
                Data d = (Data) read.readObject();//guardo el array de bytes en una variable temporal
                if (d.getMarcado().contains("*")) {//If que verifica que si el registro esta eliminado
                    eliminado = true;//si entra significa que si
                    System.out.println("ENCONTRO EL REGISTRO BORRADO... " + d.getDatos().get(1) + " Ubicacion...." + d.getUbicacion());
                    avl.BestFit(tamaño, d.ubicacion);

                } else {//entra al else cuando NO ETSA ELIMINADO
                    //KennethExport2 = new ArrayList<>();
                    Registro temporal = new Registro(d.getKey());
                    temporal.setByteOffset(d.getUbicacion());
                    arbol.insert(temporal);
                    System.out.println("SE VA A METER A: " + d.getDatos().get(1) + " Ubicacion: " + d.getUbicacion());
                    for (int i = 0; i < d.getDatos().size(); i++) {
                        //KennethExport2.add(d.getDatos().get(i));

                    }
                    //TableInsertRegistro();//Inserto en la tabla

//Agrego un registro con el mismo formato que me fue enviado para implementarlo en la table
                    //Arraylist Lista para agarrar Registros
                    //GRAB Global Array!!!! XD 
                }

            }
            arbol.traverse();
            arbol.PrintLevels();
        } catch (IOException ex) {
            //ex.printStackTrace();
            //System.out.println("ERrrrrrrrrrrrrrrrrrrrrrrrrrrrrrroooooooooooooooooorr");
        }
    }
    
    public void EscribirDatosRegistro(ArrayList<Object> arrayList, AVL avl, Btree arbol,RandomAccessFile RAfile) {

        try {
            System.out.println("=========================================");
            if (avl.head != null) {
                System.out.println("EL AVAILIST TIENE DATOS!!! VER SI ENCUENTRA CUPO....");
                Data datos = new Data();
                Registro temporal = new Registro(Integer.parseInt(arrayList.get(0).toString()));
                long byteOffset = RAfile.length();
                System.out.println("ByteOffset:: " + byteOffset);
                Bnode d = arbol.search(temporal);
                int x = searchEnNodo(d, temporal.getKey());

                d.key[x].setByteOffset(byteOffset);
                datos.setDatos(arrayList);//Alistando para guardar arraylist de objetos en el archivo
                datos.setUbicacion(byteOffset);//clase datos que guarda ubiacion

                ByteArrayOutputStream obArray = new ByteArrayOutputStream();
                ObjectOutputStream objeto = new ObjectOutputStream(obArray);
                objeto.writeObject(datos);

                byte[] dat = obArray.toByteArray();
                int required_size = dat.length;
                
                Node espacio = avl.BuscarEspacio(required_size);
                if (espacio == null) {
                    System.out.println("NO ENCONTRO ESPACIO, NO CABE");
                    RAfile.seek(byteOffset);//Place pointe at the beggining of the file
                    RAfile.writeInt(dat.length);
                    RAfile.write(dat);
                } else {
                    System.out.println("SI ENCONTROO ESPACIO!!! ENTRO");
                    //System.out.println("Esta es la POSICION: " + espacio.posicion);
                    datos.setUbicacion(espacio.posicion);
                    System.out.println("Espacio encontrado: " + espacio.size_byte 
                            + " ----- Tamaño del Registro a Insertar: " + dat.length);
                    int j = 0;
                    for (int i = 0; i < (espacio.size_byte - dat.length); i++) {//El for lo que hace es meter caracteres para igualar los size de ambos
                        datos.setMarcado(datos.getMarcado() + "|");
                        //System.out.print("ENTRO Cuantas Veces??");
                        j++;
                    }

                    obArray = new ByteArrayOutputStream();
                    objeto = new ObjectOutputStream(obArray);
                    objeto.writeObject(datos);
                    dat = obArray.toByteArray();
                    d.key[x].setByteOffset(datos.ubicacion);
                    System.out.println("Espacio Size: " + espacio.size_byte + "--- New Size: " + dat.length);
                    System.out.println("    Esta es la Ubicacion..... " + datos.ubicacion);

                    RAfile.seek(datos.ubicacion);
                    RAfile.writeInt(dat.length);
                    RAfile.write(dat);
                    avl.eliminarNodo(avl.head, espacio);
                }
            } else {
                System.out.println("EL AVAILLIST ESTA VACIO ENTONCES INGRESA NORMAL");
                Data datos = new Data();
                Registro temporal = new Registro(Integer.parseInt(arrayList.get(0).toString()));
                long byteOffset = RAfile.length();
                System.out.println("ByteOffset:: " + byteOffset);
                Bnode d = arbol.search(temporal);
                int x = searchEnNodo(d, temporal.getKey());

                d.key[x].setByteOffset(byteOffset);
                datos.setDatos(arrayList);//Alistando para guardar arraylist de objetos en el archivo
                datos.setUbicacion(byteOffset);//clase datos que guarda ubiacion

                ByteArrayOutputStream obArray = new ByteArrayOutputStream();
                ObjectOutputStream objeto = new ObjectOutputStream(obArray);
                objeto.writeObject(datos);
                byte[] dat = obArray.toByteArray();//makes an array of bytes from the object
                RAfile.seek(byteOffset);//Place pointe at the beggining of the file
                RAfile.writeInt(dat.length);
                RAfile.write(dat);
                System.out.println("ESTE ES EL SIZE DEL REGISTRO..." + dat.length);
            }

        } catch (IOException | NumberFormatException ex) {
            // System.out.println("Tiene errrrrrrrroooooooooooooooor");
            //ex.printStackTrace();
        }

    }
    
    public int searchEnNodo(Bnode d, int key) {//Como mi arbol devulve el nodo en que se ubica el Registro
        int pos = 0;
        //Este Metodo me dije la posicion en la que se encuentra en el Nodo.
        if (d != null) {
            for (int i = 0; i < d.n; i++) {//for que busca en el nodo la llave y le agrega el byte donde se ubica en el archivo
                if (d.key[i].getKey() == key) {
                    break;
                } else {
                    pos++;
                }
            }
        } else {
            // System.out.println("PORQUE ESSS NULLLLLL?????????????????????????????");
        }
        return pos;
    }
}
