package Week11;

public abstract class Taxi
{
    protected int carNum;
    protected double distance;
    protected double income;

    public Taxi(int carNum)
    {
        if (carNum < 1000 || carNum > 9999)
        {
            throw new IllegalArgumentException("carNum must be between 1000 and 9999");
        }
        this.carNum = carNum;
        this.distance = 0;
        this.income = 0;
    }

    @Override
    public String toString()
    {
        return "Taxi Number: " + carNum +
               ", Total Distance: " + distance +
               ", Total Income: " + income;
    }


    public abstract void getPaid(double distance);

    public void doDrive(double dis)
    {
        this.distance += dis;
        getPaid(dis);
    }

    public boolean earnMore(Taxi t)
    {
        return this.income > t.income;
    }
}
