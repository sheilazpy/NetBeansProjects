/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicletest;

import java.util.Scanner;

/**
 *
 * @author 1003125
 */
public class Main {

    private static Vehicle makeCar() {
        int wheels, year;
        String manufact, model;
        Scanner scan = new Scanner(System.in);
        System.out.println("Number of wheels: ");
        wheels = scan.nextInt();
        System.out.println("Manufacturer: ");
        manufact = scan.next();
        System.out.println("Model: ");
        model = scan.next();
        System.out.println("Year: ");
        year = scan.nextInt();
        return new Vehicle(wheels, manufact, model, year);
    }//makeCar method

    private static void compareCars(Vehicle[] cars, int number) {
        int compare;
        for (int i = 0; i < number - 1; i++) {
            for (int j = i + 1; j < number; j++) {
                compare = cars[i].compareTo(cars[j]);
                switch (compare) {
                    case -4:
                        System.out.println(cars[i].toString() + " is older than " + cars[j].toString());
                        break;
                    case 4:
                        System.out.println(cars[j].toString() + " is older than " + cars[i].toString());
                        break;
                    case -3:
                    case 3:
                        System.out.println(cars[i].toString() + " is a different model than " + cars[j].toString());
                        break;
                    case -2:
                    case 2:
                        System.out.println(cars[i].toString() + " has a different manufacturer than " + cars[j].toString());
                        break;
                    case -1:
                        System.out.println(cars[j].toString() + " has more wheels than " + cars[i].toString());
                        break;
                    case 1:
                        System.out.println(cars[i].toString() + " has more wheels than " + cars[j].toString());
                        break;
                    case 0:
                        System.out.println(cars[i].toString() + " is the same as " + cars[j].toString());
                        break;
                    default:
                        System.out.println("There is an error in the program.");
                        break;
                }//switch
            }//for
        }//for
    }//compareCars method

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Vehicle[] cars = new Vehicle[100];
        int option = 0, count = 0;
        Scanner scan = new Scanner(System.in);
        while (option != 3) {
            System.out.println("Choose an option: ");
            System.out.println("1 = Create a new vehicle");
            System.out.println("2 = Compare vehicles");
            System.out.println("3 = Quit");
            option = scan.nextInt();
            switch (option) {
                case 1:
                    cars[count] = makeCar();
                    count++;
                    break;
                case 2:
                    compareCars(cars, count);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }//switch
        }//while
    }//main method
}//Main Class

