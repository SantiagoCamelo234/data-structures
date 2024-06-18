/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
// Listas enlazadas
// Estructura del libro
public class Libro{
    private String titulo;
    private String autor;
    private String isbn;
    
    public Libro(String titulo, String autor, String isbn){
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn; 
    }
    
    public String getTitulo(){return titulo;}
    public void setTitulo(String titulo){ this.titulo = titulo;}
    public String getAutor(){return autor;}
    public void setAutor(String autor){this.autor = autor;}
    public String getIsbn(){return isbn;}
    public void setIsbn(String isbn){this.isbn = isbn;}
}

public class Lista{
    private Nodo cabeza = null; // Mantiene una referencia a la cabeaz de la lista
    private int longitud = 0;
    // Estructura Interna
    private class Nodo {
        private Libro libro; // Referencia al libro que tenga asociado el nodo
        public Nodo siguiente = null; // Referencia al nodo siguiente de la lista
        // Java elimina automaticamente los nodos que no utilicemos
        public Nodo(Libro libro){
            this.libro = libro;
        }
    }
    
    // Insertar al principio de la lista
    public void insertarPrincipio(Libro libro){
        // Creamos un nuevo Nodo
        Nodo nodo = new Nodo(libro);
        // Hacemos que lo que era la cabeza de la lista se vuelva el nodo siguiente del elemento que acabamos de crear
        nodo.siguiente = cabeza;
        cabeza = nodo;
        longitud++;
    }
    
    // Insertar al final de una lista
    public void insertarFinal(Libro libro){
        // Recorrer una lista
        Nodo nodo = new Nodo(libro); // Nodo que vamos a crear
        Nodo puntero = cabeza // Este puntero al principio va a ir en la cabeza de la lista
        while(puntero.siguiente != null){ // Itera mientras el puntero siguiente no sea nulo
            puntero = puntero.siguiente; // El puntero avanza por toda la lista
        }
        // Cuando ya el siguiente elemento del puntero valga null hacemos que ahora valga el elemento que acabamos de crear
        puntero.siguiente = nodo;
        longitud++;
        
    }
    // Insertar un elemento en la mitad de la lista
    public void insertarDespues(int n, Libro libroi){
        // Creamos el nuevo nodo
        Nodo nodo = new Nodo(libro);
        // Comprobamos que la lista no este vacia
        if (cabeza == null){
            cabeza = nodo
        }else{
            // Recorremos la lista y localizamos el numero n
            Nodo puntero = cabeza // Este puntero al principio va a ir en la cabeza de la lista
            int contador = 0; // Introducimos un contador que nos de la pocision de cada elemento de la lista
            while(contador < n && puntero.siguiente != null){ 
                puntero = puntero.siguiente;
                contador++; // Cada vez que pase a otro puntero el contador aumenta
            }
            
            nodo.siguiente = puntero.siguiente; // Conectamos el nodo recien creado con la lista por la derecha
            puntero.siguiente = nodo; // Conectamos el nodo recien creado por la izquierda
            
        }
        longitud++;
    }
    
    // Obtener informacion de un libro dada una pocision en la lista
    public Libro obtener(int n){
        if (cabeza == null){// Comprobamos si la lista esta vacia
            return null; // No se puede retornar nada si la lista esta vacia
        }else{
            Nodo puntero = cabeza // Este puntero al principio va a ir en la cabeza de la lista
            int contador = 0; // Introducimos un contador que nos de la pocision de cada elemento de la lista
            while(contador < n && puntero.siguiente != null){ 
                puntero = puntero.siguiente;
                contador++; // Cada vez que pase a otro puntero el contador aumenta
            }
            if (contador != n){//Si despues del bucle contador no vale lo que vale n
                return null; // Hemos alcanzado el final de la lista de forma permatura
            }else {
                return puntero.libro; // Retorna el libro que esta en la pocision n
            }
                
        }
            
        }
        
        // Funcion para que nos diga cuantos elementos hay en nuestra lista
        public int contar(){
            return longitud;
        }
        
        // ELIMINAR ELEMENTOS DE LA lista
        // Booleano que muestra si la lista esta vacia o no
        public boolean estaVacia(){
            return cabeza == null;
        }
        // Elimianr primer elemento de la lista
        public void eliminarPrimero(){
            if (cabeza != null){ // Solo podemos eliminar cosas si la lista no esta vacia
                Nodo primer = cabeza; // El primer elemento de la lista es la cabeza
                // Hacemos que la cabea en vez de apuntar al primero apunte al segundo
                cabeza = cabea.siguiente;
                // Hacemos que el nodo que quitamos apunte a null
                primer.siguiente = null;
                longitud--;
            }
        }
        
        // Eliminar un elemento que este al final de la lista
        public void eliminarUltimo(){
            // Debemos recorrer la lista hasta alcanzar el penultimo elemento
            if(cabeza != null){
                // Si la lista solo tiene un elemento
                if (cabeza.siguiente == null){
                    // Eliminamos el unico elemento que queda en la lista
                    cabeza = null;
                }else{
                Nodo puntero = cabeza;
                // Llegaremos al penultimo elemento cuando el siguiente de su siguiente sea null
                while(puntero.siguiente.siguiente != null){
                    puntero = puntero.siguiente;
                }
                // Eliminamos la referencia con el penultimo
                puntero.siguiente = null;
                longitud--;
                } 
            }
        }
        
        // Eliminar un libro en una pocision
        public void eliminarLibro(int n){
            // Comprobamos que la lista no este vacia
            if(cabeza != null){
                // Eliminar el primer libro
                if (n == 0){
                    Nodo primer = cabeza;
                    cabeza = cabeza.siguiente;
                    primer.siguiente = null;
                    longitud--;
                }else (n< longitud){
                    Nodo puntero = cabeza;
                    int contador = 0;
                    while (contador < (n-1)){
                        puntero = puntero.siguiente;
                        contador++;
                    }
                    Nodo temp = puntero.siguiente // Lo marcamos como elemento que queremos descartar
                    // Lo conectamos por izquierda y derecha a la lista
                    puntero.siguiente = temp.siguiente // Marca al siguiente nodo que queremos descartar
                    temp.siguiente = null; // Eliminamos la referencia
                    longitud --;
            }
        }
    }
}

