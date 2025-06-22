package Week7;
import java.util.Scanner;

public class Practice1{
    public static int[][] drawSnail(int n)
    {
        int[][] matrix = new int[n][n];
        int startRow = 0, endRow = n - 1;
        int startCol = 0, endCol = n - 1;
        int currentNum = 1;

        while (startRow <= endRow && startCol <= endCol) 
        {
            for (int i = startCol; i <= endCol; i++) 
            {
                matrix[startRow][i] = currentNum++;
            }
            startRow++;

            for (int i = startRow; i <= endRow; i++) 
            {
                matrix[i][endCol] = currentNum++;
            }
            endCol--;

            if (startRow <= endRow) 
            {
                for (int i = endCol; i >= startCol; i--) 
                {
                    matrix[endRow][i] = currentNum++;
                }
                endRow--;
            }

            if (startCol <= endCol) 
            {
                for (int i = endRow; i >= startRow; i--) 
                {
                    matrix[i][startCol] = currentNum++;
                }
                startCol++;
            }
        }

        return matrix;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a matrix size n: ");
        int n = scanner.nextInt();
        scanner.close();

        int[][] matrix = drawSnail(n);
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                System.out.printf("%-4d", matrix[i][j]);
            }
            System.out.println();
        }
    }   
} 