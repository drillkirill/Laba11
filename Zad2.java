import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class Zad2 {
    private static JLabel name1Label; // имя
    private static JLabel name2Label; // фамилия
    private static JLabel name3Label; // отчество
    private static JLabel wasBornLabel; // дата рождения
    private static JLabel classLabel; // учебная группа
    private static JTextField name1Text;
    private static JTextField name2Text;
    private static JTextField name3Text;
    private static JTextField wasBornText;
    private static JTextField classText;
    private static JTextField feedBackText;
    private static JLabel feedBackLabel;
    private static JButton write;
    private static JButton read;

    public static JFrame frame;
    public static JPanel panel;

    public static void main(String[] args) {
        frame = new JFrame();
        panel = new JPanel();

        frame.setSize(445, 218);
        frame.setTitle("Задание №2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        name1Label = new JLabel("Имя");
        name1Label.setBounds(10, 20, 80, 25);
        panel.add(name1Label);

        name2Label = new JLabel("Фамилия");
        name2Label.setBounds(10, 50, 80, 25);
        panel.add(name2Label);

        name3Label = new JLabel("Отчество");
        name3Label.setBounds(10, 80, 80, 25);
        panel.add(name3Label);

        wasBornLabel = new JLabel("Дата рождения");
        wasBornLabel.setBounds(10, 110, 80, 25);
        panel.add(wasBornLabel);

        classLabel = new JLabel("Уч. группа");
        classLabel.setBounds(10, 140, 80, 25);
        panel.add(classLabel);


        name1Text = new JTextField();
        name1Text.setBounds(100, 20, 165, 25);
        panel.add(name1Text);

        name2Text = new JTextField();
        name2Text.setBounds(100, 50, 165, 25);
        panel.add(name2Text);

        name3Text = new JTextField();
        name3Text.setBounds(100, 80, 165, 25);
        panel.add(name3Text);

        wasBornText = new JTextField();
        wasBornText.setBounds(100, 110, 165, 25);
        panel.add(wasBornText);

        classText = new JTextField();
        classText.setBounds(100, 140, 165, 25);
        panel.add(classText);

        write = new JButton("Write");
        write.setBounds(270, 20, 70, 25);
        panel.add(write);

        read = new JButton("Read");
        read.setBounds(350, 20, 70, 25);
        panel.add(read);

        feedBackText = new JTextField();
        feedBackText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (feedBackText.getText().length() >= 0 ) // ограничение 25 символов
                    e.consume();
            }
        });
        feedBackText.setBounds(270, 80, 150, 85);
        panel.add(feedBackText);

        feedBackLabel = new JLabel("Окно взаимодействия:");
        feedBackLabel.setBounds(270, 50, 150, 25);
        panel.add(feedBackLabel);

        write.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String filehome = "D:/home.txt";
                try (FileWriter writer = new FileWriter(filehome, false)) {
                    // запись всей строки
                    List<String> lines = Arrays.asList(name1Text.getText(), name2Text.getText(),
                            name3Text.getText(), wasBornText.getText(), classText.getText());
                    Files.write(Paths.get(filehome), lines, StandardOpenOption.CREATE);
                    feedBackText.setText("      Данные записаны!");
                } catch (IOException ex) {

                    feedBackText.setText("     Файл не найден!");
                }
            } // Запись в файл}
        }); // Запись в файл
        read.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Path path = Paths.get("D:/home.txt");
                try {
                    List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
                    name1Text.setText(lines.get(0)); name2Text.setText(lines.get(1)); name3Text.setText(lines.get(2));
                    wasBornText.setText(lines.get(3)); classText.setText(lines.get(4));
                    feedBackText.setText("     Данные прочитаны!");
                }
                catch (IOException q) {
                    feedBackText.setText("     Файл не найден!");
            }
        }}); // Чтение из файла

        frame.setVisible(true);
    }
}

