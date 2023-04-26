package frontend;
import backend.*;
import java.util.*;
import java.util.AbstractMap.SimpleImmutableEntry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ShowSales implements ActionListener
{
    JPanel panel;
    JLabel label;
    JLabel text;
    JButton searchButton;
    private JTextField searchField;
    Database db;
    public ShowSales(Database db) {
        panel = new JPanel();
        label = new JLabel("Get Report of the Pharmacy");
        text= new JLabel("default");
        searchField = new JTextField();
        panel.setLayout(new GridLayout(0, 1));
        panel.add(searchField);
        searchButton = new JButton("Search");


        searchButton.addActionListener(this);

        panel.add(label);
        panel.add(searchButton);
        panel.add(text);
        this.db = db;
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == searchButton)
        {
            String search = searchField.getText();
            ArrayList<SimpleImmutableEntry<String, Integer>> revenue = db.getRevenue(search);
            text.setText("data");
            String temp = "";// 
            for(SimpleImmutableEntry<String, Integer> temp2 : revenue){
                temp += temp2.getKey() +" "+ Integer.toString(temp2.getValue())+"\n";
            }
            text.setText(temp);
        }
    }
    public JPanel getSalesPanel(){
        return panel;
    }
}
