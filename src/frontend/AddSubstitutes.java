package frontend;
import javax.swing.*;

import backend.Database;
import backend.Inventory;
import backend.Medicine;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class AddSubstitutes implements ActionListener
{
    JPanel panel;
    JLabel result;
    String[] medicineNames;
    JComboBox<String> medicineField,substituteField;
    JButton addButton;
    Database db;

    public AddSubstitutes(Database db){
        ArrayList<Medicine> medicines = new ArrayList<>();
        medicines = db.getAllMedicines();
        String[] arr = new String[medicines.size()];
        String[] arr2 = new String[medicines.size()];
        for(int i = 0;i<medicines.size();i++){
            arr[i] = medicines.get(i).getName();
            arr2[i] = medicines.get(i).getName();
        }


        panel=new JPanel();
        medicineField = new JComboBox<>(arr);
        substituteField = new JComboBox<>(arr2);
        addButton = new JButton("Add Substitute");
        addButton.addActionListener(this);
        result = new JLabel("");
        panel.setLayout(new GridLayout(0, 1));
        panel.add(medicineField);
        panel.add(substituteField);
        panel.add(addButton);
        panel.add(result);
        this.db = db;
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addButton){   
            String name = (String) medicineField.getSelectedItem();
            String subname = (String)substituteField.getSelectedItem();
            result.setText(db.AddSubstitutes(db.getMedicineId(name),db.getMedicineId(subname)));
        }
    }
    public JPanel getSubstitutePanel() {
        return panel;
    }
}