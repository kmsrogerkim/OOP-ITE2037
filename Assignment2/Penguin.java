package Assignment2;

public class Penguin extends Animal 
{
    public Penguin(String name) 
    {
        super(name, 80);
    }

    @Override
    public void makeSound() 
    {
        System.out.println("Penguin " + name + ": Squawk!");
    }

    @Override
    public int getDailyIncome() 
    {
        return 25;
    }

    @Override
    public int getHungerLimit() 
    {
        return 50;
    }

    @Override
    public int getHealthLimit() 
    {
        return 10;
    }

    @Override
    public int getPrice() 
    {
        return 100;
    }

    @Override
    public int getFeedCost() 
    {
        return 5;
    }

    @Override
    public Animal clone() 
    {
        Penguin copy = new Penguin(name);
        copy.health = this.health;
        copy.hunger = this.hunger;
        copy.max_health = this.max_health;
        return copy;
    }
    
    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public String getType()
    {
        return "Penguin";
    }

    @Override
    public int getmax_health()
    {
        return max_health;
    }
}
