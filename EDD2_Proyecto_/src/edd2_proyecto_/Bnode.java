package edd2_proyecto_;

import java.io.Serializable;

public class Bnode implements Serializable {
    Registro[] key;//el arreglo de llaves
    int t;//grado del arbol
    Bnode[] hijos;//arreglo de hijos
    int n;//número actual de llaves en el nodo
    boolean leaf; 

    public Bnode(int t_, boolean leaf_) {
        t = t_;
        leaf = leaf_;
        key = new Registro[2 * t - 1];
        hijos = new Bnode[2 * t];

    }

    public Registro[] getKeys() {
        return key;
    }

    public void addregistro(Registro r, int pos) {
        key[pos] = r;
    }

    public void setKeys(Registro[] keys) {
        this.key = keys;
    }

    public Registro getKey(int pos) {
        return key[pos];
    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }

    public Bnode[] getHijos() {
        return hijos;
    }

    public void setHijos(Bnode[] hijos) {
        this.hijos = hijos;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean p_leaf) {
        this.leaf = p_leaf;
    }

    
    
    //
    void traverse() {
        
        int i;
        for (i = 0; i < n; i++) {
            if (leaf == false)
            {
                hijos[i].traverse();
            }
           
            System.out.print(", " + key[i]);
        }

        
        if (leaf == false) {
            
            hijos[i].traverse();
        }
    }


        
    Bnode search(Registro k) {
        
        int i = 0;
 

        for (i = 0; i < n; i++) {
            if (key[i].getKey() >= k.getKey()) {
                break;
            }
        }
        if (i < n && key[i].getKey() == k.getKey()) {
            return this;
        }
        if (leaf == true) {
            return null;
        }
        
        return hijos[i].search(k);
    }
    

    void insertNonFull(Registro k) {
        
        int i = n - 1;
        
        if (leaf == true) {
            
            while (i >= 0 && key[i].getKey() > k.getKey()) {
                
                key[i + 1] = key[i];
                i--;
            }

            
            key[i + 1] = k;
            n = n + 1;
        } else{
            while (i >= 0 && key[i].getKey() > k.getKey()) {
                i--;
            }

            if (hijos[i + 1].getN() == 2 * t - 1) {
                
                splitChild(i + 1, hijos[i + 1]);

                if (key[i + 1].getKey() < k.getKey()) {
                    i++;
                }
            }
            
            hijos[i + 1].insertNonFull(k);
        }

    }

    
    void splitChild(int i, Bnode y) { 
        Bnode z = new Bnode(y.getT(), y.isLeaf());
        
        z.setN(t - 1);

        
        for (int j = 0; j < t - 1; j++)
        {
            z.key[j] = y.key[j + t];
        }

        
        if (y.leaf == false) {
            for (int j = 0; j < t; j++)
            {
                z.hijos[j] = y.hijos[j + t];
            }
        }

        y.n = t - 1;

        
        for (int j = n; j >= i + 1; j--) 
        {
            hijos[j + 1] = hijos[j];
        }

        
        hijos[i + 1] = z;

        
        for (int j = n - 1; j >= i; j--) 
        {
            key[j + 1] = key[j];
        }

         
        key[i] = y.key[t - 1];

        
        n = n + 1;
    }

    public int findKey(Registro k) {
        int index = 0;
        
        while ((index < n) && (key[index].getKey() < k.getKey())) {
            ++index;
        }
       
        return index;
    }

    void remove(Registro k) {
        int index = findKey(k);

        
        if (index < n && key[index].getKey() == k.getKey()) {

            if (leaf) {
                removeFromLeaf(index);
            } else {
                removeFromNonLeaf(index);
            }
        } else {

            
            if (leaf) {
                System.out.println("El Registro [ " + k.getKey() + " ] no existe en el Arbol");
                
                return;
            }

            boolean bandera = ((index == n) ? true : false);
            
            if (hijos[index].getN() < t) {
                fill(index);
            }

            if (bandera && index > n) {
                hijos[index - 1].remove(k);
            } else {
                hijos[index].remove(k);
            }
        }
        return;
    }
    

