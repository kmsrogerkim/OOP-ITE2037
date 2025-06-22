package Assignment1;

public class JackpotManager
{
    private int jackpot_balance = 500;

    public void add_to_balance(int num_tickets)
    {
        this.jackpot_balance+= 5*num_tickets;
    }

    public int get_jackpot_balance()
    {
        return this.jackpot_balance;
    }

    public void reset_jackpot_balance()
    {
        this.jackpot_balance = 500;
    }
}