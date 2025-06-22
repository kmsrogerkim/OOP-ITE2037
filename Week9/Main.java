package Week9;

public class Main{
    public static void main(String[] args){
        Patient p1 = new Patient("Alice", 30, "internal");
        Patient p2 = new Patient("Bob", 45, "surgery");
        Patient p3 = new Patient("Charlie", 50, "dental");

        Doctor d1 = new Doctor("Dr. Smith", 40, "General Hospital");
        Physician d2 = new Physician("Dr. Johnson", 38, "City Hospital");

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(d1);
        System.out.println(d2);

        System.out.println("\n[Examination Results]");
        d1.examination(p1);
        d2.examination(p1);
        d2.examination(p2);
        d2.examination(p3);
    }
} 