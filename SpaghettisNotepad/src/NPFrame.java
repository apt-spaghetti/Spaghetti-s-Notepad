import javax.swing.*;
import java.awt.*;

public class NPFrame {
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Spaghetti's Notepad");

        frame.setSize(800, 550);

        JTextArea textArea = new JTextArea();

        textArea.setFont(new Font("Consolas", Font.PLAIN, 16));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane (textArea);

        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
}