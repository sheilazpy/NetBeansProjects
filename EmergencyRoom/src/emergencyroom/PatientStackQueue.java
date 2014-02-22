/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emergencyroom;

/**
 *
 * @author Dell
 */
public class PatientStackQueue {

    private Patient[] patients; //The patients in the stackqueue
    private int front; //The first patient in the stackqueue
    private int back; //The first free space in the stackqueue
    private int maxSize; //The maximum size of the stackqueue
    private int count; //The number of patients in the stackqueue

    // Constructs a PatientStackQueue of maxSize 100
    public PatientStackQueue() {
        front = 0;
        back = 0;
        count = 0;
        maxSize = 100;
        patients = new Patient[maxSize];
    } //public PatientStackQueue()

    // Constructs a PatientStackQueue of maxSize size
    public PatientStackQueue(int size) {
        front = 0;
        back = 0;
        count = 0;
        maxSize = size;
        patients = new Patient[maxSize];
    } //public PatientStackQueue(int size)

    /*
     * Puts a patient at the back of the stackqueue. Throws a StackOverflowError
     * if the stackqueue is full.
     */
    public void enqueue(Patient patient) throws StackOverflowError {
        if (isFull()) {
            throw new StackOverflowError("The stackqueue is full.");
        } //if (isFull())
        patients[back] = patient; //Put the patient in the first free space at the back
        back = (back + 1) % maxSize; //back now points to the first free space at the back of the stackqueue
        count++;
    } //public void enqueue(Patient patient) throws StackOverflowError

    /*
     * Returns the first patient in the stackqueue. Throws a
     * NullPointerException if the stackqueue is empty.
     */
    public Patient dequeue() throws NullPointerException {
        if (isEmpty()) {
            throw new NullPointerException("The stackqueue is empty.");
        } //if (isEmpty())
        Patient next = patients[front]; //Get the first patient in the stackqueue
        front = (front + 1) % maxSize; //front now points to the first element in the stackqueue
        count--;
        return next;
    } //public Patient dequeue() throws NullPointerException

    /*
     * Puts a patient at the front of the stackqueue. Throws a
     * StackOverflowError if the stackqueue is full.
     */
    public void push(Patient patient) throws StackOverflowError {
        if (isFull()) {
            throw new StackOverflowError("The stackqueue is full.");
        } //if (isFull())
        front = (front - 1 + maxSize) % maxSize; //front now points to the first free space at the front of the stackqueue
        patients[front] = patient; //Put the patient in the first free space at the front
        count++;
    } //public void push(Patient patient) throws StackOverflowError

    // Returns whether the stackqueue is empty.
    public boolean isEmpty() {
        return (count == 0);
    } //public boolean isEmpty()

    // Returns whether the stackqueue is full.
    public boolean isFull() {
        return (count == maxSize);
    } //public boolean isFull()

    // Prints out all the patients in the stackqueue in order, front to back.
    public void print() {
        for (int loop = front; loop < back; loop++) { //Print patients from front to back
            patients[loop].print();
        } //for (int loop = front; loop < back; loop++)
        if (back < front) { //Stackqueue has cycled back to the beginning of the array
            for (int loop = front; loop < 100; loop++) { //Print patients from front to the end of the array
                patients[loop].print();
            } //for (int loop = front; loop < 100; loop++)
            for (int loop = 0; loop < back; loop++) { //Print patients from the beginning of the array to back
                patients[loop].print();
            } //for (int loop = 0; loop < back; loop++)
        } //if (back < front)
    } //public void print()
} //public class PatientStackQueue
