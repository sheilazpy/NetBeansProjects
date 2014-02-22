/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksort;

/**
 *
 * @author Dell
 */
public class QuickSort {

    public static <T extends Comparable<T>> void sort(T[] list) {
        quickSort(list, 0, list.length - 1);
    }

    private static <T extends Comparable<T>> void quickSort(T[] list, int first, int last) {
        if (first < last) {
            int pivIndex = partition(list, first, last);
            quickSort(list, first, pivIndex - 1);
            quickSort(list, pivIndex + 1, last);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] list, int first, int last) {
        T pivot = list[first];
        int up = first;
        int down = last;
        do {
            while ((up < last) && (pivot.compareTo(list[up]) >= 0)) {
                up++;
            }
            while (pivot.compareTo(list[down]) < 0) {
                down--;
            }
            if(up<down) {
                T temp = list[up];
                list[up] = list[down];
                list[down] = temp;
            }
        } while (up < down);
        T temp = list[first];
        list[first] = list[down];
        list[down] = temp;
        return down;
    }
}
