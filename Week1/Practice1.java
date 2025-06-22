package Week1;

public class Practice1{
    public static void main(String[] args){
        String name = "minseung kim";
        String output = null;

        name = name.toUpperCase();    
        output = "My name is " + name + ". My name starts with the letter " + name.charAt(0) + ".";

        System.out.println(output);
    }
}