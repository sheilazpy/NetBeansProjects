/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadedSearch;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the size of the array to test: ");
        int numberOfElements = keyboard.nextInt();
        int[] crazy = new int[numberOfElements];
        System.out.println();
        System.out.print("Enter a number to search for: ");
        int searchValue = keyboard.nextInt();
        System.out.println();
        System.out.print("Enter the number of threads to use: ");
        int threadCount = keyboard.nextInt();
        System.out.println();
        Random randomInt = new Random(1393);

        for (int i = 0; i < numberOfElements; i++) {
            crazy[i] = randomInt.nextInt(numberOfElements);
        }
        SequentialSearchThreaded[] threads = new SequentialSearchThreaded[threadCount];
        for (int i = 0; i < threadCount; i++) {
            threads[i] = new SequentialSearchThreaded(crazy, searchValue, i * numberOfElements / threadCount,
                    (i + 1) * numberOfElements / threadCount - 1, i + 1);
            threads[i].start();
        }
    }
}
