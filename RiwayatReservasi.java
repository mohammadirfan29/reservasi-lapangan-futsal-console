public class RiwayatReservasi {
    private String idReservasi;
    private String tanggal;
    private Lapangan lapangan;
    private Pelanggan pelanggan;

    public RiwayatReservasi(String idReservasi, String tanggal, Lapangan lapangan, Pelanggan pelanggan) {
        this.idReservasi = idReservasi;
        this.tanggal = tanggal;
        this.lapangan = lapangan;
        this.pelanggan = pelanggan;
    }

    public void tampilkanRiwayat() {
        System.out.println("Riwayat: ID=" + idReservasi + ", Lapangan=" + lapangan.getNamaLapangan()
                + ", Pelanggan=" + pelanggan.getNama() + ", Tanggal=" + tanggal);
    }
}
