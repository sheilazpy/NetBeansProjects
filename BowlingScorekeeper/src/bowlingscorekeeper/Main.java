/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bowlingscorekeeper;

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
        String game;
        StringTokenizer scores;
        int score = 0, length, start;
        int[] rolls;
        int[][] frames = new int[10][2];
        Scanner scan = new Scanner(System.in);
        System.out.println("Scores: ");
        game = scan.nextLine();
        scores = new StringTokenizer(game);
        length = scores.countTokens();
        rolls = new int[length];
        for (int i = 0; i < length; i++) {
            rolls[i] = scores.nextToken().charAt(0);
        }//for
        scores = new StringTokenizer(game);
        for(int i = 0; i<10;i++)
        {
            frames[i][0]= scores.nextToken().charAt(0);
            if(frames[i][0]!='X')
            {
                frames[i][1]= scores.nextToken().charAt(0);
            }//if
        }//for
        start = length - 1;
        if (frames[9][1] == '/') {
            start = length - 2;
        }//if
        if (frames[9][0] == 'X') {
            start = length - 3;
        }//if
        for (int i = length - 1; i >= 0; i--) {
            switch (rolls[i]) {
                case 'X':
                    rolls[i] = 10;
                    if (i <= start) {
                        score += 10;
                        if (i < length - 1) {
                            score += rolls[i + 1];
                        }//if
                        if (i < length - 2) {
                            score += rolls[i + 2];
                        }//if
                    }//if
                    break;
                case '/':
                    rolls[i] = 10 - rolls[i - 1] + 48;
                    if (i <= start) {
                        score += rolls[i];
                        if (i < length - 1) {
                            score += rolls[i + 1];
                        }//if
                    }//if
                    break;
                default:
                    rolls[i] -= 48;
                    if (i <= start) {
                        score += rolls[i];
                    }//if
                    break;
            }//switch
        }//for
        System.out.println(score);
    }//main method
}//Main class

