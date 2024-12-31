

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.FlowLayout;

public class FormBiodata extends JFrame {
    private JTextField namaField, nomorHPField;
    private JRadioButton lakiLakiRadio, perempuanRadio;
    private JCheckBox wnaCheckBox;
    private JButton simpanButton;

    public FormBiodata() {
        setTitle("Form Biodata");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));

        // Nama
        add(new JLabel("Nama:"));
        namaField = new JTextField();
        add(namaField);

        // Nomor HP
        add(new JLabel("Nomor HP:"));
        nomorHPField = new JTextField();
        add(nomorHPField);

        // Jenis Kelamin
        add(new JLabel("Jenis Kelamin:"));
        JPanel jenisKelaminPanel = new JPanel();
        jenisKelaminPanel.setLayout(new java.awt.FlowLayout(FlowLayout.LEFT));
        lakiLakiRadio = new JRadioButton("Laki-Laki", true);
        perempuanRadio = new JRadioButton("Perempuan");
        ButtonGroup jenisKelaminGroup = new ButtonGroup();
        jenisKelaminGroup.add(lakiLakiRadio);
        jenisKelaminGroup.add(perempuanRadio);
        jenisKelaminPanel.add(lakiLakiRadio);
        jenisKelaminPanel.add(perempuanRadio);
        add(jenisKelaminPanel);

        // Warga Negara Asing
        add(new JLabel(""));
        wnaCheckBox = new JCheckBox("Warga Negara Asing");
        add(wnaCheckBox);

        // Tombol Simpan
        add(new JLabel(""));
        simpanButton = new JButton("Simpan");
        simpanButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                simpanData();
            }
        });
        add(simpanButton);

        setVisible(true);
    }

    private void simpanData() {
        String nama = namaField.getText();
        String nomorHP = nomorHPField.getText();
        String jenisKelamin = lakiLakiRadio.isSelected() ? "Laki-Laki" : "Perempuan";
        boolean isWNA = wnaCheckBox.isSelected();

        String pesan = "Data tersimpan:\n" +
                       "Nama: " + nama + "\n" +
                       "Nomor HP: " + nomorHP + "\n" +
                       "Jenis Kelamin: " + jenisKelamin + "\n" +
                       "Warga Negara Asing: " + (isWNA ? "Ya" : "Tidak");

        JOptionPane.showMessageDialog(this, pesan, "Data Tersimpan", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FormBiodata();
            }
        });
    }
}