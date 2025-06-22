package Assignment2;

import java.util.Scanner;
import java.util.Stack;

public class Main 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        Zoo zoo = new Zoo();
        Stack<Zoo> backups = new Stack<>();
        int inpt;

        System.out.println("*** Welcome to Zoo Tycoon! ***");
        while (true) 
        {
            if (zoo.isGameOver())
            {
                System.out.println(">> You're out of money. Game over!");
                return;
            }
            if (zoo.isWon())
            {
                System.out.println("Congratulations! You've achieved a 5-star zoo!");
                return;
            }

            System.out.println("(1) Build enclosure ($100)");
            System.out.println("(2) Buy animal");
            System.out.println("(3) Sell animal");
            System.out.println("(4) Feed animal");
            System.out.println("(5) Clean all enclosures");
            System.out.println("(6) Show zoo status");
            System.out.println("(7) Pass a day");
            System.out.println("(8) Rollback to previous day");
            System.out.println("(9) Exit");
            System.out.print("<< ");

            inpt = scanner.nextInt();
            scanner.nextLine();

            switch (inpt) 
            {
                case 1:
                    zoo.buildEnclosure();
                    break;
                case 2:
                    zoo.buyAnimal(scanner);
                    break;
                case 3:
                    zoo.sellAnimal(scanner);
                    break;
                case 4:
                    zoo.feedSelectedAnimal(scanner);
                    break;
                case 5:
                    zoo.cleanAll();
                    break;
                case 6:
                    zoo.showStatus();
                    break;
                case 7:
                    backups.push(zoo.deepCopy());
                    zoo.passDay();
                    break;
                case 8:
                    if (backups.isEmpty())
                    {
                        System.out.println(">> No back-up available to roll back to.");
                        break;
                    }
                    zoo = backups.pop();
                    System.out.println(">> Rolled back to the previous day.");
                    break;
                case 9:
                    System.out.println(">> Thank you for playing!");
                    return;
                default:
                    System.out.println(">> Invalid choice.");
            }
        }
    }
}
