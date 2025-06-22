package Week13;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class BinarySearch {
    static int binary_search(int[] arr, int target, int l, int r)
    {
        if (l > r)        
        {
            return -1;
        }

        int len = l+r;
        int mid = len/2;
        if (target == arr[mid])
        {
            return mid;
        }
        if (target < arr[mid])
        {
            return binary_search(arr, target, l, mid -1);
        }
        else
        {
            return binary_search(arr, target, mid + 1, r);
        }
    }


    public static void main(String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(new FileInputStream("input.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("error");
        }

        int[] trgts = new int[100];
        int[] arr = new int[100000];
        
        while(sc.hasNextInt())
        {
            int number;
            for (int i=0; i<100; i++)
            {
                number = sc.nextInt();
                trgts[i] = number;
            }
            for (int i=0; i<100000; i++)
            {
                number = sc.nextInt();
                arr[i] = number;
            }
        }
        Arrays.sort(arr);
        for (int i=0; i<100; i++)
        {
            System.out.printf("target: %-8d index: %-8d\n", trgts[i], binary_search(arr, trgts[i], 0, 100000));
        }
    }
}
