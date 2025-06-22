package Week5;

public class MenuItem
{
    private String name;
    private int price;
    private int count;

    MenuItem(String name, int price)
    {
        this.name = name;
        this.price = price;
        this.count = 0;
    }
    public String getName()
    {
        return this.name;
    }
    public int getCount()
    {
        return this.count;
    }
    public int getPrice()
    {
        return this.price;
    }
    public void setCount(int count)
    {
        this.count += 1;
    }
}