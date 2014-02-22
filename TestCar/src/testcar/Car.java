/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testcar;

/**
 *
 * @author 1003125
 */
public class Car {

    double efficiency, fuel, capacity;

    public Car(double mpg, double fuelAmt, double tankCap) {
        efficiency = mpg;
        fuel = fuelAmt;
        capacity = tankCap;
    }//Car constructor

    void fill(double amount) {
        if (fuel + amount >= capacity) {
            amount = capacity - fuel;
            fuel = capacity;
        }//if
        else {
            fuel += amount;
        }//else
        System.out.println("You added " + amount + " gallons to your tank.");
        checkFuel();
    }//fill method

    void travel(double distance) {
        if (distance >= fuel * efficiency) {
            distance = fuel * efficiency;
            fuel = 0;
        }//if
        else {
            fuel -= distance / efficiency;
        }//else
        System.out.println("You traveled " + distance + " miles.");
        if (fuel==0)
        {
            System.out.println("You ran out of fuel. Have a nice walk.");
        }//if
        else
        {
        checkFuel();
        }//else
    }//travel method

    void checkFuel() {
        System.out.println("Your tank has " + fuel + " gallons in it.");
    }
}//Car class

