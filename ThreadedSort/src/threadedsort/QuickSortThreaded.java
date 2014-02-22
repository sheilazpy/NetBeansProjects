/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threadedsort;

/**
 *
 * @author Dell
 */
public class QuickSortThreaded <T extends Comparable<T>> extends Thread {
    
    int first, last;
    T[] list;
    static int index;
    static QuickSortThreaded thread1, thread2;
    
    public QuickSortThreaded (T[] list, int start, int end) {
        this.list = list;
        first = start;
        last = end;
    }
    
    @Override
    public void run() {
        QuickSort.quickSort(list, first, last);
    }
    
    public static <T extends Comparable<T>> void sort(T[] list) {
        index = QuickSort.partition(list, 0, list.length - 1);
        thread1 = new QuickSortThreaded(list, 0, index - 1);
        thread2 = new QuickSortThreaded(list, index + 1, list.length - 1);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    } //public static <T extends Comparable<T>> void sort(T[] list)
    
}
