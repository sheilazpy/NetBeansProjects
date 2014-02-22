/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadedSearch;

public class SequentialSearchThreaded extends Thread {

    int[] listOfIntegers;
    int searchValue;
    int lowIndex;
    int highIndex;
    int threadNumber;

    public SequentialSearchThreaded(int[] listOfIntegers, int searchValue,
            int lowIndex, int highIndex, int threadNumber) {

        this.listOfIntegers = listOfIntegers;
        this.searchValue = searchValue;
        this.lowIndex = lowIndex;
        this.highIndex = highIndex;
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {

        int index = sequentialSearch(listOfIntegers,
                searchValue, lowIndex, highIndex);
        if (index == -1) {
            System.out.println("Thread " + threadNumber + " did not find "
                    + searchValue + " in the list!");
        } else {
            System.out.println("Thread " + threadNumber + " found " + searchValue
                    + " at position " + index + " in the list!");
            System.out.println("Verification: " + listOfIntegers[index]);
        }
    }

    public static int sequentialSearch(int[] list, int searchValue, int lowIndex, int highIndex) {
        for (int i = lowIndex; i <= highIndex; i++) {
            if (list[i] == searchValue) {
                return i;
            }
        }
        return -1;
    }
}
