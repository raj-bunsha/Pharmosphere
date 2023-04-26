package frontend;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Login
{
    JPanel panel;
    public JTextField usernameField;
    public JPasswordField passwordField;
    public JButton loginButton,registerButton;
    public JLabel result;
    public Login(JFrame parent) {
        ActionListener listener = (ActionListener) parent;
        panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2));
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        panel.add(new JLabel("Username: "));
        panel.add(usernameField);
        panel.add(new JLabel("Password: "));
        panel.add(passwordField);
        loginButton = new JButton("Login");
        panel.add(loginButton);
        loginButton.addActionListener(listener);
        registerButton = new JButton("Register");
        panel.add(registerButton);
        registerButton.addActionListener(listener);
        result = new JLabel();
        panel.add(result);
    }
    public JPanel getLoginPanel() {
        return panel;
    }
    
}
