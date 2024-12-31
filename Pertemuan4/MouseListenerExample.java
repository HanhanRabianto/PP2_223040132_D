import javax.swing.*;
import java.awt.event.*;

public class MouseListenerExample {

    public static void main(String[] args) {
        // Membuat frame
        JFrame frame = new JFrame("MouseListener Example");

        // Membuat label untuk menampilkan pesan
        JLabel label = new JLabel("Arahkan dan klik mouse pada area ini.");
        label.setBounds(50, 50, 300, 30);

        // Menambahkan MouseListener ke label
        label.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label.setText("Mouse Clicked at: (" + e.getX() + ", " + e.getY() + ")");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                label.setText("Mouse Pressed at: (" + e.getX() + ", " + e.getY() + ")");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                label.setText("Mouse Released at: (" + e.getX() + ", " + e.getY() + ")");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                label.setText("Mouse Entered the area.");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setText("Mouse Exited the area.");
            }
        });

        // Menambahkan label ke frame
        frame.add(label);

        // Mengatur layout frame menjadi null
        frame.setLayout(null);

        // Mengatur ukuran frame
        frame.setSize(400, 200);

        // Membuat frame terlihat
        frame.setVisible(true);

        // Menutup aplikasi saat frame ditutup
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
