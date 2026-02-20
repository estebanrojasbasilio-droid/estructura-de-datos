
package com.mycompany.shellsort;


public class QuickSort {
    
    // Método principal que ejecuta el programa
    public static void main(String[] args) {
        int[] arreglo = {10, 7, 8, 9, 1, 5};

        System.out.println("Arreglo original:");
        imprimirArreglo(arreglo);

        quickSort(arreglo, 0, arreglo.length - 1);

        System.out.println("\nArreglo ordenado:");
        imprimirArreglo(arreglo);
    }

    // Método QuickSort
    public static void quickSort(int[] arreglo, int inicio, int fin) {
        if (inicio < fin) {
            int indicePivote = particion(arreglo, inicio, fin);

            // Ordena los elementos antes y después del pivote
            quickSort(arreglo, inicio, indicePivote - 1);
            quickSort(arreglo, indicePivote + 1, fin);
        }
    }

    // Método para particionar el arreglo
    public static int particion(int[] arreglo, int inicio, int fin) {
        int pivote = arreglo[fin]; // Tomamos el último elemento como pivote
        int i = (inicio - 1);

        for (int j = inicio; j < fin; j++) {
            if (arreglo[j] <= pivote) {
                i++;

                // Intercambio arreglo[i] y arreglo[j]
                int temp = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = temp;
            }
        }

        // Intercambio arreglo[i+1] y arreglo[fin] (pivote)
        int temp = arreglo[i + 1];
        arreglo[i + 1] = arreglo[fin];
        arreglo[fin] = temp;

        return i + 1;
    }

    // Método para imprimir el arreglo
    public static void imprimirArreglo(int[] arreglo) {
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
    
