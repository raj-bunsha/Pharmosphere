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
    JLabel text;
    JButton searchButton;
    private JTextField searchField;
    Database db;
    public CustomerInfo(Database db) {
        panel = new JPanel();
        label = new JLabel("Get Report of the customer");
        text= new JLabel("default");
        searchField = new JTextField();
        // text = new JLabel("default");
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
            String searchText = searchField.getText();
            Database db = new Database();
            ArrayList<String> customerList = new ArrayList<String>();
            System.out.print(searchText);
            customerList = db.getCustomerReport(searchText);
            if(!customerList.isEmpty()){
                String temp = "<html>";
                for(String order : customerList){
                    temp += order+"<br>";
                }
                temp+="</html";
                text.setText(temp);
            }
            else{
                text.setText("No customer found.");
            }
        }
    }
    public JPanel getInfoPanel(){
        return panel;
    }
}
