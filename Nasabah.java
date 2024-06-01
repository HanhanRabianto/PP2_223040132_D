package queue;

public class Nasabah {
    private String name;
    private int queueNumber;

    public Nasabah(String name, int queueNumber) {
        this.name = name;
        this.queueNumber = queueNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQueueNumber() {
        return queueNumber;
    }

    @Override
    public String toString() {
        return "Nomor Antrian: " + queueNumber + ", Nama: " + name;
    }
}
