package backend;
public class SellRecords 
{
    private int id, pharmId, orderId;

    public SellRecords(int id, int pharmId, int orderId)
    {
        this.id = id;
        this.pharmId = pharmId;
        this.orderId = orderId;
    }   

    public int getId()
    {
        return id;
    }
    public int getPharmId()
    {
        return pharmId;
    }
    public int getOrderId()
    {
        return orderId;
    }
}
