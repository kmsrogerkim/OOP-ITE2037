package Assignment3;

import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class AdventureGame 
{
    private Map<Integer, Scene> scenes;
    private Set<String> flags;
    private Set<String> achievements;
    private int currentSceneId;
    private int score;
    private Scanner scanner;

    public AdventureGame(Map<Integer, Scene> scenes) 
    {
        this.scenes = scenes;
        this.flags = new HashSet<String>();
        this.achievements = new HashSet<String>();
        this.currentSceneId = 1;
        this.score = 0;
        this.scanner = new Scanner(System.in);
    }

    public void play() 
    {
        while (true) 
        {
            Scene scene = scenes.get(currentSceneId);

            if (scene == null) 
            {
                System.out.println("Error: Scene doesn't exist.");
                break;
            }

            System.out.println("\n" + scene.getText());
            for (String flag : scene.getSetFlags()) 
            {
                if (!flags.contains(flag)) 
                {
                    System.out.println("[You gained a new flag: " + flag + "]");
                    flags.add(flag);
                }
            }

            if (scene.isEnd()) 
            {
                System.out.println("--- Ending: " + scene.getEnding() + " ---");
                score += 10;
                System.out.println("Final Score: " + score);

                saveAchievements(scene.getEnding());
                saveHighScore();
                deleteSaveFile();
                break;
            }

            List<Choice> choices = new java.util.ArrayList<Choice>();
            int choiceNumber = 1;

            for (Choice choice : scene.getChoices()) 
            {
                if (choice.isAvailable(flags)) 
                {
                    System.out.println(choiceNumber + ". " + choice.getText());
                    choices.add(choice);
                    choiceNumber++;
                }
            }

            saveGame();

            System.out.print("Enter your choice (1-" + choices.size() + "): ");
            int inpt = scanner.nextInt();
            scanner.nextLine();

            if (inpt < 1 || inpt > choices.size()) 
            {
                System.out.println("Invalid input.");
                continue;
            }

            Choice userChoice = choices.get(inpt - 1);
            currentSceneId = userChoice.getDestinationId();
            score += 5;
        }
    }

    private void saveGame() 
    {
        try 
        {
            PrintWriter writer = new PrintWriter(new FileWriter("save.txt"));
            writer.println(currentSceneId);
            writer.println(score);

            for (String flag : flags) 
            {
                writer.println("FLAG:" + flag);
            }

            writer.close();
        } 
        catch (IOException e) 
        {
            System.out.println("Error: Cannot save game.");
        }
    }

    public void loadGame() 
    {
        try 
        {
            BufferedReader reader = new BufferedReader(new FileReader("save.txt"));
            currentSceneId = Integer.parseInt(reader.readLine());
            score = Integer.parseInt(reader.readLine());

            String line;
            while ((line = reader.readLine()) != null) 
            {
                if (line.startsWith("FLAG:")) 
                {
                    flags.add(line.substring(5));
                }
            }

            reader.close();
        } 
        catch (IOException e) 
        {
            System.out.println("Error: No save file.");
        }
    }

    private void saveAchievements(String newEnding) 
    {
        try 
        {
            File file = new File("achievements.txt");
            if (!file.exists()) 
            {
                file.createNewFile();
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) 
            {
                String str = line.trim();
                str = str.replace("Unlocked: ", "");
                achievements.add(str);
            }

            reader.close();

            if (!achievements.contains(newEnding)) 
            {
                PrintWriter writer = new PrintWriter(new FileWriter(file, true));
                writer.println("Unlocked: " + newEnding);
                writer.close();
            }
        } 
        catch (IOException e) 
        {
            System.out.println("Failed to save achievements.");
        }
    }

    private void saveHighScore() 
    {
        try 
        {
            File file = new File("highscore.txt");
            if (!file.exists()) 
            {
                file.createNewFile();
            }

            int best = 0;

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            if (line != null) 
            {
                best = Integer.parseInt(line.trim());
            }
            reader.close();

            if (score > best) 
            {
                PrintWriter writer = new PrintWriter(new FileWriter(file));
                writer.println(score);
                writer.close();
            }
        } 
        catch (IOException e) 
        {
            System.out.println("Error: Failed to save high score.");
        }
    }

    private void deleteSaveFile() 
    {
        File file = new File("save.txt");
        if (file.exists()) 
        {
            file.delete();
        }
    }
}
