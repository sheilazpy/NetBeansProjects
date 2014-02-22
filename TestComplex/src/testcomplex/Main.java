/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testcomplex;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author 1003125
 */
public class Main {

    private static Complex createComplex() {
        double real, imaginary;
        String realStr, imagStr;
        String complex;
        StringTokenizer findNums;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a complex number:");
        //System.out.println("Enter the real part:  ");
        //real = scan.nextDouble();
        complex = scan.nextLine();
        findNums = new StringTokenizer(complex, "+-iI");
        realStr = findNums.nextToken();
        real = Double.parseDouble(realStr);
        imagStr = findNums.nextToken();
        imaginary = Double.parseDouble(imagStr);
        if (complex.charAt(0) == '-') {
            real = -real;
        }
        if (complex.charAt(complex.length() - imagStr.length() - 2) == '-') {
            imaginary = -imaginary;
        }
        //System.out.println("Enter the imaginary part:  ");
        //imaginary = scan.nextDouble();
        Complex c = new Complex(real, imaginary);
        return c;
    }//createComplex method

    public static void main(String[] args) {
        int option;
        Complex c1, c2, c3;
        Scanner scan = new Scanner(System.in);
        //c1 = createComplex();
        do {
            System.out.println("1 = Add 2 complex numbers");
            System.out.println("2 = Subtract 2 complex numbers");
            System.out.println("3 = Multiply 2 complex numbers");
            System.out.println("4 = Divide 2 complex numbers");
            //System.out.println("5 = Print the complex number");
            System.out.println("5 = Quit");
            System.out.println("Choose an option:  ");
            option = scan.nextInt();
            switch (option) {
                case 1:
                    c1 = createComplex();
                    c2 = createComplex();
                    c3 = Complex.add(c1, c2);
                    c3.print();
                    break;
                case 2:
                    c1 = createComplex();
                    c2 = createComplex();
                    c3 = Complex.subtract(c1, c2);
                    c3.print();
                    break;
                case 3:
                    c1 = createComplex();
                    c2 = createComplex();
                    c3 = Complex.multiply(c1, c2);
                    c3.print();
                    break;
                case 4:
                    c1 = createComplex();
                    c2 = createComplex();
                    c3 = Complex.divide(c1, c2);
                    c3.print();
                    break;
//                case 5:
//                    c1.print();
//                    break;
                case 5:
                    break;
                default:
                    break;
            }//switch
        } while (option != 5);
    }//main method
}//Main class

