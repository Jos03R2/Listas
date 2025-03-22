package umg.edu.progra.listas;

public class Principal {
    public static void main(String[] args) {
        Lista lista = new Lista();
        lista.insertarCabezaLista(1);
        lista.insertarCabezaLista(2);
        lista.insertarCabezaLista(3);
        lista.insertarCabezaLista(4);
        lista.insertarCabezaLista(5);
        lista.insertarCabezaLista(6);
         
        System.out.println("la liista original:");
        lista.visualizar();

        
       
        //**** Ejercicio 1: Ordernar la lista de forma ascendente 
        System.out.println("\nOrdenando la lista de forma ascendente...");
        lista.ordenarLista();
        lista.visualizar();

        
        // **** Ejercicio 2: Unir dos listas enlazadas
        System.out.println("\nUniendo las listas...");
        Lista otraLista = new Lista();
        otraLista.insertarCabezaLista(7);
        otraLista.insertarCabezaLista(8);
        otraLista.insertarCabezaLista(9);
        lista.unirLista(otraLista);
        lista.visualizar();

        // **** Ejercicio 3: Separa numeros pares e impares en dos listas enlazadas diferentes
        System.out.println("\nSeparando en pares e impares...");
        Lista[] listasSeparadas = lista.separarParesImpares();
        
        System.out.println("Lista de los Pares:");
        listasSeparadas[0].visualizar();
        System.out.println("Lista de los Impares:");
        listasSeparadas[1].visualizar();
    }
}
