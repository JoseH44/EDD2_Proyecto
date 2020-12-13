package edd2_proyecto_;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class Registro {
    int key;
    long byteOffset;
   
     // ArrayList<Object> data;

    /*public Registro(ArrayList<Object> data) {
        this.data = data;
        this.key = Integer.valueOf(data.get(0).toString());
    }*/
    
    
    

    public Registro() {
    }
    
    /*public ArrayList<Object> getData() {
        return data;
    }


    public void setData(ArrayList<Object> data) {
        this.data = data;
    }*/
    

    public Registro(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public long getByteOffset() {
        return byteOffset;
    }

    public void setByteOffset(long byteOffset) {
        this.byteOffset = byteOffset;
    }


    



    @Override
    public String toString() {
        return key +"-";
    }
}


