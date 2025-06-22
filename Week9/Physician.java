package Week9;

public class Physician extends Doctor{
    public Physician(String name, int age, String hospital)
    {
        super(name, age, hospital);
    }

    @Override
    public void examination(Patient p)
    {
        if (p.getDepartment().equals("internal"))
        {
            System.out.println("I'll take care of you!");
        }
        else
        {
            System.out.println("Sorry, but it's not my major");
        }
    }
}