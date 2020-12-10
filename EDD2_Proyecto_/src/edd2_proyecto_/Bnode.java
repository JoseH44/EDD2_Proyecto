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
        // Hay n keys y n+1 hijos, visitar las n keys
        // primer hijo n
        int i;
        for (i = 0; i < n; i++) {
            // si no es un nodo hoja visitar
            // visitar el subárbol con hijo child[i]
            if (leaf == false)
            {
                hijos[i].traverse();
            }
           
            System.out.print(", " + key[i]);
        }
        //imprime el subárbol   
        
        if (leaf == false) {
            
            hijos[i].traverse();
        }
    }


    //función para buscar una key en el nodo 
    Bnode search(Registro k) {
        //encontrar la primera key que sea igual a k
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
        //moverse al hijo apropiado
        return hijos[i].search(k);
    }
    

    void insertNonFull(Registro k) {
        
        int i = n - 1;
        
        if (leaf == true) {
            /*
            while para manejar la inserción
            encuentra el lugar adecuado para insertar la llave
            y mueve las llaves una posición i+1
            */
            while (i >= 0 && key[i].getKey() > k.getKey()) {
                
                key[i + 1] = key[i];
                i--;
            }

            //inserta el nuevo nodo en la posición adecuada
            key[i + 1] = k;
            n = n + 1;
        } else{
            // encuentra al hijo que tendrá la nueva key
            while (i >= 0 && key[i].getKey() > k.getKey()) {
                i--;
            }
            
            //verifica que el hijo no contenga el máximo de llaves
            if (hijos[i + 1].getN() == 2 * t - 1) {
                //de tenerlos, hará split
                splitChild(i + 1, hijos[i + 1]);
                
                // desúés de hacer split la key en la mitad de children[i] se promueve
                // children[i] se hará split resultando en dos 
                // is going to have the new key
                if (key[i + 1].getKey() < k.getKey()) {
                    i++;
                }
            }
            
            //una vez hecho el split utilizamos la función insertNonFull
            hijos[i + 1].insertNonFull(k);
        }

    }

    
    void splitChild(int i, Bnode y) { 
        //crear un nodo que almacenará (t-1) keys de y
        Bnode z = new Bnode(y.getT(), y.isLeaf());
        
        z.setN(t - 1);

        //for para copiar los (t-1) keys de y a z
        for (int j = 0; j < t - 1; j++)
        {
            z.key[j] = y.key[j + t];
        }

        //copia el último hijo de y en z
        if (y.leaf == false) {
            for (int j = 0; j < t; j++)
            {
                z.hijos[j] = y.hijos[j + t];
            }
        }
        
        //settear el número de keys en y
        y.n = t - 1;

                
        for (int j = n; j >= i + 1; j--) 
        {
            hijos[j + 1] = hijos[j];
        }

        
        hijos[i + 1] = z;

        // Una key de y se moverá a este nuevo nodo Find location of 
        // encuentra la posición de la nueva key y mueve las keys mayores i+1
        for (int j = n - 1; j >= i; j--) 
        {
            key[j + 1] = key[j];
        }

        //copia la key de en medio de y en el nodo
        key[i] = y.key[t - 1];

        //incrementar el número de keys actuales.
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

        //verificar si la key se encuentra en este nodo.
        if (index < n && key[index].getKey() == k.getKey()) {
            //si el nodo es un nodo hoja se llama al metodo removeFromLeaf
            //de lo contrario llama al otro metodo 
            if (leaf) {
                removeFromLeaf(index);
            } else {
                removeFromNonLeaf(index);
            }
        } else {

            //si el nodo es un nodo hoja entonces la key no se encuentra aquí
            if (leaf) {
                System.out.println("El Registro [ " + k.getKey() + " ] no existe en el Arbol");
                
                return;
            }
            
            //la key a remover se encuentra en el subárbol 
            //la bandera indica si la key se encuentra en el subárbol 
            //con el último hijo de este nodo 
            boolean bandera = ((index == n) ? true : false);
            
            //si el hijo donde la key debería existir tiene menos de t keys 
            //llenamos ese hijo
            if (hijos[index].getN() < t) {
                fill(index);
            }
            
            //si el último hijo ha sido merged 
            //recursiva en el (index-1) hijo 
            //hijo(index) que ahora tiene al menos t keys
            if (bandera && index > n) {
                hijos[index - 1].remove(k);
            } else {
                hijos[index].remove(k);
            }
        }
        
    }
    

    void removeFromLeaf(int index) {
        // mover todas las keys una posición atrás 
        for (int i = index + 1; i < n; ++i) {
            
            key[i - 1] = (key[i]);
        }
        //decrementar el valor actual de keys
        n--;

    }

    void removeFromNonLeaf(int index) {
        Registro k = key[index];
        
        if (hijos[index].getN() >= t) {
            //si el hijo que precede a k tiene al menos t keys 
            //encontrar el predecesor de la key k en el subárbol 
            //reemplazar children[index] k por el predecesor y eliminar el predecesor en children[index] 
            Registro pred = getPredecesor(index);
            key[index] = pred;
            hijos[index].remove(pred);
        }else if (hijos[index + 1].n >= t) {
            //si el hijo children[index] tiene menos de t  keys examinar el siguiente hijo 
            //si children[index+1] tiene al menos t keys encontrar el sucesor de k
            //reemplazar k por el sucesor y eliminar el sucesor de children[i+1]
            Registro suc = getSucesor(index);
            key[index] = suc;
            hijos[index + 1].remove(suc);
        }else {
            //si ambos children[index] y children[index +1]tienen menos de t keys hacer merge de k con los children[i+1] 
            // en children[index]
            //ahora children[index] contiene 2t-1 keys 
            //liberar children[idx+1] eliminar k de children[index]
            merge(index);
            hijos[index].remove(k);
        }
        
    }
    

    Registro getPredecesor(int index) {
        //se mueve al nodo más a la derecha hasta llegar a un nodo hoja
        Bnode cur = hijos[index];
        while (!cur.isLeaf()) {
            cur = cur.hijos[cur.n];
        }

        // Retorna la última llave del nodo hoja
        return cur.key[cur.n - 1];
    }

    Registro getSucesor(int idx) {

        //se mueve al nodo más a la izquierda hasta encontrar un nodo hoja
        Bnode cur = hijos[idx + 1];
        while (!cur.leaf) {
            cur = cur.hijos[0];
        }

        //retorna la primera llave del nodo hoja
        return cur.key[0];
    }

    
    void fill(int index) {

        //si el hijo anterior children[index-1] tiene más de t-1 keys prestar una llave de ese hijo
        if (index != 0 && hijos[index - 1].n >= t) {
            borrowFromPrev(index);
        }else if (index != n && hijos[index + 1].n >= t) {
            //si el hijo anterior children[index-1] tiene más de t-1 keys prestar una llave de ese hijo
            borrowFromNext(index);
        }else{
            // Merge children[index] con su hermano 
            //si children[index] es el último hijo merge con el hermano anterior 
            // Otherwise merge it with its next sibling
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
        
        //la última key de children[index-1] se promueve al nodo padre
        //la llave children[index-1] del padre es insertado como la primera key en children[index] 
        // mueve todas las keys en children[index] una posición hacia adelante 
        for (int i = child.n - 1; i >= 0; --i) {
            child.key[i + 1] = child.key[i];
        }

        //si chil[index] no es nodo hoja muueve todos los punteros a hijos una posición hacia adelante
        if (!child.isLeaf()) {
            for (int i = child.getN(); i >= 0; --i) {
                child.hijos[i + 1] = child.hijos[i];
            }
        }
        
         
        child.key[0] = key[index - 1];
        //mueve los hijos del hermano 
        if (!child.isLeaf()) {
            child.hijos[0] = sibling.hijos[sibling.n];
        }
        
        //mueve la key del hermano hacía el nodo padre, reduciendo el número de keys en el hermano 
            
        key[index - 1] = sibling.key[sibling.n - 1];

        child.n += 1;
        sibling.n -= 1;

        
    }

    void borrowFromNext(int index) {

        Bnode child = hijos[index];
        Bnode sibling = hijos[index + 1];

       // keys[index] es insertado como la última llave en child[index]
        child.key[(child.getN())] = key[index];

        //el hijo del hermano es insertado como el último hijo en child[index] 
        if (!(child.isLeaf())) {
            child.hijos[(child.getN()) + 1] = sibling.hijos[0];
        }

        //la primera key del hermano es insertada en keys[index] 
        key[index] = sibling.key[0];

        //for para mover todas las llaves del hermano una posición hacia atrás 
        for (int i = 1; i < sibling.getN(); ++i) {
            sibling.key[i - 1] = sibling.key[i];
        }

        //mueve los punteros a los hijos un espacio hacia atrás 
        if (!sibling.isLeaf()) {
            for (int i = 1; i <= sibling.getN(); ++i) {
                sibling.hijos[i - 1] = sibling.hijos[i];
            }
        }

        //incrementa y decrece el número de keys actuales en child[index] y child[index+1] 
        // respectively
        child.n += 1;
        sibling.n -= 1;

        
    }

    
    void merge(int index) {
        Bnode child = hijos[index];
        Bnode sibling = hijos[index + 1];

        //agarrar una key del nodo actual e insertarla en la posición (t-1)th de child[index]
        
        child.key[t - 1] = key[index];

         //copiar las keys de child[index+1] a child[index] al final    
        for (int i = 0; i < sibling.n; ++i) {
            child.key[i + t] = sibling.key[i];
        }

        // copiar los punteros de child[index+1] a child[index] al final
        if (!child.isLeaf()) {
            for (int i = 0; i <= sibling.n; ++i) {
                child.hijos[i + t] = sibling.hijos[i];
            }
        }
        
        //mueve todas las keys después de index un espació hacia atrás en el nodo actual 
         
        for (int i = index + 1; i < n; ++i) {
            key[i - 1] = key[i];
        }

        
        //mueve todas los punteros a hijo después de index+1 un espació hacia atrás en el nodo actual 
        for (int i = index + 2; i <= n; ++i) {
            hijos[i - 1] = hijos[i];
        }

        //modificar el número de keys actuales en el nodo hijo y en el nodo actual 
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




