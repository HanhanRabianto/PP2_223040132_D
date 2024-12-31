import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HelloGridLayout extends JFrame implements ActionListener {

    private JButton buttonA;
    private JButton buttonB;
    private JButton buttonC;
    private JButton buttonD;
    private JButton buttonE;
    private JButton buttonF;
    private JButton buttonG;
    private JButton buttonH;
    private JButton buttonI;
    private JButton[] buttons; // Array untuk menyimpan semua tombol
    private boolean gameOver;

    public HelloGridLayout() {
        // Atur operasi ketika jendela ditutup
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Inisialisasi variabel
        gameOver = false;

        buttonA = new JButton("");
        buttonB = new JButton("");
        buttonC = new JButton("");
        buttonD = new JButton("");
        buttonE = new JButton("");
        buttonF = new JButton("");
        buttonG = new JButton("");
        buttonH = new JButton("");
        buttonI = new JButton("");

        // Inisialisasi array tombol
        buttons = new JButton[9];
        buttons[0] = buttonA;
        buttons[1] = buttonB;
        buttons[2] = buttonC;
        buttons[3] = buttonD;
        buttons[4] = buttonE;
        buttons[5] = buttonF;
        buttons[6] = buttonG;
        buttons[7] = buttonH;
        buttons[8] = buttonI;

        // Tambahkan ActionListener ke setiap tombol
        for (JButton button : buttons) {
            button.addActionListener(this);
        }

        // Atur tata letak GridLayout 3x3
        this.setLayout(new GridLayout(3, 3));

        // Tambahkan tombol ke jendela
        for (JButton button : buttons) {
            this.add(button);
        }

        // Atur ukuran jendela
        this.setSize(300, 300);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            JButton button = (JButton) e.getSource();
            if (button.getText().isEmpty()) {
                button.setText("0"); // Pemain pertama menandai dengan "0"
                checkWinner(); // Cek apakah ada pemenang
                if (!gameOver) {
                    for (JButton b : buttons) {
                        if (b.getText().isEmpty()) {
                            b.setText("X"); // Pemain kedua menandai dengan "X"
                            break;
                        }
                    }
                    checkWinner(); // Cek ulang setelah pemain kedua
                }
            }
        }
    }

    private void checkWinner() {
        String winner = "";

        // Cek baris atas
        if (!buttonA.getText().isEmpty() &&
            buttonA.getText().equals(buttonB.getText()) &&
            buttonA.getText().equals(buttonC.getText())) {
            winner = buttonA.getText();
            buttonA.setForeground(Color.RED);
            buttonB.setForeground(Color.RED);
            buttonC.setForeground(Color.RED);
        }
        // Cek baris tengah
        else if (!buttonD.getText().isEmpty() &&
            buttonD.getText().equals(buttonE.getText()) &&
            buttonD.getText().equals(buttonF.getText())) {
            winner = buttonD.getText();
            buttonD.setForeground(Color.RED);
            buttonE.setForeground(Color.RED);
            buttonF.setForeground(Color.RED);
        }
        // Cek baris bawah
        else if (!buttonG.getText().isEmpty() &&
            buttonG.getText().equals(buttonH.getText()) &&
            buttonG.getText().equals(buttonI.getText())) {
            winner = buttonG.getText();
            buttonG.setForeground(Color.RED);
            buttonH.setForeground(Color.RED);
            buttonI.setForeground(Color.RED);
        }
        // Cek kolom kiri
        else if (!buttonA.getText().isEmpty() &&
            buttonA.getText().equals(buttonD.getText()) &&
            buttonA.getText().equals(buttonG.getText())) {
            winner = buttonA.getText();
            buttonA.setForeground(Color.RED);
            buttonD.setForeground(Color.RED);
            buttonG.setForeground(Color.RED);
        }
        // Cek kolom tengah
        else if (!buttonB.getText().isEmpty() &&
            buttonB.getText().equals(buttonE.getText()) &&
            buttonB.getText().equals(buttonH.getText())) {
            winner = buttonB.getText();
            buttonB.setForeground(Color.RED);
            buttonE.setForeground(Color.RED);
            buttonH.setForeground(Color.RED);
        }
        // Cek kolom kanan
        else if (!buttonC.getText().isEmpty() &&
            buttonC.getText().equals(buttonF.getText()) &&
            buttonC.getText().equals(buttonI.getText())) {
            winner = buttonC.getText();
            buttonC.setForeground(Color.RED);
            buttonF.setForeground(Color.RED);
            buttonI.setForeground(Color.RED);
        }
        // Cek diagonal 1
        else if (!buttonA.getText().isEmpty() &&
            buttonA.getText().equals(buttonE.getText()) &&
            buttonA.getText().equals(buttonI.getText())) {
            winner = buttonA.getText();
            buttonA.setForeground(Color.RED);
            buttonE.setForeground(Color.RED);
            buttonI.setForeground(Color.RED);
        }
        // Cek diagonal 2
        else if (!buttonC.getText().isEmpty() &&
            buttonC.getText().equals(buttonE.getText()) &&
            buttonC.getText().equals(buttonG.getText())) {
            winner = buttonC.getText();
            buttonC.setForeground(Color.RED);
            buttonE.setForeground(Color.RED);
            buttonG.setForeground(Color.RED);
        }

        // Jika ada pemenang, set gameOver menjadi true
        gameOver = !winner.isEmpty();
    }

    public static void main(String[] args) {
        // Buat instance dan tampilkan jendela
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HelloGridLayout h = new HelloGridLayout();
                h.setVisible(true);
            }
        });
    }
}
