package org.example.java_client_desktop.UI;

import javax.swing.*;
import java.util.List;

public class BookManagementUI extends JFrame {
    private JTextField titleField;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton viewLoansButton;
    private JList<String> bookList;

    private final BookServiceRemote bookService;
    private final LoanServiceRemote loanService;

    public BookManagementUI(BookServiceRemote bookService, LoanServiceRemote loanService) {
        this.bookService = bookService;
        this.loanService = loanService;

        setTitle("Book Management");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        titleField = new JTextField(20);
        addButton = new JButton("Add Book");
        updateButton = new JButton("Update Book");
        deleteButton = new JButton("Delete Book");
        viewLoansButton = new JButton("View Loans");
        bookList = new JList<>();

        addButton.addActionListener(e -> addBook());
        updateButton.addActionListener(e -> updateBook());
        deleteButton.addActionListener(e -> deleteBook());
        viewLoansButton.addActionListener(e -> viewLoans());

        JPanel panel = new JPanel();
        panel.add(new JLabel("Book Title:"));
        panel.add(titleField);
        panel.add(addButton);
        panel.add(updateButton);
        panel.add(deleteButton);
        panel.add(viewLoansButton);
        panel.add(new JScrollPane(bookList));

        setContentPane(panel);
    }

    private void addBook() {
        String title = titleField.getText();
        bookService.addBook(new Book(title));
        refreshBookList();
    }

    private void updateBook() {
        String selectedBook = bookList.getSelectedValue();
        if (selectedBook != null) {
            bookService.updateBook(new Book(selectedBook));
            refreshBookList();
        }
    }

    private void deleteBook() {
        String selectedBook = bookList.getSelectedValue();
        if (selectedBook != null) {
            bookService.deleteBook(selectedBook);
            refreshBookList();
        }
    }

    private void viewLoans() {
        List<Loan> loans = loanService.getAllLoans();
        new LoanViewUI(loans).setVisible(true);
    }

    private void refreshBookList() {
        List<String> books = bookService.getAllBookTitles();
        bookList.setListData(books.toArray(new String[0]));
    }
}

