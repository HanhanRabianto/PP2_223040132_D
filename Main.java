package queue;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankQueue bankQueue = new BankQueue();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu Antrean Bank:");
            System.out.println("1. Daftar Antrian (Masukkan Nama Nasabah)");
            System.out.println("2. Proses Nasabah di Depan Antrean");
            System.out.println("3. Tampilkan Daftar Nasabah dalam Antrean");
            System.out.println("4. Lihat Nasabah Berikutnya");
            System.out.println("5. Hapus Nasabah dari Antrean");
            System.out.println("6. Edit Nama Nasabah dalam Antrean");
            System.out.println("7. Keluar");
            System.out.print("Pilih opsi (1-7): ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Konsumsi newline

            switch (choice) {
                case 1:
                    System.out.print("Masukkan nama nasabah: ");
                    String nasabahName = scanner.nextLine();
                    bankQueue.addNasabah(nasabahName);
                    break;
                case 2:
                    bankQueue.processNasabah();
                    break;
                case 3:
                    bankQueue.displayQueue();
                    break;
                case 4:
                    bankQueue.peekNasabah();
                    break;
                case 5:
                    System.out.print("Masukkan nomor antrian nasabah yang ingin dihapus: ");
                    int removeQueueNumber = scanner.nextInt();
                    bankQueue.removeNasabah(removeQueueNumber);
                    break;
                case 6:
                    System.out.print("Masukkan nomor antrian nasabah yang ingin diedit: ");
                    int editQueueNumber = scanner.nextInt();
                    scanner.nextLine(); // Konsumsi newline
                    System.out.print("Masukkan nama baru nasabah: ");
                    String newName = scanner.nextLine();
                    bankQueue.editNasabah(editQueueNumber, newName);
                    break;
                case 7:
                    System.out.println("Terima kasih! Program selesai.");
                    break;
                default:
                    System.out.println("Opsi tidak valid. Silakan pilih antara 1 dan 7.");
            }
        } while (choice != 7);

        scanner.close();
    }
}
