package colacircular;

// Ejemplo simple de Cola Circular SIN usar librerías
public class ColaCircularSinLibreria {
    int tamaño;       // Tamaño máximo de la cola
    int[] cola;       // Arreglo que almacena los elementos
    int frente, finalCola;  // Punteros al frente y al final

    // Constructor: inicializa la cola
    public ColaCircularSinLibreria(int tamaño) {
        this.tamaño = tamaño;
        cola = new int[tamaño];
        frente = -1;
        finalCola = -1;
    }

    // Método para verificar si la cola está llena
    boolean estaLlena() {
        return (frente == 0 && finalCola == tamaño - 1) || (frente == finalCola + 1);
    }

    // Método para verificar si la cola está vacía
    boolean estaVacia() {
        return (frente == -1);
    }

    // Insertar elemento (Enqueue)
    void encolar(int valor) {
        if (estaLlena()) {
            System.out.println("La cola está llena");
            return;
        }

        // Si es el primer elemento
        if (frente == -1)
            frente = 0;

        // Mueve el puntero final circularmente
        finalCola = (finalCola + 1) % tamaño;
        cola[finalCola] = valor;

        System.out.println("Elemento " + valor + " agregado");
    }

    // Eliminar elemento (Dequeue)
    void desencolar() {
        if (estaVacia()) {
            System.out.println("La cola está vacía");
            return;
        }

        System.out.println("Elemento " + cola[frente] + " eliminado");

        // Si la cola queda vacía después de eliminar
        if (frente == finalCola) {
            frente = -1;
            finalCola = -1;
        } else {
            // Mueve el puntero frente circularmente
            frente = (frente + 1) % tamaño;
        }
    }

    // Mostrar todos los elementos
    void mostrar() {
        if (estaVacia()) {
            System.out.println("La cola está vacía");
            return;
        }

        System.out.print("Cola actual: ");
        int i = frente;
        while (true) {
            System.out.print(cola[i] + " ");
            if (i == finalCola)
                break;
            i = (i + 1) % tamaño;
        }
        System.out.println();
    }

    // Método principal para probar
    public static void main(String[] args) {
        ColaCircularSinLibreria cola = new ColaCircularSinLibreria(5);

        cola.encolar(10);
        cola.encolar(20);
        cola.encolar(30);
        cola.mostrar();
        cola.desencolar();
        cola.mostrar();
        cola.encolar(40);
        cola.encolar(50);
        cola.encolar(60); // Llenará la cola
        cola.mostrar();
    }
}