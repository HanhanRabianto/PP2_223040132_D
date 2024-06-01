package queue;

import java.util.LinkedList;
import java.util.Queue;

public class BankQueue {
    private Queue<Nasabah> queue;
    private int nextQueueNumber;

    public BankQueue() {
        queue = new LinkedList<>();
        nextQueueNumber = 1;
    }

    // Metode untuk menambah nasabah ke antrean
    public void addNasabah(String name) {
        if (isDuplicateName(name)) {
            System.out.println("Nama nasabah " + name + " sudah ada dalam antrean. Tidak dapat menambah nasabah dengan nama yang sama.");
            return;
        }
        Nasabah nasabah = new Nasabah(name, nextQueueNumber++);
        queue.add(nasabah);
        System.out.println(nasabah + " telah ditambahkan ke antrean.");
    }

    // Metode untuk memproses nasabah di depan antrean
    public void processNasabah() {
        if (queue.isEmpty()) {
            System.out.println("Tidak ada nasabah dalam antrean.");
        } else {
            Nasabah nasabah = queue.poll();
            System.out.println(nasabah.getName() + " sedang diproses.");
        }
    }

    // Metode untuk melihat nasabah berikutnya tanpa memprosesnya
    public void peekNasabah() {
        if (queue.isEmpty()) {
            System.out.println("Tidak ada nasabah dalam antrean.");
        } else {
            Nasabah nasabah = queue.peek();
            System.out.println("Nasabah berikutnya: " + nasabah);
        }
    }

    // Metode untuk menampilkan semua nasabah dalam antrean
    public void displayQueue() {
        if (queue.isEmpty()) {
            System.out.println("Tidak ada nasabah dalam antrean.");
        } else {
            System.out.println("Nasabah dalam antrean: ");
            for (Nasabah nasabah : queue) {
                System.out.println(nasabah);
            }
        }
    }

    // Metode untuk menghapus nasabah berdasarkan nomor antrean
    public void removeNasabah(int queueNumber) {
        Nasabah nasabahToRemove = null;
        for (Nasabah nasabah : queue) {
            if (nasabah.getQueueNumber() == queueNumber) {
                nasabahToRemove = nasabah;
                break;
            }
        }
        if (nasabahToRemove != null) {
            queue.remove(nasabahToRemove);
            System.out.println("Nasabah dengan nomor antrian " + queueNumber + " telah dihapus.");
        } else {
            System.out.println("Nasabah dengan nomor antrian " + queueNumber + " tidak ditemukan.");
        }
    }

    // Metode untuk mengedit nama nasabah berdasarkan nomor antrean
    public void editNasabah(int queueNumber, String newName) {
        if (isDuplicateName(newName)) {
            System.out.println("Nama nasabah " + newName + " sudah ada dalam antrean. Tidak dapat mengganti nama nasabah dengan nama yang sama.");
            return;
        }
        for (Nasabah nasabah : queue) {
            if (nasabah.getQueueNumber() == queueNumber) {
                nasabah.setName(newName);
                System.out.println("Nama nasabah dengan nomor antrian " + queueNumber + " telah diubah menjadi " + newName);
                return;
            }
        }
        System.out.println("Nasabah dengan nomor antrian " + queueNumber + " tidak ditemukan.");
    }

    // Metode untuk mengecek apakah nama nasabah sudah ada dalam antrean
    private boolean isDuplicateName(String name) {
        for (Nasabah nasabah : queue) {
            if (nasabah.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
}
