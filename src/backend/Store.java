package backend;
public class Store 
{
    private int id;
    private String name, password, location;

    public Store(int id, String name, String password, String location)
    {
        this.id = id;
        this.name = name;
        this.password = password;
        this.location = location;
    }

    public int getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public String getPassword()
    {
        return password;
    }
    public String getLocation()
    {
        return location;
    }
}
