/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rolldistribution;

/**
 *
 * @author 1003125
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int roll;
        int[] rollTable = new int[13];
        for (int i = 0; i < 1000; i++) {
            roll = (int) (Math.random() * 6) + (int) (Math.random() * 6) + 2;
            rollTable[roll]++;
        }//for
        System.out.println("Outcomes");
        for (int i = 2; i < 10; i++) {
            System.out.println(i + "    " + rollTable[i]);
        }//for
        for (int i = 10; i < 13; i++) {
            System.out.println(i + "   " + rollTable[i]);
        }//for
    }//main method
}//Main class

