public class miPila implements Pila {

    private class Nodo{ // Definimos el nodo
        public URL url;
        public Nodo siguiente = null;

        public Nodo(URL url){
            this.url = url;
            
        }
    }

    // Mantenemos el nodo que esta a la cabeza
    private Nodo cima = null;

    // Longitud de la pila
    private int longitud =  0;

    // Poner un nuevo nodo a la cabeza de la pila
    @Override
    void apilar(URL url){
        Nodo nodo = new Nodo(url); // Creamos el nodo
        nodo.siguiente = cima; // Insertamos el nodo que creamos en la pila
        cima = nodo; // Hacemos que la cima sea lo que acabamos de crear
        longitud++;
    };
    // Operacion para elminar un elemento de la pila
    void desapilar(){
        // Comprobamos que la fila no este vacia
        if (cima != null){
            // Almaenamos el nodo que se va a eliminar
            Nodo eliminar = cima;
            cima = cima.siguiente; // Ahora la cima va a ser lo siguiente que habia despues del nodo que eliminamos
            eliminar.siguiente = null;// Hacemos que el siguiente del nodo que eliminamos apunte a null
            longitud--;
        }
    };
    // Operacion para obtener el valor que esta en la cima
    URL obtener(){
        // Primero verificamos si hay cosas en la cima
        if(cima == null){
            return null;
        } else {
            // Devolvemos la url que este almacenada en la cima 
            return cima.url;
        }
    };
    // Dice cuantos elementos hay en mi pila
    int longitud(){
        return longitud;
    };
    boolean vacio(){
        return longitud == 0;
    };

    private static void imprimirEstado(Pila pila){ // Imprime la url que esta en la cabeza de mi pila
        if(pila.vacia()){
            System.out.print('No hay valores en la pila');
        }else{
            System.out.print('L' + pila.longitud() + ' ' + pila.obtener().getUrl()) // Devuelve la longitud y la url que esta en la cabeza de la pila
        }
    };
}
