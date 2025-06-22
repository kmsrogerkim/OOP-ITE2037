package Assignment1;
import java.util.Scanner;

public class Main{
    public static void exit_program()
    {
        System.out.println(">> End of program");
        System.exit(0);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        final int lottery_price = 10; 

        LotteryGenerator lg = new LotteryGenerator();
        LotteryChecker lc = new LotteryChecker();

        System.out.printf("Enter your money:\n<< ");
        int balance = scanner.nextInt();

        while (true) 
        {
            if (balance < lottery_price)
            {
                System.out.println(">> You don't have enough money to buy a ticket.");
                scanner.close();
                exit_program();
            }
            System.out.printf(">> Enter the number of tickets to buy (0 to exit):\n<< ");
            int num_tickets = scanner.nextInt();
            if (num_tickets == 0) 
            {
                scanner.close(); 
                exit_program();
            }
            if ((balance - num_tickets * lottery_price) < 0) 
            {
                System.out.println(">> You don’t have enough money to buy that many tickets.");
                continue;
            }
            balance -= num_tickets * lottery_price;

            int[] lottery = lg.get_lottery_numbers();
            int bonus_number = lg.get_bonus_number(lottery);

            int[][] user_lotteries = new int[num_tickets][6];
            for (int i = 0; i < num_tickets; i++)
            {
                user_lotteries[i] = lg.get_lottery_numbers();
            }

            balance = lc.check_lotteries(num_tickets, lottery, bonus_number, user_lotteries, balance);
        }
    }
} 
