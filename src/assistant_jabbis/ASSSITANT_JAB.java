package assistant_jabbis;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class ASSSITANT_JAB {

    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Python Integration Example");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create a button to run the Python script
        JButton button = new JButton("Run Python Script");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runPythonScript();
            }
        });

        // Add the button to the frame
        frame.getContentPane().add(button);
        frame.setVisible(true);
//        new login().setVisible(true);

    }

    private static void runPythonScript() {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(
                "C:\\Users\\USER\\AppData\\Local\\Programs\\Python\\Python311\\python.exe", // Correct Python path
                "C:\\Users\\USER\\PycharmProjects\\pythonProject21\\Ai.py" // Path to  Python script
            );

            processBuilder.directory(new File("C:\\Users\\USER\\PycharmProjects\\pythonProject21"));

            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            int exitCode = process.waitFor();
            System.out.println("Exited with code: " + exitCode);
            System.out.println("Output:\n" + output.toString());

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
