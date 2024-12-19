package ASD.latihan1;

public class Layanan {
    private String namaLayanan;
    private int hargaLayanan;

    public Layanan(String namaLayanan, int hargaLayanan) {
        this.namaLayanan = namaLayanan;
        this.hargaLayanan = hargaLayanan;
    }


    @Override
    public String toString() {
        return "Nama layanan: " + namaLayanan + " Harga layanan: " + hargaLayanan;
    }

}

