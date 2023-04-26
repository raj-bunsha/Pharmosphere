package frontend;
import javax.swing.*;

import backend.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


class MakePurchase implements ActionListener {
    JPanel panel;
    JButton addButton, buyButton;
    int medicineCount = 0;
    ArrayList<ItemPanel> items;
    JComboBox<String> customerField;
    Database db;

    public MakePurchase(Database db) {
        items=new ArrayList<ItemPanel>();
        panel = new JPanel();
        ArrayList<Customer> cust = db.getAllCustomers();
        String[] temp2 = new String[cust.size()];
        for(int i=0;i<cust.size();i++)
        {
            temp2[i]=cust.get(i).getName();
        }
        customerField = new JComboBox<>(temp2);
        buyButton = new JButton("Buy Medicines");
        panel.setLayout(new GridLayout(0, 1));
        addButton = new JButton("+ Add Medicine");
        panel.add(customerField);
        panel.add(addButton);
        panel.add(buyButton);
        addButton.addActionListener(this);
        this.db = db;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) 
        {
            items.add(new ItemPanel(panel,db));    
        }
        if (e.getSource() == buyButton) 
        {
            //make arraylist of tuple of medicine and quantity and pass it to function make purchase
            ArrayList<SellRecords> med = new ArrayList<SellRecords>();
            for(ItemPanel item:items)
            {
                if(item.getStatus())
                {
                    String medicineName = (String)item.medicineField.getSelectedItem();
                    Integer quantity = Integer.parseInt(item.quantityField.getText());
                    med.add(new SellRecords(db.getMedicineId(medicineName),quantity));
                }
            }
            db.makePurchase((String)customerField.getSelectedItem(),med);
        }
    }

    public JPanel getPurchasePanel() {
        return panel;
    }
}
class ItemPanel implements ActionListener
{
    JPanel medicinePanel;
    String[] medicineNames;
    JComboBox<String> medicineField;
    JTextField quantityField;
    JButton removeButton;
    JPanel panel;
    boolean status;
    public ItemPanel(JPanel panel,Database db)
    {
        medicinePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ArrayList<Medicine> med = db.getAllMedicines();

        medicineField = new JComboBox<>(medicineNames);
        String[] temp = new String[med.size()];
        for(int i=0;i<med.size();i++)
        {
            temp[i]=med.get(i).getName();
        }
        medicineField = new JComboBox<>(temp);
        quantityField = new JTextField(3);
        removeButton = new JButton("-");
        removeButton.addActionListener(this);
        medicinePanel.add(medicineField);
        medicinePanel.add(new JLabel("Quantity: "));
        medicinePanel.add(quantityField);
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
