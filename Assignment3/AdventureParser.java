package Assignment3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

public class AdventureParser 
{
    public static Map<Integer, Scene> parse(String path) 
    {
        Map<Integer, Scene> scenes = new HashMap<Integer, Scene>();

        BufferedReader reader = null;

        try 
        {
            reader = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) 
        {
            try
            {
                reader = new BufferedReader(new FileReader("./Assignment3/" + path));
            } catch (FileNotFoundException er)
            {
                reader = new BufferedReader(new FileReader("./MinseungKim_2024062942_Assignment3/" + path));
                System.out.println("Error: StoryBook file doesn't exist.");
                // NOTE:
                // 조교님 이거 이상의 에러 헨들링은 실행 환경을 모르면 할 수 없지 않을까요...
                // 어느 경로에서 실행시키는지를 모르겠어서...일단 zip 파일에 StoryBook.txt를 포함 시켜놓기는 했습니다...
                return scenes;
            }
        }

        try
        {
            String line;
            Scene currentScene = null;

            while ((line = reader.readLine()) != null) 
            {
                line = line.trim();

                if (line.isEmpty()) 
                {
                    continue;
                }

                if (line.startsWith("[ID:")) 
                {
                    int id = Integer.parseInt(line.substring(5, line.length() - 1));
                    currentScene = new Scene(id, "");
                    scenes.put(id, currentScene);
                } 

                if (line.startsWith("Text:")) 
                {
                    StringBuilder textBuilder = new StringBuilder();
                    textBuilder.append(line.substring(5).trim());

                    while ((line = reader.readLine()) != null) 
                    {
                        line = line.trim();
                    
                        if (line.startsWith("Choices:") || line.startsWith("End:") || line.startsWith("Flags:") || line.startsWith("[ID:")) 
                        {
                            break;
                        }
                    
                        textBuilder.append(" ").append(line);
                    }
                
                    if (currentScene != null) 
                    {
                        currentScene = scenes.get(currentScene.getId());
                        currentScene = new Scene(currentScene.getId(), textBuilder.toString());
                        scenes.put(currentScene.getId(), currentScene);
                    }
                
                    if (line == null) 
                    {
                        break;
                    }
                } 

                if (line.startsWith("End:"))
                {
                    String ending = line.substring(4).trim();
                    if (currentScene != null) 
                    {
                        currentScene = scenes.get(currentScene.getId());
                        currentScene.setEnding(ending);
                    }
                    scenes.put(currentScene.getId(), currentScene);
                }
                if (line.startsWith("Flags:")) 
                {
                    String[] flagList = line.substring(6).split(",");
                    for (String flag : flagList) 
                    {
                        currentScene.addFlag(flag.trim());
                    }
                    scenes.put(currentScene.getId(), currentScene);
                }
                if (line.startsWith("-")) 
                {
                    String choiceLine = line.substring(1).trim();
                    String[] parts = choiceLine.split("->");

                    if (parts.length == 2) 
                    {
                        String choiceText = parts[0].trim();
                        int destinationId = Integer.parseInt(parts[1].trim());

                        String flag = null;

                        if (choiceText.contains("|")) 
                        {
                            // Has a required flag
                            String[] flagParts = choiceText.split("\\|");
                            choiceText = flagParts[0].trim();
                            flag = flagParts[1].trim();
                        }

                        Choice choice;

                        if (flag != null) 
                        {
                            choice = new Choice(choiceText, destinationId, flag);
                        } 
                        else 
                        {
                            choice = new Choice(choiceText, destinationId, null);
                        }

                        if (currentScene != null) 
                        {
                            currentScene.addChoice(choice);
                        }
                    }
                }
            }
        } 
        catch (IOException e) 
        {
            System.out.println("Error: Cannot read file.");
        }

        return scenes;
    }
}
