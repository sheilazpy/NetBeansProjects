/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testsort;

import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] numbers;
        int length, smallest, position;
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the number of elements of the list:  ");
        length = keyboard.nextInt();
        numbers = new int[length];
        System.out.print("Enter the list of numbers:  ");
        for (int loop = 0; loop < length; loop++) {
            numbers[loop] = keyboard.nextInt();
        } //for (int loop = 0; loop < length; loop++)
        for (int loop = 0; loop < length - 1; loop++) {
            smallest = numbers[loop];
            position = loop;
            for (int search = loop + 1; search < length; search++) {
                if (numbers[search] < smallest) {
                    smallest = numbers[search];
                    position = search;
                } //if (numbers[search] < smallest)
            } //for (int search = loop + 1; search < length; search++)
            numbers[position] = numbers[loop];
            numbers[loop] = smallest;
        } //for (int loop = 0; loop < length - 1; loop++)
        System.out.println("The list of numbers in order:");
        for (int loop = 0; loop < length; loop++) {
            System.out.println(numbers[loop]);
        } //for (int loop = 0; loop < length; loop++)
    }
}
