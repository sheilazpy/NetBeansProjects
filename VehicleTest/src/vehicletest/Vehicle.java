/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicletest;

/**
 *
 * @author 1003125
 */
public class Vehicle implements Comparable {

    public Integer wheels;
    public String manufacturer;
    public String model;
    public Integer year;

    public Vehicle(int carWheels, String carManufact, String carModel, int carYear) {
        wheels = carWheels;
        manufacturer = carManufact;
        model = carModel;
        year = carYear;
    }//Vehicle constructor

    public int compareTo(Object car) {
        return compareTo((Vehicle) car);
    }//compareTo method

    public int compareTo(Vehicle car) {
        if (wheels.compareTo(car.wheels) != 0) {
            return wheels.compareTo(car.wheels);
        }//if
        if (manufacturer.compareTo(car.manufacturer) < 0) {
            return -2;
        }//if
        if (manufacturer.compareTo(car.manufacturer) > 0) {
            return 2;
        }//if
        if (model.compareTo(car.model) < 0) {
            return -3;
        }//if
        if (model.compareTo(car.model) > 0) {
            return 3;
        }//if
        if (year.compareTo(car.year) != 0) {
            return year.compareTo(car.year) * 4;
        }//if
        return 0;
    }//compareTo method

    public String toString() {
        return wheels.toString() + "-wheeled " + manufacturer + " " + model + " " + year;
    }//toString method
}//Vehicle class

