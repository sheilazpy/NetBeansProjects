/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package superancestry;

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
        String[][] names;
        String[] parents;
        int number, pos=0;
        boolean test;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number: ");
        number = scan.nextInt();
        names = new String[number][2];
        parents=new String[number];
        System.out.println("Enter names:  ");
        for (int i = 0; i < number; i++) {
            names[i][0] = scan.next();
            names[i][1] = scan.next();
        }//for
        for (int i = 0; i < number; i++) {
            test = true;
            for (int j = 0; j < number; j++) {
                if (names[i][0].equals(names[j][1])) {
                    test = false;
                }//if
            }//for
            for(int loop=0;loop<number;loop++)
            {
                if(names[i][0].equals(parents[loop]))
                {
                    test=false;
                    break;
                }//if
            }//for
            if (test) {
                parents[pos]=names[i][0];
                pos++;
                System.out.println(names[i][0]);
            }//if
        }//for
    }//main method
}//Main class

