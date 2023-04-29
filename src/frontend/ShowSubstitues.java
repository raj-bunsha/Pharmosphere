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
    JTextArea text;
    JButton searchButton;
    Database db;
    private JTextField searchField;
    public ShowSubstitues(Database db) {
        panel = new JPanel();
        label = new JLabel("Get Substitutes of the Medicine");
        text= new JTextArea("");
        text.setEditable(false);
        text.setFont(new Font("Roboto",Font.BOLD, 16));
        searchField = new JTextField();
        // text = new JLabel("default");
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(searchField);
        searchButton = new JButton("Search");
        panel.add(label);
        searchButton.addActionListener(this);

        panel.add(searchButton);
        panel.add(text);
        this.db = db;
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
            // text.setText("Got the results");
        }
    }
    public JPanel getSubstituesPanel(){
        return panel;
    }
}
