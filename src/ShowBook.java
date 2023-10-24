import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ShowBook extends JFrame implements ActionListener{
    Library lib = Library.getInstance();
    JLabel quantityLabel;
    JButton backDash;
    JButton issue;
    JButton returnBook;
    String searchedBookCopy;
    ShowBook(String searchedBook){
        super("Book");
        setLayout(new GridLayout(7,1,8,8));
        setSize(400, 300);

        searchedBookCopy = searchedBook;

        JLabel titleLabel = new JLabel("Title: " + searchedBook);
        titleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        JLabel authorLabel = new JLabel("Author: " + lib.search(searchedBook).author);
        authorLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        quantityLabel = new JLabel("Quantity: " + lib.search(searchedBook).quantity);
        quantityLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        JLabel descriptionLabel = new JLabel("Description: " + lib.search(searchedBook).description);
        descriptionLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));

        backDash = new JButton("Go Back");
        backDash.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        backDash.addActionListener(this);

        issue = new JButton("Issue");
        issue.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        issue.addActionListener(this);

        returnBook = new JButton("Return");
        returnBook.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        returnBook.addActionListener(this);

        add(titleLabel);
        add(authorLabel);
        add(quantityLabel);
        add(descriptionLabel);
        add(backDash);
        add(issue);
        add(returnBook);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setResizable(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == backDash){
            new SearchBook();
            dispose();
        }
        if(e.getSource() == issue){
            if(lib.search(searchedBookCopy).quantity == 0){
                new IssueFailure();
                return;
            }
            lib.search(searchedBookCopy).quantity--;
            quantityLabel.setText("Quantity: " + lib.search(searchedBookCopy).quantity);
            new IssueSuccess();
        }
        if(e.getSource() == returnBook){
            lib.search(searchedBookCopy).quantity++;
            quantityLabel.setText("Quantity: " + lib.search(searchedBookCopy).quantity);
            new ReturnSuccess();
        }
    }
}
