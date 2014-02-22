/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package equivalence;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class Equivalence {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(new File("data.txt"));
            int n = scan.nextInt();
            boolean reflexive = true, symmetric = true, transitive = true;
            boolean[][] relation = new boolean[5][5];
            System.out.println("R = ");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int value = scan.nextInt();
                    System.out.print(value + " ");
                    relation[i][j] = (value == 1);
                }//for
                System.out.println();
            }//for
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j && !relation[i][j]) {
                        reflexive = false;
                    }//if
                    if (relation[i][j] != relation[j][i]) {
                        symmetric = false;
                    }//if
                    if (relation[i][j]) {
                        for (int k = 0; k < n; k++) {
                            if (relation[j][k] && !relation[i][k]) {
                                transitive = false;
                            }//if
                        }//for
                    }//if
                }//for
            }//for
            if (reflexive && symmetric && transitive) {
                System.out.println("R is an equivalence relation.");
                System.out.println("Equivalence classes:");
                boolean[] found = new boolean[n];
                for (int i = 0; i < n; i++) {
                    if (!found[i]) {
                        for (int j = i; j < n; j++) {
                            if (relation[i][j]) {
                                System.out.print((j + 1) + " ");
                                found[j] = true;
                            }//if
                        }//for
                        System.out.println();
                    }//if
                }//for
            } else {
                System.out.println("R is not an equivalence relation.");
                if (!reflexive) {
                    System.out.println("R is not reflexive.");
                }//if
                if (!symmetric) {
                    System.out.println("R is not symmetric.");
                }//if
                if (!transitive) {
                    System.out.println("R is not transitive.");
                }//if
            }//if-else
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }//try-catch
    }//main method
}//Equivalence class
