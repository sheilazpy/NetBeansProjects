/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clockhands;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author 1003125
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int hours, minutes;
        double angle, hAngle, mAngle;
        String input;
        StringTokenizer time;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter time: ");
        input = scan.next();
        time = new StringTokenizer(input, ":");
        hours = (int) Double.parseDouble(time.nextToken());
        minutes = (int) Double.parseDouble(time.nextToken());
        hAngle = hours * 30 + minutes / 2;
        mAngle = minutes * 6;
        angle = Math.abs(hAngle - mAngle);
        if (angle > 180) {
            angle = 360 - angle;
        }//if
        System.out.println(angle);
    }//main method
//Main class
}
