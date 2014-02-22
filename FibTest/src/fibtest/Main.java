/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fibtest;

import java.util.Scanner;

/**
 *
 * @author 1003125
 */
public class Main {

    public static int fib(int n) {
        if (n <= 2) {
            return 1;
        }//if
        else {
            return fib(n - 1) + fib(n - 2);
        }//else
    }//fib method

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        n = scan.nextInt();
        System.out.println("The " + n + "th Fibonacci number is " + fib(n));
    }//main method
}//Main class

