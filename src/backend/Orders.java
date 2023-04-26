package backend;
public class Orders 
{
    private int customerId, pharmacyId;
    private String date;
    
    public Orders(int customerId, int pharmacyId, String date)
    {
        this.customerId = customerId;
        this.pharmacyId = pharmacyId;
        this.date = date;
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
