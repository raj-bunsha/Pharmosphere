package frontend;
import backend.*;
import java.util.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ShowSales implements ActionListener
{
    JPanel panel;
    JLabel label;
    JTextArea text;
    JButton searchButton;
    private JTextField searchField;
    Database db;
    public ShowSales(Database db) {
        panel = new JPanel();
        label = new JLabel("Get Report of the Pharmacy");
        text= new JTextArea("");
        text.setEditable(false);
        text.setFont(new Font("Roboto",Font.BOLD, 16));
        searchField = new JTextField();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        searchButton = new JButton("Search");
        

        searchButton.addActionListener(this);

        panel.add(label);
        panel.add(searchField);
        panel.add(searchButton);
        panel.add(text);
        this.db = db;
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == searchButton)
        {
            String search = searchField.getText();
            ArrayList<ArrayList<String>> revenue = db.getRevenue(search);
            String temp = "STORE NAME\t REVENUE\t Location\n";// 
            for(ArrayList<String> temp2 : revenue){

                temp += temp2.get(0) +"\t"+ temp2.get(1)+"\t"+temp2.get(2)+"\n";
            }
            text.setText(temp);
        }
    }
    public JPanel getSalesPanel(){
        return panel;
    }
}
