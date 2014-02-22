/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package makeuniquetest;

import java.util.Scanner;

/**
 *
 * @author 1003125
 */
public class Main {

    public static Object[] makeUnique(Object[] stuff) {
        int n = (Integer) stuff[0];
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stuff[i].equals(stuff[j])) {
                    for (int loop = j; loop < n; loop++) {
                        stuff[loop] = stuff[loop + 1];
                    }//for
                    n--;
                }//if
            }//for
        }//for
        stuff[0] = n;
        return stuff;
    }//makeUnique method

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Object item;
        Object[] items = new Object[100];
        int count = 1;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a list ('stop' to quit): ");
        item = scan.next();
        while (!item.equals("stop")) {
            items[count] = item;
            count++;
            item = scan.next();
        }//while
        items[0] = count;
        items = makeUnique(items);
        System.out.println("The list without repeats: ");
        for (int i = 1; i < (Integer) items[0]; i++) {
            System.out.println(items[i]);
        }//for
    }//main method
}//Main class

