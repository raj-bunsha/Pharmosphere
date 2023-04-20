import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class InventoryManager implements ActionListener {
    JPanel panel;
    JLabel label;
    JButton button;
    JLabel text;
    public InventoryManager() {
        panel = new JPanel();
        label = new JLabel("Get Order");
        button = new JButton("Print Order Summary");
        text = new JLabel("default");
        panel.setLayout(new GridLayout(2, 1));
        panel.add(label);
        panel.add(button);
        panel.add(text);
        button.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button)
        {
            if(button.getText().equals("Print Order Summary"))
            {
                text.setText("Hello");
                button.setText("Print Previous Order's Summary");
            }
            else
            {
                text.setText("HI1");
                button.setText("Print Order Summary");
            }
        }
    }
    public JPanel getInventoryPanel(){
        return panel;
    }
}
