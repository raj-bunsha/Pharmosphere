package backend;
public class Medicine 
{
    private int id;
    private String name, details;
    public Medicine(int id, String name, String details)
    {
        this.id = id;
        this.name = name;
        this.details = details;
    }
    public int getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public String getDetails()
    {
        return details;
    }
}
