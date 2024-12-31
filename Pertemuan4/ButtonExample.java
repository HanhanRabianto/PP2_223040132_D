import javax.swing.*; // Perbaiki 'Isport' menjadi 'import'
import java.awt.event.*;

public class ButtonExample {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Button Example"); // Perbaikan nama 'Frane' jadi 'JFrame'
        JButton button = new JButton("Click Me");

        // Menambahkan ActionListener ke JButton
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked!");
            }
        });

        // Atur posisi dan ukuran tombol
        button.setBounds(50, 50, 150, 30);

        // Menambahkan tombol ke frame
        frame.add(button);

        // Mengatur ukuran frame
        frame.setSize(300, 200);

        // Mengatur layout menjadi null (tanpa layout manager)
        frame.setLayout(null);

        // Membuat frame terlihat
        frame.setVisible(true);

        // Menutup aplikasi saat frame ditutup
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
