package backend;
public class Pharmacy 
{
    private String name, password, location;

    public Pharmacy(String name, String password, String location)
    {
        this.name = name;
        this.password = password;
        this.location = location;
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
