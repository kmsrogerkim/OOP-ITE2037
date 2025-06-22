package Week9;

public class Person{
    private String name;
    private int age;

    public Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString()
    {
        return name + "(" + age + ")";
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true; 
        if (o == null || getClass() !=  o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && name.equals(person.name);
    }
}