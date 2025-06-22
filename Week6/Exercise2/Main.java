package Week6.Exercise2;

public class Main {
    public static void main(String[] args) {
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();
        
        System.out.println("Input first polynomial:");
        p1.inputPolynomial();
        
        System.out.println("Input second polynomial:");
        p2.inputPolynomial();
        
        Polynomial sum = p1.add(p2);
        Polynomial diff = p1.subtract(p2);
        
        System.out.println("First Polynomial: " + p1);
        System.out.println("Second Polynomial: " + p2);
        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + diff);
        System.out.println("Evaluation of first polynomial at x = 2: "+ p1.evaluate(2));
    }
}