import frontend.*;
import backend.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App extends JFrame implements ActionListener {
    JPanel panel;
    JPanel menuPanel;
    Register register;
    MenuS MenuS;
    Login login;
    Database db;
    boolean flag = false;

    public App() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        setSize(800, 500);
        db = new Database();
        login = new Login(this);
        register = new Register(this);
        panel = login.getLoginPanel();
        MenuS = new MenuS(this, db);
        menuPanel = MenuS.getMenuPanel();
        add(panel);
    }

    public void callFunction() {
        remove(panel);
        add(menuPanel);
        revalidate();
        repaint();
    }

    public void makeregister() {
        remove(panel);
        panel = register.getRegisterPanel();
        add(panel);
        revalidate();
        repaint();
        flag = true;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login.loginButton) {
            // check username and password
            String username = login.usernameField.getText();
            String password = new String(login.passwordField.getPassword());
            if (db.validate(username, password)) {
                login.result.setText("Login Successful");
                callFunction();
            } else {
                login.result.setText("Invalid Username or Password");
            }
        }
        if (e.getSource() == login.registerButton) {
            makeregister();
        }
        if (flag && e.getSource() == register.submitButton) {
            String name = register.nameField.getText();
            String password = register.passwordField.getText();
            String location = register.locationField.getText();
            Pharmacy pharma = new Pharmacy(name, password, location);
            db.addPharmacy(pharma);
            register.result.setText("Pharma Registered");
            db.validate(name, password);
            callFunction();
        }
    }

    public static void main(String[] args) {
        App gui = new App();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setTitle("My first GUI");
        // change font size to 20
        gui.setFont(new Font("Arial", Font.PLAIN, 54));
        gui.setSize(1350, 800);
        gui.setVisible(true);
    }
}
