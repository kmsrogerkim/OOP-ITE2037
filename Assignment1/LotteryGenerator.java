package Assignment1;
import java.util.Random;

public class LotteryGenerator
{
    public boolean check_unique(int random_number, int[] lottery_numbers)
    {
        for (int num : lottery_numbers)
        {
            if (num == random_number) {
                return false;
            }
        }
        return true;
    }

    public int get_bonus_number(int[] lottery_numbers)
    {
        while (true)
        {
            Random rand = new Random();  
            int random_number = rand.nextInt(20) + 1;
            boolean unique = this.check_unique(random_number, lottery_numbers);
        
            if (unique) 
            {
                return random_number;
            }
        }
    }

    public int[] get_lottery_numbers() 
    {
        int[] lottery_numbers = new int[6];
    
        int i = 0;
        Random rand = new Random();  
        while (i < 6) 
        {  
            int random_number = rand.nextInt(20) + 1;
            boolean unique = this.check_unique(random_number, lottery_numbers);
    
            if (unique) 
            {
                lottery_numbers[i] = random_number;
                i++;  
            }
        }
    
        return lottery_numbers;
    }
}
