/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksort;

/**
 *
 * @author Dell
 */
public class Patient implements Comparable<Patient> {

    private final int patientID;
    private final int patientPriority;
    private final String firstName;
    private final String lastName;

    public Patient(String first, String last, int id, int priority) {
        firstName = first;
        lastName = last;
        patientID = id;
        patientPriority = priority;
    } //public Patient(int id, int priority)
    
    public String getFirstName() {
        return firstName;
    } //public String getFirstName()
    
    public String getLastName() {
        return lastName;
    } //public String getLastName()

    // Returns the patient's ID number
    public int getID() {
        return patientID;
    } //public int getID()

    // Returns the patient's priority
    public int getPriority() {
        return patientPriority;
    } //public int getPriority()

    public int compareTo(Patient otherPatient) {
        if (getLastName().equals(otherPatient.getLastName())) {
            return getFirstName().compareTo(otherPatient.getFirstName());
        }
        return getLastName().compareTo(otherPatient.getLastName());
    } //public int compareTo(Patient otherPatient)

// Prints out the patient's ID number and priority
    public String toString() {
        return "\nPatient ID: " + patientID + "\nPatient Priority: " + patientPriority;
    } //public void print()
}
