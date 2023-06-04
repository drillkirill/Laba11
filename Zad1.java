import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;

public class Zad1 implements ActionListener {
    private static JLabel userLabel;
    private static JTextField userText;
    private static JLabel fileLabel;
    private static JTextField fileText;
    private static JButton button;
    private static JLabel res;
    public static JFrame frame;
    public static JPanel panel;

    public static void main(String[] args) {
        frame = new JFrame();
        panel = new JPanel();

        frame.setSize(350, 250);
        frame.setTitle("Задание №1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        userLabel = new JLabel("Текст") ;
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        userText = new JTextField();
        userText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (userText.getText().length() >= 25 ) // ограничение 25 символов
                    e.consume();
            }
        });
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        fileLabel = new JLabel("Путь к файлу");
        fileLabel.setBounds(10, 50, 80, 25);
        panel.add(fileLabel);

        fileText = new JTextField();
        fileText.setBounds(100, 50, 165, 25);
        panel.add(fileText);

        button = new JButton("Запись");
        button.setBounds(10, 80, 80, 25);
        button.addActionListener(new Zad1());
        panel.add(button);

        res = new JLabel("Максимум 25 символов");
        res.setBounds(10, 110, 300, 25);
        panel.add(res);

        frame.setVisible(true);
    } // GUI

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = userText.getText();
        String filehome = fileText.getText();

        try(FileWriter writer = new FileWriter(filehome, false))
        {
            // запись всей строки
            writer.write(text);
            // запись по символам
            writer.flush();
            res.setText("Текст записан!");
        }
        catch(IOException ex){

            res.setText(ex.getMessage());
        }
    } // Запись в файл

}