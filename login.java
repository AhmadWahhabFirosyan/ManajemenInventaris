import javax.swing.*;
import java.awt.*;

public class login {
    private JTextField textField1;
    private JPanel panel1;
    private JPasswordField passwordField1;
    private JButton masukButton;
    private JFrame frame;
    public login(){
        frame = new JFrame("user login");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(300 ,250));
        frame.setResizable(false);
        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

