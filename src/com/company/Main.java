package com.company;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[]{0,12,21,38,2,6,8,24};
        printArr(insertionSort(array));
    }
    public static int[] insertionSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            for (;( j >= 0  && arr[j] > key);j--) {
                arr[j+1] = arr[j];
            }
            arr[j+1] = key;
        }
        return arr;
    }
    public static void printArr(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
