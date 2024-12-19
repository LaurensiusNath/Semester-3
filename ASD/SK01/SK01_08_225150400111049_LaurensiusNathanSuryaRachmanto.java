package ASD.SK01;

import java.util.LinkedList;
import java.util.Scanner;

class ListPasien implements List {
    LinkedList<Pasien> daftarPasien = new LinkedList<>();

    @Override
    public void tambahPasien(Pasien p) {
        daftarPasien.add(p);
    }

    @Override
    public void hapusPasien(Pasien p) {
        daftarPasien.remove(p);
    }

    @Override
    public void sisipPasienPadaUrutanKe(Pasien p, int indeks) {
        if (indeks >= 0 && indeks <= daftarPasien.size()) {
            daftarPasien.add(indeks, p);
        } else {
            System.out.println("Data tidak dapat disisipkan, karena indeks melebihi batas");
        }
    }

    @Override
    public void hapusPasienAsuransi(JenisAsuransi asuransi) {
        for(int i=0;i<daftarPasien.size();i++){
            if (daftarPasien.get(i).getJenisAsuransi().equals(asuransi)){
                daftarPasien.remove(i);
            }
        }
    }

    @Override
    public String toString() {
        String hasil = "";
        if (daftarPasien.size()!=0){
            int i = 0;
            hasil += "Daftar Pasien:\n";
            while (i < daftarPasien.size()) {
                hasil += i + 1 + ". " + daftarPasien.get(i).getNama() + " " + daftarPasien.get(i).getJenisAsuransi() + "\n";
                i++;
            }
        } else {
            hasil += "Daftar Pasien Kosong\n";
        }
        return hasil;
    }
}


enum JenisAsuransi {
    Biasa,
    VIP,
    VVIP
}

class Pasien {
    String nama;
    JenisAsuransi jenisAsuransi;

    public Pasien(String nama, JenisAsuransi jenisAsuransi){
        this.nama=nama;
        this.jenisAsuransi=jenisAsuransi;
    }

    public String getNama() {
        return nama;
    }

    public JenisAsuransi getJenisAsuransi() {
        return jenisAsuransi;
    }
}

interface List {
    void tambahPasien(Pasien p);
    void hapusPasien(Pasien p);
    void sisipPasienPadaUrutanKe(Pasien p, int urutan);
    void hapusPasienAsuransi(JenisAsuransi asuransi);
    @Override
    String toString();
}

