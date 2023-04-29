package frontend;
import javax.swing.*;

import backend.Database;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
class CustomerInfo implements ActionListener
{
    JPanel panel;
    JLabel label;
    JTextArea text;
    JButton searchButton;
    private JTextField searchField;
    Database db;
    public CustomerInfo(Database db) {
        panel = new JPanel();
        label = new JLabel("Get Report of the customer");
        text= new JTextArea("");
        text.setEditable(false);
        text.setFont(new Font("Roboto",Font.BOLD, 16));
        searchField = new JTextField();
        // text = new JLabel("default");
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(label);
        panel.add(searchField);
        searchButton = new JButton("Search");


        searchButton.addActionListener(this);

        panel.add(searchButton);
        panel.add(text);
        this.db = db;
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == searchButton)
        {
            String searchText = searchField.getText();
            Database db = new Database();
            ArrayList<String> customerList = new ArrayList<String>();
            customerList = db.getCustomerReport(searchText);
            if(!customerList.isEmpty()){
                String temp = "MEDICINE NAME\tQUANTITY\t\tPRICE\t\tTOTAL PRICE\t\tDATE\n";
                for(String order : customerList){
                    temp += order+"\n";
                }
                text.setText(temp);
            }
            else{
                text.setText("No Records Found..");
            }
        }
    }
    public JPanel getInfoPanel(){
        return panel;
    }
}
