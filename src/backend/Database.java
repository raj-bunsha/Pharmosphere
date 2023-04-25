package backend;

import java.sql.*;
import java.util.*;

public class Database {
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost/project";
    public static final String USER = "raj";
    public static final String PASS = "05082003";
    public Connection conn;

    public Database() {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // CUSTOMER FUNCTIONS
    public void addCustomer(Customer c) {
        try {
            String sql = "insert into Customer values(?, ?, ?)";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, c.getId());
            p.setString(2, c.getName());
            p.setString(3, c.getPhone());
            p.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getCustomerId(String name) {
        try {
            String sql = "select * from Customer where name = " + name;
            Statement s = conn.createStatement();
            ResultSet r = s.executeQuery(sql);
            if (r.next())
                return r.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    // MEDICINE FUNCTIONS
    public void addMedicine(Medicine m) {
        try {
            String sql = "insert into Medicine values(?, ?, ?)";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, m.getId());
            p.setString(2, m.getName());
            p.setString(3, m.getDetails());
            p.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Medicine getMedicine(int id) {
        try {
            String sql = "select * from Medicine where id = " + id;
            Statement s = conn.createStatement();
            ResultSet r = s.executeQuery(sql);
            if (r.next())
                return new Medicine(r.getInt(1), r.getString(2), r.getString(3));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Medicine> getAllMedicines() {
        ArrayList<Medicine> ret = new ArrayList<Medicine>();
        try {
            String sql = "select * from Medicine";
            Statement s = conn.createStatement();
            ResultSet r = s.executeQuery(sql);
            while (r.next())
                ret.add(new Medicine(r.getInt(1), r.getString(2), r.getString(3)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }
    public int getMedicineId(String name)
    {
        try {
            String sql = "select id from Medicine where name = " + name;
            Statement s = conn.createStatement();
            ResultSet r = s.executeQuery(sql);
            if (r.next())
                return r.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    public ArrayList<Medicine> getSubstitutes(String name) {
        int id = getMedicineId(name);
        ArrayList<Medicine> sub = new ArrayList<Medicine>();
        try {
            String sql = "select * from Substitute join Medicine where Substitute.substitute_id = Medicine.id and Substitute.medicine_id = "
                    + id;
            Statement s = conn.createStatement();
            ResultSet r = s.executeQuery(sql);
            while (r.next())
                sub.add(new Medicine(r.getInt(3), r.getString(4), r.getString(5)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sub;
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
    
}
