/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package comparesort;

/**
 *
 * @author 1003125
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] list1 = new int[100];
        int[] list2 = new int[100];
        int selectCount = 0, bubbleCount = 0, temp;
        boolean swap;
        for (int loop = 0; loop < 100; loop++) {
            for (int i = 0; i < 100; i++) {
                list1[i] = (int) Math.random() * 100;
                list2[i] = (int) Math.random() * 100;
            }//for
            for (int i = 0; i < 99; i++) {
                for (int j = i + 1; j < 100; j++) {
                    selectCount++;
                    if (list1[i] > list1[j]) {
                        temp = list1[i];
                        list1[i] = list1[j];
                        list1[j] = temp;
                    }//if
                }//for
            }//for
            swap = true;
            while (swap) {
                swap = false;
                for (int i = 0; i < 99; i++) {
                    bubbleCount++;
                    if (list2[i] > list2[i + 1]) {
                        temp = list2[i];
                        list2[i] = list2[i + 1];
                        list2[i + 1] = temp;
                        swap = true;
                    }//if
                }//for
            }//while
        }//for
        System.out.println(selectCount / 100);
        System.out.println(bubbleCount / 100);
    }//main method
}//Main class

