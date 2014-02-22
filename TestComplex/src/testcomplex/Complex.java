/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testcomplex;

/**
 *
 * @author 1003125
 */
public class Complex {

    double real, imaginary;
    static Complex answer = new Complex();

    public Complex() {
        real = 0;
        imaginary = 0;
    }//Complex constructor

    public Complex(double r, double i) {
        real = r;
        imaginary = i;
    }//Complex constructor

    void add(Complex c1) {
        real += c1.real;
        imaginary += c1.imaginary;
    }//add method

    static Complex add(Complex c1, Complex c2) {
        answer.real = c1.real + c2.real;
        answer.imaginary = c1.imaginary + c2.imaginary;
        return answer;
    }//add method

    void subtract(Complex c1) {
        real -= c1.real;
        imaginary -= c1.imaginary;
    }//subtract method

    static Complex subtract(Complex c1, Complex c2) {
        answer.real = c1.real - c2.real;
        answer.imaginary = c1.imaginary - c2.imaginary;
        return answer;
    }//subtract method

    void multiply(Complex c1) {
        real = real * c1.real - imaginary * c1.imaginary;
        imaginary = real * c1.imaginary + imaginary * c1.real;
    }//multiply method

    static Complex multiply(Complex c1, Complex c2) {
        answer.real = c1.real * c2.real - c1.imaginary * c2.imaginary;
        answer.imaginary = c1.real * c2.imaginary + c1.imaginary * c2.real;
        return answer;
    }//multiply method

    void divide(Complex c1) {
        Complex c2 = new Complex(c1.real, -c1.imaginary);
        multiply(c2);
        c1.multiply(c2);
        real /= c1.real;
        imaginary /= c1.real;
    }//divide method

    static Complex divide(Complex c1, Complex c2) {
        answer.real = c1.real * c2.real + c1.imaginary * c2.imaginary;
        answer.real /= c2.real * c2.real + c2.imaginary * c2.imaginary;
        answer.imaginary = -c1.real * c2.imaginary + c1.imaginary * c2.real;
        answer.imaginary /= c2.real * c2.real + c2.imaginary * c2.imaginary;
        return answer;
    }//add method

    void print() {
        if (imaginary >= 0) {
            System.out.println(real + " + " + imaginary + "i");
        }//if
        else {
            System.out.println(real + " - " + Math.abs(imaginary) + "i");
        }//else
    }//print method
}//Complex class

