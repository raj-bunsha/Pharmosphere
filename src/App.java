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
    // static Database db = new Database();

    public App() {
        setLayout(new FlowLayout());
        // create a panel
        login = new Login(this);
        panel = login.getLoginPanel();
        MenuS = new MenuS(this);
        menuPanel = MenuS.getMenuPanel();
        add(panel);
    }

    public void callFunction() {
        remove(panel);
        add(menuPanel);
        revalidate();
        repaint();
    }

    public void makeregister()
    {
        remove(panel);
        Register register = new Register(this);
        panel = register.getRegisterPanel();
        add(panel);
        revalidate();
        repaint();
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login.loginButton || e.getSource() == register.submitButton) {
            // check username and password
            login.result.setText("Login Successful");
            callFunction();
        }
        if(e.getSource() == login.registerButton)
        {
            System.out.println("Register");
            makeregister();
        }
    }

    public static void main(String[] args) {
        App gui = new App();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setTitle("My first GUI");
        // change font size to 20
        gui.setFont(new Font("Arial", Font.PLAIN, 54));
        gui.setSize(1000, 800);
        gui.setVisible(true);
    }
}
