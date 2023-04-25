package frontend;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Register {

  JPanel panel;
  JTextField nameField;
  JTextField phoneField;
  JTextField passwordField, locationField;
  public JButton submitButton;
  JLabel result;

  public Register(JFrame parent) {
    ActionListener listener = (ActionListener) parent;
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
    submitButton.addActionListener(listener);
    result = new JLabel();
    panel.add(result);
  }
  public JPanel getRegisterPanel() {
    return panel;
  }
}
