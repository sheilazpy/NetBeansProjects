/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emergencyroom;

/**
 *
 * @author Dell
 */
public class ERRoom {

    private boolean occupied;
    private Patient inRoom;

    public ERRoom() {
        occupied = false;
        inRoom = null;
    } //public ERRoom()

    // Returns the patient in the room. Sets occupied to false.
    public Patient releasePatient() {
        occupied = false;
        return inRoom;
    } //public Patient releasePatient()

    // Places the next patient in the room. Sets occupied to true.
    public void placePatient(Patient next) {
        occupied = true;
        inRoom = next;
    } //public void placePatient(Patient next)

    // Returns whether the room is occupied.
    public boolean isOccupied() {
        return occupied;
    } //public boolean isOccupied()

    // Returns the patient in the room.
    public Patient getPatient() {
        return inRoom;
    } //public Patient getPatient()

    /*
     * Prints out the status of the room. If the room is occupied, prints
     * "Occupied" and the patient information. If the room is empty, prints
     * "Empty".
     */
    public void print() {
        if (occupied) {
            System.out.println("Occupied");
            System.out.println(inRoom.toString());
        } else {
            System.out.println("Empty");
        } //if (occupied)
    } //public void print()
} //public class ERRoom
