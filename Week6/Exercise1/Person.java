package Week6.Exercise1;

public class Person {
    private String name;
    private int birthYear;
    private int birthMonth;
    private int birthDay;

    public Person(String name, int birthYear, int birthMonth, int birthDay)
    {
        this.name = name;
        this.birthYear = birthYear;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public int getBirthYear() 
    {
        return birthYear;
    }

    public void setBirthYear(int birthYear) 
    {
        this.birthYear = birthYear;
    }

    public int getBirthMonth() 
    {
        return birthMonth;
    }

    public void setBirthMonth(int birthMonth) 
    {
        this.birthMonth = birthMonth;
    }

    public int getBirthDay() 
    {
        return birthDay;
    }

    public void setBirthDay(int birthDay) 
    {
        this.birthDay = birthDay;
    }
}
