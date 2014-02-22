
import java.util.*;

public class Main {

    public static void main(String[] args) {
        int i, j;
        Droid temp;
        Boolean done = false;
        Scanner keyboard = new Scanner(System.in);
        Random generator = new Random(314159);

        System.out.print("Enter the number of droids to create: ");

        int listSize = keyboard.nextInt();
        Droid[] list = new Droid[listSize];

        i = 0;
        while (i < listSize) {
            list[i] = new Droid();
            list[i].setId(generator.nextInt());
            list[i].setName("R2D" + i);
            i++;
        }

        // Print the randomly generated random numbers for inspection
        System.out.println();
        for (i = 0; i < listSize; i++) {
            System.out.print(list[i].getId() + " ");
        }
        System.out.println();

        // Sort the array with the course version of selection sort.
        // Include instrumentation for counting the number of statements executed
        int statementCount = 0;
        for (i = 0; i <= listSize - 2; i++) {
            int positionMin = i;
            statementCount = statementCount + 2;
            for (j = i + 1; j <= listSize - 1; j++) {
                statementCount++;
                if (list[j].getId() < list[positionMin].getId()) {
                    positionMin = j;
                    statementCount++;
                }
                statementCount++; // add one for execution of the if statement
                // itself
            }
            temp = list[i];
            list[i] = list[positionMin];
            list[positionMin] = temp;
            statementCount = statementCount + 4; // add one for the last execution of the inner
            // loop statement that kicks execution out of the loop
        }
        statementCount++; // add one for the last execution of the outer
        // loop statement that kicks execution out of the loop

        // Print the number of statements executed for use in run time complexity
        // analysis
        System.out.println();
        System.out.println("The number of statements executed was: "
                + statementCount + ".");
        System.out.println();

        // Print the array to be sure it is sorted
        for (i = 0; i <= listSize - 1; i++) {
            System.out.print(list[i].getId() + " ");
        }
        System.out.println();
    }
}
