/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package piexpansion;

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
        double piApprox = 0;
        int terms;
        Scanner scan = new Scanner(System.in);
        System.out.println("Terms: ");
        terms = scan.nextInt();
        for (int loop = 0; loop <= terms; loop++) {
            piApprox += Math.pow(-1, loop) / (2 * loop + 1);
        }//for
        piApprox *= 4;
        System.out.println("Using " + terms + " terms, the approximation of PI is " + piApprox);
    }//main method
}//Main class

