// This is an array implementation of a quack of Patient objects
// It extends a queue by adding a push method

public class Quack extends Queue {

    public void push(Patient pushValue) {
        // ASSERT Precondition: (1) If push is called, the quack is not full. (This must be checked by the
        //        calling method by first calling method isFull in this class and not calling push if
        //        the quack is full. Errors will occur otherwise.) (2) queueSize contains the number of 
        //        elements in the quack. (3) front points to the frontmost element in the quack.
        front--;
        if (front < 0) {
            front += maxQueueSize;
        }
        // ASSERT front now points to the first free element at the front of the quack.
        queue[front] = pushValue;
        // ASSERT front now points to the first element in the quack, and queueSize contains one less than
        // the number of elements in the quack.
        queueSize++;
        // ASSERT if front = back, the quack is full.
        full = (front == back);
        empty = false;
        // ASSERT Postcondition: (1) The pushValue has been place at the front of the quack
        //        (2) front points to the first element of the quack.
        //        (3) queueSize contains the number of elements in the quack.           
    }
}
