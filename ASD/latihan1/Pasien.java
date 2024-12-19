package ASD.latihan1;

public class Pasien {
    private String nama;
    private Layanan jenisLayanan;

    public Pasien(String nama, Layanan jenisLayanan){
        this.nama=nama;
        this.jenisLayanan=jenisLayanan;
    }

    @Override
    public String toString() {
        return "Nama pasien: " +nama+" "+jenisLayanan.toString();
    }
}
