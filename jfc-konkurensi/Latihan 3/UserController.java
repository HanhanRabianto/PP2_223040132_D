package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import model.*;
import view.UserPdf;
import view.UserView;

public class UserController {
    private UserView view;
    private UserMapper mapper;
    private UserPdf pdf;

    public UserController(UserView view, UserMapper mapper, UserPdf pdf) {
        this.view = view;
        this.mapper = mapper;
        this.pdf = pdf;

        this.view.addAddUserListener(new AddUserListener());
        this.view.addRefreshListener(new RefreshListener());
        this.view.addExportListener(new ExportListener());
        this.view.getProcessButton().addActionListener(new ProcessDataListener());
    }

    class AddUserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = view.getNameInput();
            String email = view.getEmailInput();
            if (!name.isEmpty() && !email.isEmpty()) {
                User user = new User();
                user.setName(name);
                user.setEmail(email);
                mapper.insertUser(user);
                JOptionPane.showMessageDialog(view, "User added successfully!");
            } else {
                JOptionPane.showMessageDialog(view, "Please fill in all fields.");
            }
        }
    }

    class RefreshListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            List<User> users = mapper.getAllUsers();
            String[] userArray = users.stream()
                .map(u -> u.getName() + " (" + u.getEmail() + ")")
                .toArray(String[]::new);
            view.setUserList(userArray);
        }
    }

    class ExportListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            List<User> users = mapper.getAllUsers();
            pdf.exportPdf(users);
        }
    }

    class ProcessDataListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton processButton = view.getProcessButton();
            JProgressBar progressBar = view.getProgressBar();

            processButton.setEnabled(false); // Nonaktifkan tombol selama proses
            progressBar.setValue(0); // Reset progress bar

            SwingWorker<Void, Integer> worker = new SwingWorker<>() {
                @Override
                protected Void doInBackground() throws Exception {
                    for (int i = 1; i <= 100; i++) {
                        Thread.sleep(50); // Simulasi tugas berat
                        publish(i); // Kirim progres terbaru
                    }
                    return null;
                }

                @Override
                protected void process(List<Integer> chunks) {
                    // Perbarui progress bar
                    int progress = chunks.get(chunks.size() - 1);
                    progressBar.setValue(progress);
                }

                @Override
                protected void done() {
                    // Aktifkan kembali tombol
                    processButton.setEnabled(true);
                    JOptionPane.showMessageDialog(view, "Proses selesai!");
                }
            };

            worker.execute(); // Jalankan SwingWorker
        }
    }
}
