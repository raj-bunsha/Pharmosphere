package frontend;
import java.util.*;
import javax.swing.*;

import backend.Database;
import backend.Inventory;

import java.awt.*;
import java.awt.event.*;
class InventoryManager implements ActionListener {
    JPanel panel;
    JLabel label;
    JButton expbutton, showInventory;
    JTextArea text;
    Database db;
    public InventoryManager(Database db) {
        panel = new JPanel();
        // label = new JLabel("Get Order");
        expbutton = new JButton("Clean Inventory");
        showInventory = new JButton("Show all medicines");
        text = new JTextArea("");
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        text.setFont(new Font("Roboto",Font.BOLD, 16));
        text.setEditable(false);
        // panel.add(label);
        panel.add(expbutton);
        panel.add(showInventory);
        panel.add(text);
        expbutton.addActionListener(this);
        showInventory.addActionListener(this);
        this.db = db;
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == expbutton)
        {
            int removeno = db.removeExpired();
            String temp = removeno+" medicines removed";
            text.setText(temp);
        }
        else if(e.getSource() == showInventory)
        {
            ArrayList<Inventory> expmedicines = db.showInventory();
            String temp = "";
            temp += "NAME\t PRICE \tQUANTITY  \tEXPIRY DATE\n";
            for(Inventory med: expmedicines){
                temp += db.getMedicineName(med.getMedicineId()) +"\t " + med.getPrice()+ "\t " + med.getQuantity() + "\t " + med.getExpiryDate()+ " \n" ;
            }
            text.setText(temp);
        }
    }
    public JPanel getInventoryPanel(){
        return panel;
    }
}
