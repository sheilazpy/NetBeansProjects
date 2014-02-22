/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package palindromerecognizer;

import java.util.Scanner;

/**
 *
 * @author 1003125
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String first, second;
        StringBuffer palindrome;
        boolean test = false;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter palindrome: ");
        first = scan.nextLine();
        palindrome = new StringBuffer(first);
        for (int pos = 0; pos < palindrome.length(); pos++) {
            if (palindrome.charAt(pos) > 122 || palindrome.charAt(pos) < 97 &&
                    palindrome.charAt(pos) != 42) {
                palindrome.deleteCharAt(pos);
                pos--;
            }//if
        }//for
        for (int pos = 0; pos < palindrome.length(); pos++) {
            if (palindrome.charAt(pos) == '*') {
                palindrome.setCharAt(palindrome.length() - pos - 1, '*');
            }//if
        }//for
        first = palindrome.toString();
        second = palindrome.reverse().toString();
        if (first.equals(second)) {
            test = true;
        }//if
        System.out.println(test);
    }//main method
}//Main class

