package Bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class BankRegistrationForm {
    private static TextField nameField;
    private static JPasswordField passwordField;
    private static JPasswordField confirmPasswordField;
    private static TextArea outputArea;
    private static JList<String> accountTypeList; 
    private static JSpinner transactionFrequencySpinner;
    private static JSpinner birthDateSpinner;

    // Method untuk membuat dan menampilkan GUI
    private static void createAndShowGUI() {
        // membuat frame dan set judulnya
        JFrame frame = new JFrame("Form Pendaftaran Nasabah Bank");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // membuat panel utama
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2, 10, 10));

        // Input Nama Nasabah
        panel.add(new JLabel("Nama:"));
        nameField = new TextField();
        panel.add(nameField);

        // Input Pilihan Jenis Tabungan
        panel.add(new JLabel("Jenis Tabungan:"));
        String[] accountTypes = {"Tabungan Reguler", "Tabungan Bisnis", "Tabungan Investasi", "Tabungan Pendidikan"};
        accountTypeList = new JList<>(accountTypes);
        accountTypeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        accountTypeList.setSelectedIndex(0);
        panel.add(new JScrollPane(accountTypeList));

        // Input Frekuensi Transaksi per Bulan
        panel.add(new JLabel("Frekuensi Transaksi (per bulan):"));
        transactionFrequencySpinner = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
        panel.add(transactionFrequencySpinner);

        // Input Password
        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        // Input Confirm Password
        panel.add(new JLabel("Confirm Password:"));
        confirmPasswordField = new JPasswordField();
        panel.add(confirmPasswordField);

        // Input Tanggal Lahir
        panel.add(new JLabel("Tanggal Lahir:"));
        birthDateSpinner = new JSpinner(new SpinnerDateModel(new Date(), null, null, java.util.Calendar.DAY_OF_MONTH));
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(birthDateSpinner, "dd/MM/yyyy");
        birthDateSpinner.setEditor(dateEditor);
        panel.add(birthDateSpinner);

        // Area Output
        outputArea = new TextArea(5, 30);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        panel.add(scrollPane);

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem resetMenuItem = new JMenuItem("Reset");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        menu.add(resetMenuItem);
        menu.add(exitMenuItem);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        // Tombol Submit
        Button submitButton = new Button("Submit");
        panel.add(submitButton);

        // Menambahkan panel utama ke frame
        frame.add(panel, BorderLayout.CENTER);
        frame.add(scrollPane, BorderLayout.SOUTH);

        // Aksi tombol submit
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSubmit();
            }
        });

        // Aksi Reset Menu 
        resetMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetForm();
            }
        });

        // Aksi menu Exit 
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Menampilkan Frame
        frame.pack();
        frame.setVisible(true);
    }

    // Methode untuk menangani aksi Submit
    private static void handleSubmit() {
        String name = nameField.getText();
        String accountType = accountTypeList.getSelectedValue();
        int transactionFrequency = (int) transactionFrequencySpinner.getValue();
        Date birthDate = (Date) birthDateSpinner.getValue();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());
        
        // Validasi password
        if (!password.equals(confirmPassword)) {
            outputArea.setText("Password dan konfirmasi password tidak cocok!");
        } else {
            // Menampilkan informasi pendaftaran
            outputArea.setText("Nama: " + name + "\n"
                + "Jenis Tabungan: " + accountType + "\n"
                + "Frekuensi Transaksi: " + transactionFrequency + "\n"
                + "Tanggal Lahir: " + birthDate + "\n"
                + "Password: Cocok");
        }
    }

    // Method untuk mereset form
    private static void resetForm() {
        nameField.setText("");
        passwordField.setText("");
        confirmPasswordField.setText("");
        transactionFrequencySpinner.setValue(1);
        accountTypeList.setSelectedIndex(0);
        birthDateSpinner.setValue(new Date());
        outputArea.setText("");
    }

    // Main method untuk menjalankan program
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}





