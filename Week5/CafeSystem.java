package Week5;
import java.util.Scanner;
import Week5.MenuItem;

public class CafeSystem{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        MenuItem[] menu_item = new MenuItem[4];

        for (int i = 0; i < 4; i++)
        {
            String name;
            int price;
            System.out.printf("Enter name of drink %d: ", i+1);
            name = scanner.nextLine();
            System.out.printf("Enter price of %s: ", name);
            price = scanner.nextInt();
            scanner.nextLine();
            menu_item[i] = new MenuItem(name, price);
        }
    
        System.out.printf("\n=== Welcome to Java Cafe ===\n\n");
        
        while (true)
        {
            for (int i = 0; i < 4; i++)
            {
                System.out.printf("%d. %s - %d won\n", i+1, menu_item[i].getName(), menu_item[i].getPrice());
            } 
            System.out.printf("5. Checkout and Exit\n\n");

            int menu_number;
            System.out.printf("Select a menu number: ");
            menu_number = scanner.nextInt() - 1;
            scanner.nextLine();

            if (menu_number == 4)
            {
                scanner.close();
                System.out.printf("\n=== Order Summery ===\n");

                int total_items = 0;
                int total_price = 0;
                for (MenuItem menu : menu_item)
                {
                    if (menu.getCount() > 0)
                    {
                        System.out.printf("- %s x %d\n", menu.getName(), menu.getCount());
                        total_items += menu.getCount();
                        total_price += menu.getPrice() * menu.getCount();
                    }
                }
                System.out.printf("Total items ordered: %d\n", total_items);
                System.out.printf("Total price: %d won\n", total_price);
                System.out.println("Thank you!");
                System.exit(0);
            }
            System.out.printf("You ordered: %s\n\n", menu_item[menu_number].getName());
            menu_item[menu_number].setCount(1);
        }
    }
} 