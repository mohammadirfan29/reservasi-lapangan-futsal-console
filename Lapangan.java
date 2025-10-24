import java.util.Scanner;

public class Lapangan {
    private String id;
    private String namaLapangan;
    private String status;

    public Lapangan(String id, String namaLapangan, String status) {
        this.id = id;
        this.namaLapangan = namaLapangan;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getNamaLapangan() {
        return namaLapangan;
    }

    public String getStatus() {
        return status;
    }

    public void ubahStatus(String statusBaru) {
        this.status = statusBaru;
    }

    public void tambahData(Scanner scanner) {
        System.out.println("Tambah data Lapangan: ID=" + id + ", Nama=" + namaLapangan + ", Status=" + status);
    }

    public void lihatData() {
        System.out.println("Data Lapangan: ID=" + id + ", Nama=" + namaLapangan + ", Status=" + status);
    }
}
