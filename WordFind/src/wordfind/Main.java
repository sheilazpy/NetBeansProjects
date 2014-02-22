/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wordfind;

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
        int size, startX = 0, startY = 0, endX = 0, endY = 0;
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
                if (grid[startX][startY] == word.charAt(0)) {
                    found = true;
                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            for (int mult = 0; mult < word.length(); mult++) {
                                endX = startX + i * mult;
                                endY = startY + j * mult;
                                if (endX < 0 || endX >= size || endY < 0 || endY >= size || grid[endX][endY] != word.charAt(mult)) {
                                    found = false;
                                    break;
                                }//if
                                else {
                                    found = true;
                                    grid[endX][endY]='*';
                                }//else
                            }//for
                            if (found) {
                                break;
                            }//if
                        }//for
                        if (found) {
                            break;
                        }//if
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
            System.out.println(word + " <" + startX + ", " + startY + "><" + endX +
                    ", " + endY + ">");
        }//else
    }//main method
}//Main class

