/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;

/**
 *
 * @author Dell
 */
public class MySort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] numbers;
        int length, trials, smallest, largest, position, statements = 0;
        Scanner keyboard = new Scanner(System.in);
        Random random;
        System.out.print("Enter the number of random numbers to be generated:  ");
        length = keyboard.nextInt();
        System.out.print("Enter the number of times to repeat the experiment:  ");
        trials = keyboard.nextInt();
        numbers = new int[length];
        for (int n = 0; n < trials; n++) { //Sort n random lists and average statements
            random = new Random();
            for (int loop = 0; loop < length; loop++) {
                numbers[loop] = random.nextInt();
            } //for (int loop = 0; loop < length; loop++)
            for (int loop = 0; loop < length - 1; loop++) {
                smallest = numbers[loop];
                position = loop;
                statements += 3;
                for (int search = loop + 1; search < length; search++) {
                    statements += 2;
                    if (numbers[search] < smallest) {
                        smallest = numbers[search];
                        position = search;
                        statements += 2;
                    } //if (numbers[search] < smallest)
                } //for (int search = loop + 1; search < length; search++)
                numbers[position] = numbers[loop];
                numbers[loop] = smallest;
                statements += 2;
            } //for (int loop = 0; loop < length - 1; loop++)
        } //for (int n = 0; n < trials; n++)
        System.out.println("\nThe average number of statements to sort a random list was " + statements / trials);
        statements = 0;
        for (int loop = 0; loop < length - 1; loop++) { //Resort already sorted list
            smallest = numbers[loop];
            position = loop;
            statements += 3;
            for (int search = loop + 1; search < length; search++) {
                statements += 2;
                if (numbers[search] < smallest) {
                    smallest = numbers[search];
                    position = search;
                    statements += 2;
                } //if (numbers[search] < smallest)
            } //for (int search = loop + 1; search < length; search++)
            numbers[position] = numbers[loop];
            numbers[loop] = smallest;
            statements += 2;
        } //for (int loop = 0; loop < length - 1; loop++)
        System.out.println("The number of statements to sort a sorted list was " + statements);
        statements = 0;
        for (int loop = 0; loop < length - 1; loop++) { //Sort list descending
            largest = numbers[loop];
            position = loop;
            statements += 3;
            for (int search = loop + 1; search < length; search++) {
                statements += 2;
                if (numbers[search] > largest) {
                    largest = numbers[search];
                    position = search;
                    statements += 2;
                } //if (numbers[search] > largest)
            } //for (int search = loop + 1; search < length; search++)
            numbers[position] = numbers[loop];
            numbers[loop] = largest;
            statements += 2;
        } //for (int loop = 0; loop < length - 1; loop++)
        System.out.println("The number of statements to sort an inverse sorted list was " + statements);
    } //public static void main(String[] args)
} //public class MySort
