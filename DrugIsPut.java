/**
 * Creator: Josue Daniel Bustamante
 * Version: 23/05/2014
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

/**
 * This class is very curious and gossipy, Ask him any gossip and she will tell you.
 * The patient was put the drug?
 */
public class DrugIsPut extends JFrame {
    private JLabel patientL, nurseL, availableL;
    private JTextField userF;
    private JComboBox drugsC;
    private JButton addDrug;
    private DefaultTableModel selectedDTM;
    private JScrollPane selectedS;
    
    public DrugIsPut() {
        setLayout(null);
        setTitle("Patient drugs");
        
        // Labels
        patientL = new JLabel("Patient");
        patientL.setBounds(15,15,80,20);
        nurseL = new JLabel("Nurse: NU961120 - John Due");
        nurseL.setBounds(390,15,200,20);
        availableL = new JLabel("Patient drugs");
        availableL.setBounds(15,60,200,20);
        add(patientL); add(nurseL); add(availableL);
        
        // TextFields
        userF = new JTextField();
        userF.setBounds(80,15,150,20);
        add(userF);
        
        // Table
        /* 
         * Source code for make the table based on
         * https://docs.oracle.com/javase/tutorial/uiswing/components/table.html
         * http://censorcosmico.blogspot.com/2010/03/uso-de-tablas-jtable-crear-anadir-y.html
         */
        String[] columnNames = {"Drug", "Is put?"};
        Object[][] data = {{"Acetaminofeno - Oral", new Boolean(false)},{"Acetaminofeno - Oral", new Boolean(true)}};
        selectedDTM = new DefaultTableModel(data, columnNames);
        final JTable selectedT = new JTable(selectedDTM);
        selectedT.setPreferredScrollableViewportSize(new Dimension(570,100));
        JScrollPane scrollPane = new JScrollPane(selectedT);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        scrollPane.setBounds(15,90,570,100);
        selectedT.getColumnModel().getColumn(0).setPreferredWidth(470);
        selectedT.getColumnModel().getColumn(1).setPreferredWidth(100);
        add(scrollPane);
    }
    
    /**
     * Main method for create a new RegisterRecipe class.
     * - Note: parameters can be left empty.
     */
    public static void main(String[] ar) {
        DrugIsPut m = new DrugIsPut();
        m.setBounds(30,30,600,250);
        m.setVisible(true);
        m.setResizable(false);
    }
}