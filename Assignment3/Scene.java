package Assignment3;

import java.util.List;
import java.util.ArrayList;

public class Scene 
{
    private int id;
    private String text;
    private List<Choice> choices;
    private List<String> setFlags;
    private String ending;

    public Scene(int id, String text) 
    {
        this.id = id;
        this.text = text;
        this.choices = new ArrayList<Choice>();
        this.setFlags = new ArrayList<String>();
        this.ending = null;
    }

    public void addChoice(Choice choice) 
    {
        choices.add(choice);
    }

    public void addFlag(String flag) 
    {
        setFlags.add(flag);
    }

    public void setEnding(String ending) 
    {
        this.ending = ending;
    }

    public int getId() 
    {
        return id;
    }

    public String getText() 
    {
        return text;
    }

    public List<Choice> getChoices() 
    {
        return choices;
    }

    public List<String> getSetFlags() 
    {
        return setFlags;
    }

    public String getEnding() 
    {
        return ending;
    }

    public boolean isEnd() 
    {
        return ending != null;
    }
}
