package umg.edu.progra.listas;

public class Lista {
    private Nodo cabeza;

    public Lista() {
        this.cabeza = null;
    }

    public void insertarCabezaLista(int dato) {
        Nodo nuevo = new Nodo(dato);
        nuevo.setEnlace(cabeza);
        cabeza = nuevo;
        //**Este public creara un nuevo nodoo con el valor "dato" lo enlaza con la acutal lo acutaliza para que apunte al nuevo nodo.**
    }

    public void visualizar() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.getDato() + " -> ");
            actual = actual.getEnlace();
        }
        System.out.println("null");
        //**va a recorrer la lista e imprime cada elemento seguido de ->. y finaliza con nulll para indicar el fin de la lista.**
    }

    public void invertirLista() {
        Nodo prev = null;
        Nodo actual = cabeza;
        Nodo siguiente;
        while (actual != null) {
            siguiente = actual.getEnlace();
            actual.setEnlace(prev);
            prev = actual;
            actual = siguiente;
        }
        cabeza = prev;
        //**este public usa tres punteros (prev, actual, siguiente) para poder recorrer la lista y cambiar las referencias. al final, cabeza se actualiza con el último nodo original (ahora primero).**
    }

    public int obtenerDesdeFinal(int n) {
        Nodo primero = cabeza;
        Nodo segundo = cabeza;
        for (int i = 0; i < n; i++) {
            if (segundo == null) return -1; 
            segundo = segundo.getEnlace();
        }
        while (segundo != null) {
            primero = primero.getEnlace();
            segundo = segundo.getEnlace();
        }
        return (primero != null) ? primero.getDato() : -1;
        //**Usa dos punteros (primero, segundo). segundo avanza n posiciones antes que primero.
        //Luego ambos avanzan hasta que segundo llega al final, primero queda en la posición deseada.**
    }

    public void eliminarDuplicados() {
        Nodo actual = cabeza;
        while (actual != null) {
            Nodo explorador = actual;
            while (explorador.getEnlace() != null) {
                if (explorador.getEnlace().getDato() == actual.getDato()) {
                    explorador.setEnlace(explorador.getEnlace().getEnlace());
                } else {
                    explorador = explorador.getEnlace();
                }
            }
            actual = actual.getEnlace();
        }
        //**este va recorrer la lista comparando cada nodo con los siguientes.
         //Si encuentra un duplicado, lo elimina cambiando las referencias.**
    }

    public int obtenerTamanio() {
        int contador = 0;
        Nodo actual = cabeza;
        while (actual != null) {
            contador++;
            actual = actual.getEnlace();
        }
        return contador;
        //**Cuenta cuántos nodos tiene una lista enlazada.
        //Empieza desde cabeza (el primer nodo de la lista)Usa un bucle while para recorrer toda la lista.
        //Por cada nodo, incrementa el contador y avanza al siguiente nodo Cuando actual llega a null (fin de la lista), 
        //devuelve el total de nodos contados.**
    }

    public void ordenarLista() {
        if (cabeza == null || cabeza.getEnlace() == null) {
            return; 
        }

        boolean huboIntercambio;
        do {
            Nodo actual = cabeza;
            Nodo siguiente = cabeza.getEnlace();
            huboIntercambio = false;

            while (siguiente != null) {
                if (actual.getDato() > siguiente.getDato()) {
                    int temp = actual.getDato();
                    actual.setDato(siguiente.getDato());
                    siguiente.setDato(temp);
                    huboIntercambio = true;
                }
                actual = siguiente;
                siguiente = siguiente.getEnlace();
            }
        } while (huboIntercambio);
        //**este va a comparar pares de nodos consecutivos y los intercambia si están en el orden incorrecto.
        // Vuelve a recorrer la lista varias veces hasta que ya no haya intercambios, lo que va a indicar que la lista está ordenada.**
    }

    public void unirLista(Lista otraLista) {
        if (otraLista == null || otraLista.cabeza == null) {
            return; 
        }

        if (this.cabeza == null) {
            this.cabeza = otraLista.cabeza;
            return;
        }

        Nodo actual = this.cabeza;
        while (actual.getEnlace() != null) {
            actual = actual.getEnlace();
        }

        actual.setEnlace(otraLista.cabeza);
        //**este verifica si la otra lista es nula o vacía (otraLista == null || otraLista.cabeza == null) Si lo es, no hace nada y sale del método.
        //si la lista actual está vacía (this.cabeza == null), simplemente asigna la otra lista como propia y termina.
        //si la lista actual tiene elementos, busca el último nodo recorriendo la lista hasta encontrar el nodo cuyo getEnlace() sea null Une la segunda 
        //lista a la primera al hacer que el último nodo de la primera apunte a la cabeza de la segunda.**
    }

    
    public Lista[] separarParesImpares() {
        if (cabeza == null) {
            System.out.println("La lista está vacía.");
            return new Lista[]{new Lista(), new Lista()};
        }

        Lista listaPares = new Lista();
        Lista listaImpares = new Lista();
        Nodo actual = cabeza;

        while (actual != null) {
            if (actual.getDato() % 2 == 0) {
                listaPares.insertarCabezaLista(actual.getDato());
            } else {
                listaImpares.insertarCabezaLista(actual.getDato());
            }
            actual = actual.getEnlace();
        }

        return new Lista[]{listaPares, listaImpares};
    }
    //**el public vera si la lista está vacía, muestra un mensaje y devuelve dos listas vacías,Creara dos listas nuevas: listaPares y listaImpares.
    //Recorre la lista original nodo por nodo.
    //Clasifica cada número.
     //Si es par, lo inserta en listaPares.
     //Si es impar, lo inserta en listaImpares.
     //Devuelve un arreglo con las dos listas separadas.**
}



   