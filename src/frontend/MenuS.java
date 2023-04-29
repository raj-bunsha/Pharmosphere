package frontend;
import javax.swing.*;

import backend.Database;

import java.awt.*;
import java.awt.event.*;
public class MenuS implements ActionListener
{
    JPanel panel,menuPanel;
    JFrame frame;
    Database db;
    JButton AddCustomer, AddMedicine, MakePurchase, MakeOrder, InventoryManager, ShowSubstitues, ShowSales, CustomerInfo;
    JButton AddSubstitute;
    public MenuS(JFrame frame, Database db)
    {
        panel = new JPanel();
        this.frame = frame;
        menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(0, 9));
        AddCustomer = new JButton("Add Customer");
        AddMedicine = new JButton("Add Medicine");
        MakePurchase = new JButton("Sell Medicine");
        MakeOrder = new JButton("Make Order");
        InventoryManager = new JButton("Inventory Manager");
        ShowSubstitues = new JButton("Show Substitutes");
        ShowSales = new JButton("Show Sales");
        CustomerInfo = new JButton("Customer Report");
        AddSubstitute = new JButton("Add Substitute");
        menuPanel.add(AddCustomer);
        menuPanel.add(AddMedicine);
        menuPanel.add(MakePurchase);
        menuPanel.add(MakeOrder);
        menuPanel.add(InventoryManager);
        menuPanel.add(ShowSubstitues);
        menuPanel.add(ShowSales);
        menuPanel.add(CustomerInfo);
        menuPanel.add(AddSubstitute);
        AddCustomer.addActionListener(this);
        AddMedicine.addActionListener(this);
        MakePurchase.addActionListener(this);
        MakeOrder.addActionListener(this);
        InventoryManager.addActionListener(this);
        ShowSubstitues.addActionListener(this);
        ShowSales.addActionListener(this);
        CustomerInfo.addActionListener(this);
        AddSubstitute.addActionListener(this);
        frame.add(panel);
        // frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        this.db=db;
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == AddCustomer)
        {
            frame.remove(panel);
            AddCustomer panel1 = new AddCustomer(db);
            panel=panel1.getAddCustomerPanel();
            frame.add(panel);
            frame.revalidate();
            frame.repaint();
        }
        else if(e.getSource() == AddMedicine)
        {
            frame.remove(panel);
            AddMedicine panel2 = new AddMedicine(db);
            panel=panel2.getAddMedicinePanel();
            frame.add(panel);
            frame.revalidate();
            frame.repaint();
        }
        else if(e.getSource() == MakePurchase)
        {
            frame.remove(panel);
            MakePurchase panel3 = new MakePurchase(db);
            panel=panel3.getPurchasePanel();
            frame.add(panel);
            frame.revalidate();
            frame.repaint();
        }
        else if(e.getSource() == MakeOrder)
        {
            frame.remove(panel);
            MakeOrder panel4 = new MakeOrder(db);
            panel=panel4.getOrderPanel();
            frame.add(panel);
            frame.revalidate();
            frame.repaint();
        }
        else if(e.getSource() == InventoryManager)
        {
            frame.remove(panel);
            InventoryManager panel5 = new InventoryManager(db);
            panel=panel5.getInventoryPanel();
            frame.add(panel);
            frame.revalidate();
            frame.repaint();
        }
        else if(e.getSource() == ShowSubstitues)
        {
            frame.remove(panel);
            ShowSubstitues panel6 = new ShowSubstitues(db);
            panel=panel6.getSubstituesPanel();
            frame.add(panel);
            frame.revalidate();
            frame.repaint();
        }
        else if(e.getSource() == ShowSales)
        {
            frame.remove(panel);
            ShowSales panel7 = new ShowSales(db);
            panel=panel7.getSalesPanel();
            frame.add(panel);
            frame.revalidate();
            frame.repaint();
        }
        else if(e.getSource() == CustomerInfo)
        {
            frame.remove(panel);
            CustomerInfo panel8 = new CustomerInfo(db);
            panel=panel8.getInfoPanel();
            frame.add(panel);
            frame.revalidate();
            frame.repaint();
        }
        else if(e.getSource() == AddSubstitute)
        {
            frame.remove(panel);
            AddSubstitutes panel9 = new AddSubstitutes(db);
            panel=panel9.getSubstitutePanel();
            frame.add(panel);
            frame.revalidate();
            frame.repaint();
        }
    }
    public JPanel getMenuPanel()
    {
        return menuPanel;
    }
}