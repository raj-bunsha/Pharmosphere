package backend;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;

public class Database 
{
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/pharmosphere";
    public static final String USER = "raj";
    public static final String PASS = "05082003";
    public Connection conn;
    public int pharmId;

    public Database() {
        System.out.println("Connecting to database...");
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASS);
            conn.setAutoCommit(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        pharmId = -1;
    }
    public int getPharmaId() {
        return pharmId;
    }
    // CUSTOMER FUNCTIONS==========================================================================================
    public void addCustomer(Customer c) {
        System.out.print("PASS");
        try {
            String sql = "insert into Customer (customer_name, phone_number) values(?, ?)";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, c.getName());
            p.setString(2, c.getPhone());
            p.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getCustomerId(String name) {
        try {
            String sql = "select id from Customer where customer_name = \"" + name + "\"";
            Statement s = conn.createStatement();
            ResultSet r = s.executeQuery(sql);
            if (r.next())
                return r.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public ArrayList<String> getCustomerReport(String name) 
    {
        int id = getCustomerId(name);
        ArrayList<String> report = new ArrayList<String>();
        try 
        {
            String sql = "select * from (select medicine_id, price, quantity, order_date from SellRecords join Orders where SellRecords.order_id = Orders.id and Orders.customer_id = "
                    + id + ") a join Medicine b where a.medicine_id = b.id";
            Statement s = conn.createStatement();
            ResultSet r = s.executeQuery(sql);
            // 2 - price 3 - quantity 4 -order date 6- medicine name 7- details
            while (r.next())
                report.add(r.getString(2) + " " + r.getString(3) + " " + r.getString(4) + " " + r.getString(6) + " "
                        + r.getString(7));
        } 
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        return report;
    }

    // MEDICINE FUNCTIONS========================================================================================
    public void addMedicine(Medicine m) {
        try {
            String sql = "insert into Medicine (medicine_name, details) values(?, ?)";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, m.getName());
            p.setString(2, m.getDetails());
            p.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Medicine> getAllMedicines() {
        System.out.println("PASS");
        ArrayList<Medicine> ret = new ArrayList<Medicine>();
        try {
            String sql = "select * from Medicine";
            Statement s = conn.createStatement();
            ResultSet r = s.executeQuery(sql);
            while (r.next())
                ret.add(new Medicine(r.getString(2), r.getString(3)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    public int getMedicineId(String name)
    {
        try {
            String sql = "select id from Medicine where medicine_name = \"" + name + "\"";
            Statement s = conn.createStatement();
            ResultSet r = s.executeQuery(sql);
            if (r.next())
                return r.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public ArrayList<Medicine> getSubstitutes(String name) 
    {
        int id = getMedicineId(name);
        ArrayList<Medicine> sub = new ArrayList<Medicine>();
        try {
            String sql = "select * from Substitute join Medicine where Substitute.substitute_id = Medicine.id and Substitute.medicine_id = "
                    + id;
            Statement s = conn.createStatement();
            ResultSet r = s.executeQuery(sql);
            while (r.next())
                sub.add(new Medicine(r.getString(4), r.getString(5)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sub;
    }

    //PHARMACY FUNCTIONS==============================================================================
    public void addPharmacy(Pharmacy m)
    {
        try {
            String sql = "insert into Pharmacy (pharmacy_name, password, location) values(?, ?, ?)";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, m.getName());
            p.setString(2, m.getPassword());
            p.setString(3, m.getLocation());
            p.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean validate(String user, String pass)
    {
        try 
        {
            String sql = "select id, password from Pharmacy where pharmacy_name = \"" + user+"\"";
            Statement s = conn.createStatement();
            ResultSet r = s.executeQuery(sql);
            if(r.next())
            {
                pharmId = r.getInt(1);
                System.out.println(r.getString(2) + " " + pass);
                return r.getString(2).equals(pass);
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return false;
    }
    public ArrayList<String> getRevenue()
    {
        ArrayList<String> ret = new ArrayList<String>();
        try 
        {
            String sql = "select pharmacy_id, sum(price * quantity) from SellRecords join Orders where SellRecords.order_id = Orders.id group by pharmacy_id";
            Statement s = conn.createStatement();
            ResultSet r = s.executeQuery(sql);
            while (r.next())
                continue;
        } 
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        return ret;
    }
    //ORDER AND SELL FUNCTIONS===================================================

    public void addOrder(Orders o)
    {
        try
        {
            String sql = "insert into Orders (customer_id, pharmacy_id, date) values(?, ?, ?)";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, o.getCustomerId());
            p.setInt(2, o.getPharmacyId());
            p.setString(3, o.getDate());
            p.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void addSellRecord(SellRecords r, int orderId, int price)
    {
        try
        {
            String sql = "insert into SellRecords (order_id, medicine_id, price, quantity) values(?, ?, ?, ?)";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, orderId);
            p.setInt(2, r.getMedicineId());
            p.setInt(3, price);
            p.setInt(4, r.getQuantity());
            p.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    //INVENTORY FUNCTIONS=========================================================

    public void addInventory(Inventory i)
    {
        try {
            String sql = "insert into Inventory (pharmacy_id, medicine_id, quantity, expiry_date) values(?, ?, ?, ?, ?)";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, i.getPharmId());
            p.setInt(2, i.getMedicineId());
            p.setInt(3, i.getPrice());
            p.setInt(4, i.getQuantity());
            p.setString(5, i.getExpiryDate());
            p.executeUpdate();
            System.out.println("ADDED");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getMedicineName(int id)
    {
        try {
            String sql = "select name from Medicine where id = " + id;
            Statement s = conn.createStatement();
            ResultSet r = s.executeQuery(sql);
            if (r.next())
                return r.getString(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public int removeExpired()
    {
        LocalDate today = LocalDate.now();
        String date = today.toString();
        try {
            String sql = "delete from Inventory where expiry_date <= ?";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, date);
            return p.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public ArrayList<Inventory> showInventory()
    {
        ArrayList<Inventory> ret = new ArrayList<Inventory>();
        try {
            String sql = "select * from Inventory";
            Statement s = conn.createStatement();
            ResultSet r = s.executeQuery(sql);
            while (r.next())
                ret.add(new Inventory(r.getInt(2), r.getInt(3), r.getInt(4), r.getInt(5), r.getString(6)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    public ArrayList<Customer> getAllCustomers()
    {
        ArrayList<Customer> ret = new ArrayList<Customer>();
        try
        {
            String sql = "select * from Customer";
            Statement s = conn.createStatement();
            ResultSet r = s.executeQuery(sql);
            while (r.next())
                ret.add(new Customer(r.getString(2), r.getString(3)));
        }catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    public boolean makePurchase(String name, ArrayList<SellRecords> sell)
    {
        Orders o = new Orders(getCustomerId(name), pharmId, LocalDate.now().toString());
        try
        {
            conn.setAutoCommit(false);
            addOrder(o);
            int orderId = 0;
            Statement cnt = conn.createStatement();
            ResultSet c = cnt.executeQuery("select count(orders) from orders");
            if(c.next())
                orderId = c.getInt(1);
            else
            {
                conn.rollback();
                conn.setAutoCommit(true);
                return false;
            }
            
            for(SellRecords s: sell)
            {
                Statement st = conn.createStatement();
                ResultSet r = st.executeQuery("select id, price from Inventory where medicine_id = " + s.getMedicineId() + " and quantity >= " + s.getQuantity() + "order by price");
                int id = -1;
                int price = 0;
                if(r.next())
                {
                    id = r.getInt(1);
                    price = r.getInt(2);
                }
                if(id < 0)
                {
                    conn.rollback();
                    conn.setAutoCommit(true);
                    return false;
                }
                PreparedStatement up = conn.prepareStatement("update Inventory set quantity = quantity - ? where id = ?");
                up.setInt(1, s.getQuantity());
                up.setInt(2, id);
                addSellRecord(s, orderId, price);
            }
            conn.commit();
            conn.setAutoCommit(true);
            return true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

}
