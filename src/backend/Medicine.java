package backend;
public class Medicine 
{
    private String name, details;
    public Medicine(String name, String details)
    {
        this.name = name;
        this.details = details;
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
