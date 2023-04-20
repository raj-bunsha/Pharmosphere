package backend;
import java.sql.*;
import java.util.*;

public class Database 
{
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost/project";
    public static final String USER = "root";
    public static final String PASS = "sqlisbad";
    public Connection conn;

    public Database()
    {
        try
        {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASS);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void addCustomer(Customer c)
    {
        try
        {
            String sql = "insert into Customer (id, customer_name, phone_number) values(?, ?, ?)";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, c.getId());
            p.setString(2, c.getName());
            p.setString(3, c.getPhone());
            p.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void addManufacturer(Manufacturer m)
    {
        try
        {
            String sql = "insert into Manufacturer (id, manufacturer_name, phone_number) values(?, ?, ?)";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, m.getId());
            p.setString(2, m.getName());
            p.setString(3, m.getPhone());
            p.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void addOrder(Orders o)
    {
        try
        {
            String sql = "insert into Orders(id, customer_id, medicine_id, total_price, date) values(?, ?, ?, ?, ?)";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, o.getId());
            p.setInt(2, o.getCustomerId());
            p.setInt(3, o.getMedicineId());
            p.setInt(4, o.getTotalPrice());
            p.setString(5, o.getDate());
            p.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void addSellRecord(SellRecords r)
    {
        try
        {
            String sql = "insert into SellRecords(id, pharm_id, order_id) values(?, ?, ?)";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, r.getId());
            p.setInt(2, r.getPharmId());
            p.setInt(3, r.getOrderId());
            p.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void addMedicine(Medicine m)
    {
        try
        {
            String sql = "insert into Medicine (id, medicine_name, category) values(?, ?, ?)";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, m.getId());
            p.setString(2, m.getName());
            p.setString(3, m.getCategory());
            p.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public Medicine getMedicine(int id)
    {
        try
        {
            String sql = "select * from Medicine where id = " + id;
            Statement s = conn.createStatement();
            ResultSet r = s.executeQuery(sql);
            if(r.next())
                return new Medicine(r.getInt("id"), r.getString("medicine_name"), r.getString("category"));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Medicine> getSubstitutes(int id)
    {
        Medicine m = getMedicine(id);
        ArrayList<Medicine> sub = new ArrayList<Medicine>();
        try
        {
            String sql = "select * from Medicine where category = " + m.getCategory();
            Statement s = conn.createStatement();
            ResultSet r = s.executeQuery(sql);
            while(r.next())
            {
                int mID = r.getInt("id");
                if(mID == m.getId())
                    continue;
                sub.add(new Medicine(mID, r.getString("medicine_name"), m.getCategory()));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return sub;
    }

    public void addInventory(Inventory i)
    {
        try
        {
            String sql = "insert into Inventory (id, pharm_id, medicine_id, manufacturer_id, quantity, price, expiry_date) values(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, i.getId());
            p.setInt(2, i.getPharmId());
            p.setInt(3, i.getMedicineId());
            p.setInt(4, i.getManufacturerId());
            p.setInt(5, i.getQuantity());
            p.setInt(6, i.getPrice());
            p.setString(7, i.getExpiryDate());
            p.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public Inventory getInventory(int id)
    {
        try
        {
            String sql = "select * from Inventory where id = " + id;
            Statement s = conn.createStatement();
            ResultSet r = s.executeQuery(sql);
            if(r.next())
                return new Inventory(r.getInt("id"), r.getInt("pharm_id"), r.getInt("medicine_id"), r.getInt("manufacturer_id"), r.getInt("quantity"), r.getInt("price"), r.getString("expiry_date"));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public boolean sellInventory(int id, int quantity)
    {
        Inventory i = getInventory(id);
        if(quantity > i.getQuantity())
            return false;
        try
        {
            String sql = "update inventory set quantity = ? where id = ?";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, i.getQuantity() - quantity);
            p.setInt(2, i.getId());
            p.executeUpdate();
            return true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    public void addStore(Store s)
    {
        try
        {
            String sql = "insert into Store (id, name, password, location) values(?, ?, ?, ?)";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, s.getId());
            p.setString(2, s.getName());
            p.setString(3, s.getPassword());
            p.setString(4, s.getLocation());
            p.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public Store getStore(int id)
    {
        try
        {
            String sql = "select * from Store where id = " + id;
            Statement s = conn.createStatement();
            ResultSet r = s.executeQuery(sql);
            if(r.next())
                return new Store(r.getInt("id"), r.getString("name"), r.getString("password"), r.getString("location"));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public Store validate(int id, String pass)
    {
        Store s = getStore(id);
        if(s.getPassword().equals(pass))
            return s;
        return null;
    }
}
