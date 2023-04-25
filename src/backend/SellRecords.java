package backend;
public class SellRecords 
{
    private int id, orderId, medicineId, price, quantity;
    public SellRecords(int id, int orderId, int medicineId, int price, int quantity)
    {
        this.id = id;
        this.orderId = orderId;
        this.medicineId = medicineId;
        this.price = price;
        this.quantity = quantity;
    }
    public int getId()
    {
        return id;
    }   
    public int getOrderId()
    {
        return orderId;
    }
    public int getMedicineId()
    {
        return medicineId;
    }
    public int getPrice()
    {
        return price;
    }
    public int getQuantity()
    {
        return quantity;
    }
}
