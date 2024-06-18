/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class Trabajo{
    private String titulo;
    private String autor;
    private boolean impreso;
    public Trabajo(String titulo, String autor){
        this.titulo = titulo;
        this.autor = autor;
        this.impreso = false;
        
    }
    
    public String getTitulo(){
        return titulo;
        
    }
    
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    public String getAutor(String autor){
        return autor;
        
    }
    
    public void setAutor(String autor){
        this.autor = autor;
    }
    
    public boolean isImpreso(){
        return impreso;
    }
    
    public void setImpreso(boolean impreso){
        this.impreso = impreso;
    }
    
}

public interface ColaProceso {
    // Encolar un Trabajo
    void encolar(Trabajo t);
    // Eliminar la cabeza
    void eliminar();
    // Encontrar la cabeza
    Trabajo obtener();
}

public class MiColaProceso implements ColaProceso{
    private class NodoProceso{ // Indica que es un nodo dentro de la cola proceso
        public Trabajo trabajo;
        public NodoProceso siguiente;
        public NodoProceso(Trabajo trabajo){
            this.trabajo = trabajo;
            thid.siguiente = null;
        }
    }
    // Creamos los nodos mas importantes
    private NodoProceso cabeza, ultimo;
    
    // Encolar 
    public void encolar(Trabajo t){
        // Si la cabeza esta vacia se construye un nuevo NodoProceso
        NodoProceso nuevoNodo = new NNodoProceso(t);
        if (cabeza == null){
            // Hacemos que la cabeza apunte al nodo recien creado
            cabeza = nuevoNodo;
            ultimo = nuevoNodo; // Como es el unico elemento tambien debe ser el ultimo
        }else{
            // Agregamos el nuevo nodo despues del ultimo de la cola
            ultimo.siguiente = nuevoNodo;
            
        }
        // Sobreescribimos la variable ultimo para que apunte al nuevo elemento que acabamos de crear
            ultimo = nuevoNodo;
    }
    // Obtener el valor que esta en la cabeza de la cola
    public Trabajo obtener(){
        if (cabeza == null){
            return null; // Si esta vacia retornamos null
        }else{
            return cabeza.trabajo; // Si no esta vacia retornamos la cabeza de la cola
        }
    }
    
    // Eliminar cabeza de la cola
    public void eliminar(){
        // Comprobamos que la cabeza no este vacia
        if (cabeza != null){
            // Hacemos que ahora la cabeza sea el siguiente elemento
            NodoProceso eliminar = cabeza; // Mantenemos una referencia al nodo que se va a eliminar
            cabeza = cabeza.siguiente; // Hacemos que la cabeza apunte al siguiente elemento
            eliminar.siguiente = null; //Eliminamos el pubtero
            if (cabeza == null){ // Si la cabeza apunta a null
                ultimo = null; // Hacemos que el ultimo tambien apunte a null
            } 
            
        }
    }
}