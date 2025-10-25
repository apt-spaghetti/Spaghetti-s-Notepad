import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class NPFrame {
    public static void main(String[] args)
    {
        // Main Frame Part
        JFrame frame = new JFrame("Spaghetti's Notepad");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(800, 550);

        // Text Editor
        JTextArea textArea = new JTextArea();

        textArea.setFont(new Font("Consolas", Font.PLAIN, 16));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane (textArea);

        frame.add(scrollPane, BorderLayout.CENTER);

        // Save
        JButton saveButton = new JButton("Save");
        frame.add(saveButton, BorderLayout.SOUTH);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // Get Desktop
                String fileName = JOptionPane.showInputDialog(frame, "Enter File Name:", "Save As", JOptionPane.PLAIN_MESSAGE);

                if (fileName != null && !fileName.trim().isEmpty()) {
                    if (!fileName.endsWith(".txt")) {
                        fileName += ".txt";
                    }

                String desktopPath = System.getProperty("user.home") + "/Desktop";
                File file = new File(desktopPath, fileName);

                try (FileWriter writer = new FileWriter(file)) {
                    writer.write(textArea.getText());
                    JOptionPane.showMessageDialog(frame, "The File is saved to your Desktop!");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Error saving file: " + ex.getMessage());
                }
            } else {
                    JOptionPane.showMessageDialog(frame, "File name can't be empty!");
                }
            }
        });
        frame.setVisible(true);
    }
}