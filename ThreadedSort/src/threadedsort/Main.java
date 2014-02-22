/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threadedsort;

import java.util.*;

/**
 *
 * @author Dell
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int startSize, increment, numTests, size;
        long startTime, endTime;
        Integer[] list, listCopy;
        Random random = new Random(314159);
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the size of the array to sort:  ");
        size = keyboard.nextInt();
        list = new Integer[size];
        listCopy = new Integer[size];
        for (int i = 0; i < size; i++) {
            list[i] = random.nextInt();
            listCopy[i] = list[i];
        }
        startTime = System.currentTimeMillis();
        InsertionSort.sort(listCopy);
        endTime = System.currentTimeMillis();
        System.out.println("Insertion Sort Runtime: " + (endTime - startTime));
        for (int i = 0; i < size; i++) {
            listCopy[i] = list[i];
        }
        startTime = System.currentTimeMillis();
        QuickSort.sort(listCopy);
        endTime = System.currentTimeMillis();
        System.out.println("Quick Sort Runtime: " + (endTime - startTime));
        for (int i = 0; i < size; i++) {
            listCopy[i] = list[i];
        }
        startTime = System.currentTimeMillis();
        QuickSortThreaded.sort(listCopy);
        endTime = System.currentTimeMillis();
        System.out.println("Threaded Quick Sort Runtime: " + (endTime - startTime));
        for (int i = 0; i < size; i++) {
            listCopy[i] = list[i];
        }
        startTime = System.currentTimeMillis();
        QuickSort4Threaded.sort(listCopy);
        endTime = System.currentTimeMillis();
        System.out.println("4 Threaded Quick Sort Runtime: " + (endTime - startTime));
    }
}
