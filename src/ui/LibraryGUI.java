package ui;

import model.*;
import storage.FileHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class LibraryGUI extends JFrame {
    private LibrarySystem system = new LibrarySystem();
    private JTextArea displayArea;

    public LibraryGUI() {
        setTitle("Library Book Lending System");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Load data
        try {
            FileHandler.loadBooks(system, "data/books.txt");
            FileHandler.loadMembers(system, "data/members.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // UI
        JPanel panel = new JPanel(new GridLayout(6, 2));
        JTextField bookId = new JTextField();
        JTextField title = new JTextField();
        JTextField author = new JTextField();
        JTextField memberId = new JTextField();
        JTextField name = new JTextField();

        panel.add(new JLabel("Book ID:")); panel.add(bookId);
        panel.add(new JLabel("Title:")); panel.add(title);
        panel.add(new JLabel("Author:")); panel.add(author);
        JButton addBook = new JButton("Add Book");
        panel.add(addBook);

        panel.add(new JLabel("Member ID:")); panel.add(memberId);
        panel.add(new JLabel("Name:")); panel.add(name);
        JButton addMember = new JButton("Add Member");
        panel.add(addMember);

        JButton viewBooks = new JButton("View Available Books");
        panel.add(viewBooks);

        add(panel, BorderLayout.NORTH);

        displayArea = new JTextArea();
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        addBook.addActionListener(e -> {
            Book b = new Book(bookId.getText(), title.getText(), author.getText(), true);
            system.addBook(b);
            display("Book added!");
        });

        addMember.addActionListener(e -> {
            Member m = new Member(memberId.getText(), name.getText());
            system.addMember(m);
            display("Member added!");
        });

        viewBooks.addActionListener(e -> {
            displayArea.setText("");
            for (Book b : system.listAvailableBooks()) {
                displayArea.append(b.getTitle() + " by " + b.getAuthor() + "\n");
            }
        });

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                try {
                    FileHandler.saveBooks(system, "data/books.txt");
                    FileHandler.saveMembers(system, "data/members.txt");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        setVisible(true);
    }

    private void display(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }
}