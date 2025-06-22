package Assignment2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Zoo 
{
    private int money = 500;
    private int stars = 1;
    private int day = 1;
    private int consecutiveHealthyDays = 0;
    private List<Enclosure> enclosures = new ArrayList<>();
    private boolean haveAnimals = false;

    public void buildEnclosure() 
    {
        System.out.print(">> ");

        if (enclosures.size() < stars * 2 && money >= 100) 
        {
            enclosures.add(new Enclosure());
            money -= 100;
            System.out.println("New enclosure built. Remaining money: $" + money);
        } 
        else if (enclosures.size() >= stars * 2) 
        {
            System.out.println("Maximum number of enclosures reached for current star level.");
        }
        else
        {
            System.out.println("Not enough money to build an enclosure.");
        }
    }

    public void buyAnimal(Scanner scanner) 
    {
        System.out.print(">> ");
    
        if (getEmptyEnclosure() == null) 
        {
            System.out.println("No empty enclosures. Build one first.");
            return;
        }
    
        String availableAnimals = "Available animals to buy: [";
        if (stars >= 1) availableAnimals += "penguin";
        if (stars >= 2) availableAnimals += ", giraffe";
        if (stars >= 3) availableAnimals += ", elephant";
        if (stars >= 4) availableAnimals += ", lion";
        availableAnimals += "]";
        System.out.println(availableAnimals);
    
        System.out.print("Choose animal:\n<< ");
        String inpt = scanner.nextLine().toLowerCase(); 
    
        String name = null;
        Animal animal = null;
        boolean canBuy = true;
        
        switch (inpt) 
        {
            case "penguin":
                System.out.printf("Enter name:\n<< ");
                name = scanner.nextLine();
                animal = new Penguin(name);
                break;
            case "giraffe":
                if (stars >= 2) 
                {
                    System.out.printf("Enter name:\n<< ");
                    name = scanner.nextLine();
                    animal = new Giraffe(name);
                } 
                else 
                {
                    canBuy = false;
                }
                break;
            case "elephant":
                if (stars >= 3) 
                {
                    System.out.printf("Enter name:\n<< ");
                    name = scanner.nextLine();
                    animal = new Elephant(name);
                } 
                else 
                {
                    canBuy = false;
                }
                break;
            case "lion":
                if (stars >= 4) 
                {
                    System.out.printf("Enter name:\n<< ");
                    name = scanner.nextLine();
                    animal = new Lion(name);
                } 
                else 
                {
                    canBuy = false;
                }
                break;
            default:
                System.out.println(">> Invalid selection.");
                return;
        }
    
        if (!canBuy) 
        {
            System.out.println(">> This animal is not available at your current star level.");
            return;
        }
    
        if (money >= animal.getPrice()) 
        {
            Enclosure emptyEnclosure = getEmptyEnclosure();

            emptyEnclosure.assignAnimal(animal);
            money -= animal.getPrice();
            animal.makeSound();
            System.out.println(">> " + name + " the " + inpt + " added to enclosure.");
        } 
        else 
        {
            System.out.println(">> Not enough money to buy this animal.");
        }

        haveAnimals = true;
    }

    public void sellAnimal(Scanner scanner) 
    {
        if (!haveAnimals) 
        {
            System.out.println(">> There are no animals to sell.");
            return;
        }
        
        for (int i = 0; i < enclosures.size(); i++) 
        {
            System.out.println("[" + (i + 1) + "] " + enclosures.get(i).toString());
        }
        
        System.out.print(">> Enter enclosure number to sell from:\n<< ");
    
        int index = scanner.nextInt() - 1;
        scanner.nextLine();
    
        System.out.print(">> ");
        if (index >= 0 && index < enclosures.size() && !enclosures.get(index).isEmpty()) 
        {
            Animal animal = enclosures.get(index).getAnimal();
            money += animal.getPrice() / 2;
            enclosures.get(index).removeAnimal();
            System.out.println("You sold " + animal.getType() + " for $" + (animal.getPrice() / 2));
        } 
        else 
        {
            System.out.println("Invalid selection.");
        }

        haveAnimals = checkIfHaveAnimals();
    }

    public void feedSelectedAnimal(Scanner scanner) 
    {
        haveAnimals = checkIfHaveAnimals();
        if (!haveAnimals) 
        {
            System.out.println(">> There are no animals to feed.");
            return;
        }

        for (int i = 0; i < enclosures.size(); i++) 
        {
            Enclosure enclosure = enclosures.get(i);
            System.out.println("[" + (i + 1) + "] " + enclosure.toString());
        }
    
        System.out.print(">> Enter enclosure number to feed:\n<< ");
        
        int index = scanner.nextInt() - 1;
        scanner.nextLine();
    
        if (index <= 0 || index + 1 > enclosures.size() || enclosures.get(index).isEmpty()) 
        {
            System.out.println(">> Invalid selection.");
            return;
        }
    
        Enclosure enclosure = enclosures.get(index);
        Animal animal = enclosure.getAnimal();
    
        if (money >= animal.getFeedCost()) 
        {
            enclosure.feedAnimal();
            money -= animal.getFeedCost();
            System.out.println(">> Animal in Enclosure " + (index + 1) + " has been fed.");
        } 
        else 
        {
            System.out.println(">> Not enough money to feed the animal.");
        }
    }

    public void cleanAll() 
    {
        if (enclosures.size() == 0) 
        {
            System.out.println(">> No enclosures to clean.");
            return;
        }
        if (money >= 10) 
        {
            for (Enclosure enclosure : enclosures) 
            {
                enclosure.clean();
            }
            money -= 10;
        } 
        else 
        {
            System.out.println(">> Not enough money to clean enclosures.");
        }
    }
    
    public void showStatus() 
    {
        System.out.print(">> Zoo Stars: ");
        for (int i = 0; i < stars; i++) 
        {
            System.out.print("*");
        }
        System.out.println();

        System.out.println(">> Money: $" + money);
    
        for (int i = 0; i < enclosures.size(); i++) 
        {
            Enclosure enclosure = enclosures.get(i);
            System.out.println(">> Enclosure " + (i + 1) + ": " + enclosure.toString());
        }
    }

    public void passDay() 
    {
        day++;
        int total_income = 0;
        int unhealthy_num = 0;
        int total_animals = 0;
    
        System.out.println(">> --- Day " + day + " begins ---");
    
        for (Enclosure enclosure : enclosures) 
        {
            enclosure.passDay();
            if (enclosure.isOccupiedAndAlive())
            {
                Animal animal = enclosure.getAnimal();
                total_income += enclosure.generateIncome();
                total_animals++;
    
                if (!animal.canEarnIncome())
                {
                    unhealthy_num++;
                }
            }
        }
    
        money += total_income;
        System.out.println(">> Day passed. Income earned: $" + total_income);
    
        if (total_animals > 0 && unhealthy_num > total_animals / 2 && stars > 1) 
        {
            stars--;
            consecutiveHealthyDays = 0;
            System.out.println(">> Many animals are unhealthy! * decreased");
        }
        else if (total_animals >= stars * 2 && unhealthy_num == 0) 
        {
            consecutiveHealthyDays++;
            if (consecutiveHealthyDays >= 3 && stars < 5) 
            {
                stars++;
                consecutiveHealthyDays = 0;
                System.out.println(">> Your zoo is thriving with healthy animals and growth! * increased");
            }
        }
        else 
        {
            consecutiveHealthyDays = 0;
        }

        haveAnimals = checkIfHaveAnimals();
    }
    
    public Zoo deepCopy() 
    {
        Zoo copy = new Zoo();
        copy.money = this.money;
        copy.stars = this.stars;
        copy.day = this.day;
        copy.consecutiveHealthyDays = this.consecutiveHealthyDays;
        copy.haveAnimals = this.haveAnimals;

        for (Enclosure enclosure : enclosures) 
        {
            copy.enclosures.add(enclosure.deepCopy());
        }

        return copy;
    }
    
    public boolean isGameOver()
    {
        return money <= 0;
    }
    
    public boolean isWon()
    {
        return stars >= 5;
    }

    private Enclosure getEmptyEnclosure() 
    {
        for (Enclosure enclosure : enclosures) 
        {
            if (enclosure.isEmpty()) 
            {
                return enclosure;
            }
        }
        return null;
    }

    private boolean checkIfHaveAnimals()
    {
        for (Enclosure enclosure : enclosures) 
        {
            if (!enclosure.isEmpty()) 
            {
                return true;
            }
        }
        return false;
    }
}
