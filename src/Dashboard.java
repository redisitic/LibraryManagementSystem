import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {
    public Dashboard() {
        super("Dashboard");
        setLayout(new GridLayout(6,1,8,8));
        setSize(300, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setResizable(true);
        setVisible(true);
    }
}
