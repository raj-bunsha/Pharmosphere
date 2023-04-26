package frontend;
import java.util.*;
import backend.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class ShowSubstitues implements ActionListener
{
    JPanel panel;
    JLabel label;
    JLabel text;
    JButton searchButton;
    Database db;
    private JTextField searchField;
    public ShowSubstitues(Database db) {
        panel = new JPanel();
        label = new JLabel("Get Substitutes of the Medicine");
        text= new JLabel("");
        searchField = new JTextField();
        // text = new JLabel("default");
        panel.setLayout(new GridLayout(2, 1));
        panel.add(searchField);
        searchButton = new JButton("Search");


        searchButton.addActionListener(this);

        panel.add(label);
        panel.add(searchButton);
        panel.add(text);
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == searchButton)
        {
            String medicine_name = searchField.getText();
            ArrayList<Medicine> substitutes = db.getSubstitutes(medicine_name);
            String temp = "";
            for(Medicine substitute : substitutes){
                String name = substitute.getName();
                temp += name+"\n";
            }
            text.setText(temp);
            text.setText("Got the results");
        }
    }
    public JPanel getSubstituesPanel(){
        return panel;
    }
}
