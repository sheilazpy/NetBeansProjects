/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package findairport;

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
        double angle, distance, totalDistance = 0;
        int flights = 0;
        Airplane plane, airport;
        Scanner scan = new Scanner(System.in);
        do {
            plane = new Airplane();
            airport = new Airplane();
        } while (plane.distanceAway(airport) < 100);
        do {
            if (totalDistance >= 1000) {
                System.out.println("You are " + Math.round(plane.distanceAway(airport) * 10.0) / 10.0 +
                        " miles away from the airport.");
                System.out.println("You ran out of gas and crash landed.");
                break;
            }//if
            System.out.println("You are " + Math.round(plane.distanceAway(airport) * 10.0) / 10.0 +
                    " miles away from the airport.");
            System.out.println("You have enough gas to go " + (1000 - totalDistance) + " more miles.");
            System.out.println("Enter angle (on a compass) to travel:  ");
            angle = scan.nextDouble();
            do {
                System.out.println("Enter distance to travel:  ");
                distance = scan.nextDouble();
                if (totalDistance + distance > 1000) {
                    System.out.println("You don't have enough gas to fly that far.");
                }//if
            } while (totalDistance + distance > 1000);
            plane.fly(angle, distance);
            totalDistance += distance;
            flights++;
        } while (plane.distanceAway(airport) > 5);
        if (plane.distanceAway(airport) <= 5) {
            System.out.println("You are " + Math.round(plane.distanceAway(airport) * 10.0) / 10.0 +
                    " miles away from the airport.");
            System.out.println("You see the airport and land.");
            System.out.println("You took " + flights + " flights to find the airport.");
        }//if
    }//main method
}//Main class

