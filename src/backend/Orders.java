package backend;
public class Orders 
{
    private int id, customerId, medicineId, totalPrice;
    private String date;
    
    public Orders(int id, int customerId, int medicineId, int totalPrice, String date)
    {
        this.id = id;
        this.customerId = customerId;
        this.medicineId = medicineId;
        this.totalPrice = totalPrice;
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
    public int getMedicineId()
    {
        return medicineId;
    }
    public int getTotalPrice()
    {
        return totalPrice;
    }
    public String getDate()
    {
        return date;
    }
}
