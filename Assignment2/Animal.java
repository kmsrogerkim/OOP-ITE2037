package Assignment2;

public abstract class Animal
{
    protected String name;
    protected int health;
    protected int max_health;
    protected int hunger;

    public Animal(String name, int health)
    {
        this.name = name;
        this.health = health;
        this.max_health = health;
        this.hunger = 0;
    }

    public void feed()
    {
        hunger = 0;
    }

    public void increaseHunger()
    {
        hunger += 10;
        if (hunger > getHungerLimit())
        {
            takeDamage(20);
            System.out.println(">> " + name + " is hungry!");
        }
        else
        {
            health = (health + 10 < getmax_health()) ?  health+10:getmax_health();
        }
    }

    public void takeDamage(int dmg)
    {
        health -= dmg;
    }

    public boolean isAlive()
    {
        return health > 0;
    }

    public boolean canEarnIncome()
    {
        return health >= getHealthLimit();
    }

    public String getStatus()
    {
        String res = name + " (HP: " + health + ", Hunger: " + hunger  + ", isHealthy: " + canEarnIncome() + ")";
        return res;
    }
    
    public abstract void makeSound();
    public abstract int getDailyIncome();
    public abstract int getHungerLimit();
    public abstract int getHealthLimit();
    public abstract int getPrice();
    public abstract int getFeedCost();
    public abstract Animal clone();
    
    public abstract String getName();
    public abstract String getType();
    public abstract int getmax_health();
}
