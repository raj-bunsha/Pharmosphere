package frontend;
import javax.swing.*;

import backend.Database;
import backend.Inventory;
import backend.Medicine;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class MakeOrder implements ActionListener {
    JPanel panel;
    JButton addButton, buyButton;
    int medicineCount = 0;
    ArrayList<OrderPanel> items;
    Database db;

    public MakeOrder(Database db) {
        items=new ArrayList<OrderPanel>();
        panel = new JPanel();
        buyButton = new JButton("Order Medicines");
        panel.setLayout(new GridLayout(0, 1));
        addButton = new JButton("+ Add Medicine");
        panel.add(addButton);
        panel.add(buyButton);
        addButton.addActionListener(this);
        buyButton.addActionListener(this);
        this.db = db;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) 
        {
            items.add(new OrderPanel(panel,db));    
        }
        if(e.getSource() == buyButton)
        {
            System.out.println("hello");
            for(OrderPanel item:items)
            {
                if(item.status)
                {
                    String medicineName = (String)item.medicineField.getSelectedItem();
                    System.out.println(medicineName);
                    Integer quantity = Integer.parseInt(item.quantityField.getText());
                    Integer price = Integer.parseInt(item.priceField.getText());
                    String expiry = item.expiryDate.getText();
                    Inventory temp = new Inventory(db.getPharmaId(),db.getMedicineId(medicineName),quantity,price,expiry);
                    db.addInventory(temp);
                }
            }
        }
    }

    public JPanel getOrderPanel() {
        return panel;
    }
}
class OrderPanel implements ActionListener
{
    JPanel medicinePanel;
    String[] medicineNames;
    JComboBox<String> medicineField;
    JTextField quantityField,expiryDate;
    JTextField priceField;
    JButton removeButton;
    JPanel panel;
    boolean status;
    public OrderPanel(JPanel panel,Database db)
    {
        
        medicinePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ArrayList<Medicine> med = new ArrayList<Medicine>();
        System.out.println("hello");
        med= db.getAllMedicines();
        String[] temp = new String[med.size()];
        for(int i=0;i<med.size();i++)
        {
            temp[i]=med.get(i).getName();
        }
        medicineField = new JComboBox<>(temp);
        quantityField = new JTextField(3);
        priceField = new JTextField(3);
        expiryDate = new JTextField(10);
        removeButton = new JButton("-");
        removeButton.addActionListener(this);
        medicinePanel.add(medicineField);
        medicinePanel.add(new JLabel("Quantity: "));
        medicinePanel.add(quantityField);
        medicinePanel.add(new JLabel("Price: "));
        medicinePanel.add(priceField);
        medicinePanel.add(new JLabel("Expiry Date: "));
        medicinePanel.add(expiryDate);
        medicinePanel.add(removeButton);
        this.panel=panel;
        panel.add(medicinePanel);
        panel.revalidate();
        panel.repaint();
        status=true;
    }
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == removeButton)
        {
            panel.remove(medicinePanel);
            status=false;
            panel.revalidate();
            panel.repaint();
        }
    }
    public JPanel getMedicinePanel()
    {
        return medicinePanel;
    }
    public boolean getStatus()
    {
        return status;
    }
}
