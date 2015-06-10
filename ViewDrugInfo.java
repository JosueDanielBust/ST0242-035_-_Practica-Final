/**
 * Creator: Josue Daniel Bustamante
 * Version: 23/05/2014
 */
import javax.swing.*;
import java.awt.event.*;

/**
 * Yeap, this class is a cool library, only shows me the info of the selected drug.
 */
public class ViewDrugInfo extends JFrame
       implements ItemListener, ActionListener {
    private JLabel nurseL, availableL, selectedL, infoDrugL, urlDrugL, errorInfoL;
    private JComboBox drugsC;
    private JButton viewDrug;
    
    public ViewDrugInfo() {
        setLayout(null);
        setTitle("View the info of the drug");
        
        // Labels
        nurseL = new JLabel("Nurse: NU961120 - John Due");
        nurseL.setBounds(390,15,200,20);
        availableL = new JLabel("Available Drugs");
        availableL.setBounds(15,40,200,20);
        selectedL = new JLabel("Info of the selected Drug");
        selectedL.setBounds(15,110,200,20);
        add(nurseL); add(availableL); add(selectedL);
        
        // ComboBox
        String[] drugs = {"...", "Acarbosa - Oral", "Acebutolol - Oral", "Acetaminofeno - Oral", "Acetaminofeno - Rectal", "Acetaminofeno y Salicilatos - Orales"};
        drugsC = new JComboBox<String>(drugs);
        drugsC.setBounds(15,70,400,20);
        add(drugsC);
        drugsC.setSelectedIndex(3);
        drugsC.addItemListener(this);
        
        // Buttons
        viewDrug = new JButton("View Info");
        viewDrug.setBounds(430,70,155,20);
        add(viewDrug);
        viewDrug.addActionListener(this);
        
        // Info
        infoDrugL = new JLabel("<html><p style='font-size:8px;'>El acetaminofeno se usa para aliviar el dolor y reducir la fiebre. A diferencia de la aspirina, no alivia el enrojecimiento, la rigidez o la hinchazón causados por la artritis reumatoidea. Sin embargo, puede aliviar el dolor causado por formas leves de artritis.</p><br><p style='font-size:8px'>Si algo de la información en este folleto le causa preocupación especial o si desea más información acerca de su medicamento y su uso, consulte con su médico, enfermera o farmacéutico. Recuerde que debe mantener éste y todos los demás medicamentos fuera del alcance de los niños y nunca comparta sus medicamentos con otras personas.</p></html>");
        urlDrugL = new JLabel("<html><p style='font-size:8px;'>More info: <a href='http://www.buenasalud.com/enc/showdrugprofile.cfm?currentpage=1&AID=993003'>http://www.buenasalud.com/enc/showdrugprofile.cfm?currentpage=1&AID=993003</a></p><html>");
        infoDrugL.setBounds(15,150,570,130);
        urlDrugL.setBounds(15,270,570,50);
        add(infoDrugL); add(urlDrugL);
        
        // Error Info
        errorInfoL = new JLabel("<html><p style='font-size:30px;'>Error 404</p><p style='font-size:15px'>The info is missing</p><html>");
        errorInfoL.setBounds(15,150,570,130);
        add(errorInfoL);
        errorInfoL.setVisible(false);
    }

    /**
     * Main method for create a new ViewDrugInfo class.
     * - Note: parameters can be left empty.
     */
    public static void main(String[] ar) {
        ViewDrugInfo m = new ViewDrugInfo();
        m.setBounds(30,30,600,400);
        m.setVisible(true);
        m.setResizable(false);
    }
    
    /**
     * OMG! I dont know what makes the buttons,
     * come with me, let's define them.
     * I think the button of this class need show me the info of the drug.
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewDrug) {
            String selected = (String)drugsC.getSelectedItem();
            if (!selected.equals("Acetaminofeno - Oral")) {
                infoDrugL.setVisible(false); urlDrugL.setVisible(false); errorInfoL.setVisible(true);
            } else {
                infoDrugL.setVisible(true); urlDrugL.setVisible(true); errorInfoL.setVisible(false);
            }
        }
    }
    
    /**
     * What is this?
     * Oh Now!, I remember that this method is indigent.
     * Need, Make or Return nothing.
     * Is nobody!
     */
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == drugsC) {}
    }
}