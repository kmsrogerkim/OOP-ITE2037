package Assignment2;

public class Lion extends Animal 
{
    public Lion(String name) 
    {
        super(name, 100);
    }

    @Override
    public void makeSound() 
    {
        System.out.println("Lion " + name + ": Roarrr!");
    }

    @Override
    public int getDailyIncome() 
    {
        return 200;
    }

    @Override
    public int getHungerLimit() 
    {
        return 20;
    }

    @Override
    public int getHealthLimit() 
    {
        return 80;
    }

    @Override
    public int getPrice() 
    {
        return 300;
    }

    @Override
    public int getFeedCost() 
    {
        return 50;
    }

    @Override
    public Animal clone() 
    {
        Lion copy = new Lion(name);
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
        return "Lion";
    }

    @Override
    public int getmax_health()
    {
        return max_health;
    }
}
