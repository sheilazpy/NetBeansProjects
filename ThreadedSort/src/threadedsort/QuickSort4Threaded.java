/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threadedsort;

/**
 *
 * @author Dell
 */
public class QuickSort4Threaded <T extends Comparable<T>> extends Thread {
    
    int first, last;
    T[] list;
    static int index1, index2, index3;
    static QuickSort4Threaded thread1, thread2, thread3, thread4;
    
    public QuickSort4Threaded (T[] list, int start, int end) {
        this.list = list;
        first = start;
        last = end;
    }
    
    @Override
    public void run() {
        QuickSort.quickSort(list, first, last);
    }
    
    public static <T extends Comparable<T>> void sort(T[] list) {
        index2 = QuickSort.partition(list, 0, list.length - 1);
        index1 = QuickSort.partition(list, 0, index2 - 1);
        index3 = QuickSort.partition(list, index2 + 1, list.length - 1);
        thread1 = new QuickSort4Threaded(list, 0, index1 - 1);
        thread2 = new QuickSort4Threaded(list, index1 + 1, index2 - 1);
        thread3 = new QuickSort4Threaded(list, index2 + 1, index3 - 1);
        thread4 = new QuickSort4Threaded(list, index3 + 1, list.length - 1);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    } //public static <T extends Comparable<T>> void sort(T[] list)
    
}
