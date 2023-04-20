import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Register implements ActionListener {

  JPanel panel;
  JTextField nameField;
  JTextField phoneField;
  JTextField passwordField, locationField;
  JButton submitButton;
  JLabel result;
  App app;

  public Register(App app) {
    panel = new JPanel();
    panel.setLayout(new GridLayout(0, 2));
    nameField = new JTextField(20);
    phoneField = new JTextField(20);
    passwordField = new JPasswordField(20);
    locationField = new JTextField(20);
    panel.add(new JLabel("UserName: "));
    panel.add(nameField);
    panel.add(new JLabel("Password: "));
    panel.add(passwordField);
    panel.add(new JLabel("Phone Number: "));
    panel.add(phoneField);
    panel.add(new JLabel("Location: "));
    panel.add(locationField);
    submitButton = new JButton("Submit");
    panel.add(submitButton);
    submitButton.addActionListener(this);
    result = new JLabel();
    panel.add(result);
    this.app = app;
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == submitButton) {
      // add customer to database
      result.setText("Pharma Registered");
      app.callFunction();
    }
  }

  public JPanel getRegisterPanel() {
    return panel;
  }
}
