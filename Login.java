/**
 * Creator: Josue Daniel Bustamante
 * Version: 23/05/2014
 */
import javax.swing.*;
import java.awt.event.*;

/**
 * The user can be use the system?
 * I dont know, give me your access permission.
 */
public class Login extends JFrame implements ActionListener {
    private JLabel userL, passL;
    private JTextField userF;
    private JButton login;
    private JPasswordField passP;
    
    public Login() {
        setLayout(null);
        setTitle("Login");
        
        // Labels
        userL = new JLabel("User");
        userL.setBounds(20,20,80,20);
        passL = new JLabel("Password");
        passL.setBounds(20,60,80,20);
        add(userL); add(passL);
        
        // TextFields
        userF = new JTextField();
        userF.setBounds(100,20,200,20);
        add(userF);
        
        // PasswordFields
        passP = new JPasswordField();
        passP.setBounds(100,60,200,20);
        add(passP);
        
        // Buttons
        login = new JButton("Login");
        login.setBounds(20,100,280,30);
        add(login);
        login.addActionListener(this);
    }
    
    /**
     * Main method for create a new RegisterRecipe class.
     * - Note: parameters can be left empty.
     */
    public static void main(String[] ar) {
        Login m = new Login();
        m.setBounds(30,30,320,180);
        m.setVisible(true);
        m.setResizable(false);
    }

    /**
     * OMG! I dont know what makes the buttons,
     * come with me, let's define them.
     * The button need take the data of the Fields and later compare with the
     * system for get or denied you the access.
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            char passC[] = passP.getPassword();
            String passS = new String(passC);
            if (userF.getText().equals("NU961120") && passS.equals("1234")){
                this.dispose();
                Launcher launcher = new Launcher();
                launcher.setBounds(30,30,320,250);
                launcher.setVisible(true);
                launcher.setResizable(false);
                JOptionPane.showMessageDialog(null, "Bienvenido\n" + "Has ingresado satisfactoriamente al sistema", "Acceso concedido", JOptionPane.INFORMATION_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(null, "Acceso denegado:\n" + "Por favor ingrese un usuario y/o contraseña correctos", "Acceso denegado", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
