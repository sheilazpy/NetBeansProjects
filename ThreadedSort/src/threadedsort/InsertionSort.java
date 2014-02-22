/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threadedsort;

/**
 *
 * @author Dell
 */
public class InsertionSort {

    public static <T extends Comparable<T>> void sort(T[] list) {
        for (int nextPosition = 1; nextPosition < list.length; nextPosition++) {
            T nextValue = list[nextPosition];
            while (nextPosition > 0 && nextValue.compareTo(list[nextPosition - 1]) < 0) {
                list[nextPosition] = list[nextPosition - 1];
                nextPosition--;
            } //while (nextPosition > 0 && nextValue.compareTo(list[nextPosition - 1]) < 0)
            list[nextPosition] = nextValue;
        } //for (int nextPosition = 1; nextPosition < list.length; nextPosition++)
    } //public static <T extends Comparable<T>> void sort(T[] list)
} //public class InsertionSort
