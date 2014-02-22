/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threadedsort;

/**
 *
 * @author Dell
 */
public class QuickSort {

    public static <T extends Comparable<T>> void sort(T[] list) {
        quickSort(list, 0, list.length - 1);
    } //public static <T extends Comparable<T>> void sort(T[] list)

    public static <T extends Comparable<T>> void quickSort(T[] list, int first, int last) {
        if (first < last) {
            int index = partition(list, first, last);
            quickSort(list, first, index - 1);
            quickSort(list, index + 1, last);
        } //if (first < last)
    } //private static <T extends Comparable<T>> void quickSort(T[] list, int first, int last)

    public static <T extends Comparable<T>> int partition(T[] list, int first, int last) {
        T pivot = list[first];
        int up = first;
        int down = last;
        do {
            while ((up < last) && (pivot.compareTo(list[up]) >= 0)) {
                up++;
            } //while ((up < last) && (pivot.compareTo(list[up]) >= 0))
            while (pivot.compareTo(list[down]) < 0) {
                down--;
            } //while (pivot.compareTo(list[down]) < 0)
            if (up < down) {
                T temp = list[up];
                list[up] = list[down];
                list[down] = temp;
            } //if (up < down)
        } while (up < down);
        T temp = list[first];
        list[first] = list[down];
        list[down] = temp;
        return down;
    } //private static <T extends Comparable<T>> int partition(T[] list, int first, int last)
} //public class QuickSort
