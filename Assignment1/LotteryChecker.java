package Assignment1;

public class LotteryChecker
{
    private JackpotManager jm = new JackpotManager();

    public void print_array(int[] arr)
    {
        for (int i : arr)
        {
            System.out.printf("%d ", i);
        }
    }

    public int get_position(int[] lottery, int[] my_lottery, int bonus_number)
    {
        int matching_numbers = 0;
        boolean match_bonus = false;

        for (int num : lottery)
        {
            for (int my_num : my_lottery)
            {
                if (num == my_num) matching_numbers++;
            }
        }
        for (int my_num: my_lottery)
        {
            if (my_num == bonus_number) match_bonus = true; break;
        }

        if ((matching_numbers == 6) || (matching_numbers == 5 && match_bonus))
        {
            return 1;
        }
        if ((matching_numbers == 5) || (matching_numbers == 4 && match_bonus))
        {
            return 2;
        }
        if (matching_numbers == 4)
        {
            return 3;
        }
        if (matching_numbers == 3)
        {
            return 4;
        }
        else
        {
            return 0;
        }
    }

    public int check_lotteries(int num_tickets, int[] lottery, int bonus_number, int[][] user_lotteries, int balance)
    {
        this.jm.add_to_balance(num_tickets);

        System.out.print(">> Round Winning numbers: ");
        this.print_array(lottery);
        System.out.printf("+ %d\n", bonus_number);

        int num_first_place = 0;
        int num_second_place = 0;
        int num_third_place = 0;
        int num_fourth_place = 0;
        int original_balance = balance;
        
        boolean jackpot = false; 
        for (int i = 0; i < num_tickets; i++)
        {
            System.out.printf(">> Lottery numbers: ");
            this.print_array(user_lotteries[i]);

            int position = this.get_position(lottery, user_lotteries[i], bonus_number);
            if (position == 1)
            {
                balance += 100 + this.jm.get_jackpot_balance();
                jackpot = true;
                num_first_place++;
                System.out.printf(" Winner (1st place)\n");
            }
            else if (position == 2)
            {
                balance += 50;
                num_second_place++;
                System.out.printf(" Winner (2nd place)\n");
            }
            else if (position == 3)
            {
                balance += 20;
                num_third_place++;
                System.out.printf(" Winner (3rd place)\n");
            }
            else if (position == 4)
            {
                balance += 10;
                num_fourth_place++;
                System.out.printf(" Winner (4th place)\n");
            }
            else
            {
                System.out.printf(" Lose\n");
            }
        }
        if (jackpot)
        {
            this.jm.reset_jackpot_balance();
        }

        System.out.printf(">> The number of 1st place: %d\n", num_first_place);
        System.out.printf(">> The number of 2nd place: %d\n", num_second_place);
        System.out.printf(">> The number of 3rd place: %d\n", num_third_place);
        System.out.printf(">> The number of 4th place: %d\n", num_fourth_place);
        if (jackpot) System.out.println(">> Jackpot!"); jackpot = false;
        System.out.printf(">> Total winnings: %d\n", balance - original_balance);
        System.out.printf(">> Current funds: %d\n", balance);
        System.out.printf(">> Jackpot amount: %d\n", this.jm.get_jackpot_balance());

        return balance;
    }
}