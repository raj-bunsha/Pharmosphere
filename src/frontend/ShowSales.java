package frontend;
import backend.Database;
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
        // text = new JLabel("default");
        panel.setLayout(new GridLayout(2, 1));
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
            text.setText("data");
        }
    }
    public JPanel getSalesPanel(){
        return panel;
    }
}