public class SK01_08_225150400111049_LaurensiusNathanSuryaRachmanto{
    public static void main(String[] args) {
        int pilih=0;
        Scanner scanner = new Scanner(System.in);
        ListPasien listPasien = new ListPasien();
        String nama;
        int layanan;
        int indeks;
        System.out.println("SELAMAT DATANG DI RUMAH SAKIT 008");
        while (pilih!=6){
            System.out.println("Silakan Pilih Layanan:");
            System.out.println("1. Tambah Pasien");
            System.out.println("2. Hapus Pasien");
            System.out.println("3. Sisip Pasien");
            System.out.println("4. Hapus Pasien Asuransi");
            System.out.println("5. Cetak Daftar Pasien");
            System.out.println("6. Keluar");
            System.out.print("Silakan Masukkan Pilihan (1, 2, 3, 4, 5, 6): ");
            pilih=scanner.nextInt();
            scanner.nextLine();

            switch (pilih){
                case 1:
                    System.out.println("LAYANAN TAMBAH DATA PASIEN");
                    System.out.print("Nama Pasien: ");
                    nama=scanner.nextLine();
                    System.out.print("Jenis Layanan\n"+
                            "1. VVIP\n" +
                            "2. VIP\n" +
                            "3. Biasa\n" +
                            "Masukkan Pilihan(1, 2, 3): ");
                    layanan=scanner.nextInt();
                    scanner.nextLine();
                    switch (layanan){
                        case 1:
                            listPasien.tambahPasien(new Pasien(nama,JenisAsuransi.VVIP));
                            System.out.println("Pasien Berhasil Ditambahkan");
                            break;
                        case 2:
                            listPasien.tambahPasien(new Pasien(nama,JenisAsuransi.VIP));
                            System.out.println("Pasien Berhasil Ditambahkan");
                            break;
                        case 3:
                            listPasien.tambahPasien(new Pasien(nama,JenisAsuransi.Biasa));
                            System.out.println("Pasien Berhasil Ditambahkan");
                            break;
                        default:
                            System.out.println("Pilihan tidak tersedia");
                    }
                    break;

                case 2:
                    System.out.println("LAYANAN HAPUS DATA PASIEN");
                    System.out.print("Nama pasien yang ingin dihapus: ");
                    nama = scanner.nextLine();
                    Pasien pasienHapus=null;
                    for (Pasien pasien : listPasien.daftarPasien){
                        if (pasien.getNama().equals(nama)){
                            pasienHapus = pasien;
                            break;
                        }
                    }
                    if (pasienHapus!=null){
                        listPasien.hapusPasien(pasienHapus);
                        System.out.println("Pasien berhasil dihapus");
                    }
                    else {
                        System.out.println("Pasien tidak ditemukan");
                    }
                    break;

                case 3:
                    System.out.println("LAYANAN SISIP DATA PASIEN");
                    System.out.print("Nama Pasien: ");
                    nama=scanner.nextLine();
                    System.out.print("Sisip di indeks ke: ");
                    indeks = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Jenis Layanan\n"+
                            "1. VVIP\n" +
                            "2. VIP\n" +
                            "3. Biasa\n" +
                            "Masukkan Pilihan(1, 2, 3): ");
                    layanan=scanner.nextInt();
                    scanner.nextLine();
                    switch (layanan){
                        case 1:
                            listPasien.sisipPasienPadaUrutanKe(new Pasien(nama,JenisAsuransi.VVIP),indeks);
                            System.out.println("Pasien Berhasil Disisipkan");
                            break;
                        case 2:
                            listPasien.sisipPasienPadaUrutanKe(new Pasien(nama,JenisAsuransi.VIP),indeks);
                            System.out.println("Pasien Berhasil Disisipkan");
                            break;
                        case 3:
                            listPasien.sisipPasienPadaUrutanKe(new Pasien(nama,JenisAsuransi.Biasa),indeks);
                            System.out.println("Pasien Berhasil Disisipkan");
                            break;
                        default:
                            System.out.println("Pilihan tidak tersedia");
                    }
                    break;

                case 4:
                    System.out.println("LAYANAN HAPUS PASIEN dengan JENIS ASURANSI");
                    System.out.print("Jenis Layanan yang ingin dihapus\n"+
                            "1. VVIP\n" +
                            "2. VIP\n" +
                            "3. Biasa\n" +
                            "Masukkan Pilihan(1, 2, 3): ");
                    layanan=scanner.nextInt();
                    scanner.nextLine();
                    switch (layanan){
                        case 1:
                            listPasien.hapusPasienAsuransi(JenisAsuransi.VVIP);
                            System.out.println("Pasien dengan layanan VVIP Berhasil Dihapus");
                            break;
                        case 2:
                            listPasien.hapusPasienAsuransi(JenisAsuransi.VIP);
                            System.out.println("Pasien dengan layanan VIP Berhasil Dihapus");
                            break;
                        case 3:
                            listPasien.hapusPasienAsuransi(JenisAsuransi.Biasa);
                            System.out.println("Pasien dengan layanan Biasa Berhasil Dihapus");
                            break;
                        default:
                            System.out.println("Pilihan tidak tersedia");
                    }
                    break;

                case 5:
                    System.out.println("LAYANAN CETAK DAFTAR PASIEN");
                    System.out.println(listPasien);
                    break;

                case 6:
                    System.out.println("TERIMA KASIH DAN SEHAT SELALU");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia");
            }

        }
    }
}