package ASD.CONTOHSK04;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Scanner;

enum JenisAsuransi {
    BIASA, VIP, VVIP;
}

class Pasien implements Comparable<Pasien> {
    String nama;
    JenisAsuransi jenisAsuransi;

    public Pasien(String nama, JenisAsuransi jenisAsuransi) {
        this.nama = nama;
        this.jenisAsuransi = jenisAsuransi;
    }

    @Override
    public int compareTo(Pasien other) {
        return this.jenisAsuransi.compareTo(other.jenisAsuransi);
    }

    @Override
    public String toString() {
        return nama + " " + jenisAsuransi;
    }
}

class ListPasien implements List {
    LinkedList<Pasien> listPasien = new LinkedList<>();

    @Override
    public void tambahPasien(String nama, JenisAsuransi ja) {
        Pasien pasien = new Pasien(nama, ja);
        listPasien.add(pasien);
    }

    @Override
    public Pasien lihatPasien(int i) {
        if (i >= 0 && i < listPasien.size()) {
            return listPasien.get(i);
        }
        return null;
    }

    @Override
    public int jumlahPasien() {
        return listPasien.size();
    }

    @Override
    public void tampil() {
        int i = 1;
        if(listPasien.isEmpty()){
            System.out.println("Data pasien kosong");
        }

        for (Pasien pasien : listPasien) {
            System.out.println(i + ". " + pasien);
            i++;
        }
    }
}

class AntrianPasien implements Antrian {
    PriorityQueue<Pasien> antrianPasien = new PriorityQueue<>(Comparator.reverseOrder());

    @Override
    public void tambahAntrian(Pasien p) {
        antrianPasien.add(p);
    }

    @Override
    public Pasien panggilAntrian() {
        return antrianPasien.poll();
    }

    @Override
    public int sisaAntrian() {
        return antrianPasien.size();
    }
}

interface List {
    void tambahPasien(String nama, JenisAsuransi ja);
    Pasien lihatPasien(int i);
    int jumlahPasien();
    void tampil();
}

interface Antrian {
    void tambahAntrian(Pasien p);
    Pasien panggilAntrian();
    int sisaAntrian();
}

public class ContohSK04 {
    public static void main(String[] args) {
        List listPasien = new ListPasien();
        Antrian antrianPasien = new AntrianPasien();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selamat Datang di RS");

        boolean selesai = false;
        while (!selesai) {
            System.out.println("");
            System.out.print("""
                               Layanan yang tersedia:
                               1. Tambah data pasien
                               2. Lihat daftar pasien
                               3. Tambah antrian pasien
                               4. Panggil antrian pasien
                               5. Lihat sisa antrian pasien 
                               """);
            System.out.print("Masukkan pilihan anda ( 1 - 5 ) : ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("\nMasukkan nama pasien : ");
                    String namaPasien = scanner.nextLine();
                    System.out.println("Jenis asuransi:");
                    System.out.println("1. BIASA");
                    System.out.println("2. VIP");
                    System.out.println("3. VVIP");
                    System.out.print("Masukkan jenis asuransi ( 1 - 3 ) : ");
                    int jenisAsuransi = scanner.nextInt();
                    scanner.nextLine();

                    JenisAsuransi asuransi = JenisAsuransi.BIASA;
                    if (jenisAsuransi == 2) {
                        asuransi = JenisAsuransi.VIP;
                    } else if (jenisAsuransi == 3) {
                        asuransi = JenisAsuransi.VVIP;
                    }

                    listPasien.tambahPasien(namaPasien, asuransi);
                    break;

                case 2:
                    System.out.println("\nData pasien:");
                    listPasien.tampil();
                    break;

                case 3:
                    System.out.println("\nData pasien:");
                    listPasien.tampil();
                    System.out.println("Pilih nomor pasien yang dimasukkan dalam antrian");
                    int nomorPasien = scanner.nextInt();
                    scanner.nextLine();
                    Pasien pasienAntrian = listPasien.lihatPasien(nomorPasien - 1);
                    if (pasienAntrian != null) {
                        antrianPasien.tambahAntrian(pasienAntrian);
                    } else {
                        System.out.println("Nomor pasien tidak valid");
                    }
                    break;

                case 4:
                    Pasien pasienPanggil = antrianPasien.panggilAntrian();
                    if (pasienPanggil != null) {
                        System.out.println("\nPasien bernama " + pasienPanggil.nama + " dengan asuransi " + pasienPanggil.jenisAsuransi + " silakan masuk.");
                    } else {
                        System.out.println("Tidak ada pasien dalam antrian.");
                    }
                    System.out.println("Sisa antrian " + antrianPasien.sisaAntrian());
                    break;

                case 5:
                    System.out.println("\nSisa antrian " + antrianPasien.sisaAntrian());
                    break;

                default:
                    System.out.println("Input layanan tidak valid.");
            }

            System.out.print("Apakah masih ada layanan yang dilakukan (Y/T)? ");
            String jawaban = scanner.next();
            selesai = !jawaban.equalsIgnoreCase("Y");
        }

        System.out.println("Terima kasih telah menggunakan layanan Rumah Sakit.");
    }
}