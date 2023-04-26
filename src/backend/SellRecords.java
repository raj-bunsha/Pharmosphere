package backend;
public class SellRecords 
{
    private int medicineId, quantity;
    public SellRecords(int medicineId, int quantity)
    {
        this.medicineId = medicineId;
        this.quantity = quantity;
    }
    public int getMedicineId()
    {
        return medicineId;
    }
    public int getQuantity()
    {
        return quantity;
    }
}
