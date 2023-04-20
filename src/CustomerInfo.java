import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class CustomerInfo implements ActionListener
{
    JPanel panel;
    JLabel label;
    JLabel text;
    JButton searchButton;
    private JTextField searchField;
    public CustomerInfo() {
        panel = new JPanel();
        label = new JLabel("Get Report of the customer");
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
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == searchButton)
        {
            text.setText("data");
        }
    }
    public JPanel getInfoPanel(){
        return panel;
    }
}
