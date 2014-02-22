/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emergencyroom;

/**
 *
 * @author Dell
 */
public class EmergencyRoom {

    private int numERRooms; //Number of ER rooms
    private int numPatientStackQueues; //Number of priority stackqueues
    private ERRoom[] erRooms; //Array of ER rooms
    private PatientStackQueue[] waiting; //Array of priority stackqueues of waiting patients

    // Constructs an EmergencyRoom with default parameters
    public EmergencyRoom() {
        numERRooms = 1;
        numPatientStackQueues = 4;
        erRooms = new ERRoom[numERRooms + 1];
        for (int room = 1; room <= numERRooms; room++) { //Initialize the ER rooms
            erRooms[room] = new ERRoom();
        } //for (int room = 1; room <= numERRooms; room++)
        waiting = new PatientStackQueue[numPatientStackQueues + 1];
        for (int priority = 1; priority <= numPatientStackQueues; priority++) { //Initialize the priority stackqueues
            waiting[priority] = new PatientStackQueue();
        } //for (int priority = 1; priority <= numPatientStackQueues; priority++)
    } //public EmergencyRoom()

    // Constructs an EmergencyRoom with the specified parameters
    public EmergencyRoom(int rooms, int priorities, int maxWaitingSize) {
        numERRooms = rooms;
        numPatientStackQueues = priorities;
        erRooms = new ERRoom[numERRooms + 1];
        for (int room = 1; room <= numERRooms; room++) { //Initialize ER rooms
            erRooms[room] = new ERRoom();
        } //for (int room = 1; room <= numERRooms; room++)
        waiting = new PatientStackQueue[numPatientStackQueues + 1];
        for (int priority = 1; priority <= numPatientStackQueues; priority++) { //Initialize priority stackqueues
            waiting[priority] = new PatientStackQueue(maxWaitingSize);
        } //for (int priority = 1; priority <= numPatientStackQueues; priority++)
    } //public EmergencyRoom()

    /*
     * Processes the incoming patient. If an ER room is empty, the incoming
     * patient is placed in the ER room. If an ER room is occupied by a patient
     * of lower priority than the incoming patient, the incoming patient is
     * placed in the ER room with the lowest priority patient and the occupying
     * patient is put at the front of his priority stackqueue. If all the ER
     * rooms are occupied by patients of higher priority, the incoming patient
     * is put at the back of his priority stackqueue.
     */
    public void process(Patient incoming) throws StackOverflowError {
        int lowestPriority = 0, lowestPriorityRoom = 0;
        for (int room = 1; room <= numERRooms; room++) {
            if (!erRooms[room].isOccupied()) { //Check for empty ER rooms
                erRooms[room].placePatient(incoming);
                return;
            } //if(!erRoom.occupied)
            if (erRooms[room].getPatient().getPriority() >= lowestPriority) { //Find lowest priority patient
                lowestPriority = erRooms[room].getPatient().getPriority();
                lowestPriorityRoom = room;
            } //if (erRooms[room].getPatient().getPriority() >= lowestPriority)
        } //for (int room = 1; room <= numERRooms; room++)
        if (incoming.getPriority() < lowestPriority) { //Incoming patient is higher priority
            Patient occupying = erRooms[lowestPriorityRoom].releasePatient(); //Release occupying patient
            erRooms[lowestPriorityRoom].placePatient(incoming); //Place incoming patient in ER room
            waiting[occupying.getPriority()].push(occupying); //Put occupying patient at front of his priority stackqueue
            return;
        } //if (incoming.getPriority() < erRoom.getPatient().getPriority())
        waiting[incoming.getPriority()].enqueue(incoming); //Put incoming patient at back of his priority stackqueue
    } //public void processPatient(Patient incoming) throws StackOverflowError

    /*
     * Returns the patient in the ER room, and places the next patient into the
     * ER room. Returns null if the ER room is empty.
     */
    public Patient release(int roomNumber) {
        if (!erRooms[roomNumber].isOccupied()) { //ER room roomNumber is empty
            return null;
        } else {
            Patient patient = erRooms[roomNumber].releasePatient(); //Release patient from ER room roomNumber
            Patient next = getNext(); //Get next patient
            if (next != null) { //There is a patient waiting
                erRooms[roomNumber].placePatient(next); //Place next patient in ER room roomNumber
            } //if (next != null)
            return patient;
        } //if (!erRoom.isOccupied())
    } //public Patient release()

    // Returns the next waiting patient. Returns null if no patients are waiting.
    private Patient getNext() {
        for (int priority = 1; priority <= numPatientStackQueues; priority++) { //Check stackqueues for waiting patients
            if (!waiting[priority].isEmpty()) { //There is a patient waiting
                return waiting[priority].dequeue();
            } //if (!waiting[priority].isEmpty())
        } //for (int priority = 1; priority <= numPatientStackQueues; priority++)
        return null; //There are no patients waiting
    } //private Patient getNext()

    // Prints out the status of each ER room and a list of the patients in each stackqueue.
    public void print() {
        for (int room = 1; room <= numERRooms; room++) { //Print the ER rooms
            System.out.println("The status of ER room " + room + "is: ");
            erRooms[room].print();
        } //for (int room = 1; room <= numERRooms; room++)
        for (int priority = 1; priority <= numPatientStackQueues; priority++) { //Print the stackqueues
            System.out.println("\n The waiting priority " + priority + " patients are:");
            waiting[priority].print();
            if (waiting[priority].isEmpty()) {
                System.out.println("None");
            } //if (waiting[priority].isEmpty())
        } //for (int priority = 1; priority < 5; priority++)
    } //public void print()
} //public class EmergencyRoom
