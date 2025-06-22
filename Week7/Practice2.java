package Week7;
import java.util.Scanner;

public class Practice2{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayStack stack = new ArrayStack();

        while (true)
        {
            System.out.println("Choose operation: ");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display Stack");
            System.out.println("5. Exit");
            int input = scanner.nextInt();
            scanner.nextLine();
            if (input == 5) break;

            switch (input) {
                case 1:
                    System.out.print("Enter element to push: ");
                    int push = scanner.nextInt();
                    scanner.nextLine();
                    stack.push(push);
                    System.out.println("Element pushed: " + stack.peek());
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Popped element: " + stack.pop());
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Peeked element: " + stack.peek());
                    System.out.println();
                    break;
                case 4:
                    if (stack.isEmpty())
                    {
                        System.out.println("Stack is empty.");
                        System.out.println();
                    }
                    else
                    {
                        System.out.print("Stack: ");
                        stack.printStack();
                        System.out.println();
                        System.out.println();
                    }
                    break;
                default:
                    break;
            }
        }
        scanner.close();
    }
} 