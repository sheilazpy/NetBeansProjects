/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package countrepeats;

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
        int[][] numbers = new int[100][2];
        boolean found;
        int number, count = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a list of numbers (end with -1):");
        number = scan.nextInt();
        while (number != -1) {
            found = false;
            for (int i = 0; i < count; i++) {
                if (number == numbers[i][0]) {
                    numbers[i][1]++;
                    found = true;
                    break;
                }//if
            }//for
            if (!found) {
                numbers[count][0] = number;
                numbers[count][1]++;
                count++;
            }//if
            number = scan.nextInt();
        }//while
        System.out.println("Number  Frequency");
        for (int i = 0; i < count; i++) {
            System.out.printf("%1$-8S %2$S", numbers[i][0] + " ", numbers[i][1]);
            System.out.println();
        }//for
    }//main method
}//Main class

