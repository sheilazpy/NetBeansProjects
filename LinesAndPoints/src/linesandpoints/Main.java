/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package linesandpoints;

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
        int n, x, y, x1, y1, x2, y2, pointsOn, maxPointsOn = 0;
        double m, b, finalM = 0, finalB = 0;
        int[][] points;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter points: ");
        n = scan.nextInt();
        points = new int[n][2];
        for (int loop = 0; loop < n; loop++) {
            points[loop][0] = scan.nextInt();
            points[loop][1] = scan.nextInt();
        }//for
        for (int loop1 = 0; loop1 < n - 1; loop1++) {
            for (int loop2 = loop1 + 1; loop2 < n; loop2++) {
                x1 = points[loop1][0];
                y1 = points[loop1][1];
                x2 = points[loop2][0];
                y2 = points[loop2][1];
                m = (double) (y2 - y1) / (double) (x2 - x1);
                b = y1 - m * x1;
                pointsOn = 0;
                for (int loop = 0; loop < n; loop++) {
                    x = points[loop][0];
                    y = points[loop][1];
                    if (y == m * x + b) {
                        pointsOn++;
                    }//if
                }//for
                if (pointsOn > maxPointsOn) {
                    maxPointsOn = pointsOn;
                    finalM = m;
                    finalB = b;
                }//if
            }//for
        }//for
        System.out.println("y = " + finalM + " x + " + finalB);
        System.out.println(maxPointsOn + " points");
    }//main method
}//Main class

