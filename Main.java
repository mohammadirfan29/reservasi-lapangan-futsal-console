import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AplikasiFutsal app = new AplikasiFutsal();
        app.inisialisasiData();

        boolean login = false;
        while (!login) {
            System.out.println("Login Aplikasi Futsal");
            System.out.print("Username: ");
            String user = scanner.nextLine();
            System.out.print("Password: ");
            String pass = scanner.nextLine();
            if (app.loginPetugas(user, pass)) {
                login = true;
                System.out.println("Login berhasil!");
            } else {
                System.out.println("Username atau password salah!");
            }
        }

        boolean jalan = true;
        while (jalan) {
            System.out.println("\nMenu Utama");
            System.out.println("1. Kelola Pelanggan");
            System.out.println("2. Kelola Lapangan");
            System.out.println("3. Kelola Reservasi");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            int pilih = scanner.nextInt();
            scanner.nextLine();

            switch (pilih) {
                case 1 -> app.kelolaPelanggan(scanner);
                case 2 -> app.kelolaLapangan(scanner);
                case 3 -> app.kelolaReservasi(scanner);
                case 4 -> {
                    System.out.println("Terima kasih!");
                    jalan = false;
                }
                default -> System.out.println("Pilihan tidak valid!");
            }
        }
        scanner.close();
    }
}
