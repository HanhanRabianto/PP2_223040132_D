
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class MainFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame ("Contoh Konkurensi di Swing");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 200);
            frame.setLayout(new BorderLayout());

            JLabel statusLabel = new JLabel("Tekan tombol untuk mulai tugas berat", JLabel.CENTER);

            JButton startButton = new JButton("Mulai");

            JProgressBar progressBar = new JProgressBar(0, 60);
            progressBar.setValue(0);
            progressBar.setStringPainted(true);

            frame.add(statusLabel, BorderLayout.NORTH);
            frame.add(progressBar, BorderLayout.CENTER);
            frame.add(startButton, BorderLayout.SOUTH);

            //tombol aksi
            startButton.addActionListener(e -> {
                startButton.setEnabled(false);
                statusLabel.setText("Proses Berjalan...");

                //Buat SwingWorker untuk Menangani tugas berat
                SwingWorker<Void, Integer> worker = new SwingWorker<>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        //Simulasi tugas berat
                        for (int i = 0; i <= 100; i++) {
                            Thread.sleep(50); //simulasi delay
                            publish(i); //perbarui progress
                        }
                        return null;
                    }
                    @Override
                    protected void process(List<Integer> chunks) {
                        //perbarui progress bar
                        int latestProgress = chunks.get(chunks.size() - 1);
                        progressBar.setValue(latestProgress);
                    }
                    @Override
                    protected void done() {
                        //Aksi setelah tugas selesai
                        startButton.setEnabled(true);
                        statusLabel.setText("Proses selesai!");
                    }
                };
                worker.execute();
            });
            //Tampilkan frame
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
