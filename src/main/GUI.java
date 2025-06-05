import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame {

    public GUI() {
        setTitle("Contacts Agenda");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 1, 10, 10));
        setSize(400, 400);
        setLocationRelativeTo(null);

        JButton createBtn = new JButton("Create contact");
        JButton searchBtn = new JButton("Search contact");
        JButton deleteBtn = new JButton("Delete contact");
        JButton updateBtn = new JButton("Update contact");
        JButton showAllBtn = new JButton("Show all contacts");
        JButton exitBtn = new JButton("Exit");

        add(createBtn);
        add(searchBtn);
        add(deleteBtn);
        add(updateBtn);
        add(showAllBtn);
        add(exitBtn);

        createBtn.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("Name:");
            String surname = JOptionPane.showInputDialog("Surname:");
            String phone = JOptionPane.showInputDialog("Phone:");
            String email = JOptionPane.showInputDialog("Email:");
            if (name != null && surname != null && phone != null && email != null) {
                String[] data = {name, surname, phone, email};
                Main.creation(data);
                JOptionPane.showMessageDialog(this, "Contact created successfully.");
            }
        });

        searchBtn.addActionListener(e -> {
            String[] options = {"ID", "Name", "Surname", "Phone", "Email"};
            String choice = (String) JOptionPane.showInputDialog(
                    this,
                    "Search contact by:",
                    "Searching",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            if (choice != null) {
                String input = JOptionPane.showInputDialog("Income " + choice + ":");
                if (input == null || input.isEmpty()) return;

                switch (choice) {
                    case "ID" -> {
                        try {
                            int id = Integer.parseInt(input);
                            Contacte contact = Main.findID(id);
                            if (contact != null) {
                                showMessage(contact);
                            } else {
                                JOptionPane.showMessageDialog(this, "No contact was found with that ID.");
                            }
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(this, "Invalid ID.");
                        }
                    }
                    case "Name" -> showContacts(Main.findName(input));
                    case "Surname" -> showContacts(Main.findSurname(input));
                    case "Phone" -> showContacts(Main.findPhone(input));
                    case "Email" -> showContacts(Main.findEmail(input));
                }
            }
        });

        deleteBtn.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("Enter the ID of the contact to delete:");
            if (input != null && input.matches("\\d+")) {
                int id = Integer.parseInt(input);
                Contacte contact = Main.findID(id);
                if (contact != null) {
                    Main.deletion(id);
                    JOptionPane.showMessageDialog(this, "Contact deleted.");
                } else {
                    JOptionPane.showMessageDialog(this, "ID not found.");
                }
            }
        });

        updateBtn.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("Enter the contact ID to update:");
            if (input != null && input.matches("\\d+")) {
                int id = Integer.parseInt(input);
                Contacte contact = Main.findID(id);
                if (contact != null) {
                    String name = JOptionPane.showInputDialog("New Name:", contact.getName());
                    String surname = JOptionPane.showInputDialog("New Surname:", contact.getSurnames());
                    String phone = JOptionPane.showInputDialog("New Phone:", contact.getPhone());
                    String email = JOptionPane.showInputDialog("New Email:", contact.getEmail());

                    if (name != null && surname != null && phone != null && email != null) {
                        Main.updation(id, name, surname, phone, email);
                        JOptionPane.showMessageDialog(this, "Updated contact.");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "ID not found.");
                }
            }
        });

        showAllBtn.addActionListener(e -> {
            var all = Main.revelation();
            if (all.isEmpty()) {
                JOptionPane.showMessageDialog(this, "There are no contacts registered.");
            } else {
                StringBuilder sb = new StringBuilder();
                for (var entry : all.entrySet()) {
                    Contacte c = entry.getValue();
                    sb.append("ID: ").append(entry.getKey())
                            .append(" | Name and surname: ").append(c.getName())
                            .append(" ").append(c.getSurnames())
                            .append(" | Phone: ").append(c.getPhone())
                            .append(" | Email: ").append(c.getEmail())
                            .append("\n");
                }
                JTextArea textArea = new JTextArea(sb.toString());
                textArea.setEditable(false);
                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new Dimension(400, 300));
                JOptionPane.showMessageDialog(this, scrollPane, "All contacts", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        exitBtn.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    private void showMessage(Contacte contact) {
        String info = "Name: " + contact.getName()
                + "\nSurname: " + contact.getSurnames()
                + "\nPhone: " + contact.getPhone()
                + "\nEmail: " + contact.getEmail();
        JOptionPane.showMessageDialog(this, info, "Contact found", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showContacts(java.util.Map<Integer, Contacte> map) {
        if (map.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No contacts found.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (var entry : map.entrySet()) {
                Contacte c = entry.getValue();
                sb.append("ID: ").append(entry.getKey())
                        .append(" | Name and surname: ").append(c.getName())
                        .append(" ").append(c.getSurnames())
                        .append(" | Phone: ").append(c.getPhone())
                        .append(" | Email: ").append(c.getEmail())
                        .append("\n");
            }
            JTextArea textArea = new JTextArea(sb.toString());
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(400, 300));
            JOptionPane.showMessageDialog(this, scrollPane, "Results", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
