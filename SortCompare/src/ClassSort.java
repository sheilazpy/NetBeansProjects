
import java.util.*;

public class ClassSort {

    public static void main(String[] args) {
        int i, j, temp;
        Scanner keyboard = new Scanner(System.in);
        Random generator = new Random();
        System.out.print("Enter the number of random numbers to be generated:  ");
        int listSize = keyboard.nextInt();
        int[] list = new int[listSize];
        System.out.print("Enter the number of times to repeat the experiment:  ");
        int trials = keyboard.nextInt();
        int statementCount = 0;
        for (int n = 0; n < trials; n++) { //Sort n random lists and average statementCount
            generator = new Random();
            for (i = 0; i < listSize; i++) {
                list[i] = generator.nextInt();
            } //for (i = 0; i < listSize; i++)
            for (i = 0; i < listSize - 1; i++) {
                statementCount++;
                for (j = i + 1; j < listSize; j++) {
                    statementCount += 2;
                    if (list[j] < list[i]) {
                        temp = list[i];
                        list[i] = list[j];
                        list[j] = temp;
                        statementCount += 3;
                    } //if (list[j] < list[i])
                } //for (j = i + 1; j < listSize; j++)
            } //for (i = 0; i < listSize - 1; i++)
        } //for (int n = 0; n < trials; n++)
        System.out.println("\nThe average number of statements to sort a random list was "
                + statementCount / trials);
        statementCount = 0;
        for (i = 0; i < listSize - 1; i++) { //Resort already sorted list
            statementCount++;
            for (j = i + 1; j < listSize; j++) {
                statementCount += 2;
                if (list[j] < list[i]) {
                    temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                    statementCount += 3;
                } //if (list[j] < list[i])
            } //for (j = i + 1; j < listSize; j++)
        } //for (i = 0; i < listSize - 1; i++)
        System.out.println("The number of statements to sort a sorted list was "
                + statementCount);
        statementCount = 0;
        for (i = 0; i < listSize - 1; i++) { //Sort list descending
            statementCount++;
            for (j = i + 1; j < listSize; j++) {
                statementCount += 2;
                if (list[j] > list[i]) {
                    temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                    statementCount += 3;
                } //if (list[j] > list[i])
            } //for (j = i + 1; j < listSize; j++)
        } //for (i = 0; i < listSize - 1; i++)
        System.out.println("The number of statements to sort an inverse sorted list was "
                + statementCount);
    } //public static void main(String[] args)
} //public class ClassSort
