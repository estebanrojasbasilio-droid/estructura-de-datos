package com.mycompany.Bublesort;

public class mergeshort {
    
    
    // Método principal que divide el arreglo
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            // Ordenar primera mitad
            mergeSort(array, left, middle);

            // Ordenar segunda mitad
            mergeSort(array, middle + 1, right);

            // Mezclar ambas mitades
            merge(array, left, middle, right);
        }
    }

    // Método que mezcla los subarreglos
    public static void merge(int[] array, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // Arreglos temporales
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copiar datos a los arreglos temporales
        for (int i = 0; i < n1; i++)
            leftArray[i] = array[left + i];

        for (int j = 0; j < n2; j++)
            rightArray[j] = array[middle + 1 + j];

        // Mezclar los arreglos temporales
        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copiar elementos restantes
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Método principal para probar
    public static void main(String[] args) {
        int[] array = {48, 27, 33, 30, 19, 82, 10};

        System.out.println("Arreglo original:");
        for (int num : array)
            System.out.print(num + " ");

        mergeSort(array, 0, array.length - 1);

        System.out.println("\nArreglo ordenado:");
        for (int num : array)
            System.out.print(num + " ");
    }
}
    

    

