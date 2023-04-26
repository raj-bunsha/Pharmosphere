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
    JLabel text;
    Database db;
    public InventoryManager(Database db) {
        panel = new JPanel();
        label = new JLabel("Get Order");
        expbutton = new JButton("Remove expired medicines");
        showInventory = new JButton("Show all medicines");
        text = new JLabel("default");
        panel.setLayout(new GridLayout(3, 1));
        panel.add(label);
        panel.add(expbutton);
        panel.add(text);
        expbutton.addActionListener(this);
        this.db = db;
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == expbutton)
        {
            int removeno = db.removeExpired();
            String temp = ""+removeno;
            text.setText(temp);
        }
        else if(e.getSource() == showInventory)
        {
            ArrayList<Inventory> expmedicines = db.showInventory();
            String temp = "";
            for(Inventory med: expmedicines){
                temp += db.getMedicineName(med.getMedicineId()) + " " + med.getQuantity() + " " + med.getExpiryDate() ;
            }
            text.setText(temp);
        }
    }
    public JPanel getInventoryPanel(){
        return panel;
    }
}
