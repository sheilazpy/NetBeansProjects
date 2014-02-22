/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reversecomplement;

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
        String sequence;
        StringBuffer reverseComp;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter sequence: ");
        sequence = scan.next();
        reverseComp = new StringBuffer(sequence);
        reverseComp.reverse();
        for (int pos = 0; pos < reverseComp.length(); pos++) {
            switch (reverseComp.charAt(pos)) {
                case 'A':
                    reverseComp.setCharAt(pos, 'T');
                    break;
                case 'C':
                    reverseComp.setCharAt(pos, 'G');
                    break;
                case 'G':
                    reverseComp.setCharAt(pos, 'C');
                    break;
                case 'T':
                    reverseComp.setCharAt(pos, 'A');
                    break;
                default:
                    reverseComp = new StringBuffer("Invalid sequence");
                    pos = reverseComp.length();
                    break;
            }//switch
        }//for
        System.out.println(reverseComp.toString());
    }//main method
}//Main class

