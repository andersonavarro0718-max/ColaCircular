
package colacircular;

// Ejemplo simple de Cola Circular usando librerías de Java
import java.util.LinkedList;
import java.util.Queue;

public class ColaCircularConLibreria {
    public static void main(String[] args) {
        // Creamos una cola usando LinkedList
        Queue<Integer> cola = new LinkedList<>();
        int capacidad = 5;  // Tamaño máximo permitido

        // Encolar elementos
        for (int i = 1; i <= capacidad; i++) {
            cola.offer(i * 10);  // agrega al final de la cola
            System.out.println("Se agregó: " + (i * 10));
        }

        System.out.println("Cola actual: " + cola);

        // Simular comportamiento circular:
        // Cuando sale uno, entra otro al final
        for (int i = 0; i < 3; i++) {
            int eliminado = cola.poll(); // saca el primero
            System.out.println("Se eliminó: " + eliminado);
            int nuevo = eliminado + 50;
            cola.offer(nuevo); // agrega al final
            System.out.println("Se agregó: " + nuevo);
            System.out.println("Cola ahora: " + cola);
        }
    }
}