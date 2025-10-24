import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class AplikasiFutsal {
    private ArrayList<Petugas> daftarPetugas = new ArrayList<>();
    private ArrayList<Pelanggan> daftarPelanggan = new ArrayList<>();
    private ArrayList<Lapangan> daftarLapangan = new ArrayList<>();
    private ArrayList<Reservasi> daftarReservasi = new ArrayList<>();
    private Petugas petugasAktif;

    public void inisialisasiData() {
        daftarPetugas.add(new Petugas("P1", "Admin", "admin", "123"));
        daftarLapangan.add(new Lapangan("L1", "Lapangan Karpet", "Tersedia"));
        daftarLapangan.add(new Lapangan("L2", "Lapangan Rumput", "Tersedia"));
    }

    public boolean loginPetugas(String username, String password) {
        for (Petugas p : daftarPetugas) {
            if (p.login(username, password)) {
                petugasAktif = p;
                return true;
            }
        }
        return false;
    }

    public void kelolaPelanggan(Scanner scanner) {
        System.out.println("Opsi: 1. Tambah Data 2. Lihat Data 3. Lihat Riwayat");
        int opsi = scanner.nextInt();
        scanner.nextLine();
        if (opsi == 1) {
            System.out.print("ID: ");
            String id = scanner.nextLine();
            System.out.print("Nama: ");
            String nama = scanner.nextLine();
            System.out.print("Nomor Telepon: ");
            String telp = scanner.nextLine();
            Pelanggan p = new Pelanggan(id, nama, telp);
            daftarPelanggan.add(p);
            p.tambahData(scanner);
        } else if (opsi == 2) {
            for (Pelanggan p : daftarPelanggan) p.lihatData();
        } else if (opsi == 3) {
            System.out.print("ID Pelanggan: ");
            String id = scanner.nextLine();
            for (Pelanggan p : daftarPelanggan)
                if (p.getId().equals(id)) p.lihatRiwayat();
        }
    }

    public void kelolaLapangan(Scanner scanner) {
        System.out.println("Opsi: 1. Tambah Data 2. Lihat Data");
        int opsi = scanner.nextInt();
        scanner.nextLine();
        if (opsi == 1) {
            System.out.print("ID: ");
            String id = scanner.nextLine();
            System.out.print("Nama Lapangan: ");
            String nama = scanner.nextLine();
            Lapangan l = new Lapangan(id, nama, "Tersedia");
            daftarLapangan.add(l);
            l.tambahData(scanner);
        } else {
            for (Lapangan l : daftarLapangan) l.lihatData();
        }
    }

    public void kelolaReservasi(Scanner scanner) {
        System.out.println("Opsi: 1. Buat Reservasi 2. Lihat Data");
        int opsi = scanner.nextInt();
        scanner.nextLine();

        if (opsi == 1) {
            System.out.print("ID Pelanggan: ");
            String idPelanggan = scanner.nextLine();
            System.out.print("ID Lapangan: ");
            String idLapangan = scanner.nextLine();

            Pelanggan pl = null;
            Lapangan lp = null;
            for (Pelanggan p : daftarPelanggan)
                if (p.getId().equals(idPelanggan)) pl = p;
            for (Lapangan l : daftarLapangan)
                if (l.getId().equals(idLapangan) && l.getStatus().equals("Tersedia")) lp = l;

            if (pl != null && lp != null) {
                String idReservasi = "RSV" + (daftarReservasi.size() + 1);
                Reservasi r = new Reservasi(idReservasi, petugasAktif, pl, lp);
                daftarReservasi.add(r);
                RiwayatReservasi riw = new RiwayatReservasi(idReservasi, LocalDate.now().toString(), lp, pl);
                pl.tambahRiwayat(riw);
                r.buatReservasi();
            } else {
                System.out.println("Data tidak valid atau lapangan tidak tersedia.");
            }
        } else {
            for (Reservasi r : daftarReservasi) r.lihatData();
        }
    }
}
