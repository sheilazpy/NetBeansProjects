 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package percentile;

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
        String[] names = new String[100];
        double[] scores = new double[100];
        double percentile, percent;
        String name;
        int count = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a list of names and scores ('stop' to end):");
        name = scan.next();
        while (!name.equals("stop")) {
            names[count] = name;
            scores[count] = scan.nextDouble();
            name = scan.next();
            count++;
        }//while
        System.out.println("Name  Score  Percentile");
        for (int i = 0; i < count; i++) {
            percent = 0;
            for (int j = 0; j < count; j++) {
                if (scores[i] >= scores[j]) {
                    percent++;
                }//if
            }//for
            percentile = percent / count * 100.0;
            System.out.println(names[i] + "   " + scores[i] + "   " + percentile);
        }//for
    }//main method
}//main class

