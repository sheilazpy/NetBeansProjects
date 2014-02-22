package fibonacci;

public class Main {
    
    public static void main(String[] args) {
        long n, fibonacci, startTime, endTime, runTime;
        double fibonacci2;
        
        for (n = 1; n <= 1000000000; n *= 10) {
            System.out.println("n: " + n);
            
            startTime = System.currentTimeMillis();
            fibonacci = fibonacciRecursive(n);
            endTime = System.currentTimeMillis();
            runTime = endTime - startTime;
            System.out.println("Recursive: " + fibonacci);
            System.out.println("Runtime: " + runTime + " ms");
            
            startTime = System.currentTimeMillis();
            fibonacci = fibonacciInductive(n);
            endTime = System.currentTimeMillis();
            runTime = endTime - startTime;
            System.out.println("Inductive: " + fibonacci);
            System.out.println("Runtime: " + runTime + " ms");
            
            startTime = System.currentTimeMillis();
            fibonacci2 = fibonacciFormula(n);
            endTime = System.currentTimeMillis();
            runTime = endTime - startTime;
            System.out.println("Formula: " + fibonacci2);
            System.out.println("Runtime: " + runTime + " ms");
        }//for
    }//main method
    
    public static long fibonacciRecursive(long n) {
        if (n <= 1) {
            return 1;
        }//if
        else {
            return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
        }//else
    }//fibonacciRecursive method

    public static long fibonacciInductive(long n) {
        long current = 1, previous = 1, next;
        for (long i = 2; i <= n; i++) {
            next = current + previous;
            previous = current;
            current = next;
        }//for
        return current;
    }//fibonacciInductive method

    public static double fibonacciFormula(long n) {
        return 1 / Math.sqrt(5) * Math.pow((1 + Math.sqrt(5)) / 2, n + 1)
                - 1 / Math.sqrt(5) * Math.pow((1 - Math.sqrt(5)) / 2, n + 1);
    }//fibonacciFormula method
    
}//Main class

