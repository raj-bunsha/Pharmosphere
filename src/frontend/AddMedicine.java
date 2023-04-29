package frontend;
import javax.swing.*;

import backend.Database;
import backend.Medicine;

import java.awt.*;
import java.awt.event.*;
class AddMedicine implements ActionListener {
    JPanel panel;
    JTextField nameField;
    JTextField detailsField;
    JButton submitButton;
    JLabel result;
    Database db;
    public AddMedicine(Database db) {
        panel = new JPanel();
        panel.setLayout(new GridLayout(0,2));
        nameField = new JTextField(20);
        detailsField = new JTextField(50);
        panel.add(new JLabel("Name: "));
        panel.add(nameField);
        panel.add(new JLabel("Details: "));
        panel.add(detailsField);
        submitButton = new JButton("Submit");
        panel.add(submitButton);
        submitButton.addActionListener(this);
        result = new JLabel();
        panel.add(result);
        this.db = db;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            // add customer to database
            String name = nameField.getText();
            String category = detailsField.getText();
            Medicine medicine = new Medicine(name,category);
            db.addMedicine(medicine);
            result.setText("Medicine added to database");
        }
    }
    public JPanel getAddMedicinePanel() {
        return panel;
    }
}