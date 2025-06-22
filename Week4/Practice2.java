package Week4;

import java.util.Random;
import java.util.Scanner;

public class Practice2{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        int user_point = 0;

        System.out.printf("Welcome to the Even or Odd Streak Game!\nTry to guess if the number is Even or Odd.\nIf you get 3 in a row, you win!\n");
        while (true)
        {
            int random_number = rand.nextInt(100) + 1;
            boolean is_even = (random_number % 2 == 0) ? true : false;

            String user_input;
            System.out.print("Is the number Even or 0dd? (Type 'even' or 'odd'): ");
            user_input = scanner.nextLine();
            if (user_input.equalsIgnoreCase("even") && is_even)
            {
                user_point++;
                System.out.printf("Correct! The numebr was %d. Streak: %d\n", random_number, user_point);
            }
            else if (user_input.equalsIgnoreCase("odd") && !is_even)
            {
                user_point++;
            }
            else 
            {
                scanner.close();
                System.out.printf("Wrong! The number was %d.\nGame Over. Your streak was: %d\n", random_number, user_point);
                System.exit(0);
            }

            if (user_point > 2)
            {
                scanner.close();
                System.out.printf("Congratulations! You won with a 3-streak!\n");
                System.exit(0);
            }
        }
    }
} 