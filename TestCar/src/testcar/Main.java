/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testcar;

import java.util.Scanner;

/**
 *
 * @author 1003125
 */
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double mpg, fuelAmt, tankCap;
        boolean quit = false;
        do {
            System.out.println("Enter your tank's capacity:  ");
            tankCap = scan.nextDouble();
        } while (tankCap <= 0);
        do {
            System.out.println("Enter your car's efficiency:  ");
            mpg = scan.nextDouble();
        } while (mpg <= 0);
        do {
            System.out.println("Enter the amount of gas in your tank:  ");
            fuelAmt = scan.nextDouble();
        } while (fuelAmt > tankCap || fuelAmt < 0);
        Car myCar = new Car(mpg, fuelAmt, tankCap);
        do {
            System.out.println("1 = Fill tank");
            System.out.println("2 = Travel");
            System.out.println("3 = Check tank level");
            System.out.println("4 = Quit");
            System.out.println("Choose an option:  ");
            int option = scan.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter amount to add:  ");
                    double amount = scan.nextDouble();
                    myCar.fill(amount);
                    break;
                case 2:
                    if (myCar.fuel==0)
                    {
                        System.out.println("You are out of fuel. You need to refill.");
                        break;
                    }//if
                    System.out.println("Enter distance to travel:  ");
                    double distance = scan.nextDouble();
                    myCar.travel(distance);
                    break;
                case 3:
                    myCar.checkFuel();
                    break;
                case 4:
                    quit = true;
                    break;
                default:
                    break;
            }//switch
        } while (quit == false);
    }//main method
}//Main class

