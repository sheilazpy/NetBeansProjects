/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boggle;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author 1003125
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String input, word;
        StringTokenizer count;
        int size, startX = 0, startY = 0, endX = 0, endY = 0, nextX, nextY;
        char[][] grid;
        boolean found = false;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter grid: ");
        input = scan.nextLine();
        count = new StringTokenizer(input);
        size = count.countTokens();
        grid = new char[size][size];
        for (int i = 0; i < size; i++) {
            grid[0][i] = count.nextToken().charAt(0);
        }//for
        for (int i = 1; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = scan.next().charAt(0);
            }//for
        }//for
        System.out.println("Enter word: ");
        word = scan.next();
        for (startX = 0; startX < size; startX++) {
            for (startY = 0; startY < size; startY++) {
                nextX=startX;
                nextY=startY;
                if (grid[startX][startY] == word.charAt(0)) {
                    found = true;
                    for (int loop = 1; loop < word.length(); loop++) {
                        for (int i = -1; i <= 1; i++) {
                            for (int j = -1; j <= 1; j++) {
                                endX = nextX + i;
                                endY = nextY + j;
                                if (endX < 0 || endX >= size || endY < 0 || endY >= size || grid[endX][endY] != word.charAt(loop)) {
                                    found = false;
                                }//if
                                else {
                                    found = true;
                                    System.out.println(grid[endX][endY]);
                                    grid[endX][endY] = '*';
                                    nextX=endX;
                                    nextY=endY;
                                    break;
                                }//else
                            }//for
                            if (found) {
                                break;
                            }//if
                        }//for
                    }//for
                }//if
                if (found) {
                    break;
                }//if
            }//for
            if (found) {
                break;
            }//if
        }//for
        if (!found) {
            System.out.println(word + " not found");
        }//if
        else {
            System.out.println(word + " found");
        }//else
    }//main method
}//Main class

