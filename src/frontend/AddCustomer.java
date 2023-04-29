package frontend;

import javax.swing.*;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import backend.Customer;
import backend.Database;

import java.awt.*;
import java.awt.event.*;

class AddCustomer implements ActionListener {
    JPanel panel;
    JTextField nameField;
    JTextField phoneField;
    JButton submitButton;
    JLabel result;
    Database db;

    public AddCustomer(Database db) {
        panel = new JPanel();
        panel.setLayout(new GridLayout(0,2));
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
        this.db = db;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
                String name = nameField.getText();
                String phone = phoneField.getText();
                Customer cust = new Customer(name,phone);
                result.setText(db.addCustomer(cust));
        }
    }

    public JPanel getAddCustomerPanel() {
        return panel;
    }
}