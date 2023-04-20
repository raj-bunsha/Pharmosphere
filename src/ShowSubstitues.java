import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ShowSubstitues implements ActionListener
{
    JPanel panel;
    JLabel label;
    JLabel text;
    JButton searchButton;
    private JTextField searchField;
    public ShowSubstitues() {
        panel = new JPanel();
        label = new JLabel("Get Substitues of the Medicine");
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
            text.setText("Got the results");
        }
    }
    public JPanel getSubstituesPanel(){
        return panel;
    }
}
