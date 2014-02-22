package quicksort;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int id, priority;
        String first, last;
        Patient patient;

        // This while statement continuously executes a loop that allows the
        // user to continuously test the stak implementation.
        // It is an example of how a class can be tested prior to its use in
        // a real program.
        System.out.print("Please enter the maximum number of expected "
                + "patients \nThis must be at least as large as the actual "
                + "number of patients you enter next: ");
        int maxPatients = keyboard.nextInt();
        Patient[] patientList = new Patient[maxPatients];
        boolean done = false;
        int i = 0;
        while (!done) {
            System.out.print("Enter the patient's ID (-1 to quit):  ");
            id = keyboard.nextInt();
            if (id == -1) {
                done = true;
            } else {
                System.out.print("Enter the patient's first name:  ");
                first = keyboard.next();
                System.out.print("Enter the patient's last name:  ");
                last = keyboard.next();
                System.out.print("Enter the patient's priority:  ");
                priority = keyboard.nextInt();
                System.out.println();
                patientList[i] = new Patient(first, last, id, priority);
                i++;
            }
        }
        int numberOfPatients = i;

        // Copy the elements in patientList into an array that has exactly
        // the size of the number of input patients, so that this will
        // work with the book quicksort routine, which uses the .length 
        // instance variable of an incoming araay to determine how many
        // values are in it.

        Patient[] patientListCopy = new Patient[numberOfPatients];
        for (i = 0; i < numberOfPatients; i++) {
            patientListCopy[i] = patientList[i];
        }

        // Print the unsorted list of patients
        System.out.println("\nUnsorted Patient List");
        for (i = 0; i < numberOfPatients; i++) {
            System.out.println(patientListCopy[i].getLastName() + ", "
                    + patientListCopy[i].getFirstName());
        }

        // Sort and print sorted list of patients
        QuickSort.sort(patientListCopy);
        System.out.println("\nSorted Patient List");
        for (i = 0; i < numberOfPatients; i++) {
            System.out.println(patientListCopy[i].getLastName() + ", "
                    + patientListCopy[i].getFirstName());
        }

    }
}