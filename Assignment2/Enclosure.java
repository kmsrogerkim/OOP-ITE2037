package Assignment2;

public class Enclosure 
{
    private Animal animal;
    private int daysSinceCleaned = 0;

    public void assignAnimal(Animal a) 
    {
        animal = a;
        daysSinceCleaned = 0;
    }

    public void removeAnimal() 
    {
        animal = null;
    }

    public void feedAnimal() 
    {
        if (animal != null) 
        {
            animal.feed();
        }
    }

    public boolean isEmpty() 
    {
        return animal == null;
    }

    public boolean isOccupiedAndAlive() 
    {
        return animal != null && animal.isAlive();
    }

    public Animal getAnimal() 
    {
        return animal;
    }

    public void clean() 
    {
        daysSinceCleaned = 0;
        System.out.println(">> Enclosure cleaned.");
    }

    public void passDay() 
    {
        if (animal != null) 
        {
            daysSinceCleaned++;
            animal.increaseHunger();

            if (daysSinceCleaned >= 3) 
            {
                System.out.println(">> Enclosure should be cleaned!");
                animal.takeDamage(20);
            }
            
            if (!animal.isAlive()) 
            {
                System.out.println(">> " + animal.name + " has died due to poor health.");
                removeAnimal();
            }
        }
    }

    public int generateIncome() 
    {
        if (isOccupiedAndAlive() && animal.canEarnIncome()) 
        {
            return animal.getDailyIncome();
        }
        return 0;
    }

    public Enclosure deepCopy() 
    {
        Enclosure copy = new Enclosure();
        copy.daysSinceCleaned = this.daysSinceCleaned;
        if (animal != null) 
        {
            copy.assignAnimal(animal.clone());
        }
        return copy;
    }

    @Override
    public String toString() 
    {
        if (animal == null) 
        {
            return "Empty";
        }
    
        String str = animal.getStatus();
        return str;
    }
    
}
