/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package channelingwifi;

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
        StringBuffer houses = new StringBuffer("A A A A A A A A A A");
        int[][] pairs;
        int number;
        char interfere;
        boolean swap = true;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number: ");
        number = scan.nextInt();
        pairs = new int[number][2];
        System.out.println("Enter interfering pairs: ");
        for (int i = 0; i < number; i++) {
            pairs[i][0] = scan.nextInt();
            pairs[i][1] = scan.nextInt();
        }//for
        while (swap) {
            swap=false;
            for (int i = 0; i < number; i++) {
                interfere=houses.charAt(pairs[i][1] * 2);
                if (houses.charAt(pairs[i][0] * 2) == interfere) {
                    swap = true;
                    if (interfere < 'C') {
                        houses.setCharAt(pairs[i][1] * 2, (char) (interfere + 1));
                    }//if
                    else {
                        houses.setCharAt(pairs[i][1] * 2, (char) (interfere - 1));
                    }//else
                }//if
            }//for
        }//while
        System.out.println(houses.toString());
    }//main method
}//Main class
