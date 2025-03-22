Explicacion del codigo de "Implementación de Listas Enlazadas en Java"
////////Clase Lista
---------------------------------Insertar la lista-------------------------------
public void insertarCabezaLista(int dato) {
    Nodo nuevo = new Nodo(dato);
    nuevo.setEnlace(cabeza);
    cabeza = nuevo;
}
**Este public creara un nuevo ndoo con el valor "dato" lo enlaza con la acutal
lo acutaliza para que apunte al nuevo nodo.**

--------------------------------Visualizar la lista---------------------------------
public void visualizar() {
    Nodo actual = cabeza;
    while (actual != null) {
        System.out.print(actual.getDato() + " -> ");
        actual = actual.getEnlace();
    }
    System.out.println("null");
}
**va a recorrer la lista e imprime cada elemento seguido de ->. y finaliza con null para
indicar el fin de la lista.**


----------------------------------Invertir la lista-----------------------------------
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
}
**este public usa tres punteros (prev, actual, siguiente) para poder recorrer la lista y cambiar las referencias.
al final, cabeza se actualiza con el último nodo original (ahora primero).**


--------------------------Obtener desde el final------------------------------------------
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
}
**Usa dos punteros (primero, segundo). segundo avanza n posiciones antes que primero.
Luego ambos avanzan hasta que segundo llega al final, primero queda en la posición deseada.**


---------------------------Eliminar los nodos duplicados------------------------------------------
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
}
**este va recorrer la lista comparando cada nodo con los siguientes.
Si encuentra un duplicado, lo elimina cambiando las referencias.**


--------------------------------Obtener el tamaño de la lista----------------------------------
public int obtenerTamanio() {
    int contador = 0;
    Nodo actual = cabeza;
    while (actual != null) {
        contador++;
        actual = actual.getEnlace();
    }
    return contador;
}
**Cuenta cuántos nodos tiene una lista enlazada.
Empieza desde cabeza (el primer nodo de la lista)Usa un bucle while para recorrer toda la lista.
Por cada nodo, incrementa el contador y avanza al siguiente nodo Cuando actual llega a null (fin de la lista), 
devuelve el total de nodos contados.**


-----------------------------------------Obtener la lista-------------------------------------
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
}
**este va a comparar pares de nodos consecutivos y los intercambia si están en el orden incorrecto.
Vuelve a recorrer la lista varias veces hasta que ya no haya intercambios, lo que va a indicar que la lista está ordenada.**


----------------------------------Unir dos listas enlazadas--------------------------------
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
}
**este verifica si la otra lista es nula o vacía (otraLista == null || otraLista.cabeza == null) Si lo es, no hace nada y sale del método.
si la lista actual está vacía (this.cabeza == null), simplemente asigna la otra lista como propia y termina.
si la lista actual tiene elementos, busca el último nodo recorriendo la lista hasta encontrar el nodo cuyo getEnlace() sea null Une la segunda 
lista a la primera al hacer que el último nodo de la primera apunte a la cabeza de la segunda.**


--------------------------------Separar en listas de pares e impares----------------------------
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
**el public vera si la lista está vacía, muestra un mensaje y devuelve dos listas vacías,Creara dos listas nuevas: listaPares y listaImpares.
Recorre la lista original nodo por nodo.
Clasifica cada número.
Si es par, lo inserta en listaPares.
Si es impar, lo inserta en listaImpares.
Devuelve un arreglo con las dos listas separadas.**


//Clase Principal
------------------------------Creacion de lista enlazada-----------------------------

Lista lista = new Lista();
lista.insertarCabezaLista(1);
lista.insertarCabezaLista(2);
lista.insertarCabezaLista(3);
lista.insertarCabezaLista(4);
lista.insertarCabezaLista(5);
lista.insertarCabezaLista(6);

Se crea una instancia de la clase Lista (suponemos que es una lista enlazada) y se insertan los valores {6, 5, 4, 3, 2, 1}.
Cada nuevo número se inserta en la cabeza, por lo que el orden en la lista enlazada será:
Lista original: 6 -> 5 -> 4 -> 3 -> 2 -> 1

-------------------------visualizar lista-----------------------------------
System.out.println("la lista original:");
lista.visualizar();

aca se imprime la lista enlazada.


----------------- Ordenar la lista en orden ascendente-------------------------
System.out.println("\nOrdenando la lista de forma ascendente...");
lista.ordenarLista();
lista.visualizar();

aca se llama al método ordenarLista(), que suponemos que ordena la lista de menor a mayor.
Si la implementación es correcta, después de la ordenación, la lista quedará así:
Lista ordenada: 1 -> 2 -> 3 -> 4 -> 5 -> 6


---------------------------unir las dos listas----------------------------------------
Lista otraLista = new Lista();
otraLista.insertarCabezaLista(7);
otraLista.insertarCabezaLista(8);
otraLista.insertarCabezaLista(9);
lista.unirLista(otraLista);
lista.visualizar();

Aquí se crea otra lista enlazada con los valores {9, 8, 7} y se une a la lista principal.
Después de la unión, la lista combinada debería quedar así (suponiendo que se une manteniendo el orden):
Lista unida: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9



-------------------------Separar en listas de pares e impares-----------------------------------------
Lista[] listasSeparadas = lista.separarParesImpares();
System.out.println("Lista de los Pares:");
listasSeparadas[0].visualizar();
System.out.println("Lista de los Impares:");
listasSeparadas[1].visualizar();

Aquí se divide la lista en dos:
Una con los números pares: {2, 4, 6, 8}
Otra con los números impares: {1, 3, 5, 7, 9}

Después de la separación:
Lista de pares: 2 -> 4 -> 6 -> 8
Lista de impares: 1 -> 3 -> 5 -> 7 -> 9




//////////Asi seria el resultado del codigo
la liista original:
6 -> 5 -> 4 -> 3 -> 2 -> 1 -> null

Ordenando la lista de forma ascendente...
1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null

Uniendo las listas...
1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 9 -> 8 -> 7 -> null

Separando en pares e impares...
Lista de los Pares:
8 -> 6 -> 4 -> 2 -> null
Lista de los Impares:
7 -> 9 -> 5 -> 3 -> 1 -> null
