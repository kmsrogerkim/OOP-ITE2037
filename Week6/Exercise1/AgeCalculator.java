package Week6.Exercise1;
import java.time.LocalDate;

public class AgeCalculator {
    public static int calAge(Person p) 
    {
        LocalDate today = LocalDate.now();
        int age = today.getYear() - p.getBirthYear();
    
        if (p.getBirthMonth() > today.getMonthValue() || (p.getBirthMonth() == today.getMonthValue() && p.getBirthDay() > today.getDayOfMonth())) 
        {
            age--;
        }
    
        return age;
    }

    public static int isOlder(Person p1, Person p2)
    {
        int age1 = calAge(p1);
        int age2 = calAge(p2);

        if (age1 > age2)
        {
            return 1;  
        }
        else if (age1 == age2)
        {
            return 0;  
        }

        return -1; 
    }
}
