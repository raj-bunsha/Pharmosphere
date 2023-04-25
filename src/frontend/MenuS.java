package frontend;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MenuS implements ActionListener
{
    JPanel panel,menuPanel;
    JFrame frame;
    JButton AddCustomer, AddMedicine, MakePurchase, MakeOrder, InventoryManager, ShowSubstitues, ShowSales, CustomerInfo;
    public MenuS(JFrame frame)
    {
        panel = new JPanel();
        menuPanel = new JPanel();
        this.frame = frame;
        panel.setLayout(new GridLayout(0, 2));
        AddCustomer = new JButton("Add Customer");
        AddMedicine = new JButton("Add Medicine");
        MakePurchase = new JButton("Make Purchase");
        MakeOrder = new JButton("Make Order");
        InventoryManager = new JButton("Inventory Manager");
        ShowSubstitues = new JButton("Show Substitues");
        ShowSales = new JButton("Show Sales");
        CustomerInfo = new JButton("Customer Info");
        menuPanel.add(AddCustomer);
        menuPanel.add(AddMedicine);
        menuPanel.add(MakePurchase);
        menuPanel.add(MakeOrder);
        menuPanel.add(InventoryManager);
        menuPanel.add(ShowSubstitues);
        menuPanel.add(ShowSales);
        menuPanel.add(CustomerInfo);
        AddCustomer.addActionListener(this);
        AddMedicine.addActionListener(this);
        MakePurchase.addActionListener(this);
        MakeOrder.addActionListener(this);
        InventoryManager.addActionListener(this);
        ShowSubstitues.addActionListener(this);
        ShowSales.addActionListener(this);
        CustomerInfo.addActionListener(this);
        frame.add(panel);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == AddCustomer)
        {
            System.out.print("HI");
            frame.remove(panel);
            System.out.print("HI1");
            AddCustomer panel1 = new AddCustomer();
            panel=panel1.getAddCustomerPanel();
            frame.add(panel);
            frame.revalidate();
            frame.repaint();
        }
        else if(e.getSource() == AddMedicine)
        {
            frame.remove(panel);
            AddMedicine panel2 = new AddMedicine();
            panel=panel2.getAddMedicinePanel();
            frame.add(panel);
            frame.revalidate();
            frame.repaint();
        }
        else if(e.getSource() == MakePurchase)
        {
            frame.remove(panel);
            MakePurchase panel3 = new MakePurchase();
            panel=panel3.getPurchasePanel();
            frame.add(panel);
            frame.revalidate();
            frame.repaint();
        }
        else if(e.getSource() == MakeOrder)
        {
            frame.remove(panel);
            MakeOrder panel4 = new MakeOrder();
            panel=panel4.getOrderPanel();
            frame.add(panel);
            frame.revalidate();
            frame.repaint();
        }
        else if(e.getSource() == InventoryManager)
        {
            frame.remove(panel);
            InventoryManager panel5 = new InventoryManager();
            panel=panel5.getInventoryPanel();
            frame.add(panel);
            frame.revalidate();
            frame.repaint();
        }
        else if(e.getSource() == ShowSubstitues)
        {
            frame.remove(panel);
            ShowSubstitues panel6 = new ShowSubstitues();
            panel=panel6.getSubstituesPanel();
            frame.add(panel);
            frame.revalidate();
            frame.repaint();
        }
        else if(e.getSource() == ShowSales)
        {
            frame.remove(panel);
            ShowSales panel7 = new ShowSales();
            panel=panel7.getSalesPanel();
            frame.add(panel);
            frame.revalidate();
            frame.repaint();
        }
        else if(e.getSource() == CustomerInfo)
        {
            frame.remove(panel);
            CustomerInfo panel8 = new CustomerInfo();
            panel=panel8.getInfoPanel();
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