    void removeFromLeaf(int index) {
        
        for (int i = index + 1; i < n; ++i) {
            
            key[i - 1] = (key[i]);
        }
        
        n--;

        return;
    }

    void removeFromNonLeaf(int index) {
        Registro k = key[index];

        
        if (hijos[index].getN() >= t) {
            
            Registro pred = getPredecesor(index);
            key[index] = pred;
            hijos[index].remove(pred);
        } 
        else if (hijos[index + 1].n >= t) {
            Registro suc = getSucesor(index);
            key[index] = suc;
            hijos[index + 1].remove(suc);
        } 
        else {
            merge(index);
            hijos[index].remove(k);
        }
        return;
    }
    

    Registro getPredecesor(int index) {
        
        Bnode cur = hijos[index];
        while (!cur.isLeaf()) {
            cur = cur.hijos[cur.n];
        }

        // Retorna la última llave del nodo hoja
        return cur.key[cur.n - 1];
    }

    Registro getSucesor(int idx) {

        
        Bnode cur = hijos[idx + 1];
        while (!cur.leaf) {
            cur = cur.hijos[0];
        }

        
        return cur.key[0];
    }

    
    void fill(int index) {

        
        if (index != 0 && hijos[index - 1].n >= t) {
            borrowFromPrev(index);
        }else if (index != n && hijos[index + 1].n >= t) {
            borrowFromNext(index);
        }else{
            if (index != n) {
                merge(index);
            } else {
                merge(index - 1);
            }
        }
        
    }

    
    void borrowFromPrev(int index) {

        Bnode child = hijos[index];
        Bnode sibling = hijos[index - 1];

        
        for (int i = child.n - 1; i >= 0; --i) {
            child.key[i + 1] = child.key[i];
        }

        
        if (!child.isLeaf()) {
            for (int i = child.getN(); i >= 0; --i) {
                child.hijos[i + 1] = child.hijos[i];
            }
        }

        child.key[0] = key[index - 1];

        if (!child.isLeaf()) {
            child.hijos[0] = sibling.hijos[sibling.n];
        }

        key[index - 1] = sibling.key[sibling.n - 1];

        child.n += 1;
        sibling.n -= 1;

        
    }

    void borrowFromNext(int index) {

        Bnode child = hijos[index];
        Bnode sibling = hijos[index + 1];

       
        child.key[(child.getN())] = key[index];

        
        if (!(child.isLeaf())) {
            child.hijos[(child.getN()) + 1] = sibling.hijos[0];
        }

        
        key[index] = sibling.key[0];

        
        for (int i = 1; i < sibling.getN(); ++i) {
            sibling.key[i - 1] = sibling.key[i];
        }

        
        if (!sibling.isLeaf()) {
            for (int i = 1; i <= sibling.getN(); ++i) {
                sibling.hijos[i - 1] = sibling.hijos[i];
            }
        }

        
        child.n += 1;
        sibling.n -= 1;

        
    }

    
    void merge(int index) {
        Bnode child = hijos[index];
        Bnode sibling = hijos[index + 1];

        
        child.key[t - 1] = key[index];

        
        for (int i = 0; i < sibling.n; ++i) {
            child.key[i + t] = sibling.key[i];
        }

        
        if (!child.isLeaf()) {
            for (int i = 0; i <= sibling.n; ++i) {
                child.hijos[i + t] = sibling.hijos[i];
            }
        }

        for (int i = index + 1; i < n; ++i) {
            key[i - 1] = key[i];
        }

        
        for (int i = index + 2; i <= n; ++i) {
            hijos[i - 1] = hijos[i];
        }

        
        child.n += sibling.n + 1;
        n--;

       
        sibling = null;
        
    }

    
    @Override
    public String toString() {
        String salida = "";
        for (int i = 0; i < n; i++) {
            if (key[i] != null) {
                salida += key[i].toString() + ",";
            }
        }
        return "Bnode{" + salida + '}';
    }
}




