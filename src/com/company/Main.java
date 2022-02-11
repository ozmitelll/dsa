package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] array = generateAnArray();
        int[] sortedArray = sort(Main::bubbleSortImpl, array);
        System.out.println("your array has elements printed below:");
        printAnArray(sortedArray);

        int searchFor = promptTheUserToEnterADigit("enter a digit to search for");
        int indexOfSearchFor = find(Main::binarySearchImpl, searchFor, array);
        System.out.println("index of at element " + indexOfSearchFor);

        int firstIndexOf = firstIndexOf(Main::binarySearchImpl, searchFor, array);
        System.out.println("first index of an element: " + firstIndexOf);
    }

    private static int promptTheUserToEnterADigit(String s) {
        System.out.println(s);
        Scanner digit = new Scanner(System.in);
        int numb = digit.nextInt();
        return numb;
    }

    private static int[] sort(Sortable sortable, int[] array) {
        return sortable.sort(array);
    }

    private static int find(Findable findable, int searchFor, int[] array) {
        return findable.find(searchFor, array);
    }

    private static void printAnArray(int[] sortedArray) {
        for (int i = 0; i < sortedArray.length; i++) {
            System.out.print(sortedArray[i] + " ");
        }
        System.out.println();
    }

    public static int[] generateAnArray() {
        System.out.println("Write size array: ");
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        System.out.println("Write a minimal value of array: ");
        int min = input.nextInt();
        System.out.println("Write a maximal value of array: ");
        int max = input.nextInt();
        int[] array = new int[size];
        Random random = new Random();
        System.out.println("You random array: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
            System.out.print(array[i] + " ");

        }
        System.out.println();
        return array;
    }

    public static int[] bubbleSortImpl(int[] array) {
        int n = array.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (array[j - 1] > array[j]) {
                    swap(array, j, j-1);
                }
            }
        }
        return array;
    }

    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < array.length; j++)
                if (array[j] < array[min_idx]) {
                    min_idx = j;
                    swap(array, i, min_idx);
                }
        }
        return array;
    }

    public static int binarySearchImpl(int searchFor, int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (array[middle] == searchFor) {
                return middle;
            }
            if (array[middle] > searchFor) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

    public static int firstIndexOf(Findable findable, int searchFor, int[] array) {
        int index = findable.find(searchFor, array);
        for (int i = index; i>=0; i--){
            if(array[i] == searchFor){
                index = i;
            } else {
                break;
            }
        }
        return index;

    }
    public static void swap(int[] array, int firstIndex, int secondIndex){
        int temp = array[secondIndex];
        array[secondIndex] = array[firstIndex];
        array[firstIndex] = temp;
    }






}
