
package com.mycompany.shellsort;

import java.util.Arrays;

public class RadixSort {
    
    // Método principal que ejecuta Radix Sort
    public static void radixSort(int[] arr) {
        // Encontrar el número máximo para saber cuántos dígitos tiene
        int max = getMax(arr);

        // Aplicar Counting Sort para cada dígito
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    // Método para obtener el valor máximo del arreglo
    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    // Counting Sort basado en el dígito representado por exp
    private static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n]; // Arreglo de salida
        int[] count = new int[10]; // Dígitos del 0 al 9

        // Contar ocurrencias de cada dígito
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }

        // Cambiar count[i] para que contenga la posición real
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Construir el arreglo de salida (de atrás hacia adelante para estabilidad)
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Copiar el arreglo ordenado al original
        System.arraycopy(output, 0, arr, 0, n);
    }

    // Método de prueba
    public static void main(String[] args) {
        int[] arr = {100, 55, 70, 90, 82, 24, 20, 60};

        System.out.println("Arreglo original:");
        System.out.println(Arrays.toString(arr));

        radixSort(arr);

        System.out.println("Arreglo ordenado:");
        System.out.println(Arrays.toString(arr));
    }
}
