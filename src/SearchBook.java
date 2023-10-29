import javax.swing.*;
import LibFuncs.*;
import java.awt.*;
import java.awt.event.*;

public class SearchBook extends JFrame implements ActionListener{
    Library lib = Library.getInstance();
    JTextField title;
    JButton search;
    JButton backDash;
    SearchBook(){
        super("Search Book");
        setLayout(new GridLayout(3,1,8,8));
        setSize(400, 300);

        JLabel titleLabel = new JLabel("Title: ");
        titleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        title = new JTextField("");
        title.setFont(new Font("Segoe UI", Font.PLAIN, 20));

        search = new JButton("Search");
        search.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        search.addActionListener(this);

        backDash = new JButton("Go Back");
        backDash.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        backDash.addActionListener(this);

        add(titleLabel);
        add(title);
        add(search);
        add(backDash);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setResizable(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == backDash){
            new Dashboard();
            dispose();
        }
        if(e.getSource() == search){
            if(title.getText().equals("")){
                new SearchBookFailure();
                return;
            }
            String title = this.title.getText();
            Book book = lib.search(title);
            if(book == null){
                new SearchBookFailure();
                return;
            }
            new ShowBook(title);
            dispose();
        }
    }
}
