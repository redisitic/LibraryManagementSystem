import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class IssueFailure extends JFrame implements ActionListener{
    JButton okButton;
    public IssueFailure(){
        super("Failure to issue book");
        setLayout(new GridLayout(2,1,8,8));
        setSize(300, 600);
        Font fontRegular = new Font("Segoe UI", Font.PLAIN, 20);

        JLabel failLabel = new JLabel("Book not available");
        failLabel.setFont(fontRegular);

        okButton = new JButton("OK");
        okButton.addActionListener(this);
        okButton.setFont(fontRegular);

        add(failLabel);
        add(okButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setResizable(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == okButton){
            dispose();
        }
    }
}