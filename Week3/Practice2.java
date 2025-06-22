import java.util.Scanner;

public class Practice2{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String[] names = new String[3];
        int[] quantities = new int[3];
        double[] prices = new double[3];
        double[] totals = new double[3];

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter the name of item " + (i + 1) + ": \n");
            if (i > 0) scanner.nextLine();
            names[i] = scanner.nextLine(); 
            
            System.out.print("Enter the quantity of item " + (i + 1) + ": \n");
            quantities[i] = scanner.nextInt();
            
            System.out.print("Enter the price of item " + (i + 1) + ": \n");
            prices[i] = scanner.nextDouble();
            
            totals[i] = quantities[i] * prices[i];
        }
        scanner.close();

        double subtotal = 0;
        for (double total : totals) {
            subtotal += total;
        }
        
        double tax = subtotal * 0.0625;
        double totalBill = subtotal + tax;

        System.out.println("Your bill:\n");
        System.out.printf("%-30s %-10s %-10s %-10s\n", "ITEM", "QUANTITY", "PRICE", "TOTAL");

        for (int i = 0; i < 3; i++) {
            System.out.printf("%-30s %-10d %-10.2f %-10.2f\n", names[i], quantities[i], prices[i], totals[i]);
        }

        System.out.printf("\n%-30s %-10s %-10s %-10.2f\n", "SUBTOTAL", "", "", subtotal);
        System.out.printf("%-30s %-10s %-10s %-10.2f\n", "6.25% SALES TAX", "", "", tax);
        System.out.printf("%-30s %-10s %-10s %-10.2f\n", "TOTAL", "", "", totalBill);

    }
} 