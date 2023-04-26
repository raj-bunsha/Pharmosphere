package backend;
public class Inventory 
{    
    private int pharmId, medicineId, quantity, price;
    private String expiryDate;

    public Inventory(int pharmId, int medicineId, int quantity, int price, String expiryDate)
    {
        this.pharmId = pharmId;
        this.medicineId = medicineId;
        this.quantity = quantity;
        this.price = price;
        this.expiryDate = expiryDate;
    }

    public int getPharmId()
    {
        return pharmId;
    }
    public int getMedicineId()
    {
        return medicineId;
    }
    public int getQuantity()
    {
        return quantity;
    }
    public int getPrice()
    {
        return price;
    }
    public String getExpiryDate()
    {
        return expiryDate;
    }
}
