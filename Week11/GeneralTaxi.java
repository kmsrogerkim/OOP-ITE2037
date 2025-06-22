package Week11;

public class GeneralTaxi extends Taxi 
{
    private double farePerKilometer;
    private double baseDistance = 3;
    private double baseFee = 3;

    public GeneralTaxi(int carNum, double farePerKilometer)
    {
        super(carNum);

        if (farePerKilometer <= baseFee / baseDistance)
        {
            System.out.println("farePerKilometer Error");
        }

        if (carNum < 1000 || carNum > 9999)
        {
            throw new IllegalArgumentException("carNum must be between 1000 and 9999");
        }

        this.farePerKilometer = farePerKilometer;
    }

    @Override
    public String toString()
    {
        return "General Taxi" + 
               " - Taxi Number: " + carNum +
               ", Total Distance: " + distance +
               ", Total Income: " + income;
    }


    @Override
    public void getPaid(double dis)
    {
        if (dis < baseDistance)
        {
            income += baseFee;
        }
        else 
        {
            income += baseFee + (dis - baseDistance) * farePerKilometer;
        }
    }
}

