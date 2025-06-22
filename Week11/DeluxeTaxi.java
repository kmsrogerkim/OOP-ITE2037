package Week11;

public class DeluxeTaxi extends Taxi{
    private double farePerKilometer;
    private double baseDistance = 3;
    private double baseFee = 5;

    public DeluxeTaxi(int carNum, double farePerKilometer)
    {
        super(carNum); 

        if (farePerKilometer <= baseFee / baseDistance)
        {
            System.out.println("farePerKilometer Error");
        }

        if (carNum < 1000 || carNum > 9999)
        {
            System.out.println("carNum Error");
        }
        this.carNum = carNum;
        this.farePerKilometer = farePerKilometer;
    }

    @Override
    public String toString()
    {
        return "Deluxe Taxi" + 
               " - Taxi Number: " + carNum +
               ", Total Distance: " + distance +
               ", Total Income: " + income;
    }

    @Override
    public void getPaid(double dis)
    {
        if (dis < baseDistance)
        {
            this.income += baseFee;
        }
        else 
        {
            this.income += baseFee + (dis - baseDistance)*farePerKilometer;
        }
    }
}
