package backend;
public class Inventory 
{    
    private int id, pharmId, medicineId, manufacturerId, quantity, price;
    private String expiryDate;

    public Inventory(int id, int pharmId, int medicineId, int manufacturerId, int quantity, int price, String expiryDate)
    {
        this.id = id;
        this.pharmId = pharmId;
        this.medicineId = medicineId;
        this.manufacturerId = manufacturerId;
        this.quantity = quantity;
        this.price = price;
        this.expiryDate = expiryDate;
    }

    public int getId()
    {
        return id;
    }
    public int getPharmId()
    {
        return pharmId;
    }
    public int getMedicineId()
    {
        return medicineId;
    }
    public int getManufacturerId()
    {
        return manufacturerId;
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
