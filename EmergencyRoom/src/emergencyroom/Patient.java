/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emergencyroom;

/**
 *
 * @author Dell
 */
public class Patient {

    private final int patientID; //The patient's ID number
    private final int patientPriority; //The patient's priority

    public Patient(int id, int priority) {
        patientID = id;
        patientPriority = priority;
    } //public Patient(int id, int priority)

    // Returns the patient's ID number
    public int getID() {
        return patientID;
    } //public int getID()

    // Returns the patient's priority
    public int getPriority() {
        return patientPriority;
    } //public int getPriority()

    // Prints out the patient's ID number and priority
    public void print() {
        System.out.println("\nPatient ID: " + patientID);
        System.out.println("Patient Priority: " + patientPriority);
    } //public void print()
} //public class Patient
