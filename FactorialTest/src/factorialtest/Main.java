/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factorialtest;

import java.util.Scanner;

/**
 *
 * @author 1003125
 */
public class Main {

    public static long factorial(int n) {
        if (n <= 1) {
            return 1;
        }//if
        else {
            return n * factorial(n - 1);
        }//else
    }//factorial method

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        n = scan.nextInt();
        System.out.println(n + "! = " + factorial(n));
    }
}
