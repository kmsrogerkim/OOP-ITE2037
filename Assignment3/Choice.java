package Assignment3;

public class Choice 
{
    private String text;
    private int destinationId;
    private String requiredFlag;

    public Choice(String text, int destinationId, String requiredFlag) 
    {
        this.text = text;
        this.destinationId = destinationId;
        this.requiredFlag = requiredFlag;
    }

    public String getText() 
    {
        return text;
    }

    public int getDestinationId() 
    {
        return destinationId;
    }

    public String getRequiredFlag() 
    {
        return requiredFlag;
    }

    public boolean isAvailable(java.util.Set<String> playerFlags) 
    {
        if (requiredFlag == null) 
        {
            return true;
        }

        return playerFlags.contains(requiredFlag);
    }
}
