/**
 * Creator: Josue Daniel Bustamante
 * Version: 23/05/2014
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * This is a hungry and impatient class.
 * Come on, give me the recipe that requires the patient!
 */
public class RegisterRecipe extends JFrame
       implements ItemListener, ActionListener {
    private JLabel patientL, nurseL, availableL, selectedL;
    private JTextField userF;
    private JComboBox drugsC;
    private JButton addDrugB, regRecipeB;
    private DefaultTableModel selectedDTM;
    private JScrollPane selectedS;
    private ArrayList<String> recipeForReg, drugsToPut;
    
    public RegisterRecipe() {
        setLayout(null);
        setTitle("Register a new Recipe");
        
        // Labels
        patientL = new JLabel("Patient");
        patientL.setBounds(15,15,80,20);
        nurseL = new JLabel("Nurse: NU961120 - John Due");
        nurseL.setBounds(390,15,200,20);
        availableL = new JLabel("Available Drugs");
        availableL.setBounds(15,60,200,20);
        selectedL = new JLabel("Selected Drugs");
        selectedL.setBounds(15,140,200,20);
        add(patientL); add(nurseL); add(availableL); add(selectedL);
        
        // ComboBox
        String[] drugs = {" ", "Acarbosa - Oral", "Acebutolol - Oral", "Acetaminofeno - Oral", "Acetaminofeno - Rectal", "Acetaminofeno y Salicilatos - Orales", "..."};
        //String[] drugs = Drugs.getDrugs();
        drugsC = new JComboBox<String>(drugs);
        drugsC.setBounds(15,90,400,20);
        add(drugsC);
        drugsC.setSelectedIndex(0);
        drugsC.addItemListener(this);
        
        // TextFields
        userF = new JTextField();
        userF.setBounds(80,15,150,20);
        add(userF);
        
        // Buttons
        addDrugB = new JButton("Add Drug");
        addDrugB.setBounds(430,90,155,20);
        addDrugB.addActionListener(this);
        regRecipeB = new JButton("Register Recipe");
        regRecipeB.setBounds(430,280,155,20);
        regRecipeB.addActionListener(this);
        add(addDrugB); add(regRecipeB);
        
        // Table
        /* 
         * Source code for make the table based on
         * https://docs.oracle.com/javase/tutorial/uiswing/components/table.html
         * http://censorcosmico.blogspot.com/2010/03/uso-de-tablas-jtable-crear-anadir-y.html
         */
        String[] columnNames = {"Drug", "Options"};
        selectedDTM = new DefaultTableModel(columnNames, 0);
        final JTable selectedT = new JTable(selectedDTM);
        selectedT.setPreferredScrollableViewportSize(new Dimension(570,90));
        JScrollPane scrollPane = new JScrollPane(selectedT);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        scrollPane.setBounds(15,170,570,90);
        selectedT.getColumnModel().getColumn(0).setPreferredWidth(470);
        selectedT.getColumnModel().getColumn(1).setPreferredWidth(100);
        add(scrollPane);
        
        // ArrayList
        recipeForReg = new ArrayList<String>();
    }
    
    /**
     * Main method for create a new RegisterRecipe class.
     * - Note: parameters can be left empty.
     */
    public static void main(String[] ar) {
        RegisterRecipe m = new RegisterRecipe();
        m.setBounds(30,30,600,350);
        m.setVisible(true);
        m.setResizable(false);
    }
    
    /**
     * OMG! I dont know what makes the buttons,
     * come with me, let's define them.
     * The first makes a filter and a selection on the drug to put into the JTable.
     * The second makes a register of the recipe calling the Recipe class.
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addDrugB) {
            String selected = (String)drugsC.getSelectedItem();
            if (!selected.equals("...") && !selected.equals(" ")) {
                Object[] drug = {selected, "0"};
                selectedDTM.addRow(drug);
                recipeForReg.add(selected);
            }
        }
        if (e.getSource() == regRecipeB) {
            drugsToPut = new ArrayList<String>();
            for (Object rfg : recipeForReg) {
                drugsToPut.add((String)rfg);
            }
            Recipe recipe = new Recipe(userF.getText(), drugsToPut);
            recipe.print();
        }
    }
    
    /**
     * This method is indigent.
     * Need, Make or Return nothing.
     * Is nobody!
     */
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == drugsC) {}
    }
}