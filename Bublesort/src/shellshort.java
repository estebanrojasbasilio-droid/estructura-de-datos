package com.mycompany.Bublesort;
 
public class shellshort {
  


    public static void Shell(int[]arr, int j){
        int n = arr.length;
        for (int gap  = n /2; gap> 0; gap /=2){
            for (int i = gap ; i< n; i++){
                int temp = arr[j];
                int j = i;
                while (j>= gap &&arr[j-gap]>temp){
                    arr[j]=arr[j-gap];
                    j-=gap;
                }
                arr[j]=temp;
            }
        }
    }
}

    

