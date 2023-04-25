package frontend;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class MakePurchase implements ActionListener {
    JPanel panel;
    JButton addButton, buyButton;
    int medicineCount = 0;
    ArrayList<ItemPanel> items;

    public MakePurchase() {
        items=new ArrayList<ItemPanel>();
        panel = new JPanel();
        buyButton = new JButton("Buy Medicines");
        panel.setLayout(new GridLayout(0, 1));
        addButton = new JButton("+ Add Medicine");
        panel.add(addButton);
        panel.add(buyButton);
        addButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) 
        {
            items.add(new ItemPanel(panel));    
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
    public ItemPanel(JPanel panel)
    {
        medicinePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        medicineNames = new String[]{"Medicine 1", "Medicine 2", "Medicine 3" };
        medicineField = new JComboBox<>(medicineNames);
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
