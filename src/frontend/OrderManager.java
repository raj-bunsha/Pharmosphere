package frontend;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class OrderManager implements ActionListener
{
    JPanel panel;
    JTextField nameField;
    JTextField priceField;
    JTextField quantityField;
    JButton submitButton;
    JLabel result;
    public OrderManager()
    {
        panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));
        nameField = new JTextField(20);
        priceField = new JTextField(20);
        quantityField = new JTextField(20);
        panel.add(new JLabel("Name: "));
        panel.add(nameField);
        panel.add(new JLabel("Price: "));
        panel.add(priceField);
        panel.add(new JLabel("Quantity: "));
        panel.add(quantityField);
        submitButton = new JButton("Submit");
        panel.add(submitButton);
        submitButton.addActionListener(this);
        result = new JLabel();
        panel.add(result);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == submitButton)
        {
            //add medicine to database
            result.setText("Medicine added to database");
        }
    }
    public JPanel getOrderManagerPanel()
    {
        return panel;
    }
}
