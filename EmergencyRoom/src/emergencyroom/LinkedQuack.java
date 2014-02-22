/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emergencyroom;

/**
 *
 * @author Dell
 */
public class LinkedQuack<T> {

    private Node front; //The first object in the quack
    private Node back; //The last object in the quack

    private class Node {

        private final T object;
        private Node next;

        private Node(T newObject) {
            object = newObject;
            next = null;
        } //private Node(T newObject)

        private T getObject() {
            return object;
        } //private T getObject()

        private Node getNext() {
            return next;
        } //private Node getNext()

        private void setNext(Node nextObject) {
            next = nextObject;
        } //private void setNext(Node nextObject)
    } //private class Node

    // Constructs a LinkedQuack
    public LinkedQuack() {
        front = null;
        back = null;
    } //public LinkedQuack()

    // Puts an object at the back of the quack.
    public void enqueue(T object) {
        Node temp = new Node(object);
        if (isEmpty()) {
            front = temp;
            back = temp;
        } else {
            back.setNext(temp);
            back = temp;
        } //if (isEmpty())
    } //public void enqueue(T object)

    /*
     * Returns the first object in the quack. Throws a NullPointerException if
     * the quack is empty.
     */
    public T dequeue() throws NullPointerException {
        if (isEmpty()) {
            throw new NullPointerException("The quack is empty.");
        } //if (isEmpty())
        T next = front.getObject();
        front = front.getNext();
        return next;
    } //public T dequeue() throws NullPointerException

    // Puts an object at the front of the quack.
    public void push(T object) {
        Node temp = new Node(object);
        if (isEmpty()) {
            front = temp;
            back = temp;
        } else {
            temp.setNext(front);
            front = temp;
        } //if (isEmpty())
    } //public void push(T object)

    // Returns whether the quack is empty.
    public boolean isEmpty() {
        return (front == null);
    } //public boolean isEmpty()

    // Prints out all the objects in the quack in order, front to back.
    public void print() {
        Node temp = front;
        while (temp != null) {
            System.out.println(temp.getObject().toString());
            temp = temp.getNext();
        } //while (temp != null)
    } //public void print()
} //public class LinkedQuack<T>
