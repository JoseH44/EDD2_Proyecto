package edd2_proyecto_;

/**
 *
 * @author jrdjh
 */
public class AVL {
    Node head;//cabeza de la lista guardada en la MetaData
    
    
    public void eliminarNodo(Node cabeza, Node nodo_eliminar){
        if (head == null || nodo_eliminar == null) {
            return;
        }
        // If node to be deleted is head node 
        if (head == nodo_eliminar) {
            head = nodo_eliminar.siguiente;
        }
        if (nodo_eliminar.siguiente != null) { //entra si no es el ultimo nodo
            nodo_eliminar.siguiente.anterior = nodo_eliminar.anterior;
        }
        if (nodo_eliminar.anterior != null) { //no lo hace si es el primer nodo
            nodo_eliminar.anterior.siguiente = nodo_eliminar.siguiente;
        }
        
    }
    
    
    public void PrintList(Node nodo){
        Node final_ = null;
        System.out.println("Normal:");
        while (nodo != null) {
            System.out.print("Size: " + nodo.size_byte +"Pos: "+ nodo.posicion + " /");
            final_ = nodo;
            nodo = nodo.siguiente;
        }
        System.out.println();
        System.out.println("Reversa:");
        while (final_ != null) {
            System.out.print(final_.size_byte + " ");
            final_ = final_.anterior;
        }
    }
    
    public void InsertarFinal(int new_size,long posicion){
        Node nuevo_nodo = new Node(new_size,posicion);
        Node final_ = head;
        nuevo_nodo.siguiente = null;

        if (head == null) {
            nuevo_nodo.anterior = null;
            head = nuevo_nodo;
            return;
        }
        
        //while para ubicarse al final de la lista
        while (final_.siguiente != null) {
            final_ = final_.siguiente;
        }
        
        // al ultimo nodo le agrega el nuevo nodo en siguiente
        final_.siguiente = nuevo_nodo;

        //al nuevo nodo apuntando al anterior le asignamos el nodo final_
        nuevo_nodo.anterior = final_;
    }
    
    public Node BuscarEspacio(int size_requerido){
        Node final_ = head;
        boolean encontrado = false;
        //dato maybe
        while (final_.siguiente != null) {
            if (size_requerido > final_.size_byte) {
                final_ = final_.siguiente;
            } else {
                
                encontrado = true;
                break;
            }
        }
        if (encontrado == false) {
            //en caso que sea mayor al tamaño en el nodo retornara null
            if (size_requerido > final_.size_byte)
                return null;
            else 
                return final_;
            
        } else {
            return final_;
        }
    }
    
    
    public void BestFit(int new_size, int posicion){
        boolean insertado = false;
        Node nuevo_nodo = new Node(new_size,posicion);
        Node final_ = head;
        nuevo_nodo.siguiente = null;
        
        if (head == null) {

            nuevo_nodo.anterior = null;
            head = nuevo_nodo;

        } else {
            if (new_size < final_.size_byte) {
                
                nuevo_nodo.anterior = final_.anterior;
                nuevo_nodo.siguiente = final_;
                final_.anterior = nuevo_nodo;
                head = nuevo_nodo;
                insertado = true;
            } else {
                
                while (final_.siguiente != null) {

                    if (new_size < final_.siguiente.size_byte) {
                        nuevo_nodo.anterior = final_;
                        nuevo_nodo.siguiente = final_.siguiente;
                        final_.siguiente.anterior = nuevo_nodo;
                        final_.siguiente = nuevo_nodo;

                        insertado = true;
                        break;
                    } else {
                        final_ = final_.siguiente;
                    }
                }
                if (!insertado) {

                    final_.siguiente = nuevo_nodo;
                    nuevo_nodo.anterior = final_;
                    
                }//fin if
            }//fin else if

        }//fin else if superior
    }
}

