/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package meanmedianmode;

import java.util.Scanner;

/**
 *
 * @author 1003125
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] numbers = new int[100];
        double mean = 0, median;
        int number, count = 0, reps = 0, maxReps = 2, pos;
        int[] mode;
        boolean test = false;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a list of numbers (end with -1):");
        number = scan.nextInt();
        while (number != -1) {
            mean += number;
            pos = 0;
            while (pos < count) {
                if (number < numbers[pos]) {
                    break;
                }//if
                pos++;
            }//while
            for (int i = count; i > pos; i--) {
                numbers[i] = numbers[i - 1];
            }//for
            numbers[pos] = number;
            count++;
            number = scan.nextInt();
        }//while
        mean /= count;
        System.out.println("Mean: " + mean);
        if (count % 2 == 0) {
            median = (numbers[count / 2 - 1] + numbers[count / 2]) / 2.0;
        }//if
        else {
            median = numbers[count / 2];
        }//else
        System.out.println("Median: " + median);
        mode = new int[count];
        for (int i = 0; i < count; i++) {
            mode[i] = -1;
        }//for
        number = numbers[0];
        pos = 0;
        for (int i = 0; i <= count; i++) {
            if (numbers[i] == number) {
                reps++;
            }//if
            else {
                if (reps > maxReps) {
                    maxReps = reps;
                    for (pos = 0; pos < count; pos++) {
                        mode[pos] = -1;
                    }//for
                    mode[0] = number;
                    pos = 1;
                }//if
                else if (reps == maxReps) {
                    mode[pos] = number;
                    pos++;
                }//if
                number = numbers[i];
                reps = 1;
            }//else
        }//for
        System.out.print("Mode: ");
        if (mode[0] == -1) {
            System.out.println("none");
        }//if
        for (int i = 0; i < count; i++) {
            if (mode[i] != -1) {
                System.out.print(mode[i] + "  ");
            }//if
        }//for
        System.out.println();
    }//main method
}//Main class

