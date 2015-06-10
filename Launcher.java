/**
 * Creator: Josue Daniel Bustamante
 * Version: 27/05/2014
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

/**
 * This sexy class what he does is provide a graphical interface
 * that's makes a easy access for the other interfaces. 
 */
public class Launcher extends JFrame
       implements ActionListener {
    private JLabel nurseL;
    private JButton VDILaunch, RRLaunch, DIPLaunch;
    
    public Launcher() {
        setLayout(null);
        setTitle("The Launcher Layout");
        
        // Labels
        nurseL = new JLabel("Nurse: NU961120 - John Due");
        nurseL.setBounds(60,15,200,20);
        add(nurseL);
        
        // Buttons
        VDILaunch = new JButton("View the drug info");
        VDILaunch.setBounds(20,70,280,30);
        VDILaunch.addActionListener(this);
        
        RRLaunch = new JButton("Register a new recipe");
        RRLaunch.setBounds(20,120,280,30);
        RRLaunch.addActionListener(this);
        
        DIPLaunch = new JButton("Check if the drug is put");
        DIPLaunch.setBounds(20,170,280,30);
        DIPLaunch.addActionListener(this);
        
        add(VDILaunch); add(RRLaunch); add(DIPLaunch);
    }
    
    /**
     * Main method for create a new Launcher class.
     * - Note: parameters can be left empty.
     */
    public static void main(String[] ar) {
        Launcher l = new Launcher();
        l.setBounds(30,30,320,250);
        l.setVisible(true);
        l.setResizable(false);
    }
    
    /**
     * OMG! I dont know what makes the buttons,
     * come with me, let's define them.
     * This buttons only makes a new instance of the class selected.
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == VDILaunch) {
            ViewDrugInfo VDI = new ViewDrugInfo();
            VDI.setBounds(30,30,600,400);
            VDI.setVisible(true);
            VDI.setResizable(false);
        }
        if (e.getSource() == RRLaunch) {
            RegisterRecipe RR = new RegisterRecipe();
            RR.setBounds(30,30,600,350);
            RR.setVisible(true);
            RR.setResizable(false);
        }
        if (e.getSource() == DIPLaunch) {
            DrugIsPut DIP = new DrugIsPut();
            DIP.setBounds(30,30,600,250);
            DIP.setVisible(true);
            DIP.setResizable(false);
        }
    }
}