package umg.edu.progra.listas;

import umg.edu.progra.listas.doblementeEnlazada.DoblementeEnlazada;

public class Principal {

    public static void main(String[] args) {
        listaEnlazadaDoble(); 
    }

    public static void listaEnlazadaDoble() {
        DoblementeEnlazada dll = new DoblementeEnlazada();

      
        dll.insertAtEnd(10);
        dll.insertAtEnd(20);
        dll.insertAtEnd(30);
        dll.insertAtBeginning(5);

        System.out.println("lista en orden:");
        dll.displayForward();

        System.out.println("lista en orden inverso:");
        dll.displayBackward();

       
        System.out.println("eliminando 20: " + dll.delete(20));
        dll.displayForward();

      
        System.out.println("buscando 10: " + dll.search(10));
        System.out.println("buscando 50: " + dll.search(50));

      
        System.out.println("numero de los nodos en la lista: " + dll.countNodes());

       
        dll.insertAfter(10, 15);
        System.out.println("lista despues de insertar 15 despues de 10:");
        dll.displayForward();

   
        dll.reverseList();
        System.out.println("lista despues de ser revertida:");
        dll.displayForward();
    }
}

