package backend;
public class Medicine
{
    private int id;
    private String name, category;
    
    public Medicine(int id, String name, String category)
    {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public int getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public String getCategory()
    {
        return category;
    }
}