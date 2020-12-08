package edd2_proyecto_;

/**
 *
 * @author jrdjh
 */
public class Node {
    Data dato;
    int size_byte;
    long posicion;
    Node anterior;
    Node siguiente;

    public Node() {
    }

    public Node(int size_byte, long posicion) {
        this.size_byte = size_byte;
        this.posicion = posicion;
    }

    
    
    
}

