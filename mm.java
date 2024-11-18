package pharmacyapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class PharmacyApp {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Pharmacy Management System");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create a panel for the search section
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout());

        // Create and add components to the search panel
        JLabel medicineLabel = new JLabel("Medicine Name:");
        JTextField medicineField = new JTextField(20);
        JButton searchButton = new JButton("Search");

        searchPanel.add(medicineLabel);
        searchPanel.add(medicineField);
        searchPanel.add(searchButton);

        // Add an area for suggestions (using a JList for example)
        DefaultListModel<String> suggestionsModel = new DefaultListModel<>();
        JList<String> suggestionsList = new JList<>(suggestionsModel);
        JScrollPane suggestionsScrollPane = new JScrollPane(suggestionsList);

        // Sample medicine suggestions with details
        String[] sampleMedicines = {
            "Aspirin", 
            "Ibuprofen", 
            "Paracetamol", 
            "Amoxicillin", 
            "Lisinopril", 
            "Metformin", 
            "Simvastatin", 
            "Omeprazole"
        };

        String[] medicineDetails = {
            "Aspirin: Pain reliever, anti-inflammatory.",
            "Ibuprofen: Pain reliever, reduces fever.",
            "Paracetamol: Pain reliever, reduces fever.",
            "Amoxicillin: Antibiotic used to treat infections.",
            "Lisinopril: Treats high blood pressure.",
            "Metformin: Used for type 2 diabetes management.",
            "Simvastatin: Lowers cholesterol levels.",
            "Omeprazole: Reduces stomach acid."
        };

        for (String medicine : sampleMedicines) {
            suggestionsModel.addElement(medicine);
        }

        // Add listener for medicine field to show suggestions
        medicineField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateSuggestions();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateSuggestions();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateSuggestions();
            }

            private void updateSuggestions() {
                String input = medicineField.getText().toLowerCase();
                suggestionsModel.clear();
                for (String medicine : sampleMedicines) {
                    if (medicine.toLowerCase().contains(input)) {
                        suggestionsModel.addElement(medicine);
                    }
                }
            }
        });

        // Add action to search button
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String medicineName = medicineField.getText();

                if (medicineName.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter a medicine name.", "Input Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame, "Searching for:\nMedicine: " + medicineName);
                    // Here you can add logic to fetch more details about the medication
                }
            }
        });

        // Add mouse listener to display details when a suggestion is clicked
        suggestionsList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) { // Check for double-click
                    String selectedMedicine = suggestionsList.getSelectedValue();
                    int index = java.util.Arrays.asList(sampleMedicines).indexOf(selectedMedicine);
                    if (index != -1) {
                        JOptionPane.showMessageDialog(frame, medicineDetails[index], selectedMedicine + " Details", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });

        // Add components to the frame
        frame.add(searchPanel, BorderLayout.NORTH);
        frame.add(suggestionsScrollPane, BorderLayout.CENTER);

        // Make the frame visible
        frame.setVisible(true);
    }
}