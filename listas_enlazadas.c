/******************************************************************************

                            Online C Compiler.
                Code, Compile, Run and Debug C program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/
#ifndef libro_h
#define libro_h

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Libro {
    char titulo[50];
    char autor[50];
    char isbn[13];
    
} Libro;

/*Definimos una estrucutura como nodo que tiene una referencia al Libro*/
typedef struct Nodo{
    Libro libro; // Guarda un libro
    struct Nodo* siguiente;    // Guarda un puntero al siguiente elemento
} Nodo;

// Creamos otra estructura que guarda el puntero a la cabeza de esa lista
typedef struct Lista{
    Nodo* cabeza;
    int longitud; // Dice cuantos elementos tenemos en la lista (Cuando incremente se lo sumamos a esta varaible)(Cuando decremente se lo restamos a esta varaible )
}Lista;

// Crear un nuevo Nodo
Nodo* CrearNodo(libro libro){
   Nodo* nodo = (Nodo*)malloc(sizeof(Nodo)); // Instanciar un nuevo nodo usando la funcion malloc()
   strcpy(nodo->libro.titulo, libro->titulo,50);// Copia dentro del libro los datos de los parametros que se pasan del libro
   strcpy(nodo->libro.autor, libro->autor,50);
   strcpy(nodo->libro.isbn, libro->isbn,50);
   nodo -> siguiente = NULL; // Como no se sabe a que apunta el siguiente lo ponemos a apuntar a null
   return nodo
}

// Destruir un nodo que ya no queramos en memoria
void DestruirNodo(Nodo* nodo){
    free(nodo);
}

// Insertar un libro al principio de una lista
void InsertarPrincipio(Lista* lista, Libro* libro){
    *Nodo nodo = CrearNodo(libro); // Creamos un nuevo nodo a partir de los datos del libro
    nodo->siguiente = lista->cabeza;// Colocamos como cola del nodo que se acaba de crear la actual cabeza de la lista
    lista->cabeza = nodo;// Movemos el puntero de la cabeza de la lista para que apunte al nuevo nodo
    lista->longitud++;
}
// Insertar un libro al final de una lista
void InsertarFinal(Lista* lista, Libro* libro){ // Esta funcion no va a funcionar si la lisa esta vacia
    Nodo* nodo = CrearNodo(libro); //Creamos otro nodo
    if(lista->cabeza == NULL){
        lista->cabeza = nodo; //Se pociciona directamente como cabeza de la lista
    }else{
    Nodo* puntero = lista->cabeza;// Creamos un nodo especial al que va a hacer la cabeza de la lista
    // Hacemos que el puntero vaya de una pocision a otra hasta que alcnace el final de la lista
    while (puntero->siguiente){
        puntero = puntero->siguiente; // El puntero avanza en una pocision 
    }
        
    }
    // Ya sabemos que el puntero en el que estamos no tiene otro siguiente por ende ponemos el nodo que queremos insertar como el siguiente del nodo actual
    puntero->siguiente = nodo;
    lista->longitud++;
}
void InsertarDespues(int n, Lista* lista, Libro* libro){
    Nodo* nodo = CrearNodo(libro);
    if(lista->cabeza == NULL){// Lista vacia
        lista->cabeza = nodo;
        
    }else{
        // Debemos recorrer la lista hasta que lleguemos a la pocision anterior
        int pocision = 0;
        while(pocision < n && puntero->siguiente){
            puntero = puntero->siguiente;
            pocision++; //Cada vez que se recorra este contador aumenta
        }
        // Cuando tenemos el libro n en la pocision del puntero, debemos insertarlo despues
        nodo->siguiente = puntero->siguiente; //Conectamos por la derecha
        puntero->siguiente = nodo;// Conectamos por izquierda
        

    }
    lista->longitud++;
}

