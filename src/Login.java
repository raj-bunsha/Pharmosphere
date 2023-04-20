import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Login implements ActionListener
{
    JPanel panel;
    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginButton,registerButton;
    JLabel result;
    App app;
    public Login(App app) {
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
        loginButton.addActionListener(this);
        registerButton = new JButton("Register");
        panel.add(registerButton);
        registerButton.addActionListener(this);
        result = new JLabel();
        panel.add(result);
        this.app=app;
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            // check username and password
            result.setText("Login Successful");
            app.callFunction();
        }
        if(e.getSource() == registerButton)
        {
            System.out.println("Register");
            app.makeregister();
        }
    }
    public JPanel getLoginPanel() {
        return panel;
    }
    
}
