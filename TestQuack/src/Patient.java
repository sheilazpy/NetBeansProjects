/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * This class creates patients with a first name, last name, age, ID number, and
 * priority (1-4)
 *
 * @author Dell
 */
public class Patient {

    private final String firstName, lastName;
    private final int age, id, priority;

    public Patient(String newFirst, String newLast, int newAge, int newId, int newPriority) {
        firstName = newFirst;
        lastName = newLast;
        age = newAge;
        id = newId;
        priority = newPriority;
    } //public Patient(String newFirst, String newLast, int newAge, int newId, int newPriority)

    public String getName() {
        return firstName + " " + lastName;
    } //public String getName()

    public int getAge() {
        return age;
    } //public int getAge()

    public int getId() {
        return id;
    } //public int getId()

    public int getPriority() {
        return priority;
    } //public int getPriority()
} //public class Patient
