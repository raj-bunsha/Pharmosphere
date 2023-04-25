package backend;
public class Orders 
{
    private int id, customerId, pharmacyId;
    private String date;
    
    public Orders(int id, int customerId, int pharmacyId, String date)
    {
        this.id = id;
        this.customerId = customerId;
        this.pharmacyId = pharmacyId;
        this.date = date;
    }

    public int getId()
    {
        return id;
    }
    public int getCustomerId()
    {
        return customerId;
    }
    public int getPharmacyId()
    {
        return pharmacyId;
    }
    public String getDate()
    {
        return date;
    }
}
