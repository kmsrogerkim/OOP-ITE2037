package Assignment3;

import java.util.Map;
import java.io.File;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        while (true) 
        {
            System.out.println("==== Java Island Adventure ====");
            System.out.println("1. Start New Game");
            System.out.println("2. View Achievements and High Score");
            System.out.println("3. Exit");
            System.out.print("Select option (1-3): ");

            String inpt = scanner.nextLine().trim();

            if (inpt.equals("1")) 
            {
                File saveFile = new File("save.txt");
                AdventureGame game = new AdventureGame(AdventureParser.parse("StoryBook.txt"));

                if (saveFile.exists()) 
                {
                    System.out.print("Found save file. Continue? (y/n): ");
                    String useSave = scanner.nextLine().trim();

                    if (useSave.equals("y")) 
                    {
                        game.loadGame();
                    }
                    else if (!useSave.equals("n"))
                    {
                        System.out.println("Error: Invalid input.");
                        System.out.println("");
                        continue;
                    }
                }

                game.play();
            } 
            else if (inpt.equals("2")) 
            {
                System.out.println("\n=== Achievements ===");
                File achievementFilee = new File("achievements.txt");

                if (!achievementFilee.exists()) 
                {
                    System.out.println("No achievements yet.");
                } 
                else 
                {
                    try 
                    {
                        BufferedReader reader = new BufferedReader(new FileReader(achievementFilee));
                        String line;

                        while ((line = reader.readLine()) != null) 
                        {
                            System.out.println(line);
                        }

                        reader.close();
                    } 
                    catch (IOException e) 
                    {
                        System.out.println("Error: Cannot read achievements.");
                    }
                }

                System.out.println("\n=== High Score ===");
                File highScoreFile = new File("highscore.txt");

                if (!highScoreFile.exists()) 
                {
                    System.out.println("No score recorded.");
                } 
                else 
                {
                    try 
                    {
                        BufferedReader reader = new BufferedReader(new FileReader(highScoreFile));
                        String line = reader.readLine();

                        if (line != null) 
                        {
                            System.out.println("High Score: " + line.trim());
                        }

                        reader.close();
                    } 
                    catch (IOException e) 
                    {
                        System.out.println("Error: Cannot read high score.");
                    }
                }
            } 
            else if (inpt.equals("3")) 
            {
                System.out.println("Exiting game. Goodbye!");
                break;
            } 
            else 
            {
                System.out.println("Invalid input.");
            }
            System.out.println("");
        }
        scanner.close();
    }
}
