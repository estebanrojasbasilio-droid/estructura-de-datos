package com.mycompany.shellsort;


public class ShellSort {
    
    // Método que implementa el algoritmo ShellSort
    public static void shellSort(int[] arreglo) {
        int n = arreglo.length;

        // Inicializamos el salto (gap)
        for (int gap = n / 2; gap > 0; gap /= 2) {

            // Recorremos los elementos desde el gap hasta el final
            for (int i = gap; i < n; i++) {
                int temp = arreglo[i];
                int j;

                // Ordenamos los elementos separados por el gap
                for (j = i; j >= gap && arreglo[j - gap] > temp; j -= gap) {
                    arreglo[j] = arreglo[j - gap];
                }

                arreglo[j] = temp;
            }
        }
    }

    // Método para imprimir el arreglo
    public static void imprimirArreglo(int[] arreglo) {
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Método principal
    public static void main(String[] args) {
        int[] datos = {44, 18,54, 31, 22, 32};

        System.out.println("Arreglo original:");
        imprimirArreglo(datos);

        shellSort(datos);

        System.out.println("Arreglo ordenado:");
        imprimirArreglo(datos);
    }
}

