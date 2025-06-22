package Week9;

public class Patient extends Person{
    private String department;
    
    public Patient(String name, int age, String dept)
    {
        super(name, age);
        this.department = dept;
    }

    public String getDepartment()
    {
        return this.department;
    }

    public void setHospital(String hostpital)
    {
        this.department = hostpital;
    }

    @Override
    public String toString()
    {
        return "[Patient] " + super.toString() + ", Department : " + this.department;
    }
}