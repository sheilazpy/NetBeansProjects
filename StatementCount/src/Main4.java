
import java.util.*;

public class Main4 {

    public static void main(String[] args) {
        int i, j, n, temp, nextNumber;
        Boolean done = false;
        Scanner keyboard = new Scanner(System.in);
        Random generator = new Random(314159);

        System.out.print("Enter the number of random numbers to be generated: ");
        int listSize = keyboard.nextInt();
        int[] list = new int[listSize];
        i = 0;
        while (i < listSize) {
            list[i] = generator.nextInt();
            i++;
        }

        System.out.println();
        for (i = 0; i < listSize; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();

        int statementCount = 0;
        for (i = 0; i < listSize - 2; i++) {
            statementCount += 10;
            for (j = i + 1; j <= listSize - 1; j++) {
                statementCount += 10;
            }
        }
        System.out.println();
        System.out.println("The number of statements executed was: "
                + statementCount + ".");
        System.out.println();

        for (i = 0; i <= listSize - 1; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }
}