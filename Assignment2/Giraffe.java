package Assignment2;

public class Giraffe extends Animal 
{
    public Giraffe(String name) 
    {
        super(name, 100);
    }

    @Override
    public void makeSound() 
    {
        System.out.println("Giraffe " + name + ": Hmmmmm!");
    }

    @Override
    public int getDailyIncome() 
    {
        return 50;
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
        return 150;
    }

    @Override
    public int getFeedCost() 
    {
        return 15;
    }

    @Override
    public Animal clone() 
    {
        Giraffe copy = new Giraffe(name);
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
        return "Giraffe";
    }

    @Override
    public int getmax_health()
    {
        return max_health;
    }
}
