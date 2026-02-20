
package com.mycompany.shellsort;


public class Radix {
    
    
     // Método principal que ejecuta Radix Sort
    public static void radixSort(int[] arr) {
        int max = getMax(arr);

        // Aplicar Counting Sort para cada dígito
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    // Obtener el número máximo del arreglo
    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // Counting Sort basado en el dígito actual
    private static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        // Contar ocurrencias
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }

        // Acumular posiciones
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Construir el arreglo ordenado (estable)
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Copiar al arreglo original
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    // Método para imprimir el arreglo sin usar Arrays
    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Método principal de prueba
    public static void main(String[] args) {
        int[] arr = {100, 55, 70, 90, 82, 24, 20, 60};

        System.out.println("Arreglo original:");
        printArray(arr);

        radixSort(arr);

        System.out.println("Arreglo ordenado:");
        printArray(arr);
    }
}

