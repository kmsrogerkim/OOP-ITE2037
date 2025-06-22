package Week4;

import java.util.Scanner;

public class Practice1{
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n; 
        }
        return fibonacci(n - 1) + fibonacci(n - 2); 
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input N: ");
        int n = scanner.nextInt();
        System.err.printf("%d-th Fibonacci number: %d\n", n, fibonacci(n));
        scanner.close();
    }
} 