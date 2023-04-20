
//write a sample swing program
//?How do i run this program?
import javax.swing.*;
import java.awt.*;

public class App extends JFrame {
    JPanel panel;
    JPanel menuPanel;
    Register register;
    Menu menu;

    public App() {
        setLayout(new FlowLayout());
        // create a panel
        Login login = new Login(this);
        panel = login.getLoginPanel();
        menu = new Menu(this);
        menuPanel = menu.getMenuPanel();
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
