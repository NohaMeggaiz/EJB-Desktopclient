package org.example.java_client_desktop.UI;

import javax.swing.*;
import java.util.List;

public class LoanViewUI extends JFrame {
    public LoanViewUI(List<Loan> loans) {
        setTitle("Current Loans");
        setSize(300, 200);

        JList<String> loanList = new JList<>();
        DefaultListModel<String> listModel = new DefaultListModel<>();

        for (Loan loan : loans) {
            listModel.addElement("Book: " + loan.getBookTitle() + ", User: " + loan.getUserName());
        }

        loanList.setModel(listModel);
        add(new JScrollPane(loanList));
    }
}
