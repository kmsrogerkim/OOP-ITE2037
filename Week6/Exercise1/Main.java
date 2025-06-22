package Week6.Exercise1;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Enter information for Person 1:\nName: ");
        String name1 = scanner.nextLine();
        System.out.print("Birth year: ");
        int by1 = scanner.nextInt();
        System.out.print("Birth month: ");
        int bm1 = scanner.nextInt();
        System.out.print("Birth day: ");
        int bd1 = scanner.nextInt();

        Person person1 = new Person(name1, by1, bm1, bd1);
        scanner.nextLine();

        System.out.printf("Enter information for Person 2:\nName: ");
        String name2 = scanner.nextLine();
        System.out.print("Birth year: ");
        int by2 = scanner.nextInt();
        System.out.print("Birth month: ");
        int bm2 = scanner.nextInt();
        System.out.print("Birth day: ");
        int bd2 = scanner.nextInt();

        Person person2 = new Person(name2, by2, bm2, bd2);
        scanner.close();

        int result = AgeCalculator.isOlder(person1, person2);
        if (result == 1) 
        {
            System.out.printf("%s is older than %s\n", name1, name2);
        }
        else if (result == 0)
        {
            System.out.printf("%s and %s are the same age\n", name1, name2);
        }
        else
        {
            System.out.printf("%s is younger than %s\n", name1, name2);
        }

    }
} 