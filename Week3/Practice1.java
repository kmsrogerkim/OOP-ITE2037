import java.util.Scanner;

public class Practice1{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter coefficients a1, b1, c1, a2, b2, c3: ");

        int a1 = scanner.nextInt();
        int b1 = scanner.nextInt();
        int c1 = scanner.nextInt();
        int a2 = scanner.nextInt();
        int b2 = scanner.nextInt();
        int c2 = scanner.nextInt();
        scanner.close();

        for (int x = -1; x<3; x++)
        {
            double leftSide = (-a1 * x + c1) / (double) b1;
            if (Math.abs(leftSide) < 1e-6) {
                leftSide = 0.0;
            }
            double rightSide = (-a2 * x + c2) / (double) b2;
            if (Math.abs(leftSide) < 1e-6) {
                leftSide = 0.0;
            }
            if (leftSide == rightSide)
            {
                System.out.printf("Intersection point: (%.3f, %.3f)\n", 
                                                (double) x, leftSide);
            }
        }
    }
} 