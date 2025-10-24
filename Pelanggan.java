import java.util.ArrayList;
import java.util.Scanner;

public class Pelanggan extends Pengguna {
    private String nomorTelepon;
    private ArrayList<RiwayatReservasi> daftarRiwayat = new ArrayList<>();

    public Pelanggan(String id, String nama, String nomorTelepon) {
        super(id, nama);
        this.nomorTelepon = nomorTelepon;
    }

    public void tambahRiwayat(RiwayatReservasi riwayat) {
        daftarRiwayat.add(riwayat);
    }

    public void lihatRiwayat() {
        System.out.println("Riwayat Reservasi untuk Pelanggan " + nama + ":");
        for (RiwayatReservasi r : daftarRiwayat) {
            r.tampilkanRiwayat();
        }
    }

    @Override
    public void tambahData(Scanner scanner) {
        System.out.println("Tambah data Pelanggan: ID=" + id + ", Nama=" + nama + ", Telepon=" + nomorTelepon);
    }

    @Override
    public void lihatData() {
        System.out.println("Data Pelanggan: ID=" + id + ", Nama=" + nama + ", Telepon=" + nomorTelepon);
    }
}
