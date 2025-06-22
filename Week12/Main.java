package Week12;
import java.util.Scanner;

public class Main {
    static boolean isValidTriangle(int a, int b, int c) throws MyException
    {
        if (a <= 0 || b <= 0 || c <= 0)
        {
            throw new MyException("one or more sides are non-positive");
        }
        else if (a == b && b == c)
        {
            throw new MyException("all three sides are equal");
        }
        else if (a + b <= c || a + c <= b || b + c <= a)
        {
            throw new MyException("triangle inequality violated");
        }
        return true;
    }

   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a,b,c;
        System.out.print("Enter 3 integers: ");        
        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();
        scanner.close();

        try
        {
            boolean isValid = isValidTriangle(a,b,c);
            if (isValid) System.out.println("Valid triangle.");
        }
        catch (MyException e)
        {
            String error = e.getMessage();
            System.out.println(error);
        }
   } 
}
