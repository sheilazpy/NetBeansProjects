/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emergencyroom;

import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EmergencyRoom er;
        boolean printStatus = false; //Whether to print ER status
        boolean done = false; //Whether to quit ER program
        int rooms, id, priority, size, numRoom, numPriorities;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Welcome to the Emergency Room Manager.");
        do {
            System.out.print("\nEnter the number of ER rooms:  ");
            rooms = keyboard.nextInt();
            if (rooms < 1) {
                System.out.println("The number of ER rooms must be a positive number.");
            } //if (rooms < 1)
        } while (rooms < 1);
        do {
            System.out.print("Enter the number of patient priority categories:  ");
            numPriorities = keyboard.nextInt();
            if (numPriorities < 1) {
                System.out.println("The number of patient priority categories must be a positive number.");
            } //if (numPriorities < 1)
        } while (numPriorities < 1);
        do {
            System.out.print("Enter the maximum capacity of the waiting lists:  ");
            size = keyboard.nextInt();
            if (size < 1) {
                System.out.println("The capacity of the waiting lists must be a positive number.");
            } //if (size < 1)
        } while (size < 1);
        er = new EmergencyRoom(rooms, numPriorities, size);
        while (!done) {
            System.out.println("\nChoose an option:");
            System.out.println("1 = Enter a new patient ID number and priority");
            System.out.println("2 = Release patient from an ER room");
            System.out.println("3 = Turn on print status");
            System.out.println("4 = Turn off print status");
            System.out.println("5 = Quit");
            System.out.print("\nEnter your choice:  ");
            switch (keyboard.nextInt()) { //Read person's choice from keyboard and perform the desired action
                case 1: //Enter a new patient ID number and priority
                    System.out.print("\nEnter the patient's ID number:  ");
                    id = keyboard.nextInt();
                    do {
                        System.out.print("Enter the patient's priority:  ");
                        priority = keyboard.nextInt();
                        if (priority < 1 || priority > 4) {
                            System.out.println("The patient's priority must be between 1 and "+numPriorities);
                        } //if (priority < 1 || priority > 4)
                    } while (priority < 1 || priority > 4);
                    try {
                        er.process(new Patient(id, priority)); //Process the incoming patient
                        System.out.println("\nPatient " + id + " has been added.");
                    } catch (StackOverflowError error) {
                        System.out.println("\nPatient " + id + " could not be added.");
                        System.out.println("The priority " + priority + " waiting list is full.");
                    } //catch (StackOverflowError error)
                    if (printStatus) {
                        er.print();
                    } //if (printStatus)
                    break;
                case 2: //Release patient from ER room
                    do {
                    System.out.print("\nEnter the room number to be released:  ");
                    numRoom = keyboard.nextInt();
                    if(numRoom<1||numRoom>rooms){
                        System.out.println("The room number must be between 1 and "+rooms);
                    }
                    } while(numRoom<1||numRoom>rooms);
                    Patient patient = er.release(numRoom);
                    if (patient == null) {
                        System.out.println("\nCould not release a patient. The ER room is empty");
                    } else {
                        System.out.println("\nPatient " + patient.getID() + " was released from the ER room.");
                    } //if (patient = null)
                    if (printStatus) {
                        er.print();
                    } //if (printStatus)
                    break;
                case 3: //Turn on print status
                    printStatus = true;
                    System.out.println("\nPrint status is now on.");
                    break;
                case 4: //Turn off print status
                    printStatus = false;
                    System.out.println("\nPrint status is now off.");
                    break;
                case 5: //Quit
                    done = true;
                    break;
                default: //Not an option, print error message
                    System.out.println("\nThe number you entered is not an option. Please try again.");
            } //switch (keyboard.nextInt())
        } //while (!done)
        System.out.println("\nThank you for using the Emergency Room Manager. Goodbye.");
    } //public static void main(String[] args)
} //public class Main
