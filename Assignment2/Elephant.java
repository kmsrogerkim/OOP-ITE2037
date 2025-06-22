package Assignment2;

public class Elephant extends Animal 
{
    public Elephant(String name) 
    {
        super(name, 250);
    }

    @Override
    public void makeSound() 
    {
        System.out.println("Elephant " + name + ": Pawoo!");
    }

    @Override
    public int getDailyIncome() 
    {
        return 40;
    }

    @Override
    public int getHungerLimit() 
    {
        return 40;
    }

    @Override
    public int getHealthLimit() 
    {
        return 50;
    }

    @Override
    public int getPrice() 
    {
        return 200;
    }

    @Override
    public int getFeedCost() 
    {
        return 20;
    }

    @Override
    public Animal clone() 
    {
        Elephant copy = new Elephant(name);
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
        return "Elephant";
    }

    @Override
    public int getmax_health()
    {
        return max_health;
    }
}
