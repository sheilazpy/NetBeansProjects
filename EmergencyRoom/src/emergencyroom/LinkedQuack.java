/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emergencyroom;

/**
 *
 * @author Dell
 */
public class LinkedQuack {

    private PatientNode front; //The first patient in the quack
    private PatientNode back; //The last patient in the quack

    private class PatientNode {

        private final Patient patient;
        private PatientNode next;

        private PatientNode(Patient newPatient) {
            patient = newPatient;
            next = null;
        } //private PatientNode(Patient newPatient)

        private Patient getPatient() {
            return patient;
        } //private Patient getPatient()

        private PatientNode getNext() {
            return next;
        } //private PatientNode getNext()

        private void setNext(PatientNode nextPatient) {
            next = nextPatient;
        } //private void setNext(PatientNode nextPatient)
    } //private class PatientNode

    // Constructs a LinkedQuack
    public LinkedQuack() {
        front = null;
        back = null;
    } //public LinkedQuack()

    // Puts a patient at the back of the quack.
    public void enqueue(Patient patient) {
        PatientNode temp = new PatientNode(patient);
        if (isEmpty()) {
            front = temp;
            back = temp;
        } else {
            back.setNext(temp);
            back = temp;
        } //if (isEmpty())
    } //public void enqueue(Patient patient)

    /*
     * Returns the first patient in the quack. Throws a NullPointerException if
     * the quack is empty.
     */
    public Patient dequeue() throws NullPointerException {
        if (isEmpty()) {
            throw new NullPointerException("The quack is empty.");
        } //if (isEmpty())
        Patient next = front.getPatient();
        front = front.getNext();
        return next;
    } //public Patient dequeue() throws NullPointerException

    // Puts a patient at the front of the quack.
    public void push(Patient patient) {
        PatientNode temp = new PatientNode(patient);
        if (isEmpty()) {
            front = temp;
            back = temp;
        } else {
            temp.setNext(front);
            front = temp;
        } //if (isEmpty())
    } //public void push(Patient patient)

    // Returns whether the quack is empty.
    public boolean isEmpty() {
        return (front == null);
    } //public boolean isEmpty()

    // Prints out all the patients in the quack in order, front to back.
    public void print() {
        PatientNode temp = front;
        while (temp != null) {
            temp.getPatient().print();
            temp = temp.getNext();
        } //while (temp != null)
    } //public void print()
} //public class LinkedQuack