// Funcion que nos devuelve el libro que este en la pocision n de la lista 
Libro* Obtener(int n, Lista* lista){
    // Verificamos si la lista esta vacia
    if(lista->cabeza == NULL){
        return NULL
    }else{
        // Se hace algo parecido con la funcion anterior
        Nodo* puntero = lista->cabeza;
        int pocision = 0;
        while (pocision < n && puntero ->siguiente){
            puntero = puntero->siguiente; // Avanza hasta el elemento n
            pocision++;
        }
        
        // Cuando ya esta en el elemento n retorna el libro de esta pocision
        if (pocision != n){ // Este condicional lo que hace es retornar null si la pocision no es la misma que n por que n es mayor
            return NULL;
        }else{
        return &puntero->libro;}
    }
}
// Saber cuantos elementos tengo en la lista
int Contar(Lista* lista){
    return lista->longitud;
}

// ELIMINAR ELEMENTOS DE LA LISTA
int EstaVacia(Lista* lista){ //Determina si la lista esta vacia
    return lista->cabeza == NULL; // Devuelve 0 si la lista esta vacia o 1 si tiene cabeza
}
void EliminarPrincipio(Lista* lista){
    if(lista->cabeza){ // Se ejecuta cuando la lista NO esta vacia
        Nodo* eliminado = lista->cabeza; // Se guarda la cabeza que se va a eliminar
        lista->cabeza = lista->cabeza->siguiente; // El siguiente nodo de la cabeza pasa a hacer la cabeza
        DestruirNodo(eliminado) // Se elimina el nodo que guardamos
        lista->longitud--; //Decrementamos la longitud de la lista
    }
        
}

void EliminarUltimo(Lista* lista){
    if(lista->cabeza){ 
        if(lista->cabeza->siguiente){ //Sirve para cuando la lista tiene mas de un elemento
            Nodo* puntero = lista->cabeza;
            while(puntero->siguiente->siguiente){ //Llegamos al penultimo elemento de la lista cuando el siguiente del siguiente valga nulo 
                puntero = puntero->siguiente;
            
            }
            // Cuando llegamos a la penultima pocision eliminamos el ultimo nodo
            Nodo* elimiando = puntero->siguiente; // Guardamos el nodo que queremos eliminar
            puntero->siguiente = NULL; // Hacemos que el penultimo nodo ahora apunte a null lo que lo convierte en el ultimo
            DestruirNodo(eliminado) //Destruimos el nodo
            lista->longitud--;
    }else{ // Se ejecuta si la lista solo tiene un elemento
        // Se elimina la cabeza de la lista
        Nodo* eliminado = lista->cabeza;
        lista->cabeza = NULL;
        DestruirNodo(eliminado);
        lista->longitud--;
    }
}
}

void EliminarElemento(int n, Lista* lista){
    if(lista->cabeza){
        if(n == 0){ // Si se quiere eliminar el primer elemento
            Nodo* eliminado = lista->cabeza; // Se guarda la cabeza que se va a eliminar
            lista->cabeza = lista->cabeza->siguiente; // El siguiente nodo de la cabeza pasa a hacer la cabeza
            DestruirNodo(eliminado) // Se elimina el nodo que guardamos
            lista->longitud--; //Decrementamos la longitud de la lista
            
        }else if (n<lista->longitud){ // Nos aseguramos de que n sea menor a los libros que tenemos en la lista
            Nodo* puntero = lista->cabeza;
            int pocision = 0;
            while(pocision<(n-1)){ // Recorremos la lista hasta llegar al nodo siguiente
                puntero = puntero->siguiente;
                pocision++;
            }
        
            // Una vez llegamos eliminamos el nodo siguiente
            Nodo* eliminado = puntero->siguiente;
            puntero->siguiente = eliminado->siguiente; // Conectamos el nodo siguiente del anterior con el siguiente que se va a eliminar
            DestruirNodo(elminado);
            lista->longitud--;
    }
    }
}
#endif /* libro_h */


