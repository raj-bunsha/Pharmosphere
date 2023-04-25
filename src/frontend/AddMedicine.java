package frontend;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class AddMedicine implements ActionListener {
    JPanel panel;
    JTextField nameField;
    JTextField phoneField;
    JButton submitButton;
    JLabel result;

    public AddMedicine() {
        panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));
        nameField = new JTextField(20);
        phoneField = new JTextField(20);
        panel.add(new JLabel("Name: "));
        panel.add(nameField);
        panel.add(new JLabel("Phone Number: "));
        panel.add(phoneField);
        submitButton = new JButton("Submit");
        panel.add(submitButton);
        submitButton.addActionListener(this);
        result = new JLabel();
        panel.add(result);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            // add customer to database
            result.setText("Customer added to database");
        }
    }
    public JPanel getAddMedicinePanel() {
        return panel;
    }
}