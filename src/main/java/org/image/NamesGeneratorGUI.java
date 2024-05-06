package org.image;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import java.awt.event.ActionEvent;

public class NamesGeneratorGUI extends JFrame {
    private final JTextField maxLengthField;
    private final JTextField totalNamesField;
    private JButton generateButton;
    private JList<String> namesList;
    private DefaultListModel<String> listModel;

    public NamesGeneratorGUI() {
        setTitle("Name Generator");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));

        inputPanel.add(new JLabel("Maximum Length of Names:"));
        maxLengthField = new JTextField();
        inputPanel.add(maxLengthField);

        inputPanel.add(new JLabel("Total Number of Names:"));
        totalNamesField = new JTextField();
        inputPanel.add(totalNamesField);

        generateButton = new JButton("Generate Names");
        generateButton.addActionListener(this::generateAction);
        inputPanel.add(generateButton);

        add(inputPanel, BorderLayout.NORTH);

        listModel = new DefaultListModel<>();
        namesList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(namesList);
        add(scrollPane, BorderLayout.CENTER);
    }


    private void generateAndDisplayNames() {
        NamesGenerator generator = new NamesGenerator();
        char[] alphabet = {'A', 'B', 'C'};  // Define the alphabet used for name generation
        int maxLength = 5;  // Define the maximum length of each name
        int totalNames = 10;  // Define the total number of names to generate

        List<String> names = generator.generateNames(alphabet, maxLength, totalNames);
        // Display or use the names as needed in the GUI
    }

    private void generateAction(ActionEvent e) {
        int maxLength = Integer.parseInt(maxLengthField.getText());
        int totalNames = Integer.parseInt(totalNamesField.getText());

        // Define the alphabet used for generating names
        char[] alphabet = {'A', 'B', 'C'};  // Adjust the alphabet as needed

        NamesGenerator generator = new NamesGenerator();
        List<String> names = generator.generateNames(alphabet, maxLength, totalNames);

        listModel.clear();
        names.forEach(listModel::addElement);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new NamesGeneratorGUI().setVisible(true);
        });
    }
}
