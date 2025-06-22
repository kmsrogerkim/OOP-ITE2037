package Week9;

public class Doctor extends Person{
    private String hospital;

    public Doctor(String name, int age, String hospital)
    {
        super(name, age);
        this.hospital = hospital;
    }

    public void examination(Patient p)
    {
        System.out.println("I haven't decided my major yet");
    }

    public String getHospital()
    {
        return this.hospital;
    }

    public void setHospital(String hostpital)
    {
        this.hospital = hostpital;
    }

    @Override
    public String toString()
    {
        return "[Doctor]" + super.toString() + ", Affiliation : " + this.hospital;
    }

    public boolean equals(Doctor d)
    {
        return super.equals(d) && this.hospital.equals(d.hospital);
    }

}