/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package unique;

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
        String name;
        String[] names = new String[100];
        int count = 0;
        boolean found = false;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a name ('stop' to quit): ");
        name = scan.next();
        while (!name.equals("stop")) {
            for (int i = 0; i < count; i++) {
                if (name.equals(names[i])) {
                    System.out.println(name + " was previously entered");
                    found = true;
                    break;
                }//if
            }//for
            if (!found) {
                System.out.println(name + " was not previously entered");
                names[count] = name;
                count++;
            }//if
            System.out.println("Enter a name ('stop' to quit): ");
            name = scan.next();
            found = false;
        }//while
    }//main method
}//Main class

