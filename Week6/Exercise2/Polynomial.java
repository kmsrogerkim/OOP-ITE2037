package Week6.Exercise2;
import java.util.Scanner;

public class Polynomial {
    private int a;
    private int b;
    private int c;

    public Polynomial()
    {
        a = 0;
        b = 0;
        c = 0;
    }

    public void inputPolynomial()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter coefficient a (for x^2): ");
        this.setA(scanner.nextInt());
        System.out.print("Enter coefficient b (for x): ");
        this.setB(scanner.nextInt());
        System.out.print("Enter coefficient c (constant term): ");
        this.setC(scanner.nextInt());
        scanner.nextLine();
    }

    public void setA(int a)
    {
        this.a = a;
    }
    public void setB(int a)
    {
        this.b = a;
    }
    public void setC(int a)
    {
        this.c = a;
    }

    public int getA()
    {
        return this.a;
    }
    public int getB()
    {
        return this.b;
    }
    public int getC()
    {
        return this.c;
    }

    public Polynomial add(Polynomial other)
    {
        Polynomial newPolynomial = new Polynomial();
        newPolynomial.setA(this.getA() + other.getA());
        newPolynomial.setB(this.getB() + other.getB());
        newPolynomial.setC(this.getC() + other.getC());
        return newPolynomial;
    }
    
    public Polynomial subtract(Polynomial other)
    {
        Polynomial newPolynomial = new Polynomial();
        newPolynomial.setA(this.getA() - other.getA());
        newPolynomial.setB(this.getB() - other.getB());
        newPolynomial.setC(this.getC() - other.getC());
        return newPolynomial;

    } 

    public int evaluate(int x)
    {
        return this.a * x * x + this.b * x + this.c;
    }

    public String toString()
    {
        return a + "x^2 + " + b + "x + " + c;
    }
}
