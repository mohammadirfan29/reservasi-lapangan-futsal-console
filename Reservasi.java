import java.util.Date;

public class Reservasi {
    private String id;
    private Date tanggal;
    private String status;
    private Petugas petugas;
    private Pelanggan pelanggan;
    private Lapangan lapangan;

    public Reservasi(String id, Petugas petugas, Pelanggan pelanggan, Lapangan lapangan) {
        this.id = id;
        this.petugas = petugas;
        this.pelanggan = pelanggan;
        this.lapangan = lapangan;
        this.tanggal = new Date();
        this.status = "Dipesan";
        lapangan.ubahStatus("Terpesan");
    }

    public void buatReservasi() {
        System.out.println("Reservasi berhasil: ID=" + id + ", Lapangan=" + lapangan.getNamaLapangan()
                + ", Pelanggan=" + pelanggan.getNama() + ", Petugas=" + petugas.getNama());
    }

    public void lihatData() {
        System.out.println("Data Reservasi: ID=" + id + ", Tanggal=" + tanggal + ", Status=" + status);
    }
}
